import java.util.ArrayList;
import java.util.Scanner;
import java.math.BigDecimal;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;

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

    public void setStockQuantity(String stockQuantity){
        this.stockQuantity = Integer.parseInt(stockQuantity);
    }

    public int getCartQuantity(){
        return(this.cartQuantity);
    }

    public void setCartQuantity(String cartQuantity){
        this.cartQuantity = Integer.parseInt(cartQuantity);
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
    public Cars(String name, String price, String make, String model, String stock, String cart){
        setName(name);
        setPrice(price);
        setMake(make);
        setModel(model);
        setStockQuantity(stock);
        setCartQuantity(cart);
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
        System.out.println("This product is a car: ");
        System.out.println(toString() + "\n");
    }
}

class Laptop extends Products implements Printable{
    private String brand = "";
    private int memory = 0;

    public Laptop(String name, String price, String brand, String memory, String stock, String cart){
        setName(name);
        setPrice(price);
        setBrand(brand);
        setMemory(memory);
        setStockQuantity(stock);
        setCartQuantity(cart);
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
        System.out.println("This product is a laptop: ");
        System.out.println(toString() + "\n");
    }
}

class House extends Products implements Printable{
    private String city = "";
    private String area = "";

    public House(String name, String price, String city, String area, String stock, String cart){
        setName(name);
        setPrice(price);
        setCity(city);
        setArea(area);
        setStockQuantity(stock);
        setCartQuantity(cart);
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
        System.out.println("This product is a house: ");
        System.out.println(toString() + "\n");
    }
}

class Furnatures extends Products implements Printable{
    private String type = "";
    private String material = "";

    public Furnatures(String name, String price, String type, String material, String stock, String cart){
        setName(name);
        setPrice(price);
        setType(type);
        setMaterial(material);
        setStockQuantity(stock);
        setCartQuantity(cart);
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
        System.out.println("This product is a furnature: ");
        System.out.println(toString() + "\n");
    }
}

class Pets extends Products implements Printable, ProductWithColor{
    private String breed = "";
    private String color = "";

