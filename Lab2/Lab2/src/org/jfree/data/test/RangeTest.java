package org.jfree.data.test;

import java.security.InvalidParameterException;

import org.jfree.data.Range;
import org.junit.*;

import junit.framework.TestCase;

public class RangeTest extends TestCase {

//	private Range rangeObjectUnderTest;
	private Range samePosValuesUnderTest;
	private Range sameNegValuesUnderTest;
	private Range differentPosValuesUnderTest;
	private Range differentNegValuesUnderTest;
	private Range posUpperNegLowerUnderTest;
	private Range zeroValuesUnderTest;
    private Range rangeWithBoundaryValues;
    private Range rangeWithLargePosValues;
    private Range rangeWithLargeNegValues;
    private Range rangeWithMaxDoubleValues;
    private Range rangeWithMinDoubleValues;
    private Range exampleRangeForContains;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	protected void setUp() throws Exception {
//		rangeObjectUnderTest = new Range(-1, 1);
		samePosValuesUnderTest = new Range(1,1);
		sameNegValuesUnderTest = new Range(-1,-1);
		differentPosValuesUnderTest = new Range(3,8);
		differentNegValuesUnderTest = new Range(-8,-3);
		posUpperNegLowerUnderTest = new Range(-10, 10);
		zeroValuesUnderTest = new Range(0,0);
		rangeWithBoundaryValues = new Range(Double.MIN_VALUE, Double.MAX_VALUE);
        rangeWithLargePosValues = new Range(1000000, 1000001);
        rangeWithLargeNegValues = new Range(-1000001, -1000000);
        rangeWithMaxDoubleValues = new Range(Double.MAX_VALUE, Double.MAX_VALUE);
        rangeWithMinDoubleValues = new Range(Double.MIN_VALUE, Double.MIN_VALUE);
        exampleRangeForContains = new Range(-10,10);
		
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
//	@Test
//	public void testCentralValueShouldBeZero() {
//		assertEquals("The central value of -1 and 1 should be 0", 0, rangeObjectUnderTest.getCentralValue(),
//				0.000000001d);
//	}

	/* Test Case ID: 1
	 * Method Under Test: getLowerBound()
	 * Description: Verify getLowerBound with same positive values  
	 * Expected Outcome: 1*/
	@Test
	public void testGetLowerBoundSucceedsWhenBothSamePosValues() {
	    assertEquals("getLowerBound: Did not return the expected output", 1, samePosValuesUnderTest.getLowerBound(), 0.000000001d);
	}

	/* Test Case ID: 2
	 * Method Under Test: getLowerBound()
	 * Description: Verify getLowerBound with same negative values  
	 * Expected Outcome: -1*/
	@Test
	public void testGetLowerBoundSucceedsWhenBothSameNegValues() {
	    assertEquals("getLowerBound: Did not return the expected output", -1, sameNegValuesUnderTest.getLowerBound(), 0.000000001d);
	}

	/* Test Case ID: 3
	 * Method Under Test: getLowerBound()
	 * Description: Verify getLowerBound with different positive values  
	 * Expected Outcome: 3*/
	@Test
	public void testGetLowerBoundSucceedsWhenBothDifferentPosValues() {
	    assertEquals("getLowerBound: Did not return the expected output", 3, differentPosValuesUnderTest.getLowerBound(), 0.000000001d);
	}

	/* Test Case ID: 4
	 * Method Under Test: getLowerBound()
	 * Description: Verify getLowerBound with positive upper and negative lower values  
	 * Expected Outcome: -10*/
	@Test
	public void testGetLowerBoundSucceedsWhenPosUpperAndNegLowerValues() {
	    assertEquals("getLowerBound: Did not return the expected output", -10, posUpperNegLowerUnderTest.getLowerBound(), 0.000000001d);
	}

	/* Test Case ID: 5
	 * Method Under Test: getLowerBound()
	 * Description: Verify getLowerBound with different negative values  
	 * Expected Outcome: -8*/
	@Test
	public void testGetLowerBoundSucceedsWhenBothDifferentNegValues() {
	    assertEquals("getLowerBound: Did not return the expected output", -8, differentNegValuesUnderTest.getLowerBound(), 0.000000001d);
	}
	
	/* Test Case ID: 6
	 * Method Under Test: getUpperBound()
	 * Description: Verify getUpperBound with same positive values 
	 * Expected Outcome: 1*/
	@Test
	public void testGetUpperBoundSucceedsWhenBothSamePosValues() {
	    assertEquals("getUpperBound: Did not return the expected output", 1, samePosValuesUnderTest.getUpperBound(), 0.000000001d);
	}

	/* Test Case ID: 7
	 * Method Under Test: getUpperBound()
	 * Description: Verify getUpperBound with same negative values  
	 * Expected Outcome: -1*/
	@Test
	public void testGetUpperBoundSucceedsWhenBothSameNegaValues() {
	    assertEquals("getUpperBound: Did not return the expected output", -1, sameNegValuesUnderTest.getUpperBound(), 0.000000001d);
	}

	/* Test Case ID: 8
	 * Method Under Test: getUpperBound()
	 * Description: Verify getUpperBound with different positive values  
	 * Expected Outcome: 8*/
	@Test
	public void testGetUpperBoundSucceedsWhenBothDifferentPosValues() {
	    assertEquals("getUpperBound: Did not return the expected output", 8, differentPosValuesUnderTest.getUpperBound(), 0.000000001d);
	}

	/* Test Case ID: 9
	 * Method Under Test: getUpperBound()
	 * Description: Verify getUpperBound with positive upper and negative lower values  
	 * Expected Outcome: 10*/
	@Test
	public void testGetUpperBoundSucceedsWhenPosUpperAndNegLowerValues() {
	    assertEquals("getUpperBound: Did not return the expected output", 10, posUpperNegLowerUnderTest.getUpperBound(), 0.000000001d);
	}

	/* Test Case ID: 10
	 * Method Under Test: getUpperBound()
	 * Description: Verify getUpperBound with different negative values  
	 * Expected Outcome: -3*/
	@Test
	public void testGetUpperBoundSucceedsWhenBothDifferentNegValues() {
	    assertEquals("getUpperBound: Did not return the expected output", -3, differentNegValuesUnderTest.getUpperBound(), 0.000000001d);
	}

	/* Test Case ID: 11
	 * Method Under Test: getLength()
	 * Description: Verify getLength with positive range  
	 * Expected Outcome: 5*/
	@Test
	public void testGetLengthWithPosRange() {
	    assertEquals("getLength: Did not return the expected output", 5, differentPosValuesUnderTest.getLength(), 0.000000001d);
	}

	/* Test Case ID: 12
	 * Method Under Test: getLength()
	 * Description: Verify getLength with negative range  
	 * Expected Outcome: 5*/
	@Test
	public void testGetLengthWithNegRange() {
	    assertEquals("getLength: Did not return the expected output", 5, differentNegValuesUnderTest.getLength(), 0.000000001d);
	}

	/* Test Case ID: 13
	 * Method Under Test: getLength()
	 * Description: Verify getLength with zero range  
	 * Expected Outcome: 0*/
	@Test
	public void testGetLengthWithZeroRange() {
	    assertEquals("getLength: Did not return the expected output", 0, zeroValuesUnderTest.getLength(), 0.000000001d);
	}

	/* Test Case ID: 14
	 * Method Under Test: getLength()
	 * Description: Verify getLength with negative and positive range  
	 * Expected Outcome: 20*/
	@Test
	public void testGetLengthWithNegAndPosRange() {
	    assertEquals("getLength: Did not return the expected output", 20, posUpperNegLowerUnderTest.getLength(), 0.000000001d);
	}

	/* Test Case ID: 15
	 * Method Under Test: getLength()
	 * Description: Verify getLength with boundary values  
	 * Expected Outcome: 0*/
	@Test
	public void testGetLengthWithBoundaryValues() {
	    assertEquals("getLength: Did not return the expected output", Double.MAX_VALUE - Double.MIN_VALUE, rangeWithBoundaryValues.getLength(), 0.0000001d);
	}

	/* Test Case ID: 16
	 * Method Under Test: getLength()
	 * Description: Verify getLength with large positive values   
	 * Expected Outcome: 1*/
	@Test
	public void testGetLengthWithLargePosValues() {
	    assertEquals("getLength: Did not return the expected output", 1, rangeWithLargePosValues.getLength(), 0.0000001d);
	}

	/* Test Case ID: 17
	 * Method Under Test: getLength()
	 * Description: Verify getLength with large negative values   
	 * Expected Outcome: 1*/
	@Test
	public void testGetLengthWithLargeNegValues() {
	    assertEquals("getLength: Did not return the expected output", 1, rangeWithLargeNegValues.getLength(), 0.0000001d);
	}

	/* Test Case ID: 18
	 * Method Under Test: getLength()
	 * Description: Verify getLength with max double values   
	 * Expected Outcome: 0*/
	@Test
	public void testGetLengthWithMaxDoubleValues() {
	    assertEquals("getLength: Did not return the expected output", 0, rangeWithMaxDoubleValues.getLength(), 0.0000001d);
	}

	/* Test Case ID: 19
	 * Method Under Test: getLength()
	 * Description: Verify getLength with min double values   
	 * Expected Outcome: 0*/
	@Test
	public void testGetLengthWithMinDoubleValues() {
	    assertEquals("getLength: Did not return the expected output", 0, rangeWithMinDoubleValues.getLength(), 0.0000001d);
	}

	/* Test Case ID: 20
	 * Method Under Test: contains()
	 * Description: Verify value inside range is contained.  
	 * Expected Outcome: True*/
    @Test
    public void testContainsWithinRange() {
        assertTrue("contains: Should return true for value within range", exampleRangeForContains.contains(0));
    }

    /* Test Case ID: 21
	 * Method Under Test: contains()
	 * Description: Verify lower bound value is contained.  
	 * Expected Outcome: True */
    @Test
    public void testContainsLowerBound() {
        assertTrue("contains: Should return true for lower bound", exampleRangeForContains.contains(-10));
    }

    /* Test Case ID: 22
	 * Method Under Test: contains()
	 * Description: Verify upper bound value is contained.  
	 * Expected Outcome: True*/
    @Test
    public void testContainsUpperBound() {
        assertTrue("contains: Should return true for upper bound", exampleRangeForContains.contains(10));
    }

    /* Test Case ID: 23
	 * Method Under Test: contains()
	 * Description: Verify value below range is not contained.  
	 * Expected Outcome: False*/
    @Test
    public void testContainsBelowRange() {
        assertFalse("contains: Should return false for value below range", exampleRangeForContains.contains(-11));
    }

    /* Test Case ID: 24
	 * Method Under Test: contains()
	 * Description: Verify value above range is not contained.   
	 * Expected Outcome: False*/
    @Test
    public void testContainsAboveRange() {
        assertFalse("contains: Should return false for value above range", exampleRangeForContains.contains(11));
    }
    
    
    /* Test Case ID: 25
     * Method Under Test: expand()
     * Description: Verify expand returns correct range with positive margins.
     * Expected Outcome: New range with expanded margins.
     */
    @Test
    public void testExpandWithPositiveMargins() {
        Range result = Range.expand(new Range(2, 6), 0.25, 0.5);
        assertEquals("expand: Should return expanded range", new Range(1, 8), result);
    }

    /* Test Case ID: 26
     * Method Under Test: expand()
     * Description: Verify expand handles zero margins.
     * Expected Outcome: Original range is returned.
     */
    @Test
    public void testExpandWithZeroMargins() {
        Range result = Range.expand(new Range(2, 6), 0.0, 0.0);
        assertEquals("expand: Should return original range", new Range(2, 6), result);
    }
    /**
     * Test Case ID: 27
     * Method Under Test: expand()
     * Description: Verify expand throws InvalidParameterException with null range.
     * Expected Outcome: InvalidParameterException is thrown.
     */
    @Test
    public void testExpandWithNullRange() {
        try {
            Range.expand(null, 0.5, 0.5);
            fail("Exception wasn't thrown: expected output: InvalidParameterException");
        } catch (InvalidParameterException e) {
        } catch (Exception e) {
            fail("Incorrect exception thrown. Expected InvalidParameterException but caught: " + e.getClass().getSimpleName());
        }
    }

    /* Test Case  ID: 28
     * Method Under Test: expand()
     * Description: Verify expand with large positive margins.
     * Expected Outcome: Correctly expanded range with large margins.
     */
    @Test
    public void testExpandWithLargePositiveMargins() {
        Range result = Range.expand(new Range(2, 6), 1.0, 1.0);
        assertEquals("expand: Should return range with large margins", new Range(-2, 10), result);
    }

    /* Test Case ID: 29
     * Method Under Test: expand()
     * Description: Verify expand alters range correctly when margins are positive and negative.
     * Expected Outcome: Range lower bound is expanded and upper bound is contracted.
     */
    @Test
    public void testExpandWithOpposingMargins() {
        Range result = Range.expand(new Range(2, 6), 0.25, -0.25);
        assertEquals("expand: Margins sum to zero should return original range", new Range(1, 5), result);
    }

    /* Test Case ID: 30
     * Method Under Test: expand()
     * Description: Verify expand with one zero margin.
     * Expected Outcome: Partially expanded range.
     */
    @Test
    public void testExpandWithOneZeroMargin() {
        Range result = Range.expand(new Range(2, 6), 0.0, 0.5);
        assertEquals("expand: One zero margin should return partially expanded range", new Range(2, 8), result);
    }

    /* Test Case ID: 31
     * Method Under Test: expand()
     * Description: Verify expand with one margin exceeding 100%.
     * Expected Outcome: Range is expanded beyond double its size in one direction.
     */
    @Test
    public void testExpandWithExcessiveMargin() {
        Range result = Range.expand(new Range(2, 6), 0.0, 2.0);
        assertEquals("expand: Margin exceeding 100% should expand range greatly", new Range(2, 14), result);
    }

    /* Test Case ID: 32
     * Method Under Test: expand()
     * Description: Verify expand with margins resulting in a zero-length range.
     * Expected Outcome: Range is contracted to a single point.
     */
    @Test
    public void testExpandToZeroLength() {
        Range result = Range.expand(new Range(2, 6), 0.5, -0.5);
        assertEquals("expand: Margins resulting in zero-length should contract range to single point", new Range(0,0), result);
    }

    /**
     * Test Case ID: 33
     * Method Under Test: expand()
     * Description: Verify expand with margins that would invert the range throws an IllegalArgumentException.
     * Expected Outcome: IllegalArgumentException is thrown due to negative margins inverting the range.
     */
    @Test
    public void testExpandWithInvertingMargins() {
        try {
            Range.expand(new Range(2, 6), -0.5, -2.0);
            fail("IllegalArgumentException was expected to be thrown due to inverting margins, but it was not");
        } catch (IllegalArgumentException e) {
        }
    }


}
