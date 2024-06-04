import java.util.Scanner;

public class recursionFactorial {
	public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	
	System.out.println("The factorial of 5 is: ");	
	int number = factorial(5);
	System.out.println(number);
	
	System.out.println();
	
	System.out.println("Enter a number to calculate it's factorial.");
	int num = sc.nextInt();
	int result = factorial(num);
	System.out.println(result);
	
	}
	
	public static int factorial(int n) {
		//base case
		if(n == 1) 
			return 1;
		 else 
			return n * factorial(n-1);
	}
}
