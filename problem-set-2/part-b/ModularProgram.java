
// Homework Question 1
// total: 10 points

//===============================================
// todo: complete the following program
//===============================================


import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;
public class ModularProgram {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		boolean continueInput = true;
		do {
			try {
				tryexception(input);
			}
			catch (InputMismatchException ex)  {
				System.out.println("Sorry, you must enter 2 integer inputs.");
			}
			catch (ArithmeticException ex) {
				System.out.println("Sorry, cannot compute mod by 0.");
			}
			finally {
				System.out.println ("Do another pair of values ? (y)");
				String str = input.nextLine();
				char ch = str.charAt(0);
				System.out.println (" ch = " + ch);

				if ((ch != 'y') && (ch != 'Y')) {
					continueInput = false;
				}
			}
		} while (continueInput);
	}

	public static void tryexception (Scanner input) throws InputMismatchException {
		System.out.println("Enter the first integer:");
		String first = input.nextLine();
		System.out.println("Enter the second integer:");
		String second = input.nextLine();

		if (!isInteger(first) || !isInteger(second)) {
			throw new InputMismatchException();
		}

		int first_int = Integer.valueOf(first);
		int second_int = Integer.valueOf(second);

		if (second_int == 0) throw new ArithmeticException();

		System.out.println("Result is: "+(first_int%second_int));
	}

	public static boolean isInteger(String str) {
		if (str == null) {
			return false;
		}

		int len = str.length();

		if (len == 0) {
			return false;
		}

		int i = 0;

		if (str.charAt(0) == '-') {
			if (len == 1) {
				return false;
			}
			i = 1;
		}
		for (; i < len; i++) {
			char c = str.charAt(i);
			if (c < '0' || c > '9') {
				return false;
			}
		}
		return true;
	}
}
