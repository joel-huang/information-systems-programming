
// Cohort Question 4
// total: 10 points

//===============================================
// todo: complete the following program
//===============================================


public class SumDigits {
	public static void main (String[] args) {
    	int number = 54;
    	if (number < 0) {
    		number = -number;
    	}

		System.out.println(sumDigits(number));
    }
    
    // sumDigits is recursive, adds the least significant digit
    // and adds to the integer sumDigits(number without that digit).
    public static int sumDigits(int i) {
    	
    	if (i==0) return 0;

    	// i%10 is the least significant digit (LSD). e.g. in 54321, it is 1.
    	// sumDigits(i/10) takes the number without that LSD, e.g. it is 5432.
    	return i%10 + sumDigits(i/10);
    }
}