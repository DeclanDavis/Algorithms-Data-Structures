import java.util.Scanner;

public class SquidGame_MonteCarlo {

	//method to make the maze, use boolean and set each row to have one true, one false
	    public static boolean[][] generateMaze() {
	    boolean[][] maze = new boolean[19][2]; //if we reach index 18 we have crossed the bridge.
	
	    for (int i = 0; i < maze.length; i++) {
	        int randomColumn = (int)(Math.random()*2); //generates (0 or 1)
	        maze[i][randomColumn] = true;
	    }
	
	    return maze;
	}
	    
	
	public static void main(String[] args) {
	        
		Scanner sc = new Scanner(System.in);
		System.out.println("What number person are you?");
		int numberPerson = sc.nextInt();
		
	    int sim = 1000000;
	    //use total to count every time someone crosses. (sum of all the counts)
	    double total = 0.0;
	    //use count to check is someone crosses successfully.
	    double count = 0.0;
	    
	    //for loop for the number of simulations
	    //1000000 - the greater the number of simulations the greater the accuracy	    
	    for(int i = 0; i < sim; i++) {
	    	
	    	//generate a maze with random true/false values
	    	boolean[][] generatedMaze = generateMaze();
	    	
	    	//p is the current person going across the maze, change 5 to n and get n through a scanner
	    	for(int p = 1; p <= numberPerson; p++) {
	    	//use count to check if they crossed and reset for each person
	    	count = 0;
	    	
	    	//______Keep jumping until you die or get to row 18(crossed bridge)
	    	boolean alive = true;
	    	int pos = 0;
		    	while(alive && pos < 18) {
		    		
			    	
			    	//_________JUMP__________
			    	int jump = (int)(Math.random()*2); //gives either 0 or 1
			    	pos++; //move you one further into the maze
			    	
			    	//if they fall off_______EveryJump
			        int num1 = (int)(Math.random()*100) +1;
			        int numfall = 6; //a 1 percent chance the random number generated between 1 and 100 is 6
			    		if(num1 == numfall) {
			    			alive = false;
			    		}
			    		
			    		//if they finish
			    		if(pos == 18) {
			    			count = count + 1.0; //means you have finished the maze
			    		}
			    		
			    		//if they make the correct jump
			    		else if(generatedMaze[pos][jump] == true) {
				    		generatedMaze[pos][0] = true;	//mark the choice as you can only succeed
				    		generatedMaze[pos][1] = true; //as future players will copy your successful move

				    	}
				    	//if(generatedMaze[pos][jump] == false) {
			    		//if they make the incorrect jump
			    		else {	
			    		   alive = false;
			    		   generatedMaze[pos][0] = true;  //mark the choice as you can only succeed
			    		   generatedMaze[pos][1] = true;  //as future players will avoid your unsuccessful move
				    	}
			    	}
		    	}
		    	
		    	total += count;
	    	}
	    
	    double probability = ((double)total/sim) *100;
	    
	    System.out.println(Math.round(probability) + "%");
	    }
	    
}
