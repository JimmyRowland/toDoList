package modelTest;

import model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    private Task task;

    @BeforeEach
    void setUp() {
        task = new Task("testTask");
    }

    @Test
    void getName() {
        assertEquals(task.getName(), "testTask");
    }

    @Test
    void setName() {
        task.setName("newName");
        assertEquals(task.getName(), "newName");
    }

    @Test
    void getToBeDone() {
        assertTrue(task.getToBeDone());
    }

    @Test
    void getDeleted() {
        assertFalse(task.getDeleted());
    }

    @Test
    void setDoneStatus() {
        task.setDoneStatus();
        assertFalse(task.getToBeDone());
    }

    @Test
    void setDeleted() {
        task.setDeleted();
        assertTrue(task.getDeleted());
    }

    @Test
    void isPastDue() {
        Calendar dueDate = Calendar.getInstance();
        dueDate.add(Calendar.DATE, -1);
        task.setReminder(dueDate);
        assertTrue(task.getPastDue());
        dueDate.add(Calendar.DATE, 20);
        assertFalse(task.getPastDue());
    }

    @Test
    void getEventInProcess() {
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.DATE, -1);
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.DATE, 10);
        task.setReminder(startDate, endDate);
        assertTrue(task.getEventInProcess());
        startDate.add(Calendar.DATE, 4);
        assertFalse(task.getEventInProcess());
    }

    @Test
    void setReminder() {
        task.setReminder();
        assertNotNull(task.getDueDate());
        Calendar date1 = Calendar.getInstance();
        Calendar date2 = Calendar.getInstance();
        Calendar date3 = Calendar.getInstance();
        task.setReminder(date1);
        assertEquals(task.getDueDate(), date1.toString());
        task.setReminder(date1, date2);
        assertEquals(task.getDueDate(), date2.toString());
        assertEquals(task.getStartDate(), date1.toString());
        task.setReminder(date1, date2, date3);
        assertEquals(task.getDateFromArray(0), date1.toString());
        assertEquals(task.getDateFromArray(1), date2.toString());
        assertEquals(task.getDateFromArray(2), date3.toString());
    }

//    @Test
//    void getPastDue() {
//    }
//
//    @Test
//    void getDueDate() {
//    }
//
//    @Test
//    void getStartDate() {
//    }
//
//    @Test
//    void getDateFromArray() {
//    }
}