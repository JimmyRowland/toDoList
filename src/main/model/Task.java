package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class Task extends ItemAbstract {
    private Boolean toBeDone;
    private Boolean deleted;
    protected Calendar startDate;
    protected Calendar endDate;
    private ArrayList<Calendar> dateArrayList;

    public Task(String name) {
        super(name);
        toBeDone = true;
        deleted = false;
        setReminder();
    }

    // EFFECTS return the stateDate of the task as string
    public String getStartDate() {
        return startDate.getTimeInMillis() + "";
    }

    // EFFECTS return index's date in the dateArrayList
    // REQUIRES 0<=index < dateArrayList.size()
    public String getDateFromArray(int index) {
        return dateArrayList.get(index).getTimeInMillis() + "";
    }

    // MODIFIES this
    // EFFECTS if there is a single parameter, set endDate as the parameter. If there is no parameter, set current
    // time as endDate.
    public void setReminder(Calendar... dates) {
        if (dates.length == 1) {
            endDate = dates[0];
            startDate = null;
        } else if (dates.length == 2) {
            startDate = dates[0];
            endDate = dates[1];
        } else if (dates.length > 2) {
            dateArrayList = new ArrayList<Calendar>(Arrays.asList(dates));
        } else {
            startDate = Calendar.getInstance();
            endDate = Calendar.getInstance();
        }
    }

    //EFFECTS if the task's due date has passes, return true. Otherwise return false
    public boolean getPastDue() {
        return endDate.before(Calendar.getInstance());
    }

    //EFFECTS if the current system time is between the endDate and the startDate, return true. Otherwise return false
    public boolean getEventInProcess() {
        Calendar time = Calendar.getInstance();
        return endDate.after(time) && startDate.before(time);
    }

    //EFFECTS return the due date as string
    public String getDueDate() {
        return endDate.getTimeInMillis() + "";
    }


    // EFFECTS if the task has not been done return true, otherwise return false
    public Boolean getToBeDone() {
        return toBeDone;
    }

    public void setToBeDone(Boolean bool) {
        toBeDone = bool;
    }

    //MODIFIES this
    // EFFECTS set toBeDone to ! toBeDone
    public void setToBeDone() {
        toBeDone = !toBeDone;
    }

    // EFFECTS if the task is deleted, return true. Otherwise return false
    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean bool) {
        deleted = bool;
    }


    //MODIFIES this
    // EFFECTS set deleted status to !deleted
    public void setDeleted() {
        deleted = !deleted;
    }
}
