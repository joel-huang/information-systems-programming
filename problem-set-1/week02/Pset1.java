import java.util.*;

public class Pset1 {

	public static boolean isAllCharacterUnique(String sIn) {
		
		// If the length of string exceeds the number of
		// possible ASCII characters, at least one character
		// must have been repeated.
		if (sIn.length() > 128) {
			return false;
		}

		// Use a boolean array to track if a character
		// has appeared. Corresponds to the ASCII index
		// of the 128 possible characters.

		boolean[] charLog = new boolean[128];

		// Set all entries false.
		Arrays.fill(charLog, false);


		// Iterate through the indexes of the string.
		// This brings time complexity down
		// to at most O(n).

		for (int i=0; i<sIn.length(); i++) {

			// Get the ASCII index of the character at the
			// current position.
			int index = (int)sIn.charAt(i);

			// The presence of this character has been
			// revealed to be true. If existing entry
			// in charLog is false, turn it true.
			
			if (charLog[index] == false) {
				charLog[index] = true;
			}	

			// If it is already true, then this character
			// is a duplicate!

			else return false;
		}

		// If no duplicates found after iteration is complete,
		// then the string must contain no duplicates.

		return true;
	}


	public static boolean isPermutation (String sIn1, String sIn2) {
		
		// String lengths must be equal.
		if (sIn1.length() != sIn2.length()) {
			return false;
		}

		// Sort the characters in both strings in ascending order.
		// If the two sorted collections are equal, then they are
		// permutations of each other.

		// Convert both strings to arrays.
		char[] a1 = sIn1.toCharArray();
		char[] a2 = sIn2.toCharArray();

		// Sort. According to the Java documentation, this sort
		// is a dual-pivot quicksort, complexity O(nlog(n)).
		Arrays.sort(a1);
		Arrays.sort(a2);


		// Compare the sorted arrays. If they contain the same
		// elements, the strings are permutations. Else they aren't.
		if (Arrays.equals(a1, a2)) {
			return true;
		}

		else return false;
	}

	// Test cases.
	public static void main(String[] args) {
		System.out.println(Pset1.isAllCharacterUnique("asdfghjk89c0"));
		System.out.println(Pset1.isPermutation("asdf","dfsa"));
	}
}