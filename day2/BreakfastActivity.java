import java.util.*;
import java.io.*;

public class BreakfastActivity{
    public static void main(String[] args){
        ArrayList<String> dynamicArray = new ArrayList<String>();
        dynamicArray.add("Tapsilog: Tapa with sisig, egg, and rice");
        dynamicArray.add("Longsilog: Longganisa sausages with sisig, egg, and rice");
        dynamicArray.add("Tocilog: Tocino with egg and rice");
        if (args.length != 0){
            switch(args[0]){
                case "display": display(dynamicArray); break;
                case "sort_asc": sortAsc(dynamicArray); break;
                case "sort_desc": sortDesk(dynamicArray); break;
                case "count": count(dynamicArray); break;
                case "keysearch": 
                    if (args.length == 2) {
                        keySearch(dynamicArray, args[1]);
                    } else {
                        System.out.println("You didnt input any query\n");
                    }
                    break;
                case "dsearch":
                    if (args.length == 2){
                        dSearch(dynamicArray, args[1]); break;
                    } else {
                        System.out.println("You didnt input any query\n");
                    }
                    break;
                default: break;
            }
        } else {
            System.out.println("You didnt input any query\n");
        }
    }

    static void display(ArrayList<String> dArray){
        System.out.println("Title: Description");
        for(int i = 0; i < dArray.size(); i++){
            System.out.println(dArray.get(i));
        }
        System.out.println();
    }

    static void sortAsc(ArrayList<String> dArray){
        Collections.sort(dArray);
        System.out.println("Title: Description");
        for(int i = 0; i < dArray.size(); i++){
            System.out.println(dArray.get(i));
        }
        System.out.println();
    }

    static void sortDesk(ArrayList<String> dArray){
        Collections.sort(dArray, Collections.reverseOrder());
        System.out.println("Title: Description");
        for(int i = 0; i < dArray.size(); i++){
            System.out.println(dArray.get(i));
        }
        System.out.println();
    }

    static void count(ArrayList<String> dArray){
        System.out.println("There are " + dArray.size() + " arrays\n");
    }

    static void keySearch(ArrayList<String> dArray, String arg){
        ArrayList<String> title = new ArrayList<String>();
        for(int i = 0; i < dArray.size(); i++){
            StringBuilder str = new StringBuilder();
            String st = dArray.get(i);
            for(int j = 0; j < st.length(); j++){
                char chr = st.charAt(j);
                if (chr == ':'){
                    break;
                } else {
                    str.append(chr);
                }
            }
            title.add(str.toString());
        }

        int count = 0;
        System.out.println("Title: Description");
        for (int i = 0; i < dArray.size(); i++){
            String element = title.get(i);
            element = element.toLowerCase();
            arg = arg.toLowerCase();
            if (element.contains(arg)){
                System.out.println(dArray.get(i));
                count++;
            }
        }
        System.out.println("Total results found: " + count);
        System.out.println();
    }

    static void dSearch(ArrayList<String> dArray, String arg){
        ArrayList<String> description = new ArrayList<String>();
        for(int i = 0; i < dArray.size(); i++){
            StringBuilder str = new StringBuilder();
            String st = dArray.get(i);
            for(int j = 0; j < st.length(); j++){
                char chr = st.charAt(j);
                if (chr == ':'){
                    for(int k = j+2; k < st.length(); k++){
                        char ch = st.charAt(k);
                        str.append(ch);
                    }
                    break;
                }
            }
            description.add(str.toString());
        }

        int count = 0;
        System.out.println("Title: Description");
        for (int i = 0; i < dArray.size(); i++){
            String element = description.get(i);
            element = element.toLowerCase();
            arg = arg.toLowerCase();
            if (element.contains(arg)){
                System.out.println(dArray.get(i));
                count++;
            }
        }
        System.out.println("Total results found: " + count);
        System.out.println();
    }
}