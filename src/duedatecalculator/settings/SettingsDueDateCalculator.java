/*
 * DueDateCalculator.java
 * Create Date: Mar 8, 2019
 * Initial-Author: Janos Aron Kiss
 */

package duedatecalculator.settings;

import duedatecalculator.DueDateCalculator;
import java.util.Calendar;
import java.util.Date;

/**
 * This class implements {@link DueDateCalculator}.
 * Calculates due date with a {@link SettingsDueDateChecker} and this can be faster than {@link BasicDueDateCalculator}.
 * @version $Revision$ $LastChangedDate$
 * @author $Author$
 */
public class SettingsDueDateCalculator implements DueDateCalculator {
    
    private final SettingsDueDateChecker dateChecker;
    private final Calendar calendar;
    
    private int neededHours;
    private int neededDays;
    private int neededWeeks;

    public SettingsDueDateCalculator(SettingsDueDateChecker dateChecker) {
        this.dateChecker = dateChecker;
        this.calendar = Calendar.getInstance();
    }    

    @Override
    public Date calculateDueDate(Date submitDate, int turnaroundTime) {                        
        calendar.setTime(submitDate);
        calculateNeeds(turnaroundTime);
        addNeededWeeks();
        addNeededDays();
        addNeededHours();       
        return calendar.getTime();
    }   
    
    private void calculateNeeds(int turnaroundTime) {
        int workingHours = dateChecker.getWorkingHoursInADay();
        int workingDays = dateChecker.getWorkingDaysInAWeek();
        
        neededHours = turnaroundTime;
        neededDays = neededHours / workingHours;
        neededHours -= neededDays * workingHours;
        neededWeeks = neededDays / workingDays;
        neededDays -= neededWeeks * workingDays;
    }
        
    private void addNeededWeeks() {
        calendar.add(Calendar.WEEK_OF_YEAR, neededWeeks);
    }
    
    private void addNeededDays() {
        for ( int i = 0; i < neededDays; i++ )
            setCalendarToNextWorkingDay();
    }
    
    private void addNeededHours() {
        for ( int i = 0; i < neededHours; i++) 
            setCalendarToNextWorkingHour();
    }
    
    private void setCalendarToNextWorkingDay() {
        do {
            calendar.add(Calendar.DAY_OF_YEAR, 1);            
        } while ( !isWorkingDay() );
    }

    private void setCalendarToNextWorkingHour() {
        do {
            calendar.add(Calendar.HOUR_OF_DAY, 1);            
        } while ( !isWorkingHour() || !isWorkingDay() );
    }
    
    private boolean isWorkingDay() {
        return dateChecker.isWorkingDay(calendar.getTime());
    }        
    
    private boolean isWorkingHour() {
        return dateChecker.isWorkingHour(calendar.getTime());
    }        
            
}
