package modelTest;

import model.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListTest {
    List list;

    @BeforeEach
    void setUp() {
        list = new List("testList");
        list.addTask("taskToBeDeleted");
        list.addTask("doneTask");
        list.addTask("taskNotDone");

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
        assertEquals(list.getListPrint(), "testList\n" +
                "\t0: taskToBeDeletedtrue\n" +
                "\t1: doneTasktrue\n" +
                "\t2: taskNotDonetrue");
        list.addTask("addedTask");
        assertEquals(list.getListPrint(), "testList\n" +
                "\t0: taskToBeDeletedtrue\n" +
                "\t1: doneTasktrue\n" +
                "\t2: taskNotDonetrue\n" +
                "\t3: addedTasktrue");
    }

    @Test
    void setTaskDone() {
        assertEquals(list.getListPrint(), "testList\n" +
                "\t0: taskToBeDeletedtrue\n" +
                "\t1: doneTasktrue\n" +
                "\t2: taskNotDonetrue");
        list.setTaskDone(1);
        assertEquals(list.getListPrint(), "testList\n" +
                "\t0: taskToBeDeletedtrue\n" +
                "\t1: taskNotDonetrue\n" + "Done\n" +
                "\t0: doneTaskfalse");
    }

    @Test
    void setTaskUndone() {
        assertEquals(list.getListPrint(), "testList\n" +
                "\t0: taskToBeDeletedtrue\n" +
                "\t1: doneTasktrue\n" +
                "\t2: taskNotDonetrue");
        list.setTaskDone(2);
        list.setTaskUndone(0);
        assertEquals(list.getListPrint(), "testList\n" +
                "\t0: taskToBeDeletedtrue\n" +
                "\t1: doneTasktrue\n" +
                "\t2: taskNotDonetrue");
    }

    @Test
    void removeTask() {
        assertEquals(list.getListPrint(), "testList\n" +
                "\t0: taskToBeDeletedtrue\n" +
                "\t1: doneTasktrue\n" +
                "\t2: taskNotDonetrue");
        list.removeTask(0);
        assertEquals(list.getListPrint(), "testList\n" +
                "\t0: doneTasktrue\n" +
                "\t1: taskNotDonetrue");
    }

    @Test
    void setName() {
        assertEquals(list.getListPrint(), "testList\n" +
                "\t0: taskToBeDeletedtrue\n" +
                "\t1: doneTasktrue\n" +
                "\t2: taskNotDonetrue");
        list.setName("newName");
        assertEquals(list.getListPrint(), "newName\n" +
                "\t0: taskToBeDeletedtrue\n" +
                "\t1: doneTasktrue\n" +
                "\t2: taskNotDonetrue");
    }

    @Test
    void getTaskName() {
        list.addTask("someTask");
        assertEquals(list.getTaskName(3), "someTask");
    }

    @Test
    void getTask() {
        list.addTask("someTask");
        assertEquals(list.getTask(3).getName(), "someTask");
    }

    @Test
    void getListPrint() {
        list.addTask("someTask");
        assertEquals(list.getListPrint(), "testList\n" +
                "\t0: taskToBeDeletedtrue\n" +
                "\t1: doneTasktrue\n" +
                "\t2: taskNotDonetrue\n" +
                "\t3: someTasktrue");
    }

    @Test
    void getSize() {
        assertEquals(list.getSize(), 3);
        list.addTask("someTask");
        assertEquals(list.getSize(), 4);
    }

    @Test
    void getName() {
        assertEquals(list.getName(), "testList");
    }
}