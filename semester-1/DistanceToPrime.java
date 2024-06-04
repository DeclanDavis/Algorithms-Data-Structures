import java.util.Scanner;

public class PrimeDistance {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		
		if(isPrime(x)) {
			System.out.println(0);
		}
		else {
			System.out.println(distanceToPrime(x));
		}
		
	}
	
	public static boolean isPrime(int x) {
		
		if(x<=1) {
			return false;
		}
		
		for(int i = 2; i*i <=x; i++) {
			if(x%i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static int distanceToPrime(int x) {
		
		int plusCount = 0;
		int minusCount = 0;
		int y = x;
		
		while(isPrime(x) == false) {
			x = x + 1;
			plusCount = plusCount + 1;
		}
		
		while(isPrime(y) == false) {
			y = y - 1;
			minusCount = minusCount - 1;
		}
		
		minusCount = Math.abs(minusCount);
		
		if(minusCount <= plusCount) {
			return minusCount;
		}
		else {
			return plusCount;
		}
	}		
}
