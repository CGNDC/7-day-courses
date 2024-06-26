import java.util.Scanner;

public class Palindrome{
	static int checker(String nth) {
		int strLength = nth.length();
		for(int i = 0; i < strLength; i++){
			if (nth.charAt(i) != nth.charAt((strLength - 1) - i)){
				return 0;
			}
		}
		return 1;
	}
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String nth;

		System.out.print("Enter a Value to Check if i's a Palindrome: ");
		nth = scan.nextLine();
	
		switch(checker(nth)){
			case 1: System.out.println("Yehey! It's a palindrome"); break;
			case 0: System.out.println("It's not a palindrome"); break;
			default: break;
		}
	}
}