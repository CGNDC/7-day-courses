import java.util.ArrayList;
import java.util.Scanner;
import java.math.BigDecimal;
import java.io.IOException;

interface Printable{
    public void print();
}

interface ProductWithColor{
    public String getColor();
}

class Products implements Printable{
    private String name = null;
    private BigDecimal price = new BigDecimal(0);
    private int stockQuantity = 0;
    private int cartQuantity = 0;

    public String getName(){
        return(this.name);
    }

    public void setName(String name){
        this.name = name;
    }
    
    public BigDecimal getPrice(){
        return(this.price);
    }
    
    public void setPrice(String price){
        this.price = new BigDecimal(price);
    }

    public BigDecimal getPriceWithVat(){
        BigDecimal vat = this.price;
        vat = vat.multiply(new BigDecimal(0.12f));
        return (this.price.add(vat));
    }

    public int getStockQuantity(){
        return(this.stockQuantity);
    }

    public void setStockQuantity(int stockQuantity){
        this.stockQuantity = stockQuantity;
    }

    public int getCartQuantity(){
        return(this.cartQuantity);
    }

    public void setCartQuantity(int cartQuantity){
        this.cartQuantity = cartQuantity;
    }

    public String toString(){
        return("Product: " + this.name + ", Price: " + this.price);
    }

    public void print(){

    }
}

class Cars extends Products implements Printable{
    String make = "";
    String model = "";
    public Cars(String name, String price, String make, String model){
        setName(name);
        setPrice(price);
        setMake(make);
        setModel(model);
    }

    public String getMake(){
        return(this.make);
    }

    public void setMake(String make){
        this.make = make;
    }
    
    public String getModel(){
        return(this.model);
    }

    public void setModel(String model){
        this.model = model;
    }

    @Override
    public String toString(){
        return(super.toString() + ", Make: " + getMake() + ", Model: " + getModel());
    }

    public void print(){
        System.out.println("Product is a laptop: " + getMake() + ", " + getModel());
    }
}

class Laptop extends Products implements Printable{
    private String brand = "";
    private int memory = 0;

    public Laptop(String name, String price, String brand, String memory){
        setName(name);
        setPrice(price);
        setBrand(brand);
        setMemory(memory);
    }

    public String getBrand(){
        return(this.brand);
    }

    public void setBrand(String brand){
        this.brand = brand;
    }
    
    public int getMemory(){
        return(this.memory);
    }

    public void setMemory(String memory){
        this.memory = Integer.parseInt(memory);
    }

    @Override
    public String toString(){
        return(super.toString() + ", Brand: " + getBrand() + ", Memory: " + getMemory());
    }

    public void print(){
        System.out.println("Product is a laptop: " + getBrand() + ", " + getMemory());
    }
}

class House extends Products implements Printable{
    private String city = "";
    private String area = "";

    public House(String name, String price, String city, String area){
        setName(name);
        setPrice(price);
        setCity(city);
        setArea(area);
    }

    public String getCity(){
        return(this.city);
    }

    public void setCity(String city){
        this.city = city;
    }
    
    public String getArea(){
        return(this.area);
    }

    public void setArea(String area){
        this.area = area;
    }

    @Override
    public String toString(){
        return(super.toString() + ", City: " + getCity() + ", Area: " + getArea());
    }

    public void print(){
        System.out.println("Product is a house: " + getCity() + ", " + getArea());
    }
}

class Furnatures extends Products implements Printable{
    private String type = "";
    private String material = "";

    public Furnatures(String name, String price, String type, String material){
        setName(name);
        setPrice(price);
        setType(type);
        setMaterial(material);
    }

    public String getType(){
        return(this.type);
    }

    public void setType(String type){
        this.type = type;
    }
    
    public String getMaterial(){
        return(this.material);
    }

    public void setMaterial(String material){
        this.material = material;
    }

    @Override
    public String toString(){
        return(super.toString() + ", Type: " + getType() + ", Material: " + getMaterial());
    }

    public void print(){
        System.out.println("Product is a furnature: " + getType() + ", " + getMaterial());
    }
}

class Pets extends Products implements Printable, ProductWithColor{
    private String breed = "";
    private String color = "";

    public Pets(String name, String price, String breed, String color){
        setName(name);
        setPrice(price);
        setBreed(breed);
        setColor(color);
    }

