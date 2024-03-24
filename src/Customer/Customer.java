package Customer;

import Helpers.Time;
import Loans.Loan;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer implements CheckPrinter {
    private String customerId;
    private double annualIncome;
    private boolean eligibility;
    private ArrayList<Loan> creditRecords = new ArrayList<>();

    public Customer () {
        // Default constructor
        createNewCustomer();

    }

    // Getter and setter methods
    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getAnnualIncome() {
        return annualIncome;
    }
    public void setAnnualIncome(double annualIncome) {
        this.annualIncome = annualIncome;
    }

    public boolean isEligibility() {
        return eligibility;
    }
    public void setEligibility(boolean eligibility) {
        this.eligibility = eligibility;
    }

    public ArrayList<Loan> getCreditRecords() {
        return creditRecords;
    }
    public void setCreditRecords(ArrayList<Loan> creditRecords) {
        this.creditRecords = creditRecords;
    }

    private void createNewCustomer(){
        Scanner scanner = new Scanner(System.in);

        // check that id follows format AAAXXX where A is a letter and X is a digit 0-9
        String newCustomerId = null;
        while (true) {
            try {
                System.out.print("Please choose an ID for the customer: ");
                newCustomerId = scanner.next();
            } catch (Exception e) {
                System.out.println("Customer ID must be in the format AAAXXX where A is a letter and X is a digit 0-9");
                continue;
            }

            if (!newCustomerId.matches("[A-Z]{3}[0-9]{3}")){ // check if the input is 3 letters followed by 3 digits
                System.out.println("Customer ID must be in the format AAAXXX where A is a letter and X is a digit 0-9");
                continue;
            } else {
                break;
            }
        }

        // check that annual income is a positive number
        double newAnnualIncome = 0;
        while (true) {
            System.out.print("Please enter annual income: ");
            try {
                newAnnualIncome = scanner.nextDouble();

                if (newAnnualIncome < 0) {
                    System.out.println("Annual income must be a positive number");
                    continue;
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Annual income must be a number.");
                scanner.nextLine(); // Consume the invalid input
            }
        }

        this.customerId = newCustomerId;
        this.annualIncome = newAnnualIncome;
        this.eligibility = true;
    }

    public void modifyCustomer() {
        Scanner scanner = new Scanner(System.in);

        // check that annual income is a positive number
        double newAnnualIncome = 0;
        while (true) {
            System.out.print("Please enter annual income: ");
            try {
                newAnnualIncome = scanner.nextDouble();

                if (newAnnualIncome < 0) {
                    System.out.println("Annual income must be a positive number");
                    continue;
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Annual income must be a number.");
                scanner.nextLine(); // Consume the invalid input
            }
        }

        Time.type("sleep");

        System.out.println("Eligibilty: ");
        boolean eligibility = scanner.nextBoolean();

        this.annualIncome = newAnnualIncome;
        this.eligibility = eligibility;
    }

    public void addCreditRecord(Loan record) {
        creditRecords.add(record);
    }

    public void deleteCreditRecord(Loan record) {
        creditRecords.remove(record);
    }

    public String getId() {
        return this.customerId;
    }

    private double amountLeftToPay() {
        double amountLeftToPay = 0;
        for (Loan creditRecord : creditRecords) {
            amountLeftToPay += creditRecord.getAmountLeftToPay();
        }
        return amountLeftToPay;
    }

    private void printFormattedLoans() {
        // Printing headers with column length of 20 characters
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s\n", " ", "Record ID", "Loan Type", "Interest Rate", "Amount Left To Pay", "Term Left");
        // Printing Loans in a row tabular way
        for (Loan creditRecord : creditRecords) {
            System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s\n", " ", creditRecord.getRecordId(), creditRecord.getLoanType(), creditRecord.getInterestRate(), creditRecord.getAmountLeftToPay(), creditRecord.getTermLeft());
        }
    }

    @Override
    public boolean checkEligibility() {
        double annualIncomeFourX = this.annualIncome * 4;
        if (amountLeftToPay() > annualIncomeFourX) {
            this.eligibility = false;
            return false;
        } else {
            this.eligibility = true;
            return true;
        }
    }

    @Override
    public void printCustomer() {
        System.out.println("CustomerID " + this.customerId);
        System.out.println(" ");
        if (this.eligibility) {
            System.out.println("Eligible to arrange new loans - YES");
        } else {
            System.out.println("Eligible to arrange new loans - NO");
        }
        System.out.println(" ");

        printFormattedLoans();
    }
}
