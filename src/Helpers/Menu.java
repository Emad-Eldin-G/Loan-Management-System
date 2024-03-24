package Helpers;

public class Menu {

    public static void printMenu() {
        menuLoader();
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("New customer (1)");
        System.out.println("Modify customer (2)");
        System.out.println("Delete customer (3)");
        System.out.println("Add Loan to customer (4)");
        System.out.println("Delete Loan from customer (5)");
        System.out.println("Check customer's loan eligibility (6)");
        System.out.println("Print data (7)");
        System.out.println("Exit (8)");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println(" ");
    }

    private static void menuLoader() {
        System.out.println("Loading up the menu...");
        System.out.println(" ");
        Time.type("sleep");
    }

}
