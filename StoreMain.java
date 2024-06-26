import java.util.ArrayList;
import java.math.BigDecimal;

interface Printable{
    public void print();
}

interface ProductWithColor{
    public String getColor();
}

class Product{
    private String name = null;
    private BigDecimal price = 0;
    private int stockQuantity = 0;
    private int cartQuantity = 0;

    public String getName(){
        return(this.name);
    }

    public void setName(String name){
        this.name = name;
    }
    
    public int getPrice(){
        return(this.price);
    }
    
    public void setPrice(int price){
        this.price = price;
    }

    public BigDecimal getPriceWithVat(){
        return (this.price + this.price.multiple(12));
    }

    public int getStockQuantity(){
        return(this.stockQuantity);
    }

    public void setStockQuantity(int stockQuantity){
        this.stockQuantity = stockQuantity
    }

    public int getCartQuantity(){
        return(this.cartQuantity);
    }

    public void setCartQuantity(int cartQuantity){
        this.cartQuantity = cartQuantity
    }

    public String toString(){
        return("Product: " + this.name + ", Price: " + this.price);
    }
}

class Cars extends Product implements Printable{
    String make = "";
    String model = "";
    public Cars(String name, int price, String make, String model){
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
        return(super.toString() + ", Make: " + this.make + ", Model: " + this.model);
    }

    public void print(){
        System.out.println("Product is a car: " + getMake() +
                    ", " + getModel());
    }
}

class Laptop extends Product{
    private String brand = "";
    private int memory = 0;

    public Laptop(String name, int price, String brand, int memory){
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

    public void setMemory(int memory){
        this.memory = memory;
    }

    @Override
    public String toString(){
        return(super.toString() + ", Brand: " + getBrand() + ", Memory: " + getMemory());
    }
}

class House extends Product implements Printable{
    private String city = "";
    private int area = 0;

    public House(String name, int price, String city, int area){
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
    
    public int getArea(){
        return(this.area);
    }

    public void setArea(int area){
        this.area = area;
    }

    @Override
    public String toString(){
        return(super.toString() + ", City: " + getCity() + ", Area: " + getArea());
    }

    public void print(){
        System.out.println("Product is a house: " + getCity() +
                    ", " + getArea());
    }
}

class Furnatures extends Product {
    private String type = "";
    private String material = 0;

    public Furnatures(String name, int price, String type, String material){
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
    
    public int getMaterial(){
        return(this.material);
    }

    public void setMaterial(int material){
        this.material = material;
    }

    @Override
    public String toString(){
        return(super.toString() + ", Type: " + getType() + ", Material: " + getMaterial());
    }

    public void print(){
        System.out.println("Product is a furnature: " + getType() +
                    ", " + getMaterial());
    }
}

class Pets extends Product implements ProductWithColor{
    private String breed = "";
    private String color = "";

    public Pets(String name, int price, String breed, String color){
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
    
    public int getColor(){
        return(this.color);
    }

    public void setColor(int color){
        this.color = color;
    }

    @Override
    public String toString(){
        return(super.toString() + ", Breed: " + getBreed() + ", Color: " + getColor());
    }

    public void print(){
        System.out.println("Product is a pet: " + getBreed() +
                    ", " + getColor());
    }
}

class ProductDatabase{
    ArrayList<Product> products = new ArrayList<Product>();
    
    public void printSummary(String arg){
        BigDecimal totalPrice = 0;
        int totalQuantity = 0;
        for(int i = 0; i < products.size(); i++){
            switch(arg){
                case "stock":
                if (products.get(i).getStockQuantity() != 0){
                    products.get(i).print("summaryStock");
                    products.get(i).getPrice("summaryStock");
                }
                break;
                case "cart":
                if (products.get(i).getCartQuantity() != 0){
                    products.get(i).print("summaryCart");
                }
                break;
            }
        }
        System.out.println("There is quantity is " + totalQuantity);
        System.out.println("The total price is " + totalPrice);
        System.out.println("The total price after vat: " + (totalValue + new BigDecimal(12)));
    }

    public void printDisplay(String arg1){
        for(int i = 0; i < products.size(); i++){
            switch(arg2){
                case "all": products.get(i).print("summaryStock"); break;
                case "cars": products.get(i).print("summaryCars"); break;
                case "laptop": products.get(i).print("summaryLaptop"); break;
                case "house": products.get(i).print("summaryHouses"); break;
                case "furnatures": products.get(i).print("summaryFurnatures"); break;
                case "pets": products.get(i).print("summaryPets"); break;
                default: break;
            }
        }
    }

    public void searchProduct(String arg1, String arg2){
        for(int i = 0; i < products.size(); i++){
            switch(arg1){
                "name": 
                if (products.get(i).getName() == arg2){

                }
                break;
                "price":
                "color":
            }
        }
    }

    public void addProduct(String arg1, String arg2, String arg3, String arg4, String arg5){
        for(int i = 0; i < products.size(); i++){
            if (product.get(i).getName() == arg2){
                System.out.println("That name was already taken, try another one!");
                break;
            } else if (i == products.size()){
                switch(arg1){
                    case "cars": products.add(new Cars(arg2, arg3, arg4, arg5)); break;
                    case "laptop": products.add(new Laptop(arg2, arg3, arg4, arg5)); break;
                    case "house": houproducts.add(new House(arg2, arg3, arg4, arg5)); break;
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
                Product prod = products.get(i);
                if (prod.getStockQuantity() >= prod.getCartQuantity() + arg2){
                    prod.setCartQuantity(arg2);
                } else {
                    System.out.println("There isnt enough stock");
                    System.out.println("The remaining stock is: " + 
                        product.get(i).getStockQuantity());
                }
                break;
            } else if (i == product.size()){
                System.out.print("Item doesnt exists!")
            }
        }
    }

    public void removeProduct(String arg1, String arg2){
        for(int i = 0; i < products.size(); i++){
            if (products.get(i).getName() == arg2){
                swith(arg1){
                    case "stock":
                        products.remove(i);
                        break;
                    case "cart":
                        products.get.setCartQuantity(0);
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
                    case "stock": product.get(i).setStockQuantity(arg3); break;
                    case "cart": 
                        if (product.get(i).getStockQuantity() >= arg3){
                            product.get(i).setCartQuantity(arg3); break;
                        } else {
                            System.out.println("There isnt enough stock");
                            System.out.println("The remaining stock is: " + 
                                product.get(i).getStockQuantity());
                        }
                    default: break;
                }
            }
        }
    }

    public void checkout(String arg1){
        BigDecimal totalPrice = 0;
        int totalQuantity = 0;
        for(int i = 0; i < products.size(); i++){
            if (products.get(i).getStockQuantity() != 0){
                products.get(i).print("summaryStock");
                totalPrice += products.get(i).getPrice("summaryStock");
            }
        }
        System.out.println("There is quantity is " + totalQuantity);
        System.out.println("The total price is " + totalPrice);
        System.out.println("The total price after vat: " + (totalValue + new BigDecimal(12)));
        if (totalPrice > arg1){
            System.out.println("---");
            System.out.println("You dont have enough balance, try again!");
        } else {
            for(int i = 0; i < products.size(); i++){
                Product prod = product.get(i);
                if (prod.getCartQuantity() != 0){
                    prod.setStockQuantity(prod.getStockQuantity() - prod.getCartQuantity());
                    prod.setCartQuantity(0);
                }
            }
            System.out.print("Your total change is " + (totalPrice - arg1));
        }
    }

    public void readFromFile(String filename){
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
    }

    public void writeToFile(String filename){
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
        pd.writeFromFile("ProductDatabase.txt");
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