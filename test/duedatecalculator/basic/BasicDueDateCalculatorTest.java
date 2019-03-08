/*
 * BasicDueDateCalculatorTest.java
 * Create Date: Mar 8, 2019
 * Initial-Author: Janos Aron Kiss
 */
package duedatecalculator.basic;

import duedatecalculator.DueDateCalculator;
import duedatecalculator.DueDateChecker;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Janos Aron Kiss
 */
public class BasicDueDateCalculatorTest {
    
    public BasicDueDateCalculatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calculateDueDate method, of class BasicDueDateCalculator.
     */
    @Test
    public void testCalculateDueDate() {
        System.out.println("calculateDueDate");
        
        DueDateChecker checker = new BasicDueDateChecker();
        DueDateCalculator instance = new BasicDueDateCalculator(checker);
        
        for ( int key : duedatecalculator.Test.EXPECTED_DUE_DATE.keySet() )
            assertEquals(duedatecalculator.Test.EXPECTED_DUE_DATE.get(key), instance.calculateDueDate(duedatecalculator.Test.SUBMIT_DATE, key));             
    }
    
}
