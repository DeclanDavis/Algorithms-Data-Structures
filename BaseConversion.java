package Lab05;

import java.util.Scanner;

public class BaseConversion {
	
	//method to convert a character to its numerical value
    public static int returnValueChar(char c) {
    	//Uses ASCII Values
    	// char '0' = int 48
    	// char '9' = int 57
    	//e.g. if c is '5', then (int) c - '0' is equivalent to '(int) '5' - '0',
    	//which is 53 - 48, resulting in 5 as an integer.
        if (c >= '0' && c <= '9') {
            return (int) c - '0';
        } else {
            return (int) c - 'A' + 10;
        }
    }
    
    //method to convert a number to its character 
    public static char returnValueInt(int num) {
        if (num >= 0 && num <= 9) {
            return (char) (num + '0');
        } else {
            return (char) (num - 10 + 'A');
        }
    }

    //method to convert a number in it's given base to base10/decimal
    public static int toDeci(String str, int base) {
        int len = str.length();
        int power = 1;
        int num = 0;

        for (int i = len - 1; i >= 0; i--) {
        	//Check if the digit in the input number is valid for the base
            if (returnValueChar(str.charAt(i)) >= base) {
                System.out.println("Invalid Number");
                return -1;
            }
            //e.g. 124 base5 = 1x5^2 + 2x5^1 + 4x5^0 = 25 + 10 + 4 = 39 base10
            //calculate decimal value using current digit and power
            num += returnValueChar(str.charAt(i)) * power;
            
            //update the power for the next digit towards the left
            power = power * base;
        }
        return num;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("What is your initial base?");
        int base1 = sc.nextInt();
        System.out.println("What base do you want to convert to?");
        int base2 = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter your number to be converted: ");
        String num1 = sc.nextLine();

        //remove minus if negative
        boolean neg = false;
        if (num1.charAt(0) == '-') {
            num1 = num1.substring(1);
            neg = true;
        }

        int base10num = toDeci(num1, base1);

        
        if (neg) {
            base10num = -base10num;
        }

        String remainder = "";
        int div = Math.abs(base10num);
        while (div > 0) {
            int currentRemainder = div % base2;
            remainder = returnValueInt(currentRemainder) + remainder;
            div = div / base2;
        }

        if (neg) {
            remainder = "-" + remainder;
        }

        System.out.println(remainder);

        sc.close();
    }
}

