package piwords;
import java.util.Collections;
import java.util.ArrayList;

public class BaseTranslator {
    /**
     * Converts an array where the ith digit corresponds to (1 / baseA)^(i + 1)
     * digits[i], return an array output of size precisionB where the ith digit
     * corresponds to (1 / baseB)^(i + 1) * output[i].
     * 
     * Stated in another way, digits is the fractional part of a number
     * expressed in baseA with the most significant digit first. The output is
     * the same number expressed in baseB with the most significant digit first.
     * 
     * To implement, logically, you're repeatedly multiplying the number by
     * baseB and chopping off the most significant digit at each iteration:
     * 
     * for (i < precisionB) {
     *   1. Keep a carry, initialize to 0.
     *   2. From RIGHT to LEFT
     *   	a. x = multiply the jth digit by baseB and add the carry
     *          b. the new jth digit is x % baseA
     *          c. carry = x / baseA
     *   3. output[i] = carry
     * }
     * If digits[j] < 0 or digits[j] >= baseA for any j, return null
     * If baseA < 2, baseB < 2, or precisionB < 1, return null
     * 
     * @param digits The input array to translate. This array is not mutated.
     * @param baseA The base that the input array is expressed in.
     * @param baseB The base to translate into.
     * @param precisionB The number of digits of precision the output should
     *                   have.
     * @return An array of size precisionB expressing digits in baseB.
     */
    public static int[] convertBase(int[] digits, int baseA,
                                    int baseB, int precisionB) {

        // baseA is the current base.
        // baseB is the target base.
        // precisionB is the target number of digits (size of the int[] returned).

        // Create a copy of digits, to avoid modifying its elements.
        int[] digitsClone = digits.clone();

        // Create another array to store the converted result.
        int[] output = new int[precisionB];

        // Account for the invalid cases.
        if (baseA < 2 || baseB < 2 || precisionB < 1) return null;
            // Else, iterate through the copy of digits.
        else {


            for (int n=0; n<precisionB; n++) {

                int carry = 0;

                // Iterate from the right
                for (int i = digitsClone.length - 1; i >= 0; i--) {

                    // Multiply the current element (integer) with baseB e.g. 26,
                    // add the carry.
                    int x = digitsClone[i] * baseB + carry;

                    // The new carry (for the next loop) is the result divided
                    // by the current base.
                    carry = x / baseA;

                    // Replace the current element by the remainder for this column.
                    digitsClone[i] = x % baseA;


                    if (digitsClone[i] < 0 || digitsClone[i] >= baseA) {
                        return null;
                    }

                }

                // Add the final carry (most significant digit) to the result list.
                output[n] = carry;
            }

            return output;
        }
    }
}
