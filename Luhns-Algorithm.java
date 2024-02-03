import java.util.Scanner;
public class LuhnsAlgorithm {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
//		int[] creditCard = new int[10];
		
		boolean range = true;
		int checkDigit = 0;
		
		while(range) {
		System.out.println("Enter the last digit of card number:");
		checkDigit = sc.nextInt();
  		if(checkDigit >= 4 && checkDigit <=30) {
  			range = false;
  		}
		}
		
		
		//Check with example
//		int[] cardNumber = {4,5,3,9,6,8,2,9,9,5,8,2,4,3,9,checkDigit};
		
		int[] cardNumber = {7,9,9,2,7,3,9,8,7,1,checkDigit};
		
		//Luhn's algorithm
		
		//___________PART 1________________
		
		//find the sum of every second digit from the last digit
		int sum1 = 0;
		for(int i = cardNumber.length-1; i >= 0; i = i-2) {
			sum1 += cardNumber[i];
//			System.out.print(array[i] + " "); CHECK to see if numbers are correct
		}
		
//		System.out.println("Sum1: " + sum1); //CHECK if sum is correct.
		
		//____________PART 2________________
		//double every second digit from the second last digit
		
		int digit = 0;
		int sum2 = 0;
		
		for(int i = cardNumber.length-2; i>=0; i = i -2) {
//			System.out.print(array[i] + " "); //CHECK to see if numbers are correct
					digit = cardNumber[i];
					digit = digit*2;
					
					if(digit>9) {
						digit = digit - 9;
					}
					sum2 += digit;
		}
		
//		System.out.println();
//		System.out.println("Sum2: " +sum2); //CHECK if sum is correct
		
		//______________Part 3_____________
		
		//take the total of step 1 and 2. If total modulo 10 == 0, then Card is VALID
		
		int sum3 = sum1 + sum2;
		
		if(sum3 % 10 == 0) {
			System.out.println("VALID");
		}
		else {
			System.out.println("INVALID");
		}	
	}
}
