// Question 1
// total: 5 points

//===============================================
// todo: complete the following program
//===============================================

public class Fibonacci{

	// This method returns the first 20 terms of the fibonacci sequence,
	// with a comma separating each term.
	public static String fibonacci(){
		// Using the recurrence relation Fn = Fn-1 + Fn-2

		// Declare initial terms in the series
		int f0 = 0;
		int f1 = 1;

		// Generate intial string with first two terms
		String s = f0 + ", " + f1;

		// Sum the previous two terms in the series and add to the string
		for (int i=0; i<18; i++) {
			int fNew = f0 + f1;

			f0 = f1;
			f1 = fNew;
			s = s + ", " + fNew;
		}
		return s;
	}

	public static void main(String[] args) {
		// Call fibonacci() and store to fibonacciString
		String fibonacciString = fibonacci();

		// Print fibonacciString
		System.out.println(fibonacciString);
	}
}

//===============================================
// test case
//===============================================

/*

Expected output

0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181

*/