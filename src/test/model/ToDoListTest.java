package model;

import model.ToDoList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ToDoListTest {
    ToDoList toDoList;

    @BeforeEach
    void setUp() {
        toDoList = new ToDoList("testList");
        toDoList.add("taskToBeDeleted");
        toDoList.add("doneTask");
        toDoList.add("taskNotDone");

    }

//    @Test
//    void deleteTask() {
//        assertEquals(list.getListPrint(),"testList\n" +
//                "\t0: taskToBeDeletedtrue\n" +
//                "\t1: doneTasktrue\n" +
//                "\t2: taskNotDonetrue");
//        list.deleteTask(0);
//        assertEquals(list.getListPrint(),"testList\n" +
//                "\t0: doneTasktrue\n" +
//                "\t1: taskNotDonetrue");
//    }

    @Test
    void addTask() {
        assertEquals(toDoList.getListPrint(), "testList\n" +
                "\t0: taskToBeDeletedtrue\n" +
                "\t1: doneTasktrue\n" +
                "\t2: taskNotDonetrue");
        toDoList.add("addedTask");
        assertEquals(toDoList.getListPrint(), "testList\n" +
                "\t0: taskToBeDeletedtrue\n" +
                "\t1: doneTasktrue\n" +
                "\t2: taskNotDonetrue\n" +
                "\t3: addedTasktrue");
    }

    @Test
    void setTaskDone() {
        assertEquals(toDoList.getListPrint(), "testList\n" +
                "\t0: taskToBeDeletedtrue\n" +
                "\t1: doneTasktrue\n" +
                "\t2: taskNotDonetrue");
        toDoList.setTaskDone(1);
        assertEquals(toDoList.getListPrint(), "testList\n" +
                "\t0: taskToBeDeletedtrue\n" +
                "\t1: taskNotDonetrue\n" + "Done\n" +
                "\t0: doneTaskfalse");
    }

    @Test
    void setTaskUndone() {
        assertEquals(toDoList.getListPrint(), "testList\n" +
                "\t0: taskToBeDeletedtrue\n" +
                "\t1: doneTasktrue\n" +
                "\t2: taskNotDonetrue");
        toDoList.setTaskDone(2);
        toDoList.setTaskUndone(0);
        assertEquals(toDoList.getListPrint(), "testList\n" +
                "\t0: taskToBeDeletedtrue\n" +
                "\t1: doneTasktrue\n" +
                "\t2: taskNotDonetrue");
    }

    @Test
    void removeTask() {
        assertEquals(toDoList.getListPrint(), "testList\n" +
                "\t0: taskToBeDeletedtrue\n" +
                "\t1: doneTasktrue\n" +
                "\t2: taskNotDonetrue");
        toDoList.remove(0);
        assertEquals(toDoList.getListPrint(), "testList\n" +
                "\t0: doneTasktrue\n" +
                "\t1: taskNotDonetrue");
    }

    @Test
    void setName() {
        assertEquals(toDoList.getListPrint(), "testList\n" +
                "\t0: taskToBeDeletedtrue\n" +
                "\t1: doneTasktrue\n" +
                "\t2: taskNotDonetrue");
        toDoList.setName("newName");
        assertEquals(toDoList.getListPrint(), "newName\n" +
                "\t0: taskToBeDeletedtrue\n" +
                "\t1: doneTasktrue\n" +
                "\t2: taskNotDonetrue");
    }

    @Test
    void getTaskName() {
        toDoList.add("someTask");
        assertEquals(toDoList.getItemName(3), "someTask");
    }

    @Test
    void getTask() {
        toDoList.add("someTask");
        assertEquals(toDoList.getTask(3).getName(), "someTask");
    }

    @Test
    void getListPrint() {
        toDoList.add("someTask");
        assertEquals(toDoList.getListPrint(), "testList\n" +
                "\t0: taskToBeDeletedtrue\n" +
                "\t1: doneTasktrue\n" +
                "\t2: taskNotDonetrue\n" +
                "\t3: someTasktrue");
    }

    @Test
    void getSize() {
        assertEquals(toDoList.size(), 3);
        toDoList.add("someTask");
        assertEquals(toDoList.size(), 4);
    }

    @Test
    void getName() {
        assertEquals(toDoList.getName(), "testList");
    }
}