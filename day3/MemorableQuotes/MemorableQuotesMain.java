import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.lang.String;
import java.lang.NumberFormatException;

class MemorableQuotes{
    private String quoteText;
    private String reference;
    private String category;
    private int counter;
    
    public MemorableQuotes(){
        this.quoteText = "";
        this.reference = "";
        this.category = "";
        this.counter = 0;
    }

    public MemorableQuotes(String quotes){
        this.quoteText = quotes;
        this.reference = "";
        this.category = "";
        this.counter = 0;
    }

    public MemorableQuotes(String quotes, String reference){
        this.quoteText = quotes;
        this.reference = reference;
        this.category = "";
        this.counter = 0;
    }

    public MemorableQuotes(String quotes, String reference, String category){
        this.quoteText = quotes;
        this.reference = reference;
        this.category = category;
        this.counter = 0;
    }

    public MemorableQuotes(String quotes, String reference, String category, int counter){
        this.quoteText = quotes;
        this.reference = reference;
        this.category = category;
        this.counter = counter;
    }

    public String getQuotes(){
        return(this.quoteText);
    }

    public void setQuotes(String quote){
        this.quoteText = quote;
    }

    public String getReference(){
        return(this.reference);
    }

    public void setReference(String reference){
        this.reference = reference;
    }

    public String getCategory(){
        return(this.category);
    }

    public void setCategory(String category){
        this.category = category;
    }

    public int getCounter(){
        return(this.counter);
    }

    public void setCounter(int counter){
        this.counter = counter;
    }

    void printQuote(){
        counter++;
        System.out.println(this.quoteText + "\n--reference: " + this.reference + "\n--category: " + this.category);
        System.out.println("This quote has been printed " + counter + " times\n");
    }

    public boolean matches(String text){
        text = text.toLowerCase();
        String tempQuoteText = this.quoteText.toLowerCase();
        String tempReference = this.reference.toLowerCase();
        return (tempQuoteText.contains(text) || tempReference.contains(text)) ? true : false;
    }
}

class MemorableQuotesDatabase{
    ArrayList<MemorableQuotes> quotes;

    public MemorableQuotesDatabase(){
        this.quotes = new ArrayList<MemorableQuotes>();
    }

    public MemorableQuotesDatabase(ArrayList<MemorableQuotes> quotes){
        this.quotes = quotes;
    }

    public void printQuotes(ArrayList<MemorableQuotes> quotes, String category){
        if (category.equals("")){
            for(int i = 0; i < quotes.size(); i++){
                quotes.get(i).printQuote();
            }
        } else {
            for(int i = 0; i < quotes.size(); i++){
                if (quotes.get(i).getCategory().equals(category)){
                    quotes.get(i).printQuote();
                }
            }
        }
    }

    public void printRandomQuotes(String category){
        if (category.equals("")){
            if (quotes.size() != 0){
                getRandomQuotes().printQuote();
            }
        } else {
            if (quotes.size() != 0){
                MemorableQuotes quote;
                do{
                    quote = getRandomQuotes();
                }while(!quote.getCategory().equals(category));
                quote.printQuote();
            }
        }
    }

    public MemorableQuotes getRandomQuotes(){
        Random rand = new Random();
        return this.quotes.get(rand.nextInt(quotes.size()));
    }

    public void addQuotes(MemorableQuotes quotes){
        this.quotes.add(quotes);
    }

    public void removeQuotes(MemorableQuotes quotes){
        quotes.setQuotes("");
    }

    public int getQuotesCount(int id){
        return quotes.size();
    }

    public MemorableQuotes getQuotesByIndex(int n){
        return quotes.get(n);
    }

    public ArrayList<MemorableQuotes> getAllQuotes(){
        return this.quotes;
    }

    public ArrayList<MemorableQuotes> searchQuotes(String text){
        ArrayList<MemorableQuotes> matchQuotes = new ArrayList<MemorableQuotes>();
        for(int i = 0; i < this.quotes.size(); i++){
            if (this.quotes.get(i).matches(text)){
                matchQuotes.add(this.quotes.get(i));
            }
        }
        return matchQuotes;
    }

    public void add(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter new quote: ");
        String tempQuote = scan.nextLine();
        System.out.print("Enter new reference: ");
        String tempReference = scan.nextLine();
        System.out.print("Enter new category: ");
        String tempCategory = scan.nextLine();
        this.quotes.add(new MemorableQuotes(tempQuote, tempReference, tempCategory));
    }