    public Pets(String name, String price, String breed, String color, String stock, String cart){
        setName(name);
        setPrice(price);
        setBreed(breed);
        setColor(color);
        setStockQuantity(stock);
        setCartQuantity(cart);
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
        System.out.println("This product is a pet: ");
        System.out.println(toString() + "\n");
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
                    totalPrice = totalPrice.add(products.get(i).getPrice());
                    totalQuantity += products.get(i).getStockQuantity();
                break;
                case "cart":
                if (products.get(i).getCartQuantity() != 0){
                    products.get(i).print();
                    totalPrice.add(products.get(i).getPrice());
                    totalQuantity += products.get(i).getCartQuantity();
                }
                break;
            }
        }
        System.out.println("There is quantity is " + totalQuantity);
        System.out.println("The total price is " + totalPrice);
        BigDecimal vat = totalPrice.multiply(new BigDecimal(0.12));
        totalPrice = totalPrice.add(vat);
        totalPrice = totalPrice.setScale(2, java.math.RoundingMode.HALF_EVEN);
        System.out.println("The total price after vat: " + (totalPrice));
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
                case "name": if (products.get(i).getName().equals(arg2)){products.get(i).print();} break;
                case "price": if (products.get(i).getPrice().equals(new BigDecimal(arg2))){products.get(i).print();} break;
                default: break;
            }
        }
    }

    public void addProduct(String arg1, String arg2, String arg3, String arg4, String arg5){
        for(int i = 0; i < products.size(); i++){
            if (products.get(i).getName().equals(arg2)){
                System.out.println("That name was already taken, try another one!");
                return;
            }
        }
        switch(arg1){
            case "cars": products.add(new Cars(arg2, arg3, arg4, arg5, "1", "0")); break;
            case "laptop": products.add(new Laptop(arg2, arg3, arg4, arg5, "1", "0")); break;
            case "house": products.add(new House(arg2, arg3, arg4, arg5, "1", "0")); break;
            case "furnatures": products.add(new Furnatures(arg2, arg3, arg4, arg5, "1", "0")); break;
            case "pets": products.add(new Pets(arg2, arg3, arg4, arg5, "1", "0")); break;
            default: break;
        }
        System.out.println("The product has been successfully added to the system");
    }

    public void buyProduct(String arg1, String arg2){
        for(int i = 0; i < products.size(); i++){
            if (products.get(i).getName().equals(arg1)){
                Products prod = products.get(i);
                if (prod.getStockQuantity() >= prod.getCartQuantity() + Integer.parseInt(arg2)){
                    prod.setCartQuantity(arg2);
                    System.out.println("You successfully added the product to your cart!");
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
            if (products.get(i).getName().equals(arg2)){
                switch(arg1){
                    case "stock":
                        products.remove(i);
                        System.out.println("You removed the item from the system!");
                        break;
                    case "cart":
                        products.get(i).setCartQuantity("0");
                        System.out.println("You removed all the item from your cart!");
                        break;
                    default: break;
                }
            }
        }
    }

    public void setProduct(String arg1, String arg2, String arg3){
        for(int i = 0; i < products.size(); i++){
            if (products.get(i).getName().equals(arg2)){
                switch(arg1){
                    case "stock": products.get(i).setStockQuantity(arg3); break;
                    case "cart": 
                        if (products.get(i).getStockQuantity() >= Integer.parseInt(arg3)){
                            System.out.println("You successfully added the product to your cart!");
                            products.get(i).setCartQuantity(arg3); break;
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
            if (products.get(i).getCartQuantity() != 0){
                totalQuantity += products.get(i).getCartQuantity();
                for(int j = 0; j < products.get(i).getCartQuantity(); j++){
                    products.get(i).print();
                    totalPrice = totalPrice.add(products.get(i).getPrice());
                }
            }
        }
        System.out.println("There is quantity is " + totalQuantity);
        System.out.println("The total price is " + totalPrice);
        BigDecimal vat = totalPrice.multiply(new BigDecimal(0.12));
        totalPrice = totalPrice.add(vat);
        totalPrice = totalPrice.setScale(2, java.math.RoundingMode.HALF_EVEN);
        System.out.println("The total price after vat: " + (totalPrice));
        if (totalPrice.compareTo(money) == 1){
            System.out.println("---");
            System.out.println("You dont have enough balance, try again!");
        } else {
            for(int i = 0; i < products.size(); i++){
                int stockQuantity = products.get(i).getStockQuantity();
                int cartQuantity = products.get(i).getCartQuantity();
                int remaining = stockQuantity - cartQuantity;
                if (stockQuantity != 0){
                    products.get(i).setStockQuantity(Integer.toString(remaining));
                    products.get(i).setCartQuantity("0");
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
                String data = scan.nextLine();
                if (data.length() != 0){
                    Products prod = new Products();
                    switch(data.substring(0, nthIndex(data, '@', 1))){
                        case "Cars": products.add( new Cars(
                            data.substring(nthIndex(data, '@', 1)+1, nthIndex(data, '@', 2)),
                            data.substring(nthIndex(data, '@', 2)+1, nthIndex(data, '@', 3)),
                            data.substring(nthIndex(data, '@', 3)+1, nthIndex(data, '@', 4)),
                            data.substring(nthIndex(data, '@', 4)+1, nthIndex(data, '@', 5)),
                            data.substring(nthIndex(data, '@', 5)+1, nthIndex(data, '@', 6)),
                            data.substring(nthIndex(data, '@', 6)+1, data.length())
                        ));
                        break;
                        case "Laptop": products.add( new Laptop(
                            data.substring(nthIndex(data, '@', 1)+1, nthIndex(data, '@', 2)),
                            data.substring(nthIndex(data, '@', 2)+1, nthIndex(data, '@', 3)),
                            data.substring(nthIndex(data, '@', 3)+1, nthIndex(data, '@', 4)),
                            data.substring(nthIndex(data, '@', 4)+1, nthIndex(data, '@', 5)),
                            data.substring(nthIndex(data, '@', 5)+1, nthIndex(data, '@', 6)),
                            data.substring(nthIndex(data, '@', 6)+1, data.length())
                        ));
                        break;
                        case "House": products.add( new House(
                            data.substring(nthIndex(data, '@', 1)+1, nthIndex(data, '@', 2)),
                            data.substring(nthIndex(data, '@', 2)+1, nthIndex(data, '@', 3)),
                            data.substring(nthIndex(data, '@', 3)+1, nthIndex(data, '@', 4)),
                            data.substring(nthIndex(data, '@', 4)+1, nthIndex(data, '@', 5)),
                            data.substring(nthIndex(data, '@', 5)+1, nthIndex(data, '@', 6)),
                            data.substring(nthIndex(data, '@', 6)+1, data.length())
                        ));
                        break;
                        case "Furnatures": products.add( new Furnatures(
                            data.substring(nthIndex(data, '@', 1)+1, nthIndex(data, '@', 2)),
                            data.substring(nthIndex(data, '@', 2)+1, nthIndex(data, '@', 3)),
                            data.substring(nthIndex(data, '@', 3)+1, nthIndex(data, '@', 4)),
                            data.substring(nthIndex(data, '@', 4)+1, nthIndex(data, '@', 5)),
                            data.substring(nthIndex(data, '@', 5)+1, nthIndex(data, '@', 6)),
                            data.substring(nthIndex(data, '@', 6)+1, data.length())
                        ));
                        break;
                        case "Pets": products.add( new Pets(
                            data.substring(nthIndex(data, '@', 1)+1, nthIndex(data, '@', 2)),
                            data.substring(nthIndex(data, '@', 2)+1, nthIndex(data, '@', 3)),
                            data.substring(nthIndex(data, '@', 3)+1, nthIndex(data, '@', 4)),
                            data.substring(nthIndex(data, '@', 4)+1, nthIndex(data, '@', 5)),
                            data.substring(nthIndex(data, '@', 5)+1, nthIndex(data, '@', 6)),
                            data.substring(nthIndex(data, '@', 6)+1, data.length())
                        ));
                        break;
                        default: break;
                    }
                }
            }
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
            for(int i = 0; i < this.products.size(); i++){
                if (products.get(i) instanceof Cars){
                    Cars prod = (Cars)products.get(i);
                    f2.write("Cars@");
                    f2.write(prod.getName() + "@");
                    f2.write(prod.getPrice() + "@");
                    f2.write(prod.getMake() + "@");
                    f2.write(prod.getModel() + "@");
                    f2.write(prod.getStockQuantity() + "@");
                    f2.write(prod.getCartQuantity() + "\n");
                } else if (products.get(i) instanceof Laptop){
                    Laptop prod = (Laptop)products.get(i);
                    f2.write("Laptop@");
                    f2.write(prod.getName() + "@");
                    f2.write(prod.getPrice() + "@");
                    f2.write(prod.getBrand() + "@");
                    f2.write(prod.getMemory() + "@");
                    f2.write(prod.getStockQuantity() + "@");
                    f2.write(prod.getCartQuantity() + "\n");
                } else if (products.get(i) instanceof House){
                    House prod = (House)products.get(i);
                    f2.write("House@");
                    f2.write(prod.getName() + "@");
                    f2.write(prod.getPrice() + "@");
                    f2.write(prod.getCity() + "@");
                    f2.write(prod.getArea() + "@");
                    f2.write(prod.getStockQuantity() + "@");
                    f2.write(prod.getCartQuantity() + "\n");
                } else if (products.get(i) instanceof Furnatures){
                    Furnatures prod = (Furnatures)products.get(i);
                    f2.write("Furnatures@");
                    f2.write(prod.getName() + "@");
                    f2.write(prod.getPrice() + "@");
                    f2.write(prod.getType() + "@");
                    f2.write(prod.getMaterial() + "@");
                    f2.write(prod.getStockQuantity() + "@");
                    f2.write(prod.getCartQuantity() + "\n");
                } else if (products.get(i) instanceof Pets){
                    Pets prod = (Pets)products.get(i);
                    f2.write("Pets@");
                    f2.write(prod.getName() + "@");
                    f2.write(prod.getPrice() + "@");
                    f2.write(prod.getBreed() + "@");
                    f2.write(prod.getColor() + "@");
                    f2.write(prod.getStockQuantity() + "@");
                    f2.write(prod.getCartQuantity() + "\n");
                }
            }
            f2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int nthIndex(String string, char ch, int n) {
        return string.length()-string.replaceAll("^([^"+ch+"]*"+ch+"){"+n+"}", "").length()-1;
    }
}

public class StoreMain{
    public static void main(String[] args){
        ProductDatabase pd = new ProductDatabase();
        pd.readFromFile("ProductDatabase.txt");
        for(int i = 0; i < args.length; i++){
            args[i] = args[i].toLowerCase();
        }
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
                case "set": pd.setProduct(args[1], args[2], args[3]); break;
                default: break;
            }
        } else if (args.length == 6){
            switch(args[0]){
                case "add": pd.addProduct(args[1], args[2], args[3], args[4], args[5]); break;
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