package com.pluralsight;

import java.util. *;

public class financialCalculators {
    private static final int Months_IN_A_Year = 12;
    public static void main(String[] args) {

        /**
         * Prompt user to select which calculator do they want?
         * 2-3 calculator options
         */

        // ask user what cal would he like to use?

        Scanner scanner = new Scanner(System.in);

        System.out.print("Which calculator would you like to use, (1-Mortgage or 2-CD calculator) ? ");

        int command = scanner.nextInt();
        if (command == 1) {
            MortgageCalculator();
        }

        else if (command == 2) {
            CDCalculator();
        }
        else {
            System.out.printf("%d -- Invalid command!", command);
        }
    }

        public static void MortgageCalculator() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the principal amount: ");
        double principal = scanner.nextDouble();

        System.out.print("Enter the annual interest rate: ");
        float annualInterestRate = scanner.nextFloat();

        System.out.print("Enter the term in years: ");
        int termInYears = scanner.nextInt();

        float monthlyInterestRate = annualInterestRate / Months_IN_A_Year;
        int numberOfPayments = termInYears * Months_IN_A_Year;

        double monthlyPayment = principal * (
                (monthlyInterestRate * (Math.pow(1 + monthlyInterestRate, numberOfPayments))) /
                        ((Math.pow(1 + monthlyInterestRate, numberOfPayments)) - 1)
                );

        // Round up monthlyPayment
        monthlyPayment = Math.ceil(monthlyPayment);

        System.out.println("Monthly payment: " + monthlyPayment);
    }

    public static void CDCalculator() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the Deposit amount: ");
        double principal = scanner.nextDouble();

        System.out.print("Enter the interest rate: ");
        double annualRate = scanner.nextDouble();

        System.out.print("Enter number of years: ");
        double years = scanner.nextDouble();

        int compoundPerYear = 365;

        //Calculate compound interest
        double ratePerPeriod = annualRate / compoundPerYear;
        int totalPeriods = (int) (compoundPerYear * years);
        double amount = principal * Math.pow(1 + ratePerPeriod, totalPeriods);

        amount = Math.ceil(amount);

        System.out.println("The future value of the investment " + amount);
    }
}