    public String getBreed(){
        return(this.breed);
    }

    public void setBreed(String breed){
        this.breed = breed;
    }
    
    public String getColor(){
        return(this.color);
    }

    public void setColor(String color){
        this.color = color;
    }

    @Override
    public String toString(){
        return(super.toString() + ", Breed: " + getBreed() + ", Color: " + getColor());
    }

    public void print(){
        System.out.println("Product is a pet: " + getBreed() +", " + getColor());
    }
}

class ProductDatabase{
    ArrayList<Products> products = new ArrayList<Products>();
    
    public void printSummary(String arg){
        BigDecimal totalPrice = new BigDecimal(0);
        int totalQuantity = 0;
        for(int i = 0; i < products.size(); i++){
            switch(arg){
                case "stock":
                    products.get(i).print();
                    totalPrice.add(products.get(i).getPrice());
                break;
                case "cart":
                if (products.get(i).getCartQuantity() != 0){
                    products.get(i).print();
                    totalPrice.add(products.get(i).getPrice());
                }
                break;
            }
        }
        System.out.println("There is quantity is " + totalQuantity);
        System.out.println("The total price is " + totalPrice);
        BigDecimal vat = totalPrice;
        vat = vat.multiply(new BigDecimal(0.12f));
        System.out.println("The total price after vat: " + (totalPrice.add(vat)));
    }

    public void printDisplay(String arg1){
        for(int i = 0; i < products.size(); i++){
            switch(arg1){
                case "all": products.get(i).print(); break;
                case "cars": 
                    if (products.get(i) instanceof Cars){
                        products.get(i).print(); 
                    }
                    break;
                case "laptop":
                    if (products.get(i) instanceof Laptop){
                        products.get(i).print();
                    }
                    break;
                case "house":
                    if (products.get(i) instanceof House){
                        products.get(i).print();
                    }
                    break;
                case "furnatures":
                    if (products.get(i) instanceof Furnatures){
                        products.get(i).print();
                    }
                    break;
                case "pets":
                    if (products.get(i) instanceof Pets){
                        products.get(i).print();
                    }
                    break;
                default: break;
            }
        }
    }

    public void searchProduct(String arg1, String arg2){
        for(int i = 0; i < products.size(); i++){
            switch(arg1){
                case "name": if (products.get(i).getName() == arg2){products.get(i).print();} break;
                case "price": if (products.get(i).getPrice().equals(new BigDecimal(arg2))){products.get(i).print();} break;
                default: break;
            }
        }
    }

    public void addProduct(String arg1, String arg2, String arg3, String arg4, String arg5){
        for(int i = 0; i < products.size(); i++){
            if (products.get(i).getName() == arg2){
                System.out.println("That name was already taken, try another one!");
                break;
            } else if (i == products.size()){
                switch(arg1){
                    case "cars": products.add(new Cars(arg2, arg3, arg4, arg5)); break;
                    case "laptop": products.add(new Laptop(arg2, arg3, arg4, arg5)); break;
                    case "house": products.add(new House(arg2, arg3, arg4, arg5)); break;
                    case "furnatures": products.add(new Furnatures(arg2, arg3, arg4, arg5)); break;
                    case "pets": products.add(new Pets(arg2, arg3, arg4, arg5)); break;
                    default: break;
                }
            }
        }
    }

    public void buyProduct(String arg1, String arg2){
        for(int i = 0; i < products.size(); i++){
            if (products.get(i).getName() == arg1){
                Products prod = products.get(i);
                if (prod.getStockQuantity() >= prod.getCartQuantity() + Integer.parseInt(arg2)){
                    prod.setCartQuantity(Integer.parseInt(arg2));
                } else {
                    System.out.println("There isnt enough stock");
                    System.out.println("The remaining stock is: " + 
                        products.get(i).getStockQuantity());
                }
                break;
            } else if (i == products.size()){
                System.out.println("Item doesnt exists!");
            }
        }
    }

    public void removeProduct(String arg1, String arg2){
        for(int i = 0; i < products.size(); i++){
            if (products.get(i).getName() == arg2){
                switch(arg1){
                    case "stock":
                        products.remove(i);
                        break;
                    case "cart":
                        products.get(i).setCartQuantity(0);
                        break;
                    default: break;
                }
            }
        }
    }

