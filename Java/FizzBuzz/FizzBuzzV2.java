public class FizzBuzzV2 {

    public static void main(String[] args) {

        // Declare replacements in array
        String[][] replacements = {
                { "3", "Fizz" },
                { "5", "Buzz" }
        };

        String output = "";

        // Count to 100 and check for replacements
        for (int count = 1; count <= 100; count++) {

            // For each row of the replacements array...
            for (int arrayRow = 0; arrayRow < replacements.length; arrayRow++) {

                // Extract the number in the first column...
                int testValue = Integer.parseInt(replacements[arrayRow][0]);

                // If it is divisible by our current number...
                if (count % testValue == 0) {
                    // Extract the text from column 2 to the output tracker
                    output += replacements[arrayRow][1];
                }
            }

            // Replace FizzBuzz with Razz
            if (output.equals("FizzBuzz")) {
                output = "Razz";
            }

            // If blank, use current number
            if (output == "") {
                output = Integer.toString(count);
            }

            // Print output and clear
            System.out.print(output + "\n");
            output = "";
        }
    }
}
