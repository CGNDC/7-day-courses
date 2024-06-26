import java.lang.*;
import java.util.ArrayList;

public class SimpleProductDatabase{
	static int getColon(String n){
		for(int i = 0; i < n.length(); i++){
			String str = "";
			str += n.charAt(i);
			if (str.equals(":")){
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args){
		ArrayList<String> dynamicArray = new ArrayList<String>();
		dynamicArray.add("Mitsubishi Adventure:800000");
		dynamicArray.add("Brewed Coffee(Venti):110");
		dynamicArray.add("Candy bar:50");
		for(int i = 0; i <dynamicArray.size(); i++){
			String str = dynamicArray.get(i);
			int nth = getColon(str);
			System.out.println("Product: " + str.substring(0, nth) + ", Price: " + str.substring(nth+1, str.length()));
		}
	}
}



