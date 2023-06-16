import java.util.Scanner;
import java.lang.Thread;

public class HelloWorld {
    static String name;
    static Scanner in;

    public static void computerOutput(String text) {
        try {
            Thread.sleep(1200);
            System.out.println("PC: " + text);
        }
        catch (Exception e) {
        }
    }

    public static String userInput() {
        System.out.print(name + ": ");
        return in.nextLine();
    }

    public static void main(String[] args) {
        
        // Variables
        name = "You";
        in = new Scanner(System.in);
    
        // Request input
        computerOutput("Oh!!");
        computerOutput("Hello There!!");
        computerOutput("What's your name?? ");

        // Process input
        name = userInput();

        // Output
        computerOutput("Well, it's a pleasure to meet you " + name + "!!");

        userInput();

    }
}