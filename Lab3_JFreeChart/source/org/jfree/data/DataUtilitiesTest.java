package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataUtilitiesTest {
	
	private Values2D values2D;
	private Values2D valuesEmpty;
	private double[] valuesArray;
	private double[] valuesArrayEmpty;
	private double[] valuesArrayNeg;
	private double[][] valuesArray2D;
	private double[][] valuesArray2DEmpty;
	private double[][] valuesArray2DNeg;
	private KeyedValues keyedValues;
	private KeyedValues keyedValuesEmpty;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;
		
		testValues.addValue(1, 0, 0); 
		testValues.addValue(3, 0, 1);
		testValues.addValue(5, 0, 2); 
		testValues.addValue(7, 1, 0);
		testValues.addValue(9, 1, 1); 
		testValues.addValue(11, 1, 2);
		
		DefaultKeyedValues2D testEmpty = new DefaultKeyedValues2D();
		valuesEmpty = testEmpty;
		
		valuesArray = new double[] {1.0,3.0,5.0,7.0,9.0,11.0};
		valuesArrayNeg = new double[] {-1.0,-3.0,-5.0,-7.0,-9.0,-11.0};
		valuesArrayEmpty = new double[] {};
		
		valuesArray2D = new double[][] {{1.0,3.0,5.0},{7.0,9.0,11.0}};
		valuesArray2DNeg = new double[][] {{-1.0,-3.0,-5.0},{-7.0,-9.0,-11.0}};
		valuesArray2DEmpty = new double[][] {};
		
		DefaultKeyedValues cumulativeTestValues = new DefaultKeyedValues();
		keyedValues = cumulativeTestValues;
		
		cumulativeTestValues.addValue("0", 1);
		cumulativeTestValues.addValue("1", 3);
		cumulativeTestValues.addValue("2", 5);
		cumulativeTestValues.addValue("3", 7);
		cumulativeTestValues.addValue("4", 9);
		cumulativeTestValues.addValue("5", 11);
		
		DefaultKeyedValues cumulativeTestValuesEmpty = new DefaultKeyedValues();
		keyedValuesEmpty = cumulativeTestValuesEmpty;


	}

	@After
	public void tearDown() throws Exception {
		values2D = null;
		valuesArray = null;
		valuesArrayNeg = null;
		valuesArray2D = null;
		valuesArray2DNeg = null;
		keyedValues = null;
	}

