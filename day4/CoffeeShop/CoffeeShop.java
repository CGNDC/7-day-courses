import java.util.ArrayList;
import java.lang.String;


class Beverage{
    String name;
    int price;
    String size;
    String type;

    public Beverage(String name , int price, String size, String type){
        this.name = name;
        this.price = price;
        this.size = size;
        this.type = type;
    }

    public int getPrice(){
        return this.price;
    }
}

class Pastry{
    String name;
    int price;
    String type;

    public Pastry(String name, int price, String type){
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public int getPrice(){
        return this.price;
    }
}

public class CoffeeShop{
    public static void main(String[] args){
        ArrayList<Beverage> bev = new ArrayList<Beverage>();
        ArrayList<Pastry> pas = new ArrayList<Pastry>();
        int total = 0;

        bev.add(new Beverage("coffee", 299, "tall", "coffe based"));
        bev.add(new Beverage("coffee", 499, "tall", "coffe based"));
        bev.add(new Beverage("coffee", 999, "tall", "coffe based"));
        pas.add(new Pastry("coffee", 299, "coffe based"));
        pas.add(new Pastry("coffee", 399, "coffe based"));
        pas.add(new Pastry("coffee", 499, "coffe based"));
        
        for(int i = 0; i < bev.size(); i++){
            total += bev.get(i).getPrice();
        }
        for(int i = 0; i < pas.size(); i++){
            total += pas.get(i).getPrice();
        }
        String stotal = Integer.toString(total);
        System.out.print("You're bill is: " + 
            stotal.substring(0, stotal.length()-2) + "." + 
            stotal.substring(stotal.length()-2, stotal.length()));
    }
}