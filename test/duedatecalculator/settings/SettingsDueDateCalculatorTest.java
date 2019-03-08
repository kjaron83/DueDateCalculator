/*
 * SettingsDueDateCalculatorTest.java
 * Create Date: Mar 8, 2019
 * Initial-Author: Janos Aron Kiss
 */
package duedatecalculator.settings;

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
public class SettingsDueDateCalculatorTest {
    
    public SettingsDueDateCalculatorTest() {
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
     * Test of calculateDueDate method, of class SettingsDueDateCalculator.
     */
    @Test
    public void testCalculateDueDate() {
        System.out.println("calculateDueDate");
        
        SettingsDueDateChecker checker = new SettingsDueDateChecker(duedatecalculator.Test.WORKING_HOURS, duedatecalculator.Test.WORKING_DAYS);
        SettingsDueDateCalculator instance = new SettingsDueDateCalculator(checker);
        
        for ( int key : duedatecalculator.Test.EXPECTED_DUE_DATE.keySet() )
            assertEquals(duedatecalculator.Test.EXPECTED_DUE_DATE.get(key), instance.calculateDueDate(duedatecalculator.Test.SUBMIT_DATE, key));           
    }
    
}
