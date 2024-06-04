public class RecursionClassFailTester {

    public static void main(String[] args) {

        String input = "PPLLAPLLP";
        String input1 = "PPALLP";
        String input2 = "PPALLLPPPPPP";
        int A_count = 0;
        int L_count = 0;

        if (passRecur(input2, A_count, L_count)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

    }

    public static boolean passRecur(String str1, int A_count, int L_count) {

        // base case
        if (str1.length() == 0) {
            return true;
        } else {
            // check the last character
            char lastChar = str1.charAt(str1.length() - 1);

            if (lastChar == 'P') {
                L_count = 0;
            }

            if (lastChar == 'A') {
                A_count++;
                L_count = 0;

                if (A_count >= 2) {
                    return false;
                }
            }

            if (lastChar == 'L') {
                L_count++;

                if (L_count >= 3) {
                    return false;
                }
            }

            // knock off the last character
            str1 = str1.substring(0, str1.length() - 1);

            return passRecur(str1, A_count, L_count);
        }

    }

}
