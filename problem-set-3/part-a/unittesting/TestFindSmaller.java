import junit.framework.*;
import junit.framework.Test;

import org.junit.*;

public class TestFindSmaller extends TestCase {

    // constructor
    public TestFindSmaller (String name) {
        super(name);
    }

    @org.junit.Test
    public void testFindingSmaller () {
         FindSmaller findSmaller = new FindSmaller();
         int[] testArr = {1,2,7,6,2};
        assertEquals("Failed Assertion for FindSmaller", 3, findSmaller.findSmaller(4,testArr));
        assertEquals("Failed Assertion for FindSmaller", 5, findSmaller.findSmaller(8,testArr));
        assertEquals("Failed Assertion for FindSmaller", 0, findSmaller.findSmaller(-1,testArr));
    }

    // method create a test suite
    public static Test suite() {
        return new TestSuite(TestFindSmaller.class);
    }

    // the main method
    public static void main(String args[]) {
        junit.textui.TestRunner.run(suite());
    }
}

