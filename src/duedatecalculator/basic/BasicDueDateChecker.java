/*
 * BasicDueDateChecker.java
 * Create Date: Mar 8, 2019
 * Initial-Author: Janos Aron Kiss
 */

package duedatecalculator.basic;

import duedatecalculator.DueDateChecker;
import java.util.Calendar;
import java.util.Date;

/**
 * This class is the basic implementation of {@link DueDateChecker}.
 * @version $Revision$ $LastChangedDate$
 * @author $Author$
 */
public class BasicDueDateChecker implements DueDateChecker {

    private final Calendar calendar;

    public BasicDueDateChecker() {
        this.calendar = Calendar.getInstance();
    }
    
    /**
     * Returns true on every weekday.
     */
    @Override
    public boolean isWorkingDay(Date date) {
        calendar.setTime(date);        
        int day = calendar.get(Calendar.DAY_OF_WEEK);                
        return ((day == Calendar.MONDAY) || (day == Calendar.TUESDAY) || (day == Calendar.WEDNESDAY) || (day == Calendar.THURSDAY) || (day == Calendar.FRIDAY));
    }

    /**
     * Returns true if time is between 9:00:00 and 16:59:59.
     */
    @Override
    public boolean isWorkingHour(Date date) {        
        calendar.setTime(date);        
        int hour = calendar.get(Calendar.HOUR_OF_DAY);                
        return ((hour > 8) && (hour < 17));
    }    

}
