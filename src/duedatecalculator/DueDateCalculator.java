/*
 * IDueDateCalculator.java
 * Create Date: Mar 8, 2019
 * Initial-Author: Janos Aron Kiss
 */

package duedatecalculator;

import java.util.Date;

/**
 * This interface calculates the due date by the specified parameters.
 * @version $Revision$ $LastChangedDate$
 * @author $Author$
 */
public interface DueDateCalculator {

    public Date calculateDueDate(Date submitDate, int turnaroundTime);
    
}
