/*
 * SettingsDueDateCheckerTest.java
 * Create Date: Mar 8, 2019
 * Initial-Author: Janos Aron Kiss
 */
package duedatecalculator.settings;

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
public class SettingsDueDateCheckerTest {
    
    public SettingsDueDateCheckerTest() {
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
     * Test of isWorkingDay method, of class SettingsDueDateChecker.
     */
    @Test
    public void testIsWorkingDay() {
        System.out.println("isWorkingDay");
        DueDateChecker instance = new SettingsDueDateChecker(duedatecalculator.Test.WORKING_HOURS, duedatecalculator.Test.WORKING_DAYS);
        assertEquals(true, instance.isWorkingDay(duedatecalculator.Test.A_WORKING_DAY));
        assertEquals(false, instance.isWorkingDay(duedatecalculator.Test.A_NON_WORKING_DAY));
    }

    /**
     * Test of isWorkingHour method, of class SettingsDueDateChecker.
     */
    @Test
    public void testIsWorkingHour() {
        System.out.println("isWorkingHour");
        DueDateChecker instance = new SettingsDueDateChecker(duedatecalculator.Test.WORKING_HOURS, duedatecalculator.Test.WORKING_DAYS);
        assertEquals(true, instance.isWorkingHour(duedatecalculator.Test.A_WORKING_HOUR));
        assertEquals(false, instance.isWorkingHour(duedatecalculator.Test.A_NON_WORKING_HOUR));
    }
    
}
