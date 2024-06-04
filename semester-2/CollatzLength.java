import java.util.Scanner;

public class CollatzLength {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a start number: ");
		int start = sc.nextInt();
		System.out.println("Number " + start + ": number of steps to get to 1 is: " + getStepsCount(start));
		long conSecCount = checkUp(start);
		System.out.println("Highest Consecutive Count is " + conSecCount);
	
	}
	
	public static long checkUp(int start) {	
		long currentConSecCount = 1;
		long highestConSecCount = 1;
		int count = 0;
		
		while(start < 10000000) {
			count++;
			int previousSteps = getStepsCount(start);
			int next = start + 1;
			int currentSteps = getStepsCount(next);
			
			if(previousSteps == currentSteps) {
				currentConSecCount++;					
				if(currentConSecCount > highestConSecCount) {
					highestConSecCount = currentConSecCount;
				}
				start = next;
				
			} else if (previousSteps != currentSteps){			//This means they are not the same conseq
				currentConSecCount = 1;
				start = next; 									//Gives new start to count from
				
			} else {
				break;
			}	
		}	
		return highestConSecCount;	
	}
	
	public static int getStepsCount(int start) {
		int count = 0;
		
		while(start != 1) {
			start = checker(start);
			count++;
		}	
		return count;
	}
	
	public static int checker(int num) {
		
		if(num % 2 == 0) {
			num = num / 2;;
		} else {
			num = (num * 3) + 1;
		}
		return num;
	}
	
}
