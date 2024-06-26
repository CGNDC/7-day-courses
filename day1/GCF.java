import java.util.Scanner;

public class GCF{
	static int gcf(int x, int y) {
	   if (y==0) return x;
	   return gcf(y,x%y);
	}
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int x, y, gcf;

		System.out.println("Greatest common factor calculator");
		System.out.print("Enter Value 1: ");
		x = scan.nextInt();
		
		System.out.print("Enter Value 2: ");
		y = scan.nextInt();		
	
		System.out.println("Greatest common factor of " + x + " and " + y + " is " + gcf(x, y));			
	}
}