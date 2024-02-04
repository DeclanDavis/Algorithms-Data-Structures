import java.io.File;
import java.util.Scanner;

public class QueueLab {
	
	public static void main(String[] args) {
		//File file = new File("C:\\stack.txt");
		//File file = new File("C:\\queue.txt");
		
		//This will read in the text file and store each line in a String array.
		
		File file = new File("C:\\Users\\Administrator\\Documents\\MaynoothUniversity\\Semester1\\DataStructures&Algorithms\\Labs\\Lab7\\queue.txt");
		int inputSize = 1000;
		String[] input = new String[inputSize]; 
		try {
			Scanner scan = new Scanner(file);
			
			for(int i = 0; i < inputSize; i++) {
				input[i] = scan.nextLine();
			}
			scan.close();
		} catch (Exception e) {
			System.err.println(e);
		}
		
		//Initialize a Queue Object
    //Question askes to limit que to 100
		Queue que = new Queue(100);
		
		// go through each index of the String array (the read in file)
		// break each index into the command word and the input data
		for(int i = 0; i< inputSize; i++) {
			if(input[i].split("\t")[0].equals("INSERT")) {
				que.insert(input[i].split("\t")[1]);	
			}
			else {
				que.remove();
			}
		}
		
		System.out.println(que.peekFront());
		
	}
	
	public static class Queue{

		//attributes
		private int maxSize;
		private String[] queArray;
		private int front;
		private int rear;
		private int nItems;
		
		public Queue(int s) { //constructor
			maxSize = s;
			queArray = new String[maxSize];
			front = 0;
			rear = -1;
			nItems = 0;
		}
		
		public boolean insert(String j) {  //put item at rear of queue
			if(isFull()) return false;		//don't remove if full
			if(rear == maxSize-1)			//deal with wrap around
				rear = -1;
			rear++;
			queArray[rear] = j;			//increment rear and insert
			nItems++;					//one more item
			return true;				//successfully inserted
		}
		
		public Object remove() {		//take item from front of queue
			if(isEmpty()) {				//don't remove if empty
				return null;			
			}
			String temp = queArray[front];	//get value and inc front
			front++;
			if(front == maxSize)		//deal with wrap around
				front = 0;
			nItems--;					// one less item
			return temp;
		}
		
		public String peekFront() {		// peek at front of queue
			return queArray[front];
		}
		
		public boolean isEmpty() {		//true if queue is empty
			return (nItems==0);
		}
		
		public boolean isFull() {		//true if queue is full
			return (nItems==maxSize);
		}
		
		public int size() {				//number of items in queue
			return nItems;
		}
	}

}
