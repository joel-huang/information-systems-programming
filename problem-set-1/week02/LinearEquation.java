// Question 1
// total: 10 points

//===============================================
// todo: complete the following program
//===============================================

import java.util.Scanner;

class LinearEquation {
    private double a, b, c, d, e, f;
    private double determinant;

    // Arg constructor
    LinearEquation(double a, double b, double c, double d, double e, double f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.determinant = a*d-b*c;
    }

    // Accessor methods to get variables.
    public double getA(){
        return this.a;
    }

    public double getB(){
        return this.b;
    }

    public double getC(){
        return this.c;
    }

    public double getD(){
        return this.d;
    }

    public double getE(){
        return this.e;
    }

    public double getF(){
        return this.f;
    }

    // Checks if the determinant of the 2x2 matrix is not 0.
    // This ensures the matrix is invertible, allowing computation
    // of the solution of the matrix A*x=b, which is x = A^-1*B.
    public boolean isSolvable() {
        if (this.a * this.d - this.b * this.c == 0) {
            return false;
        }

        else return true;
    }

    public double[] solveEquation() {

        // Compute A^-1, the inverse matrix of A.
        double a11 = (1/this.determinant)*this.d; // Top left element
        double a12 = (1/this.determinant)*-this.b; // Top right element
        double a21 = (1/this.determinant)*-this.c; // Bottom left element
        double a22 = (1/this.determinant)*this.a; // Bottom right element

        // Compute A^-1 * b, which gives the solution matrix.
        double x = a11 * this.e + a12 * this.f;
        double y = a21 * this.e + a22 * this.f;

        // Return the solution in the array [x,y].
        return new double[] {x,y};
    }

    public double getX() {
        return solveEquation()[0];
    }

    public double getY() {
        return solveEquation()[1];
    }

    public static void prompt() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of a:");
        double a = sc.nextDouble();
        System.out.println("Enter the value of b:");
        double b = sc.nextDouble();
        System.out.println("Enter the value of c:");
        double c = sc.nextDouble();
        System.out.println("Enter the value of d:");
        double d = sc.nextDouble();
        System.out.println("Enter the value of e:");
        double e = sc.nextDouble();
        System.out.println("Enter the value of f:");
        double f = sc.nextDouble();

        if (a * d - b * c == 0) {
            System.out.println("The equation has no solution.");
        }
        else {
            LinearEquation le = new LinearEquation(a,b,c,d,e,f);
            String reply = "x is " + le.getX() + " and Y is " + le.getY();
            System.out.println(reply);
        }
    }

    public static void main(String[] args) {
        prompt();
    }
}




//===============================================
// test case
//===============================================

/*

Input:

a = 1.0, b = 2.0, c = 3.0, d = 5.0, e = 6.0, f= 7.0

Expected Output: x is -16.0 and y is 11.0


Input:

a = 1.25, b = 2.0, c = 2.0, d = 4.2, e = 3.0, f= 6.0

Expected Output: x is 0.48000000000000115 y is 1.2


Input:

a = 1.0, b = 2.0, c = 2.0, d = 4.0, e = 3.0, f= 6.0

Expected Output: The equation has no solution

*/