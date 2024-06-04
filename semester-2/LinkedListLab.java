import java.util.Scanner;

	public class LinkedListLab {
		public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);	
		LinkedList theList = new LinkedList(); //make a new list
		boolean quit = true;
		
			while(quit) {
				System.out.println("Enter a word: ");
				
				String data = sc.nextLine();
									
				if(data.equalsIgnoreCase("END")) {	
						theList.displayList();
						break;
					}	
				theList.insertHead(data);
			}
		}
	}
	
	class Link {
		
		Link next;		//next link in List
		String data;	//data item
		
		public Link(String data) {		//constructor
			this.data = data;			//initialize data
		}	
	}
		//end class Link
	
	class LinkedList{	
		Link head;		// ref to first link on list
		
		public LinkedList() {	// constructor
			head = null;
		}
		
		public boolean isEmpty() {
			return (head == null);	//true if list is empty
		}
		
		public void insertHead(String data) {
			Link newLink = new Link(data);
			newLink.next = head;
			head = newLink;
		}
		public Link deleteHead() {
			Link temp = head;
			head = head.next;
			return temp;		
		}
		public void displayList() {
			System.out.println("List (first-->last): ");
			Link current = head;
				while(current != null) {
					System.out.println(current.data);
					current = current.next;
				}
				
			System.out.println("");
		}
	}


