import java.io.*;
import java.util.*;
import java.lang.Thread;


public class MemorableQuotes {
    public static void main(String[] args) {
        ArrayList<String> dynamicArray = new ArrayList<String>();
        dynamicArray = createQuotes(dynamicArray);
        if (args.length == 1){
            switch(args[0]){
                case "all": printAllQuotes(dynamicArray); break;
                case "random": printRandomQuotes(getRandomQuotes(dynamicArray)); break;
                case "add": add(dynamicArray); break;
                case "delete": delete(dynamicArray); break;
                case "modify": modify(dynamicArray); break;
                case "search": System.out.print("Error: requires parameter (eg. Java MemorableQuotes search <parameter>)"); break;
                case "csearch": System.out.print("Error: requires parameter (eg. Java MemorableQuotes csearch <parameter>)"); break;
                default: break;
            }
        } else if (args.length == 2){
            switch(args[0]){
                case "search": getSearch(dynamicArray, args[1]); break;
                case "csearch": getContentSearch(dynamicArray, args[1]); break;
                default: break;
            }
        } else {
            System.out.print("Error: requires parameter (eg. Java MemorableQuotes <parameter>)");
        }
        if (args[0].equals("display")){
            switch(args.length){
                case 1: getDisplay(dynamicArray); break;
                case 2: getDisplay(dynamicArray, args[1]); break;
                case 3: getDisplay(dynamicArray, args[1], args[2]); break;
            }
        }
    }

    static ArrayList<String> createQuotes(ArrayList<String> quotes){
        try {
            File myObj = new File("quotes.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
      
        try {
            File file = new File("quotes.txt");
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String data = scan.nextLine();
                quotes.add(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return quotes;
    }

    static void printAllQuotes(ArrayList<String> quotes){
        if (quotes.size() == 0){
            System.out.println("There are no quotes in the database!");
        }
        for(int i = 0; i < quotes.size(); i++){
            printQuote(quotes.get(i));
            System.out.println();
        }
    }

    static void printRandomQuotes(String quotes){
        if (!quotes.equals("")){
            printQuote(quotes);
            System.out.println();
        }
    }

    static String getRandomQuotes(ArrayList<String> quotes){
        if (quotes.size() == 0){
            System.out.println("There are no quotes in the database!");
        } else{
            Random rand = new Random();
            return quotes.get(rand.nextInt(quotes.size()));
        }
        return "";
    }

    static void getSearch(ArrayList<String> quotes, String arg){
        for(String element : quotes){
            String ref = element.substring(element.indexOf('@'), element.length());
            ref = ref.toLowerCase();
            arg = arg.toLowerCase();
            if (ref.contains(arg)){
                printQuote(element);
                System.out.println();
            }
        }
    }

    static void getContentSearch(ArrayList<String> quotes, String arg){
        for(String element : quotes){
            String ref = element.substring(0, element.indexOf('@'));
            ref = ref.toLowerCase();
            arg = arg.toLowerCase();
            if (ref.contains(arg)){
                printQuote(element);
                System.out.println();
            }
        }
    }

    static void getDisplay(ArrayList<String> quotes){
        try {
            while(true){
                printRandomQuotes(getRandomQuotes(quotes));
                Thread.sleep(3000);
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    static void getDisplay(ArrayList<String> quotes, String arg1){
        int max = -1;
        int delay = 3000;
        if (arg1.contains("max=")){max = argToInt(arg1, 4);} 
        else if (arg1.contains("delay=")){delay = argToInt(arg1, 6) * 1000;} 
        try {
            while(max != 0){
                printRandomQuotes(getRandomQuotes(quotes));
                Thread.sleep(delay); max--;
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        
    }

    static void getDisplay(ArrayList<String> quotes, String arg1, String arg2){
        int max = -1;
        int delay = 3000;
        if (arg1.contains("max=")){max = argToInt(arg1, 4);} 
        else if (arg1.contains("delay=")){delay = argToInt(arg1, 6) * 1000;} 
        if (arg2.contains("max=")){max = argToInt(arg2, 4);} 
        else if (arg2.contains("delay=")){delay = argToInt(arg2, 6) * 1000;} 
        try {
            while(max != 0){
                printRandomQuotes(getRandomQuotes(quotes));
                Thread.sleep(delay); max--;
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    static int argToInt(String arg, int num){
        return Integer.valueOf(arg.substring(num, arg.length()));
    }

    static void add(ArrayList<String> quotes){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter new quote: ");
        String str = scan.nextLine();
        if (str.contains("@")){
            quotes.add(str);
            updateFile(quotes);
            System.out.println("New quote added\n");
        } else {
            System.out.println("Requires '@' to reference author\n");
        }
    }

    static void delete(ArrayList<String> quotes){
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i < quotes.size(); i++){
            System.out.println("[" + i + "]: " + quotes.get(i));
        }
        System.out.print("type the id of the item you want to delete: ");
        int id = scan.nextInt();
        if (id < quotes.size() && id >= 0){
            quotes.remove(id);
            updateFile(quotes);
        } else {
            System.out.print("Invalid input!");
        }
    }

    static void modify(ArrayList<String> quotes){
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i < quotes.size(); i++){
            System.out.println("[" + i + "]: " + quotes.get(i));
        }
        System.out.print("type the id of the item you want to modify: ");
        int id = scan.nextInt();
        scan.nextLine();
        if (id < quotes.size() && id >= 0){
            System.out.print("Enter new quote: ");
            String str = scan.nextLine();
            if (str.contains("@")){
                quotes.set(id, str);
                updateFile(quotes);
                System.out.println("New quote added\n");
            } else {
                System.out.println("Requires '@' to reference author\n");
            }

            updateFile(quotes);
        } else {
            System.out.print("Invalid input!");
        }
    }

    static void printQuote(String quotes){
        int nth = quotes.indexOf('@');
        System.out.println(quotes.substring(0, nth));
        System.out.println("-- " + quotes.substring(nth+1, quotes.length()));
    }

    static void updateFile(ArrayList<String> quotes){
        File fold = new File("quotes.txt");
        fold.delete();
        File fnew = new File("quotes.txt");

        try {
            FileWriter f2 = new FileWriter(fnew, false);
            for(int i = 0; i < quotes.size(); i++){
                f2.write(quotes.get(i) + "\n");
            }
            f2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }     
    }
}