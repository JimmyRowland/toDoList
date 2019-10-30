package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class TaskListHashmapTest {
    TaskListHashmap listTask;
    TaskListHashmap listTask1;
    TaskInHashmap task0;
    TaskInHashmap task1;
    TaskInHashmap taskNumber;
    @BeforeEach
    void setUp() {
        listTask = new TaskListHashmap();
        listTask1 = new TaskListHashmap();
        taskNumber = new TaskInHashmap("1");
        task0 = new TaskInHashmap("test");
        task1 = new TaskInHashmap("test");
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.DATE,1);
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.DATE,2);
        task0.setReminder(startDate,endDate);
        task1.setReminder(startDate,startDate);

    }

    @Test
    void size() {
        assertEquals(0,listTask.size());
        listTask.add(new TaskInHashmap("test"));
        assertEquals(1,listTask.size());
    }

    @Test
    void add() {
        listTask.add("test");
        System.out.println(listTask.getTask("test").getDueDate());
        System.out.println(task0.getDueDate());
        assertTrue(listTask.containsKey(task0));
        assertFalse(listTask.containsValue(task0));
        listTask.add(task0);
        assertFalse(listTask.containsValue(task0));
        assertTrue(listTask.containsKey(task0));
        listTask.remove(task0);
        assertFalse(listTask.containsValue(task0));
        assertFalse(listTask.containsKey(task0));
        listTask.add(taskNumber);
        listTask.add(task1);
        assertTrue(listTask.containsValue(task1));
        assertTrue(listTask.containsKey(task1));
        listTask1.add(task1);
        assertFalse(listTask.containsKey(task1));
        assertTrue(listTask1.containsKey(task1));
    }

    @Test
    void remove() {
        listTask.add(taskNumber);
        assertTrue(listTask.containsValue(taskNumber));
        listTask.remove(1);
        assertFalse(listTask.containsValue(taskNumber));
    }

    @Test
    void equals(){
        assertNotEquals(task0, new Task("test"));
        assertNotEquals(task0,task1);

    }

    @Test
    void setName(){
        listTask.add(task0);
        task0.setName("test1");
        assertFalse(listTask.containsKey(task1));
        assertTrue(listTask.containsKey(task0));
    }

    @Test
    void testHashCode(){
        assertNotEquals(task0.hashCode(),task1.hashCode());
        //Time signature is unstable
//        TaskInHashmap testList = new TaskInHashmap("1");
//        assertEquals(taskNumber.hashCode(), testList.hashCode());
    }
}