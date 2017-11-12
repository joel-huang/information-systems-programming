
// Cohort Question 3
// total: 5 points

//===============================================
// todo: complete the following program
//===============================================

//package com.example;
import java.lang.Math;


public class RecurMulti {
    public static void main(String[] args) {
        System.out.println(multiply(4, 7));
        System.out.println(multiply(0,7));
        System.out.println(multiply(4,0));

    }

    public static int multiply(int i, int j) {

    	// counter check, using int i as a counter.
    	if (i<=0) {
    		return 0;
    	}
    	// recursively add j + the result of i-1 and j.
    	return j + multiply(i-1,j);

    }
}