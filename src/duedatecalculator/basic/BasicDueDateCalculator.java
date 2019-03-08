/*
 * BasicDueDateCalculator.java
 * Create Date: Mar 8, 2019
 * Initial-Author: Janos Aron Kiss
 */

package duedatecalculator.basic;

import duedatecalculator.DueDateCalculator;
import duedatecalculator.DueDateChecker;
import java.util.Calendar;
import java.util.Date;

/**
 * This class is the basic implementation of {@link DueDateCalculator}.
 * @version $Revision$ $LastChangedDate$
 * @author $Author$
 */
public class BasicDueDateCalculator implements DueDateCalculator {

    protected final Calendar calendar;
    private final DueDateChecker dateChecker;

    public BasicDueDateCalculator(DueDateChecker dateChecker) {
        this.dateChecker = dateChecker;
        this.calendar = Calendar.getInstance();        
    }
    
    @Override
    public Date calculateDueDate(Date submitDate, int turnaroundTime) {                        
        calendar.setTime(submitDate);
        
        for( int i = 0; i < turnaroundTime; i++ )
            setCalendarToNextWorkingHour();
        
        return calendar.getTime();
    }    
    
    private void setCalendarToNextWorkingHour() {
        Date time;
        do {            
            calendar.add(Calendar.HOUR_OF_DAY, 1);            
            time = calendar.getTime();
        } while ( !dateChecker.isWorkingHour(time) || !dateChecker.isWorkingDay(time) );
    }
    
}
