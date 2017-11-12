
// Question 2
// total: 5 points

//===============================================
// todo: complete the following program
//===============================================

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class IteratingExamples_Iterator {

	public static int Act2Iterator(List<Integer> integers) {

		// Create an Integer Iterator iter
		Iterator<Integer> iter = integers.iterator();

		// Create an int sumOfIntegers to store the sum
		int sumOfIntegers = 0;

		// Iterate through and add each next term to the sum
		while (iter.hasNext()) {
			sumOfIntegers += iter.next();
		}

		return sumOfIntegers;
	}

	public static void main (String[] args) {
		
		// Create test case
		List<Integer> testList = new ArrayList<Integer>();
		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(4);
		testList.add(5);

		System.out.println(Act2Iterator(testList));
	}
}

//===============================================
// test case
//===============================================

/*

Input: (1, 2, 3, 4, 5)

Expected Output: 15

Input: (1, 2, 3, 4, 5, 10)

Expected Output: 25

Input: (1, 10, 100)

Expected Output: 111

*/

