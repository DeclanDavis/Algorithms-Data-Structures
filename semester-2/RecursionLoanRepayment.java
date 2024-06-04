public class RecursionLoanRepayment {

    public static void main(String[] args) {

        double loan = 250000;
        double annualInterest = 0.03;
        double monthlyRepay = 1600;

        System.out.println("It will take " + loanRepay(loan, annualInterest, monthlyRepay) + " months.");

    }

    public static int loanRepay(double loan, double annualInterest, double monthlyRepay) {

        // base case - when the loan is 0
        if (loan <= 0) {
            return 0;
        } else {
            // what is the smallest amount of work you can do

            // add monthly interest
            loan = loan + ((loan * annualInterest) / 12);

            // make repayment
            loan = loan - monthlyRepay;

            // call the method within itself
            return loanRepay(loan, annualInterest, monthlyRepay) + 1;
        }
    }
}
