/*
 * BasicSuite.java
 * Create Date: Mar 8, 2019
 * Initial-Author: Janos Aron Kiss
 */
package duedatecalculator.basic;

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
@Suite.SuiteClasses({duedatecalculator.basic.BasicDueDateCheckerTest.class, duedatecalculator.basic.BasicDueDateCalculatorTest.class})
public class BasicSuite {

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
