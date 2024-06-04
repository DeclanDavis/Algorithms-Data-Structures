package Lab2;

public class RecursionPalindrome {
	public static void main(String[] args) {
		
		String str1 = "hello";
		String str2 = "enavane";
		
		System.out.println(palindrome(str1));
		System.out.println(palindrome(str2));
	}
		
	//recursive method to check is a String is a palindrome
	public static boolean palindrome(String str1) {
		
		//base case
		if(str1.length() <= 1) { 
			return true;
		} else { //whats the smallest amount of work you can do
			if(str1.charAt(0) == str1.charAt(str1.length()-1)) {
				//call the method within the method
				str1 = str1.substring(1, str1.length()-1);
				return palindrome(str1);
			} else {
				return false;
			}	
		}
	}
}
	

