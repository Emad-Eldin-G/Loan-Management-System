import java.util.Scanner;

public class Record {
    private String recordId;
    private String customerId;
    private String loanType;
    private double interestRate;
    private double amountLeftToPay;
    private int loanTermLeft;

    public Record() {
        // Default constructor
    }

    public Record(String recordId, String customerId, String loanType, double interestRate,
                  double amountLeftToPay, int loanTermLeft) {
        this.recordId = recordId;
        this.customerId = customerId;
        this.loanType = loanType;
        this.interestRate = interestRate;
        this.amountLeftToPay = amountLeftToPay;
        this.loanTermLeft = loanTermLeft;
    }

    public void updateRecord(String recordId, String customerId, String loanType, double interestRate,
                             double amountLeftToPay, int loanTermLeft) {
        this.recordId = recordId;
        this.customerId = customerId;
        this.loanType = loanType;
        this.interestRate = interestRate;
        this.amountLeftToPay = amountLeftToPay;
        this.loanTermLeft = loanTermLeft;
    }

    public String getRecordId() {
        return recordId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getLoanType() {
        return loanType;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public double getAmountLeftToPay() {
        return amountLeftToPay;
    }

    public int getLoanTermLeft() {
        return loanTermLeft;
    }
}
