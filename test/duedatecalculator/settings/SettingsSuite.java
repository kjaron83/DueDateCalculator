/*
 * SettingsSuite.java
 * Create Date: Mar 8, 2019
 * Initial-Author: Janos Aron Kiss
 */
package duedatecalculator.settings;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Janos Aron Kiss
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({duedatecalculator.settings.SettingsDueDateCheckerTest.class, duedatecalculator.settings.SettingsDueDateCalculatorTest.class})
public class SettingsSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
