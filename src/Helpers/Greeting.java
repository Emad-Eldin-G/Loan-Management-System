package Helpers;
import java.util.concurrent.TimeUnit;

public class Greeting {
    public static void welcome() {
        printLogo();
        partition();
    }

    private static void printLogo() {
        System.out.println(" ");
        System.out.println("____  ________.___.__________ __________                __    ");
        System.out.println("\\   \\/  /\\__  |   |\\____    / \\______   \\_____    ____ |  | __");
        System.out.println(" \\     /  /   |   |  /     /   |    |  _/\\__  \\  /    \\|  |/ /");
        System.out.println(" /     \\  \\____   | /     /_   |    |   \\ / __ \\|   |  \\    < ");
        System.out.println("/___/\\  \\ / ______|/_______ \\  |______  /(____  /___|  /__|_ \\");
        System.out.println("      \\_/ \\/               \\/         \\/      \\/     \\/     \\/");
    }

    private static void partition() {
        System.out.println(" ");
        System.out.println("---------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------");
        System.out.println(" ");
    }

}
