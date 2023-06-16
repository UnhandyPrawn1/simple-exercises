
// Below gets java to collect the 'Scanner' class from its library
// Scanner is used to receive user input
import java.util.Scanner;

public class AfternoonTea {

    public static void main(String args[]) {

        // Creates a scanner which records and converts user input
        Scanner input = new Scanner(System.in);

        // TODO: Ask if the user wants tea with println()

        // Stores the answer (must be 'true' or 'false')
        boolean wantsTea = input.nextBoolean();

        if (wantsTea == true) {
            // TODO: Ask if the user wants milk
            // TODO: Store answer as true/false

            // TODO: Ask how many sugars user wants
            // TODO: Store answer as an *integer* 

            // Below stores the result of 'makeTea()' as the variable 'tea'
            // Pauses here and completes the 'makeTea()' method below before continuing
            String tea = makeTea(milk, sugars); // <-- These values have to match the variable names you chose above

            // Uses the variable 'tea' to serve to the user
            System.out.println("Here is your tea: " + tea);

        }
        input.close();
        System.out.println("Goodbye!!");
    }

    public static String makeTea(boolean hasMilk, int teaspoonsOfSugar) {
        // Creates blank String to work from
        String cupOfTea = "";

        // TODO: If tea hasMilk, add 'White tea' to cupOfTea string

        // TODO: If it doesn't have milk, Add 'Black tea' to cupOfTea instead

        // Can insert int variables into Strings too!!
        cupOfTea += "with " + teaspoonsOfSugar + " sugars";


        // Sends whatever is stored under 'cupOfTea' back to main method
        return cupOfTea;
    }

}