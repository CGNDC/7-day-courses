public class MyIfElseProgram{
	public static void main(String[] args){
		int n;
		for(n = 0; n <= 20; n++){
			if (n == 0){
				System.out.println("First one: " + n);
			} else if (n < 5){
				System.out.println("Less than 5: " + n);
			} else if (n == 10) {
				System.out.println("Ten: " + n);
			} else if (n == 11){
				System.out.println("Eleven: " + n);				
			} else{
				System.out.println("Not less than 5: " + n);
			}
		}
	}
}