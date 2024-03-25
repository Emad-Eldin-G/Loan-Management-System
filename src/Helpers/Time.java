package Helpers;

public class Time {
    public static void type(String type) {
      // based on user choice of time type, sleep or pause is called
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

    // Sleep method causes program to halt for 1 second
    // This method was created in order to call Thread.sleep in a try-catch block
    // reducing redundancy in the code and making it more readable
    private static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Pause method causes program to halt for 1 second similar to sleep method, but outputs a processing message
    // mimicking a loading screen in systems
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
