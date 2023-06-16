public class FizzBuzz {
    public static String output;

    public static void main(String[] args) {

        for (int i = 1; i < 101; i++) {
            // Clear output
            output = "";
            // Add Fizz/Buzz
            if (i % 3 == 0) {
                output += "Fizz";
            }
            if (i % 5 == 0) {
                output += "Buzz";
            }

            // If blank, use current number
            if (output == "") {
                output = Integer.toString(i);
            }
            // Output
            System.out.println(output);
        }
    }
}
