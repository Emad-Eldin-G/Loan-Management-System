package Helpers;

public class Time {
    public static void type(String type) {
      switch (type) {
            case "sleep":
              sleep();
                break;
            case "pause":
                pause();
                break;
            default:
                break;

      }
    }

    private static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static void pause() {
        System.out.println("Processing...");
        System.out.println(" ");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