    public void setProduct(String arg1, String arg2, String arg3){
        for(int i = 0; i < products.size(); i++){
            if (products.get(i).getName() == arg2){
                switch(arg1){
                    case "stock": products.get(i).setStockQuantity(Integer.parseInt(arg3)); break;
                    case "cart": 
                        if (products.get(i).getStockQuantity() >= Integer.parseInt(arg3)){
                            products.get(i).setCartQuantity(Integer.parseInt(arg3)); break;
                        } else {
                            System.out.println("There isnt enough stock");
                            System.out.println("The remaining stock is: " + 
                                products.get(i).getStockQuantity());
                        }
                    default: break;
                }
            }
        }
    }

    public void checkout(String arg1){
        BigDecimal money = new BigDecimal(arg1);
        BigDecimal totalPrice = new BigDecimal(0);
        int totalQuantity = 0;
        for(int i = 0; i < products.size(); i++){
            if (products.get(i).getStockQuantity() != 0){
                products.get(i).print();
                totalPrice.add(products.get(i).getPrice());
            }
        }
        System.out.println("There is quantity is " + totalQuantity);
        System.out.println("The total price is " + totalPrice);
        System.out.println("The total price after vat: " + (totalPrice.add(totalPrice.multiply(new BigDecimal(12)))));
        if (totalPrice.compareTo(money) == 1){
            System.out.println("---");
            System.out.println("You dont have enough balance, try again!");
        } else {
            for(int i = 0; i < products.size(); i++){
                if (products.get(i).getCartQuantity() != 0){
                    products.get(i).setStockQuantity(products.get(i).getStockQuantity() - products.get(i).getCartQuantity());
                    products.get(i).setCartQuantity(0);
                }
            }
            System.out.println("Your total change is " + totalPrice.subtract(money));
        }
    }

    public void readFromFile(String filename){
        try {
            File file = new File(filename);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
      
        try {
            File file = new File(filename);
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                Products prod = new Products();
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
    }

    public void writeToFile(String filename){
        File fold = new File(filename);
        fold.delete();
        File fnew = new File(filename);

        try {
            FileWriter f2 = new FileWriter(fnew, false);
            for(int i = 0; i < this.quotes.size(); i++){
                f2.write(quotes.get(i).getQuotes() + "@");
                f2.write(quotes.get(i).getReference() + "@");
                f2.write(quotes.get(i).getCategory() + "@");
                f2.write(quotes.get(i).getCounter() + "\n");
            }
            f2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class StoreMain{
    public static void main(String[] args){
        ProductDatabase pd = new ProductDatabase();
        pd.readFromFile("ProductDatabase.txt");
        if (args.length == 1){
            switch(args[0]){
                case "help": help(); break;
                default: break;
            }
        } else if (args.length == 2){
            switch(args[0]){
                case "summary": pd.printSummary(args[1]); break;
                case "display": pd.printDisplay(args[1]); break;
                case "checkout": pd.checkout(args[1]); break;
                default: break;
            }
        } else if (args.length == 3){
            switch(args[0]){
                case "buy": pd.buyProduct(args[1], args[2]); break;
                case "search": pd.searchProduct(args[1], args[2]); break;
                case "remove": pd.removeProduct(args[1], args[2]); break;
                default: break;
            }
        } else if (args.length == 4){
            switch(args[0]){
                case "add": pd.addProduct(args[1], args[2], args[3], args[4], args[5]); break;
                case "set": pd.setProduct(args[1], args[2], args[3]); break;
                default: break;
            }
        }
        pd.writeToFile("ProductDatabase.txt");
    }

    static void help(){
        System.out.println("help:");
        System.out.println("display all");
        System.out.println("display <category>");
        System.out.println("search <details> <info>");
        System.out.println("add <category> <item name> <price> <parameter> <parameter>");
        System.out.println("set stock <item name> <quantity>");
        System.out.println("remove stock <item name>");
        System.out.println("buy <item name> <quantity>");
        System.out.println("set cart <item name> <quantity>");
        System.out.println("remove cart <item name>");
        System.out.println("summary stock");
        System.out.println("summary cart");
        System.out.println("checkout <money>");
    }
}