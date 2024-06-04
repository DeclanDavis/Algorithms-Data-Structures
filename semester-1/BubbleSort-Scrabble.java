import java.util.Scanner;

public class ScrabbleSort {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("How many words?");
		int n = sc.nextInt();
		
		//call getWords to fill array
		String[] list = getWords(n);
		System.out.println("Unsorted List:");
		printList(list);
		
//		//sort list alphabetically 
//		Arrays.sort(list);
//		System.out.println("Alphabetically Sorted List:");
//		printList(list);
		
		System.out.println();
		String[] sortedList = bubbleSort(list);
		System.out.println("Sorted List:");
		printList(sortedList);
		sc.close();
				
	}
	
	public static void printList(String[] str) {
		
		for(int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}
	}

	public static String[] getWords(int n) {
		
		// take in a list of words and store them in a 
		// String array of size n
		
		Scanner sc = new Scanner(System.in);
		
		String[] list = new String[n];
		
			for(int i = 0; i < n; i++) {
				list[i] = sc.nextLine();
			}
		
		return list;
	}
	
	public static String[] bubbleSort(String[] list) {
		
		//take in unsorted list and sort it from lowest to highest
		for(int outer = list.length-1; outer > 0; outer--) {
		
			for(int i = 0; i < outer; i++) {
//					 
					if(getValue(list[i]) > getValue(list[i+1]) ) {
						
						String temp = list[i];
						list[i] = list[i+1];
						list[i+1] = temp;
					}
					
					//if they are the same value, sort alphabetically
					if(getValue(list[i]) == getValue(list[i+1]) && list[i].compareTo(list[i+1]) > 0 ) {
						String temp = list[i];
						list[i] = list[i+1];
						list[i+1] = temp;
					}
				}
		}
		
		return list;
	}
	
	public static int getValue(String str1) {
		
		// a method to get a numeric value for each word
		//by adding the value of every character
		int value = 0;
		String str = str1.toUpperCase();
		for(int i = str.length()-1; i >= 0; i--) {
			char letter = str.charAt(i);
			
			if(letter == 'A' || letter == 'E' || letter == 'I' || letter == 'O' || 
					letter == 'U' || letter == 'L' || letter == 'N' || letter == 'S'
					|| letter == 'T' || letter == 'R') {
				value += 1;				
			}
			
			if(letter == 'D' || letter == 'G') {
				value += 2;				
			}
			
			if(letter == 'B' || letter == 'C' || letter == 'M' || letter == 'P') {
				value += 3;				
			}
			
			if(letter == 'F' || letter == 'H' || letter == 'V' || letter == 'W'
					|| letter == 'Y') {
				value += 4;				
			}
			
			if(letter == 'K') {
				value += 5;				
			}
			
			if(letter == 'J' || letter == 'X') {
				value += 8;				
			}
			
			if(letter == 'Q' || letter == 'Z') {
				value += 10;				
			}
		}
		
		return value;
		
	}
}
