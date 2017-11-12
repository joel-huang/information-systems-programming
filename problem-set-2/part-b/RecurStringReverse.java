
// Homework Question 7
// total: 10 points

//===============================================
// todo: complete the following program
//===============================================

import java.util.InputMismatchException;

public class RecurStringReverse {
    public static void main (String[] args) {
        System.out.println(recurStringReverse("man ate fish"));
         
        
    }
    public static String recurStringReverse (String s) {
    	// find index of the first space
    	int x = s.indexOf(" ");

    	// if no spaces
    	if (x == -1) return s;

    	return recurStringReverse(s.substring(x+1)) + " " + s.substring(0,x);

    }
}
