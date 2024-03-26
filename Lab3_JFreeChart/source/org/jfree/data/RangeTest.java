package org.jfree.data;

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
	private Range zeroAndNegValuesUnderTest;
	private Range zeroAndPosValuesUnderTest;
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
		zeroAndNegValuesUnderTest = new Range(-10, 0);
		zeroAndPosValuesUnderTest = new Range(0, 10);
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
	 * Method Under Test: getLowerBound()
	 * Description: Verify getLowerBound with zero and positive range values
	 * Expected Outcome: 0 */
	@Test
	public void testGetLowerBoundZeroAndPositive() {
	    assertEquals("getLowerBound: Expected zero for range with zero and positive bounds", 0, zeroAndPosValuesUnderTest.getLowerBound(), 0.000000001d);
	}
	
	/* Test Case ID: 7
	 * Method Under Test: getLowerBound()
	 * Description: Verify getLowerBound with zero and negative range values
	 * Expected Outcome: -1 */
	@Test
	public void testGetLowerBoundZeroAndNegative() {
	    assertEquals("getLowerBound: Expected negative value for range with zero and negative bounds", -10, zeroAndNegValuesUnderTest.getLowerBound(), 0.000000001d);
	}
	
	/* Test Case ID: 8
	 * Method Under Test: getLowerBound()
	 * Description: Verify getLowerBound with boundary range values
	 * Expected Outcome: Double.MIN_VALUE */
	@Test
	public void testGetLowerBoundBoundaryValues() {
	    assertEquals("getLowerBound: Expected Double.MIN_VALUE for range with boundary values", Double.MIN_VALUE, rangeWithBoundaryValues.getLowerBound(), 0.000000001d);
	}
	
	/* Test Case ID: 9
	 * Method Under Test: getLowerBound()
	 * Description: Verify getLowerBound with large positive range values
	 * Expected Outcome: 1000000 */
	@Test
	public void testGetLowerBoundLargePosValues() {
	    assertEquals("getLowerBound: Expected 1000000 for range with large positive values", 1000000, rangeWithLargePosValues.getLowerBound(), 0.000000001d);
	}

	/* Test Case ID: 10
	 * Method Under Test: getLowerBound()
	 * Description: Verify getLowerBound with large negative range values
	 * Expected Outcome: -1000001 */
	@Test
	public void testGetLowerBoundLargeNegValues() {
	    assertEquals("getLowerBound: Expected -1000001 for range with large negative values", -1000001, rangeWithLargeNegValues.getLowerBound(), 0.000000001d);
	}

	/* Test Case ID: 11
	 * Method Under Test: getLowerBound()
	 * Description: Verify getLowerBound with maximum double range values
	 * Expected Outcome: Double.MAX_VALUE */
	@Test
	public void testGetLowerBoundMaxDoubleValues() {
	    assertEquals("getLowerBound: Expected Double.MAX_VALUE for range with maximum double values", Double.MAX_VALUE, rangeWithMaxDoubleValues.getLowerBound(), 0.000000001d);
	}

	/* Test Case ID: 12
	 * Method Under Test: getLowerBound()
	 * Description: Verify getLowerBound with minimum double range values
	 * Expected Outcome: Double.MIN_VALUE */
	@Test
	public void testGetLowerBoundMinDoubleValues() {
	    assertEquals("getLowerBound: Expected Double.MIN_VALUE for range with minimum double values", Double.MIN_VALUE, rangeWithMinDoubleValues.getLowerBound(), 0.000000001d);
	}

	
	/* Test Case ID: 13
	 * Method Under Test: getUpperBound()
	 * Description: Verify getUpperBound with same positive values 
	 * Expected Outcome: 1*/
	@Test
	public void testGetUpperBoundSucceedsWhenBothSamePosValues() {
	    assertEquals("getUpperBound: Did not return the expected output", 1, samePosValuesUnderTest.getUpperBound(), 0.000000001d);
	}

	/* Test Case ID: 14
	 * Method Under Test: getUpperBound()
	 * Description: Verify getUpperBound with same negative values  
	 * Expected Outcome: -1*/
	@Test
	public void testGetUpperBoundSucceedsWhenBothSameNegaValues() {
	    assertEquals("getUpperBound: Did not return the expected output", -1, sameNegValuesUnderTest.getUpperBound(), 0.000000001d);
	}

	/* Test Case ID: 15
	 * Method Under Test: getUpperBound()
	 * Description: Verify getUpperBound with different positive values  
	 * Expected Outcome: 8*/
	@Test
	public void testGetUpperBoundSucceedsWhenBothDifferentPosValues() {
	    assertEquals("getUpperBound: Did not return the expected output", 8, differentPosValuesUnderTest.getUpperBound(), 0.000000001d);
	}

	/* Test Case ID: 16
	 * Method Under Test: getUpperBound()
	 * Description: Verify getUpperBound with positive upper and negative lower values  
	 * Expected Outcome: 10*/
	@Test
	public void testGetUpperBoundSucceedsWhenPosUpperAndNegLowerValues() {
	    assertEquals("getUpperBound: Did not return the expected output", 10, posUpperNegLowerUnderTest.getUpperBound(), 0.000000001d);
	}

	/* Test Case ID: 17
	 * Method Under Test: getUpperBound()
	 * Description: Verify getUpperBound with different negative values  
	 * Expected Outcome: -3*/
	@Test
	public void testGetUpperBoundSucceedsWhenBothDifferentNegValues() {
	    assertEquals("getUpperBound: Did not return the expected output", -3, differentNegValuesUnderTest.getUpperBound(), 0.000000001d);
	}
	
	/* Test Case ID: 18
	 * Method Under Test: getUpperBound()
	 * Description: Verify getUpperBound with zero and positive range values
	 * Expected Outcome: 0 */
	@Test
	public void testGetUpperBoundZeroAndPositive() {
	    assertEquals("getUpperBound: Expected zero for range with zero and positive bounds", 10, zeroAndPosValuesUnderTest.getUpperBound(), 0.000000001d);
	}

	/* Test Case ID: 19
	 * Method Under Test: getUpperBound()
	 * Description: Verify getUpperBound with zero and negative range values
	 * Expected Outcome: 0 */
	@Test
	public void testGetUpperBoundZeroAndNegative() {
	    assertEquals("getUpperBound: Expected zero for range with zero and negative bounds", 0, zeroAndNegValuesUnderTest.getUpperBound(), 0.000000001d);
	}

	/* Test Case ID: 20
	 * Method Under Test: getUpperBound()
	 * Description: Verify getUpperBound with boundary range values
	 * Expected Outcome: Double.MAX_VALUE */
	@Test
	public void testGetUpperBoundBoundaryValues() {
	    assertEquals("getUpperBound: Expected Double.MAX_VALUE for range with boundary values", Double.MAX_VALUE, rangeWithBoundaryValues.getUpperBound(), 0.000000001d);
	}

	/* Test Case ID: 21
	 * Method Under Test: getUpperBound()
	 * Description: Verify getUpperBound with large positive range values
	 * Expected Outcome: 1000001 */
	@Test
	public void testGetUpperBoundLargePosValues() {
	    assertEquals("getUpperBound: Expected 1000001 for range with large positive values", 1000001, rangeWithLargePosValues.getUpperBound(), 0.000000001d);
	}

	/* Test Case ID: 22
	 * Method Under Test: getUpperBound()
	 * Description: Verify getUpperBound with large negative range values
	 * Expected Outcome: -1000000 */
	@Test
	public void testGetUpperBoundLargeNegValues() {
	    assertEquals("getUpperBound: Expected -1000000 for range with large negative values", -1000000, rangeWithLargeNegValues.getUpperBound(), 0.000000001d);
	}

	/* Test Case ID: 23
	 * Method Under Test: getUpperBound()
	 * Description: Verify getUpperBound with maximum double range values
	 * Expected Outcome: Double.MAX_VALUE */
	@Test
	public void testGetUpperBoundMaxDoubleValues() {
	    assertEquals("getUpperBound: Expected Double.MAX_VALUE for range with maximum double values", Double.MAX_VALUE, rangeWithMaxDoubleValues.getUpperBound(), 0.000000001d);
	}

	/* Test Case ID: 24
	 * Method Under Test: getUpperBound()
	 * Description: Verify getUpperBound with minimum double range values
	 * Expected Outcome: Double.MIN_VALUE */
	@Test
	public void testGetUpperBoundMinDoubleValues() {
	    assertEquals("getUpperBound: Expected Double.MIN_VALUE for range with minimum double values", Double.MIN_VALUE, rangeWithMinDoubleValues.getUpperBound(), 0.000000001d);
	}

	/* Test Case ID: 25
	 * Method Under Test: getLength()
	 * Description: Verify getLength with positive range  
	 * Expected Outcome: 5*/
	@Test
	public void testGetLengthWithPosRange() {
	    assertEquals("getLength: Did not return the expected output", 5, differentPosValuesUnderTest.getLength(), 0.000000001d);
	}

	/* Test Case ID: 26
	 * Method Under Test: getLength()
	 * Description: Verify getLength with negative range  
	 * Expected Outcome: 5*/
	@Test
	public void testGetLengthWithNegRange() {
	    assertEquals("getLength: Did not return the expected output", 5, differentNegValuesUnderTest.getLength(), 0.000000001d);
	}

	/* Test Case ID: 27
	 * Method Under Test: getLength()
	 * Description: Verify getLength with zero range  
	 * Expected Outcome: 0*/
	@Test
	public void testGetLengthWithZeroRange() {
	    assertEquals("getLength: Did not return the expected output", 0, zeroValuesUnderTest.getLength(), 0.000000001d);
	}

	/* Test Case ID: 28
	 * Method Under Test: getLength()
	 * Description: Verify getLength with negative and positive range  
	 * Expected Outcome: 20*/
	@Test
	public void testGetLengthWithNegAndPosRange() {
	    assertEquals("getLength: Did not return the expected output", 20, posUpperNegLowerUnderTest.getLength(), 0.000000001d);
	}

	/* Test Case ID: 29
	 * Method Under Test: getLength()
	 * Description: Verify getLength with boundary values  
	 * Expected Outcome: 0*/
	@Test
	public void testGetLengthWithBoundaryValues() {
	    assertEquals("getLength: Did not return the expected output", Double.MAX_VALUE - Double.MIN_VALUE, rangeWithBoundaryValues.getLength(), 0.0000001d);
	}

	/* Test Case ID: 30
	 * Method Under Test: getLength()
	 * Description: Verify getLength with large positive values   
	 * Expected Outcome: 1*/
	@Test
	public void testGetLengthWithLargePosValues() {
	    assertEquals("getLength: Did not return the expected output", 1, rangeWithLargePosValues.getLength(), 0.0000001d);
	}

	/* Test Case ID: 31
	 * Method Under Test: getLength()
	 * Description: Verify getLength with large negative values   
	 * Expected Outcome: 1*/
	@Test
	public void testGetLengthWithLargeNegValues() {
	    assertEquals("getLength: Did not return the expected output", 1, rangeWithLargeNegValues.getLength(), 0.0000001d);
	}

	/* Test Case ID: 32
	 * Method Under Test: getLength()
	 * Description: Verify getLength with max double values   
	 * Expected Outcome: 0*/
	@Test
	public void testGetLengthWithMaxDoubleValues() {
	    assertEquals("getLength: Did not return the expected output", 0, rangeWithMaxDoubleValues.getLength(), 0.0000001d);
	}

	/* Test Case ID: 33
	 * Method Under Test: getLength()
	 * Description: Verify getLength with min double values   
	 * Expected Outcome: 0*/
	@Test
	public void testGetLengthWithMinDoubleValues() {
	    assertEquals("getLength: Did not return the expected output", 0, rangeWithMinDoubleValues.getLength(), 0.0000001d);
	}

	/* Test Case ID: 34
	 * Method Under Test: contains()
	 * Description: Verify value inside range is contained.  
	 * Expected Outcome: True*/
    @Test
    public void testContainsWithinRange() {
        assertTrue("contains: Should return true for value within range", exampleRangeForContains.contains(0));
    }

    /* Test Case ID: 35
	 * Method Under Test: contains()
	 * Description: Verify lower bound value is contained.  
	 * Expected Outcome: True */
    @Test
    public void testContainsLowerBound() {
        assertTrue("contains: Should return true for lower bound", exampleRangeForContains.contains(-10));
    }

    /* Test Case ID: 36
	 * Method Under Test: contains()
	 * Description: Verify upper bound value is contained.  
	 * Expected Outcome: True*/
    @Test
    public void testContainsUpperBound() {
        assertTrue("contains: Should return true for upper bound", exampleRangeForContains.contains(10));
    }

    /* Test Case ID: 37
	 * Method Under Test: contains()
	 * Description: Verify value below range is not contained.  
	 * Expected Outcome: False*/
    @Test
    public void testContainsBelowRange() {
        assertFalse("contains: Should return false for value below range", exampleRangeForContains.contains(-11));
    }

    /* Test Case ID: 38
	 * Method Under Test: contains()
	 * Description: Verify value above range is not contained.   
	 * Expected Outcome: False*/
    @Test
    public void testContainsAboveRange() {
        assertFalse("contains: Should return false for value above range", exampleRangeForContains.contains(11));
    }
    
    /* Test Case ID: 39
     * Method Under Test: expand()
     * Description: Verify expand returns correct range with positive margins.
     * Expected Outcome: New range with expanded margins.
     */
    @Test
    public void testExpandWithPositiveMargins() {
        Range result = Range.expand(new Range(2, 6), 0.25, 0.5);
        assertEquals("expand: Should return expanded range", new Range(1, 8), result);
    }

    /* Test Case ID: 40
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
     * Test Case ID: 41
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

    /* Test Case  ID: 42
     * Method Under Test: expand()
     * Description: Verify expand with large positive margins.
     * Expected Outcome: Correctly expanded range with large margins.
     */
    @Test
    public void testExpandWithLargePositiveMargins() {
        Range result = Range.expand(new Range(2, 6), 1.0, 1.0);
        assertEquals("expand: Should return range with large margins", new Range(-2, 10), result);
    }

    /* Test Case ID: 43
     * Method Under Test: expand()
     * Description: Verify expand alters range correctly when margins are positive and negative.
     * Expected Outcome: Both margins should contract.
     */
    @Test
    public void testExpandWithOpposingMargins() {
        Range result = Range.expand(new Range(2, 6), 0.25, -0.25);
        assertEquals("expand: Should return with contracting margins on both sides", new Range(1, 5), result);
    }

    /* Test Case ID: 44
     * Method Under Test: expand()
     * Description: Verify expand with one zero margin.
     * Expected Outcome: Partially expanded range.
     */
    @Test
    public void testExpandWithOneZeroMargin() {
        Range result = Range.expand(new Range(2, 6), 0.0, 0.5);
        assertEquals("expand: One zero margin should return partially expanded range", new Range(2, 8), result);
    }

    /* Test Case ID: 45
     * Method Under Test: expand()
     * Description: Verify expand with one margin exceeding 100%.
     * Expected Outcome: Range is expanded beyond double its size in one direction.
     */
    @Test
    public void testExpandWithExcessiveMargin() {
        Range result = Range.expand(new Range(2, 6), 0.0, 2.0);
        assertEquals("expand: Margin exceeding 100% should expand range greatly", new Range(2, 14), result);
    }

    /* Test Case ID: 46
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
     * Test Case ID: 47
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
    
    //WHITE BOX TESTING
    
    /**
     * Test Case ID: 48
     * Method Under Test: equals()
     * Description: Verify equals with an object that is not an instance of Range.
     * Expected Outcome: The method should return false.
     */
    @Test
    public void testEqualsWithDifferentClass() {
        Range range = new Range(1.0, 5.0);
        assertFalse("equals: Non-Range instance should return false", range.equals("Not a Range"));
    }

    /**
     * Test Case ID: 49
     * Method Under Test: equals()
     * Description: Verify equals with a null reference.
     * Expected Outcome: The method should return false.
     */
    @Test
    public void testEqualsWithNull() {
        Range range = new Range(1.0, 5.0);
        assertFalse("equals: Null reference should return false", range.equals(null));
    }

    /**
     * Test Case ID: 50
     * Method Under Test: equals()
     * Description: Verify equals with a Range object with a different lower bound.
     * Expected Outcome: The method should return false.
     */
    @Test
    public void testEqualsWithDifferentLowerBound() {
        Range range1 = new Range(1.0, 5.0);
        Range range2 = new Range(2.0, 5.0);
        assertFalse("equals: Different lower bounds should return false", range1.equals(range2));
    }

    /**
     * Test Case ID: 51
     * Method Under Test: equals()
     * Description: Verify equals with a Range object with a different upper bound.
     * Expected Outcome: The method should return false.
     */
    @Test
    public void testEqualsWithDifferentUpperBound() {
        Range range1 = new Range(1.0, 5.0);
        Range range2 = new Range(1.0, 6.0);
        assertFalse("equals: Different upper bounds should return false", range1.equals(range2));
    }

    /**
     * Test Case ID: 52
     * Method Under Test: equals()
     * Description: Verify equals with a Range object that has the same lower and upper bounds.
     * Expected Outcome: The method should return true.
     */
    @Test
    public void testEqualsWithIdenticalRange() {
        Range range1 = new Range(1.0, 5.0);
        Range range2 = new Range(1.0, 5.0);
        assertTrue("equals: Identical ranges should return true", range1.equals(range2));
    }

    /**
     * Test Case ID: 53
     * Method Under Test: equals()
     * Description: Verify equals with the same object reference.
     * Expected Outcome: The method should return true.
     */
    @Test
    public void testEqualsWithSameObject() {
        Range range = new Range(1.0, 5.0);
        assertTrue("equals: Same object reference should return true", range.equals(range));
    }

    /**
     * Test Case ID: 54
     * Method Under Test: combine()
     * Description: Verify combine with the first range being null.
     * Expected Outcome: The method should return the second range.
     */
    @Test
    public void testCombineFirstRangeNull() {
        Range range1 = null;
        Range range2 = new Range(3.0, 7.0);
        Range result = Range.combine(range1, range2);
        assertSame("combine: First range null should return second range", range2, result);
    }

    /**
     * Test Case ID: 55
     * Method Under Test: combine()
     * Description: Verify combine with the second range being null.
     * Expected Outcome: The method should return the first range.
     */
    @Test
    public void testCombineSecondRangeNull() {
        Range range1 = new Range(1.0, 5.0);
        Range range2 = null;
        Range result = Range.combine(range1, range2);
        assertSame("combine: Second range null should return first range", range1, result);
    }

    /**
     * Test Case ID: 56
     * Method Under Test: combine()
     * Description: Verify combine with both ranges being non-null and disjoint.
     * Expected Outcome: The method should return a range that encompasses both input ranges.
     */
    @Test
    public void testCombineNonNullDisjointRanges() {
        Range range1 = new Range(1.0, 2.0);
        Range range2 = new Range(3.0, 4.0);
        Range result = Range.combine(range1, range2);
        assertEquals("combine: Non-null disjoint ranges should return encompassing range", new Range(1.0, 4.0), result);
    }

    /**
     * Test Case ID: 57
     * Method Under Test: combine()
     * Description: Verify combine with both ranges being non-null and overlapping.
     * Expected Outcome: The method should return a range that encompasses both input ranges.
     */
    @Test
    public void testCombineNonNullOverlappingRanges() {
        Range range1 = new Range(1.0, 3.0);
        Range range2 = new Range(2.0, 5.0);
        Range result = Range.combine(range1, range2);
        assertEquals("combine: Non-null overlapping ranges should return encompassing range", new Range(1.0, 5.0), result);
    }

    /**
     * Test Case ID: 58
     * Method Under Test: combine()
     * Description: Verify combine with both ranges being null.
     * Expected Outcome: The method should return null.
     */
    @Test
    public void testCombineBothRangesNull() {
        Range range1 = null;
        Range range2 = null;
        Range result = Range.combine(range1, range2);
        assertNull("combine: Both ranges null should return null", result);
    }

    /**
     * Test Case ID: 59
     * Method Under Test: expandToInclude()
     * Description: Verify expandToInclude with a null range.
     * Expected Outcome: The method should return a new range equal to the value.
     */
    @Test
    public void testExpandToIncludeWithNullRange() {
        double value = 5.0;
        Range result = Range.expandToInclude(null, value);
        assertEquals("expandToInclude: Null range should return new range from value", new Range(value, value), result);
    }

    /**
     * Test Case ID: 60
     * Method Under Test: expandToInclude()
     * Description: Verify expandToInclude with a value less than the lower bound of the range.
     * Expected Outcome: The method should return a new range with the lower bound equal to the value.
     */
    @Test
    public void testExpandToIncludeWithValueBelowLowerBound() {
        Range range = new Range(10.0, 20.0);
        double value = 5.0;
        Range result = Range.expandToInclude(range, value);
        assertEquals("expandToInclude: Value below lower bound should return new range with lower bound as value", new Range(value, range.getUpperBound()), result);
    }

    /**
     * Test Case ID: 61
     * Method Under Test: expandToInclude()
     * Description: Verify expandToInclude with a value greater than the upper bound of the range.
     * Expected Outcome: The method should return a new range with the upper bound equal to the value.
     */
    @Test
    public void testExpandToIncludeWithValueAboveUpperBound() {
        Range range = new Range(10.0, 20.0);
        double value = 25.0;
        Range result = Range.expandToInclude(range, value);
        assertEquals("expandToInclude: Value above upper bound should return new range with upper bound as value", new Range(range.getLowerBound(), value), result);
    }

    /**
     * Test Case ID: 62
     * Method Under Test: expandToInclude()
     * Description: Verify expandToInclude with a value within the bounds of the range.
     * Expected Outcome: The method should return the same range.
     */
    @Test
    public void testExpandToIncludeWithValueWithinRange() {
        Range range = new Range(10.0, 20.0);
        double value = 15.0;
        Range result = Range.expandToInclude(range, value);
        assertSame("expandToInclude: Value within range bounds should return same range", range, result);
    }

    /**
     * Test Case ID: 63
     * Method Under Test: expandToInclude()
     * Description: Verify expandToInclude with a value equal to the lower bound of the range.
     * Expected Outcome: The method should return the same range.
     */
    @Test
    public void testExpandToIncludeWithValueEqualToLowerBound() {
        Range range = new Range(10.0, 20.0);
        double value = 10.0;
        Range result = Range.expandToInclude(range, value);
        assertSame("expandToInclude: Value equal to lower bound should return same range", range, result);
    }

    /**
     * Test Case ID: 64
     * Method Under Test: expandToInclude()
     * Description: Verify expandToInclude with a value equal to the upper bound of the range.
     * Expected Outcome: The method should return the same range.
     */
    @Test
    public void testExpandToIncludeWithValueEqualToUpperBound() {
        Range range = new Range(10.0, 20.0);
        double value = 20.0;
        Range result = Range.expandToInclude(range, value);
        assertSame("expandToInclude: Value equal to upper bound should return same range", range, result);
    }
    
    /**
     * Test Case ID: 65
     * Method Under Test: intersects()
     * Description: Verify intersects where the provided lower bound is less than or equal to the range's lower bound and the provided upper bound is greater than the range's lower bound.
     * Expected Outcome: The method should return true as the ranges do intersect.
     */
    @Test
    public void testIntersectsLowerBoundLessThanRangeLower() {
        Range range = new Range(10.0, 20.0);
        assertTrue("intersects: Lower bound less than range lower should return true", range.intersects(5.0, 15.0));
    }

    /**
     * Test Case ID: 66
     * Method Under Test: intersects()
     * Description: Verify intersects where the provided upper bound is less than the range's lower bound.
     * Expected Outcome: The method should return false as the ranges do not intersect.
     */
    @Test
    public void testIntersectsUpperBoundLessThanRangeLower() {
        Range range = new Range(10.0, 20.0);
        assertFalse("intersects: Upper bound less than range lower should return false", range.intersects(5.0, 9.0));
    }

    /**
     * Test Case ID: 67
     * Method Under Test: intersects()
     * Description: Verify intersects where the provided upper bound is within the range's bounds.
     * Expected Outcome: The method should return true as the ranges do intersect.
     */
    @Test
    public void testIntersectsUpperBoundWithinRange() {
        Range range = new Range(10.0, 20.0);
        assertTrue("intersects: Upper bound within range should return true", range.intersects(15.0, 18.0));
    }

    /**
     * Test Case ID: 68
     * Method Under Test: intersects()
     * Description: Verify intersects where the provided lower bound is greater than the range's upper bound.
     * Expected Outcome: The method should return false as the ranges do not intersect.
     */
    @Test
    public void testIntersectsLowerBoundGreaterThanRangeUpper() {
        Range range = new Range(10.0, 20.0);
        assertFalse("intersects: Lower bound greater than range upper should return false", range.intersects(21.0, 25.0));
    }

    /**
     * Test Case ID: 69
     * Method Under Test: intersects()
     * Description: Verify intersects where both provided bounds are outside but around the range's bounds.
     * Expected Outcome: The method should return true as the ranges do intersect.
     */
    @Test
    public void testIntersectsBoundsAroundRange() {
        Range range = new Range(10.0, 20.0);
        assertTrue("intersects: Bounds around range should return true", range.intersects(5.0, 25.0));
    }

    /**
     * Test Case ID: 70
     * Method Under Test: hashCode()
     * Description: Verify that the same range instances produce the same hash code.
     * Expected Outcome: The hash codes of two identical range instances should be equal.
     */
    @Test
    public void testHashCodeConsistencyForSameRange() {
        Range range1 = new Range(1.0, 5.0);
        Range range2 = new Range(1.0, 5.0);
        assertEquals("hashCode: Identical ranges should have the same hash code", range1.hashCode(), range2.hashCode());
    }

    /**
     * Test Case ID: 71
     * Method Under Test: hashCode()
     * Description: Verify that different range instances have different hash codes.
     * Expected Outcome: The hash codes of two different range instances should not be equal.
     */
    @Test
    public void testHashCodeDifferenceForDifferentRanges() {
        Range range1 = new Range(1.0, 5.0);
        Range range2 = new Range(2.0, 6.0);
        assertFalse("hashCode: Different ranges should have different hash codes", range1.hashCode() == range2.hashCode());
    }

    /**
     * Test Case ID: 72
     * Method Under Test: hashCode()
     * Description: Verify the hashCode for the same range instance called multiple times.
     * Expected Outcome: The hash code should be consistent across multiple invocations.
     */
    @Test
    public void testHashCodeConsistencyOverTime() {
        Range range = new Range(1.0, 5.0);
        int initialHashCode = range.hashCode();
        int consistentHashCode = range.hashCode();
        assertEquals("hashCode: Multiple invocations should return the same hash code", initialHashCode, consistentHashCode);
    }
    
    /**
     * Test Case ID: 73
     * Method Under Test: shift()
     * Description: Verify that shifting a range to the right by a positive delta works as expected.
     * Expected Outcome: The method should return a new range shifted to the right by delta.
     */
    @Test
    public void testShiftRightByPositiveDelta() {
        Range base = new Range(1.0, 5.0);
        double delta = 2.0;
        Range expected = new Range(3.0, 7.0);
        Range actual = Range.shift(base, delta);
        assertEquals("shift: Positive delta should shift range to the right", expected, actual);
    }

    /**
     * Test Case ID: 74
     * Method Under Test: shift()
     * Description: Verify that shifting a range to the right by a negative delta returns the original range.
     * Expected Outcome: Since the method does not allow zero crossing, a negative delta should have no effect and return the original range.
     */
    @Test
    public void testShiftRightByNegativeDelta() {
        Range base = new Range(1.0, 5.0);
        double delta = -0.5;
        Range actual = Range.shift(base, delta);
        assertSame("shift: Negative delta should not shift range due to zero crossing prevention", base, actual);
    }

    /**
     * Test Case ID: 75
     * Method Under Test: shift()
     * Description: Verify shifting a range with zero delta returns the same range.
     * Expected Outcome: A zero delta means no shift, so the original range should be returned.
     */
    @Test
    public void testShiftByZeroDelta() {
        Range base = new Range(1.0, 5.0);
        double delta = 0.0;
        Range actual = Range.shift(base, delta);
        assertSame("shift: Zero delta should return the same range", base, actual);
    }

    /**
     * Test Case ID: 76
     * Method Under Test: shift()
     * Description: Verify that shifting a range with positive delta and zero crossing allowed returns a new range shifted right.
     * Expected Outcome: The method should return a new range with both bounds shifted right by delta.
     */
    @Test
    public void testShiftWithPositiveDeltaAllowZeroCrossing() {
        Range base = new Range(-2.0, 2.0);
        double delta = 5.0;
        Range expected = new Range(3.0, 7.0);
        Range actual = Range.shift(base, delta, true);
        assertEquals("shift: Positive delta with zero crossing allowed should return shifted range", expected, actual);
    }

    /**
     * Test Case ID: 77
     * Method Under Test: shift()
     * Description: Verify that shifting a range with negative delta and zero crossing not allowed adjusts to zero.
     * Expected Outcome: The method should return a new range adjusted to zero instead of crossing it.
     */
    @Test
    public void testShiftWithNegativeDeltaNoZeroCrossing() {
        Range base = new Range(1.0, 5.0);
        double delta = -2.0;
        Range actual = Range.shift(base, delta, false);
        assertEquals("shift: Negative delta with zero crossing not allowed should adjust to zero", 0.0, actual.getLowerBound(), 0.00001);
        assertEquals("shift: Negative delta with zero crossing not allowed should adjust to zero", 3.0, actual.getUpperBound(), 0.00001);
    }

    /**
     * Test Case ID: 78
     * Method Under Test: shift()
     * Description: Verify that shifting a range with zero delta returns the same range when zero crossing is allowed.
     * Expected Outcome: The method should return the same range, unchanged.
     */
    @Test
    public void testShiftByZeroDeltaAllowZeroCrossing() {
        Range base = new Range(1.0, 5.0);
        double delta = 0.0;
        Range actual = Range.shift(base, delta, true);
        assertEquals("shift: Zero delta with zero crossing allowed should return the same range", base, actual);
    }

    /**
     * Test Case ID: 79
     * Method Under Test: shift()
     * Description: Verify that shifting a range with positive delta and zero crossing not allowed returns the same range when shift would cause zero crossing.
     * Expected Outcome: The method should return the same range when shift to negative is prevented.
     */
    @Test
    public void testShiftWithPositiveDeltaNoZeroCrossing() {
        Range base = new Range(-3.0, -1.0);
        double delta = 1.0;
        Range actual = Range.shift(base, delta, false);
        assertEquals("shift: Positive delta with zero crossing not allowed should return adjusted range", 0.0, actual.getLowerBound(), 0.00001);
        assertEquals("shift: Positive delta with zero crossing not allowed should return adjusted range", 0.0, actual.getUpperBound(), 0.00001);
    }

    /**
     * Test Case ID: 80
     * Method Under Test: constrain()
     * Description: Verify that a value outside the range on the upper side is constrained to the upper bound.
     * Expected Outcome: The method should return the upper bound of the range.
     */
    @Test
    public void testConstrainValueAboveUpper() {
        Range range = new Range(1.0, 5.0);
        double value = 6.0;
        double expected = 5.0;
        double actual = range.constrain(value);
        assertEquals("constrain: Value above upper bound should be constrained to upper bound", expected, actual, 0.00001);
    }

    /**
     * Test Case ID: 81
     * Method Under Test: constrain()
     * Description: Verify that a value outside the range on the lower side is constrained to the lower bound.
     * Expected Outcome: The method should return the lower bound of the range.
     */
    @Test
    public void testConstrainValueBelowLower() {
        Range range = new Range(1.0, 5.0);
        double value = 0.0;
        double expected = 1.0;
        double actual = range.constrain(value);
        assertEquals("constrain: Value below lower bound should be constrained to lower bound", expected, actual, 0.00001);
    }

    /**
     * Test Case ID: 82
     * Method Under Test: constrain()
     * Description: Verify that a value within the range is returned unchanged.
     * Expected Outcome: The method should return the input value.
     */
    @Test
    public void testConstrainValueWithinRange() {
        Range range = new Range(1.0, 5.0);
        double value = 3.0;
        double actual = range.constrain(value);
        assertEquals("constrain: Value within the range should be returned unchanged", value, actual, 0.00001);
    }
    
    /**
     * Test Case ID: 83
     * Method Under Test: getCentralValue()
     * Description: Verify that the method returns the correct central value of the range.
     * Expected Outcome: The method should return the midpoint between the lower and upper bounds of the range.
     */
    @Test
    public void testGetCentralValue() {
        Range range = new Range(1.0, 5.0);
        double expected = 3.0; // The midpoint of 1.0 and 5.0 is 3.0
        double actual = range.getCentralValue();
        assertEquals("getCentralValue: Should return central value of the range", expected, actual, 0.00001);
    }


}
