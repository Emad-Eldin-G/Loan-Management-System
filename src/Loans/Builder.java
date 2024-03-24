package Loans;

import Helpers.Time;

import java.util.Scanner;

public class Builder extends Loan{
    private int overpayment; // should be a percentage between 0 and 2

    public void createBuilder(){
        System.out.println("Builder Loan Creator Tool Spinning Up...");
        Time.type("pause");

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
        this.loanType = "Builder";
        // Initialize overpayment to 0
        this.overpayment = 0;
    }
}
