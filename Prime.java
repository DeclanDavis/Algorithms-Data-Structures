import java.util.Scanner;
public class Prime {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		boolean quit = true;

    //menu for the user to select an option 1, 2 or 3.
		while(quit){
		System.out.println("1.Check if a number is prime");
		System.out.println("2.List prime numbers in a range");
		System.out.println("3.Exit");
		
		
		int menuChoice = sc.nextInt();
		
		if(menuChoice == 1) {
			System.out.println("Enter a number: ");
			int input = sc.nextInt();
		if(isPrime(input)) {
			System.out.println(input + " is a prime number.");
		}
		else {
			System.out.println(input + " is not a prime number.");
		}
		}
		
		if(menuChoice == 2) {
			System.out.println("Enter the start of the range: ");
			int start = sc.nextInt();
			
			System.out.println("Enter the end of the range: ");
			int end = sc.nextInt();
			
			isPrimeRange(start,end);
			System.out.println();
		}
		
		if(menuChoice == 3) {
			quit = false;
		}
		}
					
//		sc.close();
		
	}

  //method to check is a number is prime or not
		public static boolean isPrime(int input) {
			
		if(input <= 1) {
			return false;
		}
		for(int i = 2; i*i <= input; i++) {
			if(input%i == 0) {
				return false;
			}
		}
		return true;

	}
		//method to iterate through all the numbers in the given range and print them if they are prime
		public static void isPrimeRange(int start, int end) {
			
			System.out.println("Prime numbers in the range [" + start + "]" + "[" + end + "]");			
			for(int i = start; i <= end; i++) {
				if(isPrime(i)) {
					System.out.print(i + " ");
				}
			}
		}
				
}
