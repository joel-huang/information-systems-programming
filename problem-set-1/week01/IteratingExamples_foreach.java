// Question 3
// total: 5 points

//===============================================
// todo: complete the following program
//===============================================

import java.util.List;
import java.util.ArrayList;

public class IteratingExamples_foreach {

	public static int Act2ForEach(List<Integer> integers) {
		
		int sumOfIntegers = 0;

		// Obtain size of input list.
		int lengthOfList = integers.size();

		// Iterate through the integers less than the size.
		for (int i=0; i<lengthOfList; i++) {

			// Add the element at each index to the sum.
			sumOfIntegers += integers.get(i);
		}

		return sumOfIntegers;
	}

	public static void main (String[] args){

		// Create test list.
		List<Integer> testList = new ArrayList<Integer>();
		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(4);
		testList.add(5);
		testList.add(10);

		System.out.println(Act2ForEach(testList));
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

