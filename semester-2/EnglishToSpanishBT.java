import java.util.ArrayList; //need this import to use ArrayList
import java.io.File;
import java.util.Scanner;
import java.util.Random; // need to use Random

public class Lab07_v05 {

    public static void main(String[] args) {

        // Path to the Excel CSV file which is in the format englishword,spanishword
        String filePath = "C:\\Users\\Administrator\\Documents\\MaynoothUniversity\\Semester2\\\\CS211DataStructuresAlgorithms2\\\\Lab7\\\\EnglishSpanish.csv";

        // Create a binary tree
        Tree binaryTree = new Tree();

        // Read the content of the CSV file and insert into the binary tree
        readCSVAndInsert(filePath, binaryTree);

        // Get input, translate, and print translation
        String[] EnglishSentenceArray = TranslateEnglishToSpanish(binaryTree);

        // Print the structure of the binary tree
        // binaryTree.printTree(binaryTree.root);

        int steps = binaryTree.steps;
        System.out.println("\nSteps Total: " + steps);

        int TotalWords = EnglishSentenceArray.length;
        int AverageStepsPerWord = steps / TotalWords;
        System.out.println("\nSteps Average: " + AverageStepsPerWord);

        System.out.println("\nThe resulting binary tree has " + binaryTree.maxLevelCount + " levels.");

        // System.out.println("\nAverage Steps Per Word: " +
        // binaryTree.averageStepsPerWord);

    }

    public static String[] TranslateEnglishToSpanish(Tree binaryTree) {

        // Enter English sentence as a String
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter English sentence: ");

        String EnglishSentence = sc.nextLine();
        EnglishSentence = EnglishSentence.toLowerCase(); // Verify input by making lowercase
        String[] EnglishSentenceArray = EnglishSentence.split(" "); // this will split the sentence words into elements
                                                                    // in an array

        // for(int i = 0; i < EnglishSentenceArray.length; i++) { //Print out each index
        // to check
        // System.out.println(EnglishSentenceArray[i]);
        // }

        String[] SpanishSentence = new String[EnglishSentenceArray.length]; // Since word by word translation
                                                                            // English/Spanish sentences will be the
                                                                            // same

        for (int i = 0; i < SpanishSentence.length; i++) {
            SpanishSentence[i] = binaryTree.find(EnglishSentenceArray[i]); // Translate each word using find in the
                                                                           // binary Tree
        }

        // Print the sentence
        System.out.println("\nThe translated Spanish sentence is: ");
        for (int i = 0; i < SpanishSentence.length; i++) {
            System.out.print(SpanishSentence[i].toUpperCase() + " ");
        }

        return EnglishSentenceArray;

    }

    public static void readCSVAndInsert(String filePath, Tree binaryTree) {

        File file = new File(filePath);

        ArrayList<String> fileArrayList = new ArrayList<>(); // Store read in file as an ArrayList
        try {

            Scanner sc = new Scanner(file);

            // Read each line from the file and split into English and Spanish words
            while (sc.hasNextLine()) {

                // this will take the full String e.g. aardvark,cerdo hormiguero
                String line = sc.nextLine();
                // will add each line
                fileArrayList.add(line);

            }
            sc.close();
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }

        System.out.println("Inserted List: \n" + fileArrayList); //

        shuffleArrayList(fileArrayList); // shuffle is used to reOrder an ArrayList, it is a library for arrayLists

        System.out.println("ReOrdered List: \n" + fileArrayList);

        // Now insert the shuffled ArrayList into the binary tree
        for (int i = 0; i < fileArrayList.size(); i++) {

            String line = fileArrayList.get(i);

            // this will take the split the String at the "," : "aardvark,cerdo hormiguero"
            // into two strings in the String array pair. pair[0] == aardvark pair[1]==cerdo
            // hormiquero
            String[] pair = line.split(","); // Split the line using comma at comma

            if (pair.length == 2) {
                // Insert the pair of English and Spanish words into the binary tree
                binaryTree.insert(pair); // Insert each English-Spanish pair into the binary tree
            }
        }
    }