    public void delete(){
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i < this.quotes.size(); i++){
            System.out.println("Quote id is: " + i);
            this.quotes.get(i).printQuote();
        }
        System.out.print("type the id of the item you want to delete: ");
        int id = scan.nextInt();
        if (id < this.quotes.size() && id >= 0){
            this.quotes.remove(id);
        } else {
            System.out.print("Invalid input!");
        }
    }

    public void modify(){
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i < quotes.size(); i++){
            System.out.println("Quote id is: " + i);
            this.quotes.get(i).printQuote();
        }
        System.out.print("type the id of the item you want to modify: ");
        int id = scan.nextInt();
        scan.nextLine();
        if (id < this.quotes.size() && id >= 0){
            System.out.print("Enter new quote: ");
            String tempQuote = scan.nextLine();
            System.out.print("Enter new reference: ");
            String tempReference = scan.nextLine();
            System.out.print("Enter new category: ");
            String tempCategory = scan.nextLine();
            this.quotes.set(id, new MemorableQuotes(tempQuote, tempReference, tempCategory));
        } else {
            System.out.print("Invalid input!");
        }
    }

    public boolean readFromFile(String filename){
        try {
            File myObj = new File(filename);
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
                MemorableQuotes tempQuote = new MemorableQuotes();
                String data = scan.nextLine();
                tempQuote.setQuotes(data.substring(0, nthIndex(data, '@', 1)));
                tempQuote.setReference(data.substring(nthIndex(data, '@', 1)+1, nthIndex(data, '@', 2)));
                tempQuote.setCategory(data.substring(nthIndex(data, '@', 2)+1, nthIndex(data, '@', 3)));
                try{
                    int number = Integer.parseInt(data.substring(nthIndex(data, '@', 3)+1, data.length()));
                    tempQuote.setCounter(number);
                }
                catch (NumberFormatException ex){
                    ex.printStackTrace();
                }
                this.quotes.add(tempQuote);
            }
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return false;
    }

    public boolean writeToFile(String filename){
        File fold = new File(filename);
        fold.delete();
        File fnew = new File(filename);

        try {
            FileWriter f2 = new FileWriter(fnew, false);
            for(int i = 0; i < this.quotes.size(); i++){
                f2.write(this.quotes.get(i).getQuotes() + "@");
                f2.write(this.quotes.get(i).getReference() + "@");
                f2.write(this.quotes.get(i).getCategory() + "@");
                f2.write(this.quotes.get(i).getCounter() + "\n");
            }
            f2.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int nthIndex(String string, char ch, int n) {
        return string.length()-string.replaceAll("^([^"+ch+"]*"+ch+"){"+n+"}", "").length()-1;
    }
}

class MemorableQuotesDisplayShow{
    MemorableQuotesDatabase mqd;
    int delayBetweenQuotes;
    int maxQuotesToDisplay;

    public MemorableQuotesDisplayShow(MemorableQuotesDatabase mqd){
        delayBetweenQuotes = 3000;
        maxQuotesToDisplay = 0;
        this.mqd = mqd;
    }

    public MemorableQuotesDisplayShow(MemorableQuotesDatabase mqd, String arg1){
        String tempArgs1 = arg1.toLowerCase();
        delayBetweenQuotes = 3000;
        maxQuotesToDisplay = 0;
        this.mqd = mqd;
        if (arg1.contains("max=")){maxQuotesToDisplay = argToInt(arg1, 4);} 
        else if (arg1.contains("delay=")){delayBetweenQuotes = argToInt(arg1, 6) * 1000;} 
    }

    public MemorableQuotesDisplayShow(MemorableQuotesDatabase mqd, String arg1, String arg2){
        String tempArgs1 = arg1.toLowerCase();
        String tempArgs2 = arg2.toLowerCase();
        delayBetweenQuotes = 3000;
        maxQuotesToDisplay = 0;
        this.mqd = mqd;
        if (tempArgs1.contains("max=")){maxQuotesToDisplay = argToInt(arg1, 4);} 
        else if (tempArgs1.contains("delay=")){delayBetweenQuotes = argToInt(arg1, 6) * 1000;}
        if (tempArgs2.contains("max=")){maxQuotesToDisplay = argToInt(arg2, 4);} 
        else if (tempArgs2.contains("delay=")){delayBetweenQuotes = argToInt(arg2, 6) * 1000;} 
    }

    public void execute(){
        try {
            if (this.maxQuotesToDisplay <= 0){
                while(true){
                    mqd.printRandomQuotes("");
                    Thread.sleep(this.delayBetweenQuotes);
                }
            } else {
                for(int i = 0; i < this.maxQuotesToDisplay; i++){
                    mqd.printRandomQuotes("");
                    Thread.sleep(this.delayBetweenQuotes);
                }
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    int argToInt(String arg, int num){
        return Integer.valueOf(arg.substring(num, arg.length()));
    }
}

class MemorableQuotesMain{
    public static void main(String[] args){
        MemorableQuotesDatabase mqd = new MemorableQuotesDatabase();
        mqd.readFromFile("quotes.txt");
        if (args.length != 0){
            args[0] = args[0].toLowerCase();
            if (args.length == 1){
                switch(args[0]){
                    case "all": mqd.printQuotes(mqd.getAllQuotes(), ""); break;
                    case "random": mqd.printRandomQuotes(""); break;
                    case "add": mqd.add(); break;
                    case "delete": mqd.delete(); break;
                    case "modify": mqd.modify(); break;
                    case "search": System.out.println("Error: missing parameter (Eg. Java MemorableQuotesMain search <query>)"); break;
                    default: break;
                }
            } else if (args.length == 2){
                switch(args[0]){
                    case "all": mqd.printQuotes(mqd.getAllQuotes(), args[1]); break;
                    case "random": mqd.printRandomQuotes(args[1]); break;
                    case "search": mqd.printQuotes(mqd.searchQuotes(args[1]), ""); break;
                    default: break;
                }
            } else if (args.length != 0){
                switch(args[0]){
                    case "search": System.out.println("Make sure to add double quotes \" \" before and after the query"); break;
                    default: break;
                }
            }
            if (args[0].equals("display")){
                MemorableQuotesDisplayShow display = new MemorableQuotesDisplayShow(mqd);
                switch(args.length){
                    case 2: display = new MemorableQuotesDisplayShow(mqd, args[1]); break;
                    case 3: display = new MemorableQuotesDisplayShow(mqd, args[1], args[2]); break;
                    default: break;
                }
                display.execute();
            }
        }
        mqd.writeToFile("quotes.txt");
    }
}