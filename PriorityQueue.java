import java.io.File;
import java.util.Scanner;

public class PriorityQueueReader {
	public static void main(String[] args) {

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
		
		PriorityQueue que = new PriorityQueue(100);
		
		
		for(int i = 0; i<inputSize; i++) {
			if(input[i].split("\t")[0].equals("INSERT")) {
				que.insert(input[i].split("\t")[1]);
			}
			else if(input[i].split("\t")[0].equals("REMOVE")) {
				que.remove();
			}
			else {
				System.out.println(que.peekFront());
			}
			
		}

    //look at the ten items at the front of the queue.
		for(int i = 0; i<10; i++) {
			System.out.println(que.peekFront());
			que.remove();
		}
		
	}


	public static class PriorityQueue{

		//attributes
		private int maxSize;
		private String[] queArray;
		private int nItems; //front is nItems
		
		public PriorityQueue(int s) { //constructor
			maxSize = s;
			queArray = new String[maxSize];
			nItems = 0;
		}
		
		public void insert(String item) {
			
			if(!isFull()) {
				int j = nItems; 	//start at the end
								
				while(j > 0 && vowelCount(queArray[j-1], item)) { //whichever has more vowels gets priority
					queArray[j] = queArray[j-1];
					j--;
				}
				queArray[j] = item;
				
				nItems++;
			}
			
		}
		
		
			public boolean vowelCount(String first, String second) {
				
				int firstTotal = 0;
				int secondTotal = 0;
				
				char[] targets = {'a','o','u','i','e'};
				for(int i = 0; i < first.length(); i++) {
					for(int j =0; j<targets.length;j++) {
						if(first.charAt(i)==targets[j]) {
							firstTotal++;
						}
					}
				}
				
				for(int i = 0; i < second.length(); i++) {
					for(int j =0; j<targets.length;j++) {
						if(second.charAt(i)==targets[j]) {
							secondTotal++;
						}
					}
				}
				
				if(firstTotal>secondTotal) {
					return true;
				} else if (firstTotal<secondTotal) {
					return false;
				}
				//if they have the same vowels sort alphabetically
				if(first.compareTo(second)<0) {
					return true;
				}
				return false;
			}
		
		public String remove() {		//take item from front of queue
			if(isEmpty()) {				//don't remove if empty
				return null;			
			}
			
			String temp = queArray[nItems-1];	//get value from front
			nItems--;					// one less item
			return temp;
		}
		
		public String peekFront() { // peek at front of queue
			if(isEmpty()) return null;
			return queArray[nItems-1];
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
