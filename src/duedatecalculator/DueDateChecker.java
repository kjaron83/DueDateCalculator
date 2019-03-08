/*
 * IDueDateChecker.java
 * Create Date: Mar 8, 2019
 * Initial-Author: Janos Aron Kiss
 */

package duedatecalculator;

import java.util.Date;

/**
 * This interface provides information from a specified date.
 * @version $Revision$ $LastChangedDate$
 * @author $Author$
 */
public interface DueDateChecker {

    public boolean isWorkingDay(Date date);   
    
    public boolean isWorkingHour(Date date);
    
}
