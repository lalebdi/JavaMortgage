import java.text.NumberFormat;
import java.util.Scanner;

public class Mortgage {
    public static void main(String[] args) {
        final int MONTHS_IN_YEAR = 12;
        final int PERCENT = 100;

        int principal;
        double monthlyInterest;
        int numberOfPayments;

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Principal: ");
             principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1000000) {

                break;
            }
            System.out.println("Your principal should be between 1,000 and 1,000,000");
        }

        while (true) {
            System.out.print("Interest Rate: ");
            double annualInterest = scanner.nextDouble();
            if (annualInterest >=1 && annualInterest <= 30 ) {
                monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Your annual interest should be between 1 and 30");
        }
        while(true) {
            System.out.print("Period in years: ");
            int years = scanner.nextInt();
            if (years >= 1 && years <=30) {
                numberOfPayments = years * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("The period should be between 1 and 30.");
        }
        double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) / (Math.pow(1+ monthlyInterest, numberOfPayments)-1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }
}
