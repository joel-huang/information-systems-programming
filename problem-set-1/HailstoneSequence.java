import java.util.ArrayList;

public class HailstoneSequence {

	public static ArrayList Hailstone (int n) {

		// Place n as the first element.
		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(n);

		// Since the terminal value for n is 1, use while n>1 to iterate.
		while (n>1) {
			if (n%2 == 0) n=n/2;
			else n=3*n+1;

			// Add the new n to the array.
			arrayList.add(n);
		}

		return arrayList;
	}

	public static void main (String[] args) {
		System.out.println(Hailstone(3));
	}
}