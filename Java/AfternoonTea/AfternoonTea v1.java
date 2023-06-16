/**
 * AfternoonTea
 * 
 * Runs when a guest arrives
 */
import java.util.Scanner;

public class AfternoonTea {
    public static Scanner input = new Scanner(System.in);
    public static void main(String args[]) {

        System.out.println("Would you like tea?");
        boolean wantsTea = input.nextBoolean();

        if(wantsTea == true) {
            System.out.println("Would you like milk?");
            boolean milk = input.nextBoolean();
            
            System.out.println("How many sugars?");
            int sugar = input.nextInt();

            // Pauses here and completes the 'makeTea()' method below before returning
            // Stores the result of 'makeTea()' as the variable 'tea'
            String tea = makeTea(milk, sugar);

            System.out.println("Here is your tea: " + tea);
            
        }
    }

    public static String makeTea(boolean hasMilk, int teaspoonsOfSugar) {
        String cupOfTea = "";

        // Adds text to cupOfTea String (both formats below do same thing)
        if(hasMilk == true) {
            cupOfTea.concat("White tea, ");
        }
        else {
            cupOfTea += "Black tea, ";
        }

        // Can insert number into a string if we use numbers
        cupOfTea += "with " + teaspoonsOfSugar + " sugars";

        return cupOfTea;
    }





}