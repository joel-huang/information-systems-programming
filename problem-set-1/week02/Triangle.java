// Question 2
// total: 10 points

//===============================================
// todo: complete the following program. please find the GeometricObject.java in the same folder.
//===============================================

class Triangle extends GeometricObject {

	// Default length of 3 sides = 1.0
	double side1 = 1.0;
	double side2 = 1.0;
	double side3 = 1.0;

	// No arg constructor.
	Triangle () {
		this.side1 = 1.0;
		this.side2 = 1.0;
		this.side3 = 1.0;
	}

	// Arg constructor.
	Triangle (double s1, double s2, double s3) {
		this.side1 = s1;
		this.side2 = s2;
		this.side3 = s3;
	}

	public double getArea() {

		// Using Heron's formula, A = sqrt(s*(s-a)*(s-b)*(s-c)) where s = (a+b+c)/2
		double s = (side1 + side2 + side3)/2;
		return Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
	}

	public double getPerimeter() {
		return side1 + side2 + side3;
	}

	// Returns basic information about the Triangle.
	public String toString() {
		String s = "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3
		+ " area: " + getArea() + " perimeter: " + getPerimeter();
		return s;
	}


	// Test cases.
	public static void main(String[] args) {
		Triangle t = new Triangle(2,4,5.5);
		System.out.println(t.toString());
		System.out.println(t.isFilled());
	}
}



//===============================================
// test case
//===============================================

/*

Input:

public class TestTriangle {
	public static void main(String[] args) {
		Triangle myTri = new Triangle();
		myTri.setColor("red");
		myTri.setFilled(true);
		System.out.println(myTri);
		System.out.println(myTri.isFilled());

		Triangle myTri2 = new Triangle(2.0, 4.0, 5.5);
		System.out.println(myTri2);
		System.out.println("area : " + myTri2.getArea() + " perimeter: " + myTri2.getPerimeter());
		
	}
}

Expected Output:

Triangle: side1 = 1.0 side2 = 1.0 side3 = 1.0
true
Triangle: side1 = 2.0 side2 = 4.0 side3 = 5.5
area : 3.0714155938264036 perimeter: 11.5

*/
