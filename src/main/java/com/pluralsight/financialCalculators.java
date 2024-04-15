package com.pluralsight;

import java.util. *;

public class financialCalculators {
    private static final int Months_IN_A_Year = 12;
    public static void main(String[] args) {

        // ask user what calculator would they like to use?

        Scanner scanner = new Scanner(System.in);

        System.out.print("Which calculator would you like to use, (1-Mortgage or 2-CD calculator)? ");

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
        double annualInterestRate = scanner.nextFloat();

        System.out.print("Enter the term in years: ");
        int termInYears = scanner.nextInt();

        double monthlyInterestRate = annualInterestRate / Months_IN_A_Year;
        int numberOfPayments = termInYears * Months_IN_A_Year;

        double monthlyPayment = principal * (
                (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments)) /
                        ((Math.pow(1 + monthlyInterestRate, numberOfPayments)) - 1)
                );

            double totalInterest = principal *
                    Math.pow(1 + monthlyInterestRate, numberOfPayments) - principal;

        System.out.printf("Monthly payment: %.2f\n", monthlyPayment);
        System.out.printf("Total interest paid: %.2f\n", totalInterest);
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


        double ratePerPeriod = annualRate / compoundPerYear;
        double totalPeriods = compoundPerYear * years;

        // Total amount of time, money invested for, in years.
        double amount = principal * Math.pow(1 + ratePerPeriod, totalPeriods);

        // Total amount of interest earned
        double totalInterest = amount - principal;

        System.out.printf("The future value of the investment: %.2f\n", amount);
        System.out.printf("Total interest earned: %.2f\n", totalInterest);
    }
}