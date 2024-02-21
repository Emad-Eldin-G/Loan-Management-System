import java.util.Arrays;
import java.util.Scanner;

public class XYZBank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter maximum number of records: ");
        int maxRecords = scanner.nextInt();
        System.out.println("_________________________________");

        Record[] records = new Record[maxRecords];

        for (int i = 0; i < maxRecords; i++) {
            System.out.println("Enter details for Record " + (i + 1) + ":");


            System.out.print("Record ID: ");
            String recordId = scanner.next();

            while (!(Integer.parseInt(recordId) > 0 && Integer.parseInt(recordId) < 999999)) {
                System.out.print("Please choose an ID between 0 and 999,999: ");
                recordId = scanner.next();
            }

            System.out.println("-----");

            System.out.print("Customer ID: ");
            String customerId = scanner.next();

            while (!(customerId.matches("[A-Z]{3}[0-9]{3}"))) {
                System.out.print("Customer ID must be in the following format: ");
                System.out.print("XXX000, where X is A-Z and 0 is 0-9: ");
                customerId = scanner.next();
            }

            System.out.println("-----");

            System.out.print("Loan Type (Auto/Builder/Mortgage/Personal/Other): ");
            String loanType = scanner.next();
            String[] allowed = {"Auto", "Builder", "Mortgage", "Personal", "Other"};
            // Helper isInArray checks that loan Type chosen is in the allowed types array

            while (!(Helpers.isInArray(loanType, allowed))) {
                System.out.print("Loan Type must be Auto - Builder - Mortgage - Personal - Other:  ");
                loanType = scanner.next();
            }

            System.out.println("-----");

            System.out.print("Interest Rate: ");
            double interestRate = scanner.nextDouble();
            // The highest interest rate ever recorded was around 18.63%, so the upper bound to check abnormality is 19
            while ((interestRate < 0.0)  || (interestRate > 19.0)) {
                if (interestRate < 0.0) {
                    System.out.print("Interest rate must be positive: ");
                }
                if (interestRate > 20.0) {
                    System.out.print("Please input a reasonable rate: ");
                }

                interestRate = scanner.nextDouble();
            }

            System.out.println("-----");

            System.out.print("Amount Left to Pay (in thousands pounds): ");
            double amountLeftToPay = scanner.nextDouble();
            // Amount left can not be negative, otherwise what is left 🤷🏼
            while (amountLeftToPay < 0.0) {
                System.out.print("Amount left can not be negative");
                System.out.print("Please retry inputting: ");
                amountLeftToPay = scanner.nextDouble();
            }

            System.out.println("-----");

            System.out.print("Loan Term Left (in years): ");
            int loanTermLeft = scanner.nextInt();
            // Number of years can not be negative, it does not make sense 🤷🏼
            while (loanTermLeft < 0.0) {
                System.out.print("Loan term left can not be negative");
                System.out.print("Please retry inputting: ");
                loanTermLeft = scanner.nextInt();
            }


            System.out.println("_________________________________");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

            // Creates a new Record object for that entry, the moves on
            records[i] = new Record(recordId, customerId, loanType, interestRate, amountLeftToPay, loanTermLeft);
        }

        System.out.println("\nRecords:");
        // Using helper function to format records and print them to screen
        Helpers.formattedPrint(records);

        scanner.close();
    }
}