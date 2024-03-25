package Loans;

import Helpers.Time;

import java.util.Scanner;

public class Mortgage extends Loan{
    private int overpayment; // should be a percentage between 0 and 2

    public void createMortgage(){
        System.out.println("Mortgage Creator Tool Spinning Up...");

        // Broken down each input into separate methods for readability and better design
        // Each method returns the value to be set in the constructor
        String newRecordId = setID();
        double interestRate = setInterestRate();
        double loanAmount = setLoanAmount();
        int termLeft = setTermLeft();


        this.recordId = newRecordId;
        this.interestRate = interestRate;
        this.amountLeftToPay = loanAmount;
        this.termLeft = termLeft;
        this.loanType = "Mortgage";
        // Initialize overpayment to 0
        this.overpayment = 0;
    }

}
