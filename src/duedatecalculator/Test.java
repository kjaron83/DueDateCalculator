/*
 * Test.java
 * Create Date: Mar 8, 2019
 * Initial-Author: Janos Aron Kiss
 */

package duedatecalculator;

import duedatecalculator.settings.SettingsDueDateChecker;
import duedatecalculator.settings.SettingsDueDateCalculator;
import duedatecalculator.basic.BasicDueDateCalculator;
import duedatecalculator.basic.BasicDueDateChecker;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Visual testing of {@link DueDateCalculator} implementations.
 * @version $Revision$ $LastChangedDate$
 * @author $Author$
 */
public class Test {

    public static final int[] WORKING_HOURS = new int[]{9, 10, 11, 12, 13, 14, 15, 16};
    public static final int[] WORKING_DAYS = new int[]{Calendar.MONDAY, Calendar.TUESDAY, Calendar.WEDNESDAY, Calendar.THURSDAY, Calendar.FRIDAY};

    public static final Date SUBMIT_DATE = new Date(119, 0, 1, 10, 0, 0);
    
    public static final Map<Integer, Date> EXPECTED_DUE_DATE = new HashMap<>();
    static {
        EXPECTED_DUE_DATE.put(1, new Date(119, 0, 1, 11, 0, 0));        
        EXPECTED_DUE_DATE.put(8, new Date(119, 0, 2, 10, 0, 0));        
        EXPECTED_DUE_DATE.put(10, new Date(119, 0, 2, 12, 0, 0));        
        EXPECTED_DUE_DATE.put(20, new Date(119, 0, 3, 14, 0, 0));        
        EXPECTED_DUE_DATE.put(30, new Date(119, 0, 4, 16, 0, 0));        
        EXPECTED_DUE_DATE.put(35, new Date(119, 0, 7, 13, 0, 0));        
        EXPECTED_DUE_DATE.put(40, new Date(119, 0, 8, 10, 0, 0));        
        EXPECTED_DUE_DATE.put(1001, new Date(119, 5, 25, 11, 0, 0));        
    }    
    
    public static final Date A_WORKING_DAY = new Date(119, 0, 1, 10, 0, 0);
    public static final Date A_NON_WORKING_DAY = new Date(119, 0, 5, 10, 0, 0);
    
    public static final Date A_WORKING_HOUR = A_NON_WORKING_DAY;
    public static final Date A_NON_WORKING_HOUR = new Date(119, 0, 1, 19, 0, 0);    
    
    public static void main(String[] args) {        
        DueDateCalculator basic = new BasicDueDateCalculator(new BasicDueDateChecker());
        DueDateCalculator settings = new SettingsDueDateCalculator(new SettingsDueDateChecker(WORKING_HOURS, WORKING_DAYS));
        
        Date submitDate = new Date(119, 0, 1, 10, 0, 0);        
        for(int i = 1; i <= 168; i++) {
            System.out.println(i + ".b.: " + basic.calculateDueDate(submitDate, i));
            System.out.println(i + ".s.: " + settings.calculateDueDate(submitDate, i));
        }
    }    
    
    
}
