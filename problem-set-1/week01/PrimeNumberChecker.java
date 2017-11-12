// Question 1
// total: 5 points

//===============================================
// todo: complete the following program
//===============================================


public class PrimeNumberChecker{

	// This algorithm checks for primality by iterating through every
	// integer between 2 and the integer 'num' whose primality is in question,
	// then checking if 'num' is divisible by the iterated integer.
	public static int isPrime(int num) {
		
		// All integers are divisible by 1, so we start checking with 2.
		int i = 2;

		// Iterate through the range (i=2, num) to check if
		// num is divisible by every integer between 2 and itself.
		while (i < num) {
			if (num % i == 0) {

				// If divisible by any integer, return false.
				return 0;
			}

			// Iterate the next integer.
			i+=1;
		}

		// If no factors found, then the integer num is only divisible
		// by itself and 1. Hence it is prime, return true.
		return 1;
	}

	// Test cases.
	public static void main (String[] args) {
		System.out.println(isPrime(4));
		System.out.println(isPrime(7));
		System.out.println(isPrime(14));
		System.out.println(isPrime(23));
		System.out.println(isPrime(99));
	}
}




//===============================================
// test case
//===============================================

/*

Input: 4

Expected Output: 0

Input: 7

Expected Output: 1

Input: 14

Expected Output: 0

*/