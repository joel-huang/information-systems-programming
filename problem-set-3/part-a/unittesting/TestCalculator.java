import junit.framework.*;
import junit.framework.Test;

import org.junit.*;

public class TestCalculator extends TestCase {

    // constructor
    public TestCalculator (String name) {
        super(name);
    }

    @org.junit.Test
    public void testFourOperations () {
        Calculator calc = new Calculator();
        // given in pset:
        assertEquals("Failed Addition", 9, calc.add(4,5));
        assertEquals("Failed Subtraction", 2, calc.sub(5,3));
        assertEquals("Failed Multiplication", 42, calc.mul(6,7));
        assertEquals("Failed Division", 1, calc.divInt(6,4));
    }

   @org.junit.Test
    public void testDivideByZero () {
        Calculator calc = new Calculator();
        try {
            calc.divInt(100,0);
        } catch (IllegalArgumentException e) {
            // do nothing since exception has been correctly raised
        }
    }

    // method create a test suite
    public static Test suite() {
        return new TestSuite(TestCalculator.class);
    }

    // the main method
    public static void main(String args[]) {
        junit.textui.TestRunner.run(suite());
    }
}