    public static ArrayList<String> shuffleArrayList(ArrayList<String> list) {

        Random rand = new Random();
        int n = list.size();

        // Iterate over the list from the last element to the first
        for (int i = n - 1; i > 0; i--) {

            // Generate a random index j between 0 <= j <= i
            int j = rand.nextInt(i + 1);

            // Swap elements at i and j indices
            String temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }

        return list;
    }

    static class Node {
        public String[] data; // Data consisting of English and Spanish words
        public Node leftChild; // Left child node
        public Node rightChild; // Right child node

        public Node(String[] data) {
            this.data = data; // Initialize node with the English-Spanish pair
            this.leftChild = null;
            this.rightChild = null;
        }
    }

    static class Tree {
        public Node root; // Root node of the binary tree
        public int maxLevelCount = 0;
        private int currentLevelCount = 0;

        public int steps;

        public Tree() {
            this.root = null;
        }

        public void insert(String[] pair) {
            // Trim the English word before insertion to remove any invisible characters
            String englishWord = pair[0].trim();

            // two strings in the String array pair. pair[0] == aardvark pair[1]==cerdo
            // hormiquero
            Node newNode = new Node(new String[] { englishWord, pair[1] }); // Create a new node with the
                                                                            // English-Spanish pair

            if (root == null) {
                root = newNode; // If the tree is empty, set the new node as the root
                return;
            }

            Node current = root;
            currentLevelCount = 0; // reset currentLevelCount to 0

            Node parent = null;
            while (true) {
                parent = current;
                int compareResult = current.data[0].compareTo(englishWord);
                if (compareResult > 0) { // If the current English word is greater than the new English word

                    currentLevelCount++; // increment the currentLevelCount
                    current = current.leftChild; // Move to the left child

                    if (current == null) {
                        parent.leftChild = newNode; // Insert the new node as the left child
                        maxLevelCount = setHighestCount(maxLevelCount, currentLevelCount);
                        return;
                    }
                } else if (compareResult < 0) { // If the current English word is less than the new English word

                    currentLevelCount++; // increment the currentLevelCount
                    current = current.rightChild; // Move to the right child

                    if (current == null) {
                        parent.rightChild = newNode; // Insert the new node as the right child
                        maxLevelCount = setHighestCount(maxLevelCount, currentLevelCount);
                        return;
                    }
                } else {
                    current.data[1] = pair[1]; // If the English word already exists, update the Spanish translation
                    return;
                }
            }
        }

        public void printTree(Node node) {
            if (node != null) {
                printTree(node.leftChild); // Recursively print left subtree
                System.out.println("English: " + node.data[0] + ", Spanish: " + node.data[1]); // Print current node's
                                                                                               // data
                printTree(node.rightChild); // Recursively print right subtree
            }
        }

        public String find(String englishWord) {
            Node current = root; // Start from the root

            // Check if the root node's English word matches the given word
            String rootEnglishWord = root.data[0].trim().toLowerCase();
            String trimmedEnglishWord = englishWord.trim().toLowerCase();

            if (rootEnglishWord.equals(trimmedEnglishWord)) {
                steps++;
                return root.data[1]; // Return the corresponding Spanish word
            }

            while (current != null) {
                // Use trim and lowercase incase invisible spaces when the file read in
                String currentNodeEnglishWord = current.data[0].trim().toLowerCase();
                int compareResult = currentNodeEnglishWord.compareTo(trimmedEnglishWord);

                if (compareResult == 0) { // If the current nodes English word matches the given word
                    steps++;
                    return current.data[1]; // Return the corresponding Spanish word

                } else if (compareResult > 0) { // If the current English word is greater than the given word
                    steps++;
                    current = current.leftChild; // Move to the left child

                } else { // If the current English word is less than the given word
                    steps++;
                    current = current.rightChild; // Move to the right child
                }
                // stepsSum += stepsPerWord;
            }
            return trimmedEnglishWord; // Return the English word if not found in the tree
        }

        public int setHighestCount(int highestCount, int currentCount) {

            if (highestCount < currentCount) {
                highestCount = currentCount;
            }
            return highestCount;
        }

    }
}
