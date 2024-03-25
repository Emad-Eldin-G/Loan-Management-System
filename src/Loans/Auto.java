package Loans;

import Helpers.Time;

public class Auto extends Loan{

    public void createAuto(){
        System.out.println("Auto Loan Creator Tool Spinning Up...");

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
        this.loanType = "Auto";
    }
}
