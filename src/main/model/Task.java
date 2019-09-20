package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class Task {
    private String name;
    private Boolean toBeDone;
    private Boolean deleted;
    private Calendar startDate;
    private Calendar endDate;
    private ArrayList<Calendar> dateArrayList;

    public Task(String name) {
        this.name = name;
        toBeDone = true;
        deleted = false;
    }

    public String getStartDate() {
        return startDate.toString();
    }

    public String getDateFromArray(int index) {
        return dateArrayList.get(index).toString();
    }

    // MODIFIES this
    // EFFECTS if there is a single parameter, set endDate as the parameter. If there is no parameter, set current
    // time as endDate.
    public void setReminder(Calendar... dates) {
        if (dates.length == 1) {
            endDate = dates[0];
        } else if (dates.length == 2) {
            startDate = dates[0];
            endDate = dates[1];
        } else if (dates.length > 2) {
            dateArrayList = new ArrayList<Calendar>(Arrays.asList(dates));
        } else {
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
        return endDate.toString();
    }

    //EFFECTS return task's name
    public String getName() {
        return name;
    }

    // MODIFIES this
    // EFFECTS set task's name to name
    public void setName(String name) {
        this.name = name;
    }

    // EFFECTS if the task has not been done return true, otherwise return false
    public Boolean getToBeDone() {
        return toBeDone;
    }


    // EFFECTS if the task is deleted, return true. Otherwise return false
    public Boolean getDeleted() {
        return deleted;
    }

    //MODIFIES this
    // EFFECTS set toBeDone to ! toBeDone
    public void setDoneStatus() {
        toBeDone = !toBeDone;
    }

    //MODIFIES this
    // EFFECTS set deleted status to !deleted
    public void setDeleted() {
        deleted = !deleted;
    }
}
