import java.util.HashMap;  
import java.util.Map;  
import java.util.PriorityQueue; 
import java.util.Scanner;


	public class HuffmanEncoding {  
	    public static void main(String args[])  
	    {  
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter your text: ");
	        String str1 = sc.nextLine();
	      
	        //function calling  
	        createHuffmanTree(str1);  
	    }  
	    //function to build Huffman tree  
	    public static void createHuffmanTree(String text)  
	    {  
	        //count the frequency of each character and store it in a map  
	        //creating an instance of the Map   
	        Map<Character, Integer> freq = new HashMap<>();  
	          
	        // convert the String text into character array
	        char[] charArray = text.toCharArray();	//toCharArray will turn a String into a char array
	        
	        //Count the frequency of each letter
	        for (int i = 0; i < charArray.length; i++) {
	        	//go through every element in the charArray and check
	            char c = charArray[i];
	         
	            // Check if the character exists in the map
	            if (freq.containsKey(c)) {
	                
	                freq.put(c, freq.get(c) + 1);	// If it exists, increment its frequency
	            
	            } else {
	                // If it doesn't exist, add it to the map with a frequency of 1
	                freq.put(c, 1);
	            } 
	        }
	        
	        //create a priority queue that stores current nodes of the Huffman tree.   
	        //highest priority means the lowest frequency   
	        PriorityQueue<Node> pq = new PriorityQueue<>();  
	     
	     // adding the (forest of trees) to the Priority Queue   
	     // Loop through each key in the key set of the freq map
	        for (Character key : freq.keySet()) {
	            // Get the value (frequency) corresponding to the key
	            int value = freq.get(key);           
	            // Create a leaf node using the key and value, and add it to the priority queue
	            pq.add(new Node(key, value));
	        } 
	        
	        //while loop runs until there is more than one node in the queue  
	        while (pq.size() != 1)  
	        {  
	            //removing the nodes having the highest priority (the lowest frequency) from the queue  
	            Node left = pq.poll();  
	            Node right = pq.poll();  
	            //create a new internal node with these two nodes as children and with a frequency equal to the sum of both nodes' frequencies. Add the new node to the priority queue.  
	            //sum up the frequency of the nodes (left and right) that we have deleted   
	            int sum = left.freq + right.freq;  
	            //adding a new internal node (deleted nodes i.e. right and left) to the queue with a frequency that is equal to the sum of both nodes  
	            pq.add(new Node(null, sum, left, right));  
	        } 
	        
	        //root stores pointer to the root of Huffman Tree  
	        Node root = pq.peek();  
	        
	        //Go over the Huffman tree and store the Huffman codes in a map  
	        // e.g. t, 101
	        // huffman code map is for storing the letter, and encoded format
	        Map<Character, String> huffmanCode = new HashMap<>();  
	        encodeData(root, "", huffmanCode);  
	        
	        //print the Huffman codes for the characters  
	        System.out.println("Huffman Codes of the characters are: " + huffmanCode);  
	        
	        //prints the initial data  
	        System.out.println("The initial string is: " + text);  
	        
	        //create encodedString to store encodedString   
	        String encodedString = "";  
 
	        // go through the character array
	        for (int i = 0; i < text.length(); i++) {
	            char c = text.charAt(i);
	            
	            encodedString += huffmanCode.get(c);	// c is the character, huffmanCode.get(Character) FINDS the String as part of the Map<Character, String>
	        }   
	        System.out.println("The encoded string is: " + encodedString);  	         
	    }  
	    
	    //traverse the Huffman Tree and store Huffman Codes in a Map  
	    //function that encodes the data  
	    public static void encodeData(Node root, String str, Map<Character, String> huffmanCode) {
	        if (root == null) {
	            return;
	        }
	        
	        if (isLeaf(root)) {
	            if (str.length() > 0) {	// If the current string is not empty, assign it as the Huffman code for the leaf node
	                huffmanCode.put(root.ch, str);
	            } else {
	                huffmanCode.put(root.ch, "1");	// If the current String is empty, assign "1" as the Huffman code for the leaf node
	            }
	        } else {
	            // Encode left child with '0' appended to the current string
	            encodeData(root.left, str + '0', huffmanCode);
	            // Encode right child with '1' appended to the current string
	            encodeData(root.right, str + '1', huffmanCode);
	        }
	    }  
 
	    //function to check if the Huffman Tree contains a single node  
	    public static boolean isLeaf(Node root)   
	    {  
	        //returns true if both conditions return ture  
	        return root.left == null && root.right == null;  
	    }       
	} 
	//Creates nodes of the tree  
	class Node implements Comparable<Node> 
	{  
	    //storing character in ch variable of type character  
	    Character ch;  
	    //storing frequency in freq variable of type int  
	    Integer freq;  
	    //initially both child (left and right) are null  
	    Node left = null;   
	    Node right = null;   
	     
	    Node(Character ch, Integer freq)  	// LEAF Constructor takes in Character and Frequency e.g 't', 3
	    {  
	        this.ch = ch;  
	        this.freq = freq;  
	    }  
	 
	    public Node(Character ch, Integer freq, Node left, Node right)  // PARENT CONSTRUCTOR for new root node that has summed frequency value of children
	    {  
	        this.ch = ch;  
	        this.freq = freq;  
	        this.left = left;  
	        this.right = right;  
	    }  
	    
	    public int compareTo(Node other) {		// Compare nodes based on frequency (used for priority queue)
	    	return this.freq.compareTo(other.freq);
	    }
	} 