//	@SuppressWarnings("rawtypes")
//	@Test
//	public void testGetCumulativePercentages() {
//		DefaultKeyedValues keyvalues = new DefaultKeyedValues();
//		keyvalues.addValue((Comparable) 0.0, 6.0);
//		keyvalues.addValue((Comparable) 1.0, 11.0);
//		keyvalues.addValue((Comparable) 2.0, 3.0);
//		KeyedValues object_under_test = DataUtilities.getCumulativePercentages((KeyedValues) keyvalues);
//		
//		assertEquals((double) object_under_test.getValue(2), 1.0, .000000001d);
//	}
	
	//test cases for calculateColumnTotal
	
	/**
     * Test Case ID: 1
     * Method Under Test: calculateColumnTotal
     * Description: Verify that calculateColumnTotal throws IllegalArgumentException for negative column index
     * Expected Outcome: IllegalArgumentException should be thrown
     */
	
	@Test
	public void testInvalidDataAndColumnTotalNegColumn() {
		try {
			DataUtilities.calculateColumnTotal(values2D, -1);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		} catch(Exception e) {
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	/**
     * Test Case ID: 2
     * Method Under Test: calculateColumnTotal
     * Description: Verify that calculateColumnTotal correctly sums the values of column 0
     * Expected Outcome: The sum for column 0 is returned accurately
     */
	
	@Test
	public void testValidDataAndColumnTotalColumn0() {
		assertEquals("Wrong sum returned. It should be 8.0",
		8.0, DataUtilities.calculateColumnTotal(values2D, 0), 0.0000001d);
	}
	
	/**
	 * Test Case ID: 3
	 * Method Under Test: calculateColumnTotal
	 * Description: Verify that calculateColumnTotal correctly sums the values of column 1
	 * Expected Outcome: The sum for column 1 is returned accurately
	 */
	
	@Test
	public void testValidDataAndColumnTotalColumn1() {
		assertEquals("Wrong sum returned. It should be 12.0",
		12.0, DataUtilities.calculateColumnTotal(values2D, 1), 0.0000001d);
	}
	
	/**
	 * Test Case ID: 4
	 * Method Under Test: calculateColumnTotal
	 * Description: Verify that calculateColumnTotal throws IllegalArgumentException for a column index that is out of range
	 * Expected Outcome: IllegalArgumentException should be thrown for an invalid column index
	 */
	
	@Test
	public void testInvalidPosDataColumnTotal() {
		try {
			DataUtilities.calculateColumnTotal(values2D, 55);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	/**
	 * Test Case ID: 5
	 * Method Under Test: calculateColumnTotal
	 * Description: Verify that calculateColumnTotal returns 0.0 when data is empty and column index is negative
	 * Expected Outcome: 0.0 should be returned
	 */
	
	@Test
	public void testEmptyDataAndColumnTotalNegColumn() {
		assertEquals("Wrong sum returned. It should be 0.0",
				0.0, DataUtilities.calculateColumnTotal(valuesEmpty, -1), 0.0000001d);
	}
	
	/**
	 * Test Case ID: 6
	 * Method Under Test: calculateColumnTotal
	 * Description: Verify that calculateColumnTotal returns 0.0 when data is empty for column 0
	 * Expected Outcome: 0.0 should be returned
	 */
	
	@Test
	public void testEmptyDataAndColumnTotalColumn0() {
		assertEquals("Wrong sum returned. It should be 0.0",
				0.0, DataUtilities.calculateColumnTotal(valuesEmpty, 0), 0.0000001d);
	}
	
	/**
	 * Test Case ID: 7
	 * Method Under Test: calculateColumnTotal
	 * Description: Verify that calculateColumnTotal returns 0.0 when data is empty for column 1
	 * Expected Outcome: 0.0 should be returned
	 */
	
	@Test
	public void testEmptyDataAndColumnTotalColumn1() {
		assertEquals("Wrong sum returned. It should be 0.0",
				0.0, DataUtilities.calculateColumnTotal(valuesEmpty, 1), 0.0000001d);
	}
	
	/**
	 * Test Case ID: 8
	 * Method Under Test: calculateColumnTotal
	 * Description: Verify that calculateColumnTotal returns 0.0 when data is empty for a column index that is out of range
	 * Expected Outcome: 0.0 should be returned
	 */
	
	@Test
	public void testEmptyDataAndColumnTotalColumn55() {
		assertEquals("Wrong sum returned. It should be 0.0",
				0.0, DataUtilities.calculateColumnTotal(valuesEmpty, 55), 0.0000001d);
	}
	
	/**
	 * Test Case ID: 9
	 * Method Under Test: calculateColumnTotal
	 * Description: Verify that calculateColumnTotal throws IllegalArgumentException when data is null and column index is negative
	 * Expected Outcome: IllegalArgumentException should be thrown
	 */
	
	@Test
	public void testNullDataColumnTotalNegColumn() {
		try {
			DataUtilities.calculateColumnTotal(null, -1);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	/**
	 * Test Case ID: 10
	 * Method Under Test: calculateColumnTotal
	 * Description: Verify that calculateColumnTotal throws IllegalArgumentException when data is null for column 0
	 * Expected Outcome: IllegalArgumentException should be thrown
	 */
	
	@Test
	public void testNullDataColumnTotalColumn0() {
		try {
			DataUtilities.calculateColumnTotal(null, 0);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	/**
	 * Test Case ID: 11
	 * Method Under Test: calculateColumnTotal
	 * Description: Verify that calculateColumnTotal throws IllegalArgumentException when data is null for column 1
	 * Expected Outcome: IllegalArgumentException should be thrown
	 */
	
	@Test
	public void testNullDataColumnTotalColumn1() {
		try {
			DataUtilities.calculateColumnTotal(null, 1);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	/**
	 * Test Case ID: 12
	 * Method Under Test: calculateColumnTotal
	 * Description: Verify that calculateColumnTotal throws IllegalArgumentException when data is null for a column index that is out of range
	 * Expected Outcome: IllegalArgumentException should be thrown
	 */
	
	@Test
	public void testNullDataColumnTotalColumn55() {
		try {
			DataUtilities.calculateColumnTotal(null, 55);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	//test cases for calculateRowTotal
	
	/**
	 * Test Case ID: 13
	 * Method Under Test: calculateRowTotal
	 * Description: Verify that calculateRowTotal throws IllegalArgumentException for negative row index
	 * Expected Outcome: IllegalArgumentException should be thrown
	 */

	
	@Test
	public void testInvalidDataAndRowTotalNegRow() {
		try {
			DataUtilities.calculateRowTotal(values2D, -1);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		} catch(Exception e) {
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	/**
	 * Test Case ID: 14
	 * Method Under Test: calculateRowTotal
	 * Description: Verify that calculateRowTotal correctly sums the values of row 0
	 * Expected Outcome: The sum for row 0 is returned accurately
	 */
	
	@Test
	public void testValidDataAndRowTotalRow0() {
		assertEquals("Wrong sum returned. It should be 9.0",
		9.0, DataUtilities.calculateRowTotal(values2D, 0), 0.0000001d);
	}
	
	/**
	 * Test Case ID: 15
	 * Method Under Test: calculateRowTotal
	 * Description: Verify that calculateRowTotal correctly sums the values of row 1
	 * Expected Outcome: The sum for row 1 is returned accurately
	 */
	
	@Test
	public void testValidDataAndRowTotalRow1() {
		assertEquals("Wrong sum returned. It should be 27.0",
		27.0, DataUtilities.calculateRowTotal(values2D, 1), 0.0000001d);
	}
	
	/**
	 * Test Case ID: 16
	 * Method Under Test: calculateRowTotal
	 * Description: Verify that calculateRowTotal throws IllegalArgumentException for a row index that is out of range
	 * Expected Outcome: IllegalArgumentException should be thrown
	 */
	
	@Test
	public void testInvalidPosDataRowTotal() {
		try {
			DataUtilities.calculateRowTotal(values2D, 55);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	/**
	 * Test Case ID: 17
	 * Method Under Test: calculateRowTotal
	 * Description: Verify that calculateRowTotal returns 0.0 when data is empty and row index is negative
	 * Expected Outcome: 0.0 should be returned
	 */
	
	@Test
	public void testEmptyDataAndRowTotalNegRow() {
		assertEquals("Wrong sum returned. It should be 0.0",
				0.0, DataUtilities.calculateRowTotal(valuesEmpty, -1), 0.0000001d);
	}
	
	/**
	 * Test Case ID: 18
	 * Method Under Test: calculateRowTotal
	 * Description: Verify that calculateRowTotal returns 0.0 when data is empty for row 0
	 * Expected Outcome: 0.0 should be returned
	 */
	
	@Test
	public void testEmptyDataAndRowTotalRow0() {
		assertEquals("Wrong sum returned. It should be 0.0",
				0.0, DataUtilities.calculateRowTotal(valuesEmpty, 0), 0.0000001d);
	}
	
	/**
	 * Test Case ID: 19
	 * Method Under Test: calculateRowTotal
	 * Description: Verify that calculateRowTotal returns 0.0 when data is empty for row 1
	 * Expected Outcome: 0.0 should be returned
	 */
	
	@Test
	public void testEmptyDataAndRowTotalRow1() {
		assertEquals("Wrong sum returned. It should be 0.0",
				0.0, DataUtilities.calculateRowTotal(valuesEmpty, 1), 0.0000001d);
	}
	
	/**
	 * Test Case ID: 20
	 * Method Under Test: calculateRowTotal
	 * Description: Verify that calculateRowTotal returns 0.0 when data is empty for a row index that is out of range
	 * Expected Outcome: 0.0 should be returned
	 */
	
	@Test
	public void testEmptyDataAndRowTotalRow55() {
		assertEquals("Wrong sum returned. It should be 0.0",
				0.0, DataUtilities.calculateRowTotal(valuesEmpty, 55), 0.0000001d);
	}
	
	/**
	 * Test Case ID: 21
	 * Method Under Test: calculateRowTotal
	 * Description: Verify that calculateRowTotal throws IllegalArgumentException when data is null and row index is negative
	 * Expected Outcome: IllegalArgumentException should be thrown
	 */
	
	@Test
	public void testNullDataRowTotalNegRow() {
		try {
			DataUtilities.calculateRowTotal(null, -1);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	/**
	 * Test Case ID: 22
	 * Method Under Test: calculateRowTotal
	 * Description: Verify that calculateRowTotal throws IllegalArgumentException when data is null for row 0
	 * Expected Outcome: IllegalArgumentException should be thrown
	 */
	
	@Test
	public void testNullDataRowTotalRow0() {
		try {
			DataUtilities.calculateRowTotal(null, 0);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	/**
	 * Test Case ID: 23
	 * Method Under Test: calculateRowTotal
	 * Description: Verify that calculateRowTotal throws IllegalArgumentException when data is null for row 1
	 * Expected Outcome: IllegalArgumentException should be thrown
	 */
	
	@Test
	public void testNullDataRowTotalRow1() {
		try {
			DataUtilities.calculateRowTotal(null, 1);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	/**
	 * Test Case ID: 24
	 * Method Under Test: calculateRowTotal
	 * Description: Verify that calculateRowTotal throws IllegalArgumentException when data is null for a row index that is out of range
	 * Expected Outcome: IllegalArgumentException should be thrown
	 */
	
	@Test
	public void testNullDataRowTotalRow55() {
		try {
			DataUtilities.calculateRowTotal(null, 55);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	// test cases for createNumberArray
	
	/**
	 * Test Case ID: 25
	 * Method Under Test: createNumberArray
	 * Description: Verify that createNumberArray properly converts an array of double primitives to an array of Numbers
	 * Expected Outcome: An array of Numbers matching the double array should be returned
	 */
	
	@Test
	public void testValidArrayData() {
		 Number[] arrayData = DataUtilities.createNumberArray(valuesArray);
		 Number[] expectedArrayData = {1.0,3.0,5.0,7.0,9.0,11.0};

		 for (int i = 0; i < arrayData.length; i++) {
			 assertEquals(arrayData[i],expectedArrayData[i]);
		 } 
	}
	
	/**
	 * Test Case ID: 26
	 * Method Under Test: createNumberArray
	 * Description: Verify that createNumberArray properly converts an array of negative double primitives to an array of Numbers
	 * Expected Outcome: An array of Numbers matching the negative double array should be returned
	 */
	
	@Test
	public void testValidArrayDataNegValues() {
		 Number[] arrayData = DataUtilities.createNumberArray(valuesArrayNeg);
		 Number[] expectedArrayData = {-1.0,-3.0,-5.0,-7.0,-9.0,-11.0};

		 for (int i = 0; i < arrayData.length; i++) {
			 assertEquals(arrayData[i],expectedArrayData[i]);
		 } 
	}
	
	/**
	 * Test Case ID: 27
	 * Method Under Test: createNumberArray
	 * Description: Verify that createNumberArray returns an empty Number array when given an empty double array
	 * Expected Outcome: An empty Number array should be returned
	 */
	
	@Test
	public void testEmptyArrayData() {
		 Number[] arrayData = DataUtilities.createNumberArray(valuesArrayEmpty);
		 Number[] expectedArrayData = {};

		 for (int i = 0; i < arrayData.length; i++) {
			 assertEquals(arrayData[i],expectedArrayData[i]);
		 }
	}
	
	/**
	 * Test Case ID: 28
	 * Method Under Test: createNumberArray
	 * Description: Verify that createNumberArray throws IllegalArgumentException when given a null double array
	 * Expected Outcome: IllegalArgumentException should be thrown
	 */
	
	@Test
	public void testNullArrayData() {
		 try {
			 DataUtilities.createNumberArray(null);
			 fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		 } catch (Exception e) {
			 assertTrue("Incorrect exception type thrown",
						e.getClass().equals(IllegalArgumentException.class));
		 }
	}
	
	// test cases for createNumberArray2D
	
	/**
	 * Test Case ID: 29
	 * Method Under Test: createNumberArray2D
	 * Description: Verify that createNumberArray2D properly converts a 2D array of double primitives to a 2D array of Numbers
	 * Expected Outcome: A 2D array of Numbers matching the 2D double array should be returned
	 */
	
	@Test
	public void testValidArrayData2D() {
		 Number[][] arrayData = DataUtilities.createNumberArray2D(valuesArray2D);
		 Number[][] expectedArrayData = {{1.0,3.0,5.0},{7.0,9.0,11.0}};

		 for (int i = 0; i < arrayData.length; i++) {
			 for (int j = 0; j < arrayData.length; j++) {
				assertEquals(arrayData[i][j],expectedArrayData[i][j]);
			 } 
		 }
	}
	
	/**
	 * Test Case ID: 30
	 * Method Under Test: createNumberArray2D
	 * Description: Verify that createNumberArray2D properly converts a 2D array of negative double primitives to a 2D array of Numbers
	 * Expected Outcome: A 2D array of Numbers matching the negative 2D double array should be returned
	 */
	
	@Test
	public void testValidArrayData2DNegValues() {
		Number[][] arrayData = DataUtilities.createNumberArray2D(valuesArray2DNeg);
		Number[][] expectedArrayData = {{-1.0,-3.0,-5.0},{-7.0,-9.0,-11.0}};

		for (int i = 0; i < arrayData.length; i++) {
			for (int j = 0; j < arrayData.length; j++) {
				 assertEquals(arrayData[i][j],expectedArrayData[i][j]);
			} 
		}
	}
	
	/**
	 * Test Case ID: 31
	 * Method Under Test: createNumberArray2D
	 * Description: Verify that createNumberArray2D handles an empty 2D double array correctly
	 * Expected Outcome: An appropriate representation of an empty 2D Number array should be returned
	 */
	
	@Test
	public void testEmptyArrayData2D() {
		Number[][] arrayData = DataUtilities.createNumberArray2D(valuesArray2DEmpty);
		Number[][] expectedArrayData = {{},{}};

		for (int i = 0; i < arrayData.length; i++) {
			 for (int j = 0; j < arrayData.length; j++) {
				 assertEquals(arrayData[i][j],expectedArrayData[i][j]);
			 } 
		}
	}
	
	/**
	 * Test Case ID: 32
	 * Method Under Test: createNumberArray2D
	 * Description: Verify that createNumberArray2D throws IllegalArgumentException when given a null 2D double array
	 * Expected Outcome: IllegalArgumentException should be thrown
	 */
	
	@Test
	public void testNullArrayData2D() {
		 try {
			 DataUtilities.createNumberArray2D(null);
			 fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		 } catch (Exception e) {
			 assertTrue("Incorrect exception type thrown",
						e.getClass().equals(IllegalArgumentException.class));
		 }
	}
	
	// test cases for getCumulativePercentages
	
	/**
	 * Test Case ID: 33
	 * Method Under Test: getCumulativePercentages
	 * Description: Verify that getCumulativePercentages correctly computes the cumulative percentages of the given KeyedValues
	 * Expected Outcome: The correct cumulative percentages should be returned
	 */

	
	@Test
	public void testGetCumulativePercentagesValidValues() {
		KeyedValues values = DataUtilities.getCumulativePercentages(keyedValues);
		
		DefaultKeyedValues testKeyedValues = new DefaultKeyedValues();
		testKeyedValues.addValue("0", 0.02777778);
		testKeyedValues.addValue("1", 0.11111111);
		testKeyedValues.addValue("2", 0.25);
		testKeyedValues.addValue("3", 0.44444444);
		testKeyedValues.addValue("4", 0.69444444);
		testKeyedValues.addValue("5", 1);
		
		assertEquals(testKeyedValues.getValue(0), values.getValue(0));
		assertEquals(testKeyedValues.getValue(3), values.getValue(3));
		assertEquals(testKeyedValues.getValue(5), values.getValue(5));

	}
	
	/**
	 * Test Case ID: 34
	 * Method Under Test: getCumulativePercentages
	 * Description: Verify that getCumulativePercentages handles empty KeyedValues correctly
	 * Expected Outcome: Appropriate cumulative percentages for empty data should be returned
	 */
	
	@Test
	public void testGetCumulativePercentagesEmptyValues() {
		KeyedValues values = DataUtilities.getCumulativePercentages(keyedValuesEmpty);
		DefaultKeyedValues testKeyedValues = new DefaultKeyedValues();
		
		assertEquals(testKeyedValues, values);

	}
	
	/**
	 * Test Case ID: 35
	 * Method Under Test: getCumulativePercentages
	 * Description: Verify that getCumulativePercentages throws IllegalArgumentException when given null KeyedValues
	 * Expected Outcome: IllegalArgumentException should be thrown
	 */
	
	@Test
	public void testGetCumulativePercentagesNullValues() {
		try {
			DataUtilities.getCumulativePercentages(null);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		} catch(Exception e) {
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}

}
