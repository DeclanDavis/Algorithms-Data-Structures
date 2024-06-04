import java.util.Scanner;

public class BinaryTree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		Tree binaryTree = new Tree();
		
		System.out.println("Please insert values: ");	//Keep inserting values
		
		while(true) {
			String value = sc.nextLine();					//Taken in as a String
			int number;									//Value to store as a number
			if(value.equalsIgnoreCase("END")) {		//If end command, stop inserting
				break;								//Break out of the while loop
			} else {							// Otherwise
			number = Integer.parseInt(value);	//Convert the String to an int
			binaryTree.insert(number);			//insert the int into the Binary Tree
			}
		}
		
		System.out.println("The resulting binary tree has " + binaryTree.maxLevelCount + " levels.");
	}
}

	class Node{
		public int iData;					// data used as key value
		public Node leftChild;				// this node's left child
		public Node rightChild;				// this node's right child
		
		
		public void displayNode() {
			System.out.println("{");
			System.out.println(iData);
			System.out.println("} ");
		}
	}	// end class Node
	
	class Tree {
		private Node root;		//first Node of tree
		public int maxLevelCount = 0;
		private int currentLevelCount = 0;
		
		public Tree() {			// no-arg constructor
			root = null; 		// no nodes in tree yet
		}
		
		public void insert(int id) {
			Node newNode = new Node();		//make new node
			newNode.iData = id;				//insert data
			if(root==null) {				//no node in root
				root = newNode;
								
			} else {						// root occupied
				Node current = root;		// start at the root
				currentLevelCount = 0;		//reset currentLevelCount to 0
				
				Node parent;
				while(true) {				// (exits internally)
					parent = current;
					if(id < current.iData) {	//go left?
				    currentLevelCount++;		//increment the currentLevelCount
						current = current.leftChild;
  						if(current == null) {
  							parent.leftChild = newNode;
  							maxLevelCount = setHighestCount(maxLevelCount, currentLevelCount);
  							return;
  						}
  					}	//end if go left
					 else {	//or go right?
				
				    currentLevelCount++;		//increment the currentLevelCount
						current = current.rightChild;
						if(current == null) {
							parent.rightChild = newNode;
							
							maxLevelCount = setHighestCount(maxLevelCount, currentLevelCount);
							return;
						}
					}	// end else go right
				}	//end while
			}	//end else not root	
		}	//end insert()
		
		public int setHighestCount(int highestCount, int currentCount) {
			
			if(highestCount < currentCount) {
				highestCount = currentCount;
			}	
			return highestCount;
		}
	} // end tree
	
	
	
	
	
	
	
	
	
	
	
	
	
	

