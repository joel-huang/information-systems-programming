package piwords;

import java.util.*;


public class AlphabetGenerator {
    /**
     * Given a numeric base, return a char[] that maps every digit that is
     * representable in that base to a lower-case char.
     * <p>
     * This method will try to weight each character of the alphabet
     * proportional to their occurrence in words in a training set.
     * <p>
     * This method should do the following to generate an alphabet:
     * 1. Count the occurrence of each character a-z in trainingData.
     * 2. Compute the probability of each character a-z by taking
     * (occurrence / total_num_characters).
     * 3. The output generated in step (2) is a PDF of the characters in the
     * training set. Convert this PDF into a CDF for each character.
     * 4. Multiply the CDF value of each character by the base we are
     * converting into.
     * 5. For each index 0 <= i < base,
     * output[i] = (the first character whose CDF * base is > i)
     * <p>
     * A concrete example:
     * 0. Input = {"aaaaa..." (302 "a"s), "bbbbb..." (500 "b"s),
     * "ccccc..." (198 "c"s)}, base = 93
     * 1. Count(a) = 302, Count(b) = 500, Count(c) = 198
     * 2. Pr(a) = 302 / 1000 = .302, Pr(b) = 500 / 1000 = .5,
     * Pr(c) = 198 / 1000 = .198
     * 3. CDF(a) = .302, CDF(b) = .802, CDF(c) = 1
     * 4. CDF(a) * base = 28.086, CDF(b) * base = 74.586, CDF(c) * base = 93
     * 5. Output = {"a", "a", ... (29 As, indexes 0-28),
     * "b", "b", ... (46 Bs, indexes 29-74),
     * "c", "c", ... (18 Cs, indexes 75-92)}
     * <p>
     * The letters should occur in lexicographically ascending order in the
     * returned array.
     * - {"a", "b", "c", "c", "d"} is a valid output.
     * - {"b", "c", "c", "d", "a"} is not.
     * <p>
     * If base >= 0, the returned array should have length equal to the size of
     * the base.
     * <p>
     * If base < 0, return null.
     * <p>
     * If a String of trainingData has any characters outside the range a-z,
     * ignore those characters and continue.
     *
     * @param base         A numeric base to get an alphabet for.
     * @param trainingData The training data from which to generate frequency
     *                     counts. This array is not mutated.
     * @return A char[] that maps every digit of the base to a char that the
     * digit should be translated into.
     */
    public static char[] generateFrequencyAlphabet(int base,
                                                   String[] trainingData) {

        if (base == 0) {
            char[] n = {};
            return n;
        }

        if (base < 0) {
            return null;
        }

        Map<Character, Integer> characterMap = new HashMap<>();

        char[] characterArray;

        // Iterate through 0 to length.
        for (int i = 0; i < trainingData.length; i++) {

            characterArray = trainingData[i].toCharArray();

            // For each j, check if letter.
            for (int j = 0; j < characterArray.length; j++) {

                char characterCheck = characterArray[j];

                if (Character.isLetter(characterCheck)) {

                    char lowerCase = Character.toLowerCase(characterCheck);

                    if (characterMap.containsKey(lowerCase)) {
                        characterMap.put(lowerCase, characterMap.get(lowerCase)+ 1);
                    }

                    else {
                        characterMap.put(lowerCase, 1);
                    }
                }
            }
        }

        Character[] cKeys = characterMap.keySet().toArray(new Character[0]);

        Arrays.sort(cKeys);

        // Add chars to the counter.
        int amountOfCharacters = 0;
        for (char c : cKeys) {
            amountOfCharacters += characterMap.get(c);
        }

        // Cdf
        Map<Character, Float> CDF = new HashMap<>();

        float r = 0f;

        // Iterate through chars, convert to cdf.
        for (char i : cKeys) {
            float PDF = (float)characterMap.get(i)/amountOfCharacters;
            CDF.put(i,(PDF + r));
            r += PDF;
        }

        char[] answer = new char[base];

        int j = 0;

        // output[i] = (the first character whose CDF * base is > i)

        for (char i : cKeys) {
            while (j < base && j <= (Math.round(CDF.get(i) * base) - 1)) {
                answer[j] = i;
                j++;
            }
        }

        return answer;
    }
}
