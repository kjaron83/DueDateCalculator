/*
 * SettingsDueDateChecker.java
 * Create Date: Mar 8, 2019
 * Initial-Author: Janos Aron Kiss
 */

package duedatecalculator.settings;

import duedatecalculator.DueDateChecker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class implements {@link DueDateChecker}.
 * Using lists of working hours and working days to determine {@link #isWorkingDay(java.util.Date) } and
 * {@link #isWorkingHour(java.util.Date) }.
 * @version $Revision$ $LastChangedDate$
 * @author $Author$
 */
public class SettingsDueDateChecker implements DueDateChecker {

    private final List<Integer> workingHours;    
    private final List<Integer> workingDays;
    
    private final Calendar calendar;

    public SettingsDueDateChecker(int[] workingHours, int[] workingDays) {
        this.calendar = Calendar.getInstance();
        this.workingHours = Arrays.stream(workingHours).boxed().collect(Collectors.toList());
        this.workingDays = Arrays.stream(workingDays).boxed().collect(Collectors.toList());
    }
    
    public SettingsDueDateChecker(List<Integer> workingHours, List<Integer> workingDays) {
        this.calendar = Calendar.getInstance();
        this.workingHours = new ArrayList<>(workingHours);
        this.workingDays = new ArrayList<>(workingDays);
    }

    public int getWorkingHoursInADay() {
        return workingHours.size();
    }
    
    public int getWorkingDaysInAWeek() {
        return workingDays.size();
    }

    @Override
    public boolean isWorkingDay(Date date) {
        calendar.setTime(date);
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        return workingDays.contains(day);
    }

    @Override
    public boolean isWorkingHour(Date date) {
        calendar.setTime(date);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        return workingHours.contains(hour);
    }
    
}
