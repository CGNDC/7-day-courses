import java.util.LinkedList;

public class LinkedListProject{
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
		LinkedList<String> list = new LinkedList<String>();
		list.add("Mitsubishi Adventure:800000");
		list.add("Brewed Coffee(Venti):110");
		list.add("Candy bar:50");
		for(int i = 0; i <list.size(); i++){
			String str = list.get(i);
			int nth = getColon(str);
			System.out.println("Product: " + str.substring(0, nth) + ", Price: " + str.substring(nth+1, str.length()));
		}
    }
}