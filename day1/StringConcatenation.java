import java.io.*;

public class StringConcatenation{
	public static void main(String[] args){
		long startTime = System.nanoTime();
		StringBuffer str = new StringBuffer();
		for(int i = 0; i < 100000; i++){
			str.append("x");
		}
		System.out.println(str);
        	long endTime = System.nanoTime();
	        long executionTime = (endTime - startTime) / 1000000;
		System.out.println(executionTime);
	}
}