// Question 2
// total: 20 points

//===============================================
// todo: complete the following program
//===============================================

public class MyRectangle2D {

	// Coordinates of the center of the rectangle.
	private double x;
	private double y;

	// Width and height of the rectangle.
	private double width;
	private double height;

	// No-arg constructor. Default rectangle instantiated.
	MyRectangle2D() {
		this.x = 0;
		this.y = 0;
		this.width = 1;
		this.height = 1;
	}

	// Arg constructor. Specified rectangle instantiated.
	MyRectangle2D(double sX, double sY, double sWidth, double sHeight) {
		this.x = sX;
		this.y = sY;
		this.width = sWidth;
		this.height = sHeight;
	}

	// Accessor methods.
	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public double getWidth() {
		return this.width;
	}

	public double getHeight() {
		return this.height;
	}

	// Mutator methods.
	public void setX(double newX) {
		this.x = newX;
	}

	public void setY(double newY) {
		this.y = newY;
	}

	public void setWidth(double newWidth) {
		this.width = newWidth;
	}

	public void setHeight(double newHeight) {
		this.height = newHeight;
	}

	// Methods.
	public double getArea() {
		return this.height * this.width;
	}

	public double getPerimeter() {
		return 2 * (this.height + this.width);
	}

	public boolean contains(double cX, double cY) {
		
		boolean xIn = false;
		boolean yIn = false;

		// Check if cX is within x+0.5(width) and x-0.5(width)
		if (cX < this.x + 0.5*this.width && cX > this.x - 0.5*this.width) {
			xIn = true;
		}

		// Check if cY is within y+0.5(height) and y-0.5(height)
		if (cY < this.y + 0.5*this.height && cY > this.y - 0.5*this.height) {
			yIn = true;
		}

		// If both x and y are inside, the point is inside.
		if (xIn == true && yIn == true) {
			return true;
		}

		else return false;
	}

	// We assume that we require the larger rectangle to fully contain the smaller rectangle;
	// i.e., there are no intersecting faces.
	public boolean contains(MyRectangle2D r) {
		
		// Get all four corners. All stored in doubles to reuse the contains() method.
		double topRight_X = r.x + 0.5*r.width;
		double topRight_Y = r.y + 0.5*r.height;

		double topLeft_X = r.x - 0.5*r.width;
		double topLeft_Y = r.y + 0.5*r.width;

		double bottomRight_X = r.x + 0.5*r.width;
		double bottomRight_Y = r.y - 0.5*r.height;

		double bottomLeft_X = r.x - 0.5*r.width;
		double bottomLeft_Y = r.y - 0.5*r.height;

		// Check if four corners are all points inside the current rectangle.
		if (this.contains(topRight_X, topRight_Y) && this.contains(topLeft_X, topLeft_Y)
			&& this.contains(bottomRight_X, bottomRight_Y) && this.contains(bottomLeft_X, bottomLeft_Y)) {
			return true;
		}

		else return false;

	}

	// Assuming overlapping to be when one or more points on the rectangles are shared.
	public boolean overlaps(MyRectangle2D r) {

		double firstRectCeiling = this.y + 0.5*this.height;
		double firstRectFloor = this.y - 0.5*this.height;
		double firstRectRightWall = this.x + 0.5*this.width;
		double firstRectLeftWall = this.x - 0.5*this.width;

		double secondRectCeiling = r.y + 0.5*r.height;
		double secondRectFloor = r.y - 0.5*r.height;
		double secondRectRightWall = r.x + 0.5*r.width;
		double secondRectLeftWall = r.x - 0.5*r.width;

		// Eliminate the false cases, where the first and second
		// rectangles are NOT overlapped, e.g. the bottom of the
		// first rectangle is above the top of the second.
		if (firstRectFloor > secondRectCeiling || secondRectFloor > firstRectCeiling ||
			firstRectLeftWall > secondRectRightWall || secondRectLeftWall > firstRectRightWall) {
			return false;
		}

		else return true;

	}

	// Test cases.
	public static void main(String[] args){
		MyRectangle2D larger = new MyRectangle2D(0, 0, 10, 10);
		MyRectangle2D smaller = new MyRectangle2D(5, -5, 6, 6);

		System.out.println(larger.contains(smaller));
		System.out.println(smaller.overlaps(larger));
		System.out.println(larger.getWidth());
 		System.out.println(smaller.getArea());
 		System.out.println(larger.getPerimeter());

	}

}


//===============================================
// test case
//===============================================

/*

Input:

MyRectangle2D a = new MyRectangle2D();
System.out.println(a.getX());

Expected Output: 0


Input: 

MyRectangle2D a = new MyRectangle2D(1, 2, 3, 4);
System.out.println(a.getWidth());

Expected Output: 3


Input: 

MyRectangle2D a = new MyRectangle2D(1, 2, 3, 4);
System.out.println(a.getArea());

Expected Output: 12

*/

