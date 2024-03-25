import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

import Customer.Customer;
import Helpers.Greeting;
import Helpers.Menu;
import Helpers.Time;
import Loans.*;

public class XYZBank {
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static int maxRecords = 0;
    private static int recordsCount = 0;


    // record count checker method - return bool
    private static boolean checkRecordCount() {
        return recordsCount < maxRecords;
    }


    public static void main(String[] args) {
        Greeting.welcome(); // Prints bank name in ASCII art
        Time.type("pause");
        Time.type("sleep");

        boolean programRunning = true; // program running is initially set to true, as it has just started

        // Ask user for max records
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Please input the maximum number of records to store: ");
                maxRecords = scanner.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Please input a valid positive number...");
                continue;
            }
        }
        Time.type("pause");


        // program continues to run until user chooses to exit (option 8)
        while(programRunning) {

            Menu.printMenu(); // menu printing is called from the Menu class
            // the menu is printed every time the program loops after user has chosen an option

            String option;
            while (true) {
                System.out.print("Choose an option: ");
                option = scanner.next();

                try {
                    Integer.parseInt(option);
                } catch (NumberFormatException e) {
                    System.out.println("Please choose an option between 1 and 8...");
                    continue;
                }

                if (Integer.parseInt(option) >= 1 && Integer.parseInt(option) <= 8) {
                    break;
                } else {
                    System.out.print("Please choose an option between 1 and 8...");
                    Time.type("sleep");
                }
            }


            switch (option) {
                case "1":
                    System.out.println("- New customer -");
                    Time.type("sleep");
                    // Creating customer, constructor directs user on how to create a new customer
                    Customer customer = new Customer();

                    Time.type("pause");
                    System.out.println("Created customer with ID: " + customer.getId());
                    Time.type("sleep");

                    // Adding customer to the list of customers
                    customers.add(customer);
                    break;


                case "2":
                    System.out.println("- Modify customer -");
                    Time.type("sleep");

                    if (customers.isEmpty()) {
                        System.out.println("No customers to modify...");
                        Time.type("sleep");
                        break;
                    }

                    // Ask for customer id to modify
                    System.out.print("Enter ID of customer to modify: ");
                    String customerId = scanner.next();

                    // Query customers to see if customer exists
                    for (Customer c : customers) {
                        if (c.getId().equals(customerId)) {
                            System.out.println("Customer found!");
                            Time.type("sleep");

                            System.out.println("Please follow the prompts to modify customer...");
                            Time.type("sleep");
                            // modify customer
                            c.modifyCustomer();

                            Time.type("pause");
                            System.out.println("Customer modified!");

                            break;
                        } else {
                            System.out.println("Customer not found!");
                            Time.type("sleep");
                            System.out.println("Please check that ID is correct, otherwise customer was not added.");
                        }
                    }
                    break;


                case "3":
                    System.out.println("- Delete customer -");
                    Time.type("sleep");

                    // Ask for customer id to delete
                    System.out.print("Enter ID of customer to delete: ");
                    scanner = new Scanner(System.in);
                    customerId = scanner.next();

                    for (Customer c : customers) {
                        if (c.getId().equals(customerId)) {
                            System.out.println("Customer found...");
                            Time.type("sleep");
                            System.out.println("Deleting Now...");
                            // delete customer (remove from list)
                            customers.remove(c);

                            Time.type("pause");
                            System.out.println("Customer Deleted!");

                            break;
                        } else {
                            System.out.println("Customer not found!");
                            Time.type("sleep");
                            System.out.println("Please check that ID is correct, otherwise customer was not added.");
                        }
                    }


                case "4":
                    System.out.println("- Add Loan to customer -");
                    Time.type("pause");

                    // check if there are customers to add loan to
                    if (customers.isEmpty()) {
                        System.out.println("No customers to add loan to...");
                        Time.type("sleep");
                        break;
                    }

                    // check if there are records to add loan to
                    // if not, the user is notified and the program breaks out of the case
                    if (!checkRecordCount()) {
                        System.out.println("Sorry...");
                        System.out.println("You have reached the maximum number of records to add...");
                        Time.type("sleep");
                        break;
                    }

                    // Ask for customer id to add loan to
                    scanner = new Scanner(System.in);
                    String customerID = null;
                    while (true) {
                        try {
                            System.out.print("Please input ID of customer to start adding Loans: ");
                            customerID = scanner.next();
                        } catch (Exception e) {
                            System.out.println("Customer ID must be in the format AAAXXX where A is a letter and X is a digit 0-9");
                            continue;
                        }

                        if (!customerID.matches("[A-Z]{3}[0-9]{3}")){ // check if the input is 3 letters followed by 3 digits
                            System.out.println("Customer ID must be in the format AAAXXX where A is a letter and X is a digit 0-9");
                            continue;
                        } else {
                            break;
                        }
                    }

                    // Query customers to find customer
                    for (Customer c : customers) {
                        // if customer is found, add loan to customer
                        if (c.getId().equals(customerID)) {

                            // check customer's loan eligibility
                            boolean elig = c.checkEligibility();
                            if (!elig) {
                                System.out.println("Customer found, but is not eligible for a loan...");
                                System.out.println(" "); // add space for readability
                                Time.type("sleep");
                                break;
                            }

                            System.out.println("Customer found!");
                            System.out.println(" "); // add space for readability
                            Time.type("sleep");
                            System.out.println("Please follow the prompts to add loan to customer...");
                            Time.type("sleep");


                            // first ask user to choose loan type
                            System.out.println("Choose loan type: ");
                            Time.type("sleep");
                            System.out.println("1. Mortgage");
                            System.out.println("2. Builder");
                            System.out.println("3. Personal");
                            System.out.println("4. Auto");
                            System.out.println("5. Other");
                            System.out.println(" "); // add space for readability

                            String loanType = null; // initialize loan type variable
                            while (true) {
                                try {
                                    System.out.print("Please choose a loan type: ");
                                    loanType = scanner.next();
                                    if (Integer.parseInt(loanType) >= 1 && Integer.parseInt(loanType) <= 5) {
                                        break;
                                    } else {
                                        System.out.print("Please choose a loan type between 1 and 5...");
                                        Time.type("sleep");
                                    }
                                } catch (Exception e) {
                                    System.out.println("Please choose a loan type between 1 and 5...");
                                    continue;
                                }
                            }


                            System.out.println(" "); // add space for readability


                            // Then create a loan based on the type
                            switch (loanType) {
                                case "1":
                                    // create mortgage loan
                                    Mortgage mortgage = new Mortgage();
                                    mortgage.createMortgage();
                                    // check that loan amount is less than 4 times the annual income
                                    if (mortgage.getAmountLeftToPay() > 4 * c.getAnnualIncome()) {
                                        System.out.println("Loan amount exceeds 4 times the annual income...");
                                        Time.type("sleep");
                                        System.out.println("Please try again with a lower loan amount...");
                                        break;
                                    }
                                    c.addCreditRecord(mortgage);
                                    System.out.println("Loan added to customer!");
                                    Time.type("pause");
                                    // increment records count
                                    recordsCount++;
                                    break;


                                case "2":
                                    // create builder loan
                                    Builder builder = new Builder();
                                    builder.createBuilder();
                                    // check that loan amount is less than 4 times the annual income
                                    if (builder.getAmountLeftToPay() > 4 * c.getAnnualIncome()) {
                                        System.out.println("Loan amount exceeds 4 times the annual income...");
                                        Time.type("sleep");
                                        System.out.println("Please try again with a lower loan amount...");
                                        break;
                                    }
                                    c.addCreditRecord(builder);
                                    System.out.println("Loan added to customer!");
                                    Time.type("pause");
                                    // increment records count
                                    recordsCount++;
                                    break;


                                case "3":
                                    // create personal loan
                                    Personal personal = new Personal();
                                    personal.createPersonal();
                                    // check that loan amount is less than 4 times the annual income
                                    if (personal.getAmountLeftToPay() > 4 * c.getAnnualIncome()) {
                                        System.out.println("Loan amount exceeds 4 times the annual income...");
                                        Time.type("sleep");
                                        System.out.println("Please try again with a lower loan amount...");
                                        break;
                                    }
                                    c.addCreditRecord(personal);
                                    System.out.println("Loan added to customer!");
                                    Time.type("pause");
                                    // increment records count
                                    recordsCount++;
                                    break;


                                case "4":
                                    // create auto loan
                                    Auto auto = new Auto();
                                    auto.createAuto();
                                    // check that loan amount is less than 4 times the annual income
                                    if (auto.getAmountLeftToPay() > 4 * c.getAnnualIncome()) {
                                        System.out.println("Loan amount exceeds 4 times the annual income...");
                                        Time.type("sleep");
                                        System.out.println("Please try again with a lower loan amount...");
                                        break;
                                    }
                                    c.addCreditRecord(auto);
                                    System.out.println("Loan added to customer!");
                                    Time.type("pause");
                                    // increment records count
                                    recordsCount++;
                                    break;


                                case "5":
                                    // create other loan
                                    Other other = new Other();
                                    other.createOther();
                                    // check that loan amount is less than 4 times the annual income
                                    if (other.getAmountLeftToPay() > 4 * c.getAnnualIncome()) {
                                        System.out.println("Loan amount exceeds 4 times the annual income...");
                                        Time.type("sleep");
                                        System.out.println("Please try again with a lower loan amount...");
                                        break;
                                    }
                                    c.addCreditRecord(other);
                                    System.out.println("Loan added to customer!");
                                    Time.type("pause");
                                    // increment records count
                                    recordsCount++;
                                    break;

                                default:
                                    System.out.println("Invalid option - Please try again and follow the prompts...");
                                    break;
                            }
                break;

                        } else { // if customer is not found, notify user, and break out of the loop
                            System.out.println("Customer not found!");
                            Time.type("sleep");
                            System.out.println("Please check that ID is correct, otherwise customer was not added.");
                            break;
                        }
                    }


                case "5":
                    // double checking that user chose 5 before continuing
                    if (!option.equals("5")) {
                        break;
                    }

                    if (customers.isEmpty()) {
                        System.out.println("No customers to delete loan from...");
                        Time.type("sleep");
                        break;
                    }

                    System.out.println("Delete Loan from customer");
                    // Ask for customer id to delete loan from
                    scanner = new Scanner(System.in);
                    customerID = null;
                    while (true) {
                        try {
                            System.out.print("Please input ID of customer to start deleting Loans: ");
                            customerID = scanner.next();
                        } catch (Exception e) {
                            System.out.println("Customer ID must be in the format AAAXXX where A is a letter and X is a digit 0-9");
                            continue;
                        }

                        if (!customerID.matches("[A-Z]{3}[0-9]{3}")){ // check if the input is 3 letters followed by 3 digits
                            System.out.println("Customer ID must be in the format AAAXXX where A is a letter and X is a digit 0-9");
                            continue;
                        } else {
                            break;
                        }
                    }

                    // Query customers to see if customer exists
                    for (Customer c : customers) {
                        if (c.getId().equals(customerID)) {
                            System.out.println("Customer found!");
                            Time.type("sleep");
                            System.out.println("Please follow the prompts to delete loan from customer...");
                            Time.type("sleep");

                            // Ask for record id to delete
                            System.out.print("Enter ID of loan to delete: ");
                            scanner = new Scanner(System.in);
                            String recordId = scanner.next();

                            // query customer's loans to see if loan exists
                            for (Loan l : c.getCreditRecords()) {
                                if (l.getRecordId().equals(recordId)) {
                                    System.out.println("Loan found!");
                                    Time.type("sleep");
                                    System.out.println("Deleting Now...");

                                    // delete loan (by removing from list of loans belonging to customer)
                                    c.deleteCreditRecord(l);

                                    Time.type("pause");
                                    System.out.println("Loan deleted from customer!");
                                    break;
                                } else {
                                    System.out.println("Loan not found!");
                                    Time.type("sleep");
                                    System.out.println("Please check that ID is correct, otherwise loan was not added.");
                                }
                            }

                            // delete loan from customer when loan is found successfully
                            Time.type("pause");
                            System.out.println("Loan deleted from customer!");
                            break;

                        } else {
                            System.out.println("Customer not found!");
                            Time.type("sleep");
                            System.out.println("Please check that ID is correct, otherwise customer was not added.");
                            break;
                        }
                    }


                case "6":
                    // double checking that user chose 6 before continuing
                    if (!option.equals("6")) {
                        break;
                    }

                    if (customers.isEmpty()) {
                        System.out.println("No customers to check eligibility...");
                        Time.type("sleep");
                        break;
                    }

                    System.out.println("- Check customer's loan eligibility -");
                    Time.type("pause");

                    // Ask for customer id to check eligibility
                    scanner = new Scanner(System.in);
                    customerID = null;
                    while (true) {
                        try {
                            System.out.print("Please input ID of customer to check eligibility: ");
                            customerID = scanner.next();
                        } catch (Exception e) {
                            System.out.println("Customer ID must be in the format AAAXXX where A is a letter and X is a digit 0-9");
                            continue;
                        }

                        if (!customerID.matches("[A-Z]{3}[0-9]{3}")){ // check if the input is 3 letters followed by 3 digits
                            System.out.println("Customer ID must be in the format AAAXXX where A is a letter and X is a digit 0-9");
                            continue;
                        } else {
                            break;
                        }
                    }

                    // Query customers to see if customer exists
                    for (Customer c : customers) {
                        if (c.getId().equals(customerID)) {
                            System.out.println("Customer found!");
                            Time.type("sleep");
                            System.out.println("Checking eligibility...");

                            // check customer's loan eligibility
                            boolean elig = c.checkEligibility();
                            if (elig) {
                                System.out.println("Customer is eligible for a loan!");
                            } else {
                                System.out.println("Customer is not eligible for a loan...");
                            }
                            break;

                        } else {
                            System.out.println("Customer not found!");
                            Time.type("sleep");
                            System.out.println("Please check that ID is correct, otherwise customer was not added.");
                        }
                    }
                    break;


                case "7":
                    System.out.println("- Printing data -");
                    Time.type("pause");

                    // first printing info about the records count and max records
                    System.out.println("Maximum number of Records: " + maxRecords);
                    System.out.println("Current number of Records: " + recordsCount);
                    Time.type("sleep");
                    System.out.println("======================================================="); // add space for readability

                    if (customers.isEmpty()) {
                        System.out.println("No customers or data to print...");
                        System.out.println("Please add customers and data to print...");
                        Time.type("sleep");
                        break;
                    }

                    // the printCustomer method prints all the data of a customer, including their loans
                    for (Customer c : customers) {
                        c.printCustomer();
                    }
                    // sleep for 3 seconds
                    Time.type("sleep");
                    Time.type("sleep");
                    Time.type("sleep");

                    break;


                case "8":
                    System.out.println("Exiting XYZ Bank...");
                    Time.type("sleep");
                    System.out.println("Goodbye!");
                    programRunning = false; // set programRunning to false and exit the while loop and main program
                    break;

                default:
                    System.out.println("Invalid option");
                    break;

            }

        }

    }


}