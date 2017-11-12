package piwords;

import java.util.HashMap;
import java.util.Map;

public class WordFinder {
    /**
     * Given a String (the haystack) and an array of Strings (the needles),
     * return a Map<String, Integer>, where keys in the map correspond to
     * elements of needles that were found as substrings of haystack, and the
     * value for each key is the lowest index of haystack at which that needle
     * was found. A needle that was not found in the haystack should not be
     * returned in the output map.
     *
     * @param haystack The string to search into.
     * @param needles The array of strings to search for. This array is not
     *                mutated.
     * @return The list of needles that were found in the haystack.
     */
    public static Map<String, Integer> getSubstrings(String haystack,
                                                     String[] needles) {

        // Generate new hashmap.
        HashMap<String, Integer> newMap = new HashMap<>();

        // Iterate thru the dictionary, checking each word.
        // If it is not already inside the hashmap, place it inside.
        for (String word : needles)
            if (!newMap.containsKey(word)) {

                // This is the index.
                int i = WordFinder.retrieve(haystack, word);

                if (i >= 0) newMap.put(word, i);
            }

        return newMap;
    }

    // Searches the haystack for the word index.
    public static int retrieve(String haystack, String s) {
        if (haystack.length() < s.length()) {
            return -1;
        }

        int diff = (haystack.length() - s.length());

        // Scan each letter in the haystack.
        // The integer i tracks the index of the character in the haystack.
        for (int i = 0; i <= diff; i++) {

            // While the letters in the word match, continue checking them.
            // The integer j tracks the number of matched letters.
            int j = 0;

            // The letter in the word should be at index j, while the
            // letter in the haystack should be at index i+j.
            while (j < s.length() && s.charAt(j) == haystack.charAt(i+j)) {
                j++;
            }
            if (j == s.length()) {
                return i;
            }
        }
        // If no match, return -1.
        return -1;
    }
}
