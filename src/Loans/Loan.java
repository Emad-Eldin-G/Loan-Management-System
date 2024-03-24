package Loans;

import Helpers.Time;

import java.util.Scanner;

public abstract class Loan {
    String recordId;
    String loanType;
    double interestRate;
    double amountLeftToPay;
    int termLeft;


    // getter and setter methods
    public String getRecordId() {
        return this.recordId;
    }
    public double getAmountLeftToPay() {
        return this.amountLeftToPay;
    }

    public String getLoanType() {
        return this.loanType;
    }

    public double getInterestRate() {
        return this.interestRate;
    }

    public int getTermLeft() {
        return this.termLeft;
    }


    public String setID(){
        Scanner scanner = new Scanner(System.in);
        Time.type("pause");

        System.out.println("Please input the following details to add this loan: ");
        Time.type("sleep");

        String newRecordId = null;
        while (true) {
            try {
                System.out.print("Please input an ID: ");
                newRecordId = scanner.next();
            } catch (Exception e) {
                System.out.println("Record ID must be in the format XXXXXX (0-9) (6 characters)");
                continue;
            }

            if (!newRecordId.matches("[0-9]{6}")){ // check if the input is 6 digits
                System.out.println("Record ID must be in the format XXXXXX (0-9) (6 characters)");
                continue;
            } else {
                break;
            }
        }

        return newRecordId;
    }

    public double setLoanAmount(){
        Scanner scanner = new Scanner(System.in);
        double loanAmount = 0;
        while (true) {
            System.out.print("Please enter the loan amount: ");
            try {
                loanAmount = scanner.nextDouble();

                if (loanAmount < 0) {
                    System.out.println("Loan amount must be a positive number");
                    continue;
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Loan amount must be a number.");
                scanner.nextLine(); // Consume the invalid input
            }
        }

        return loanAmount;
    }

    public double setInterestRate(){
        Scanner scanner = new Scanner(System.in);
        double interestRate = 0;
        while (true) {
            System.out.print("Please enter the interest rate: ");
            try {
                interestRate = scanner.nextDouble();

                if (interestRate < 0) {
                    System.out.println("Interest rate must be a positive number");
                    continue;
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Interest rate must be a number.");
                scanner.nextLine(); // Consume the invalid input
            }
        }

        return interestRate;
    }

    public int setTermLeft(){
        Scanner scanner = new Scanner(System.in);
        int termLeft = 0;
        while (true) {
            System.out.print("Please enter the term left: ");
            try {
                termLeft = scanner.nextInt();

                if (termLeft < 0) {
                    System.out.println("Term left must be a positive number");
                    continue;
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Term left must be a number.");
                scanner.nextLine(); // Consume the invalid input
            }
        }

        return termLeft;
    }


}