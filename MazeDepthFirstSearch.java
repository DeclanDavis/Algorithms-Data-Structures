import java.util.*;
import java.io.*;

public class Maze {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Administrator\\Documents\\MaynoothUniversity\\Semester1\\DataStructures&Algorithms\\Labs\\Lab10\\Maze2.txt");

        int lives = 200;
        int posX = 0;
        int posY = 0;
        String[] input = new String[20];

        try {
            Scanner scan = new Scanner(file);

            for (int i = 0; i < 20; i++) {
                input[i] = scan.nextLine(); // read the maze
            }

            posX = Integer.parseInt(scan.nextLine()); // this is where you appear
            posY = Integer.parseInt(scan.nextLine());
            scan.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        
        boolean[][] maze = new boolean[20][20];

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (input[i].charAt(j) == 'X') {
                    maze[i][j] = false; // there's a wall
                } else {
                    maze[i][j] = true; // there's a space
                }
            }
        }

        Brain myBrain = new Brain();

        while (lives > 0) {
            System.out.println("Current position: " + posX + " " + posY);

            for (int i = 0; i < 20; i++) { // print out the map
                for (int j = 0; j < 20; j++) {
                    if (posX == i && posY == j) {
                        System.out.print("o");
                    } else if (maze[i][j] == true) {
                        System.out.print(" "); // there is a space
                    } else {
                        System.out.print("X"); // there is a wall
                    }
                }
                System.out.println();
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // Handle interrupted exception (if necessary)
                e.printStackTrace();
            }
           
            String move = myBrain.getMove(maze[posX - 1][posY], maze[posX + 1][posY], maze[posX][posY + 1],
                    maze[posX][posY - 1]);

            if (move.equals("north") && maze[posX - 1][posY]) {
                posX--; // if the brain wants to move North AND it's possible
            } else if (move.equals("south") && maze[posX + 1][posY]) {
                posX++; // if the brain wants to move South AND it's possible
            } else if (move.equals("east") && maze[posX][posY + 1]) {
                posY++;
            } else if (move.equals("west") && maze[posX][posY - 1]) {
                posY--;
            }

            lives--;

            if (posY % 19 == 0 || posX % 19 == 0) { // found a way out!
                System.out.println("You found the exit at: " + posX + "," + posY);
                System.exit(0);
            }
        }

        System.out.println("You died in the maze!");
    }

}
	class Brain {
	
    //create a boolean array to mark moves
    //default value as false. Mark as true at each visited index.
    boolean[][] memory = new boolean[41][41]; 
    
    //create stack to remember moves in case we need to move back
    Stack backtracker = new Stack(1000);
    
    //assume you're in the middle
    int posX = 20;
    int posY = 20;
    
    public Brain() {
    	memory[posX][posY]=true; //mark the starting pos as true.
    }
    
    public String getMove(boolean north, boolean south, boolean east, boolean west) {

    	System.out.println(north+" "+south+" "+east+" "+west);
    	
    	if(north&&!memory[posX][posY-1]) {
    		backtracker.push("south");
    		posY--;
    		memory[posX][posY]=true;
    		System.out.println("north");
    		return "north";
    	} else if (south&&!memory[posX][posY+1]) {
    		backtracker.push("north");
    		posY++;
    		memory[posX][posY]=true;
    		System.out.println("south");
    		return "south";
    	} else if (east&&!memory[posX+1][posY]) {
    		backtracker.push("west");
    		posX++;
    		memory[posX][posY]=true;
    		System.out.println("east");
    		return "east";
    	} else if(west&&!memory[posX-1][posY]) {
    		backtracker.push("east");
    		posX--;
    		memory[posX][posY]=true;
    		System.out.println("west");
    		return "west";
    	}
    	
    	String backtrack = backtracker.pop();
    	if(backtrack=="north") {
    		posY--;
    	} else if(backtrack=="south") {
    		posY++;
    	}else if (backtrack=="east") {
    		posX++;
    	}else if(backtrack=="west") {
    		posX--;
    	}
    	
    	System.out.println(backtrack);
    	return backtrack;
    	
    	}
	}



