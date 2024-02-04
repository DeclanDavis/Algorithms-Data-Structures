import java.util.Scanner;
public class E_MonteCarlo {
	
		public static void main(String[] args) {
			
			//use the Monte Carlo method to estimate the value of
			// the mathematical constant e, the base of the natural logarithm
			//(to get our specified variable)
			Scanner sc = new Scanner(System.in);
			long num = sc.nextInt();
			
			double total = 0;
			//generating the number of times we will generate a random number(doing the dice roll) specified by user input
     			// the greater the number the more simulations we will run and hence the more accurate the estimation
			for(int i = 0; i<num; i++) {
				int sum = 0;
				int count = 0;
				while(sum<=600) {	//note (math.random()*600)+1);
							// plus 1 changes from 0 1 2 3 4 5 to
							// 1 2 3 4 5 6 - 600 
					sum = sum + ((int)(Math.random()*600)+1); // like rolling a dice, will generate a random
					count = count +1;	                        //number between 1 and 600
					//counting how many times we've generated a number (like rolled our dice)					
				}
				total= total+count;
			}
			
			double estValueE = total/num;
			
			System.out.println("The estimated value of e is: " + estValueE);
			
			//variable to store the distance between our estimated e and actual e
			double distanceToE = estValueE - 2.71828;
			double absoluteDistanceToE = Math.abs(distanceToE);
			
			
			System.out.println("Difference between the estimated value of e and the actual value of e is: " + absoluteDistanceToE);
			sc.close();
		}
}
