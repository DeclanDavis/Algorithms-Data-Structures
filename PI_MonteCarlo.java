import java.util.Scanner;
public class PI_MonteCarlo {
	
		public static void main(String[] args) {
			
			/*
			use the Monte Carlo simulation to estimate the value of
			PI, generate points within a square and determine the ratio 
			of points that fall within the inscribed circle to the total number of points 
			this ratio is used to estimate PI 
			(to get our specified variable)
			*/
			Scanner sc = new Scanner(System.in);
			long num = sc.nextInt();
			
			//_________Step 1:_______
			//Fill the square with random points (x,y Co-Ordinates)
			double R = 1.0; //R is the radius of the inner circle
			double C = 0.0; //the number of points inside Circle
			double S = 0.0; //the number of points inside Square
			//number of times to generate random Co-Ords specified by user input
			for(int i = 1; i<=num; i++) {
				//generate random x,y CoOrds
				double x = (Math.random()*2)-1;
				double y = (Math.random()*2)-1;
				S++;                           //count every time a point is added to the square
				if(((x*x) + (y*y)) <= (R*R)) { //use Pythagorus Theorum to check if CoOrd is in the circle
					C++;					   //count every time a point is inside the circle
				}
			}
			
			/*________Step 2:___________
			After completing all of the inserted Co-Ords and 
			counting which are in the circle and which are in the square
			we can estimate the value of PI by 4C/S
			*/
			double estPI = (4*C) /S;
			System.out.println("The estimated value of PI is: " + estPI);
			sc.close();
			
	}
}
