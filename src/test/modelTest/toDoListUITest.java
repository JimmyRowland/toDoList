package modelTest;

import model.ToDoList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ui.ToDoListUI;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class toDoListUITest {

    ToDoListUI ToDoListUI1;
    ToDoList toDoList;

    private void init(String name) {
        toDoList = new ToDoList(name);
        ToDoListUI1.seed(toDoList);
    }

    @BeforeEach
    void runBefore() {
        ToDoListUI1 = new ToDoListUI();
    }

    //    @Test
//    void test
    @ParameterizedTest
    @ValueSource(strings = {"racecar", "radar", "able was I ere I saw elba"})
    void testSeedShouldGive2by2toDolistWithNamename(String name) {
        init(name);
        assertEquals(toDoList.getName(), name);
        assertEquals(toDoList.getListName(1), "To do list 1");
        assertEquals(toDoList.getList(1).getTaskName(1), "Task1");
        toDoList.setName(name + "1");
        assertEquals(toDoList.getName(), name + "1");
        ;
    }

    @ParameterizedTest
    @ValueSource(strings = {"racecar", "radar", "able was I ere I saw elba"})
    void testAddListAndRemovelistAndPrintLists(String listName) {
        init(listName);
        toDoList.addList(listName);
        toDoList.addList("listToBeRemoved");
        toDoList.addList(listName);
        toDoList.addList("willNotBeDeleted");
        assertEquals(toDoList.getListsPrint(), listName + "\n" +
                " 0: To do list 0\n" +
                " 1: To do list 1\n" +
                " 2: " + listName + "\n" +
                " 3: listToBeRemoved\n" +
                " 4: " + listName + "\n" +
                " 5: willNotBeDeleted");
        assertEquals(toDoList.getLength(), 6);
        toDoList.removeList(3);
        assertEquals(toDoList.getLength(), 5);

//        ToDoListUI1.printLists(toDoList);
        assertEquals(toDoList.getListsPrint(), listName + "\n" +
                " 0: To do list 0\n" +
                " 1: To do list 1\n" +
                " 2: " + listName + "\n" +
                " 3: " + listName + "\n" +
                " 4: willNotBeDeleted");

    }

    @ParameterizedTest
    @ValueSource(strings = {"racecar", "radar", "able was I ere I saw elba"})
    void testAddTaskAndRemovetaskAndPrintTasks(String taskName) {
        init(taskName);
        toDoList.addTask(1, taskName);
        toDoList.getList(0).addTask(taskName);
        toDoList.addTask(1, "doneTask");
        toDoList.addTask(1, "removedTask");
        toDoList.addTask(1, "toBeDone");
        assertEquals(toDoList.getTasksPrint(0), "To do list 0\n" +
                "\t0: Task0true\n" +
                "\t1: Task1true\n" +
                "\t2: " + taskName + "true");
        assertEquals(toDoList.getTasksPrint(1), "To do list 1\n" +
                "\t0: Task0true\n" +
                "\t1: Task1true\n" +
                "\t2: " + taskName + "true\n" +
                "\t3: doneTasktrue\n" +
                "\t4: removedTasktrue\n" +
                "\t5: toBeDonetrue");
        toDoList.getList(1).setTaskDone(3);
        assertEquals(toDoList.getTasksPrint(1), "To do list 1\n" +
                "\t0: Task0true\n" +
                "\t1: Task1true\n" +
                "\t2: " + taskName + "true\n" +
                "\t3: removedTasktrue\n" +
                "\t4: toBeDonetrue\n" +
                "Done\n" +
                "\t0: doneTaskfalse");
        toDoList.getList(1).removeTask(3);
        assertEquals(toDoList.getTasksPrint(1), "To do list 1\n" +
                "\t0: Task0true\n" +
                "\t1: Task1true\n" +
                "\t2: " + taskName + "true\n" +
                "\t3: toBeDonetrue\n" +
                "Done\n" +
                "\t0: doneTaskfalse");
        toDoList.getList(1).setTaskDone(3);
        toDoList.getList(1).setTaskUndone(1);
        assertEquals(toDoList.getTasksPrint(1), "To do list 1\n" +
                "\t0: Task0true\n" +
                "\t1: Task1true\n" +
                "\t2: " + taskName + "true\n" +
                "\t3: toBeDonetrue\n" +
                "Done\n" +
                "\t0: doneTaskfalse");
        assertEquals(toDoList.getTask(1, 3), "toBeDone");

    }

//    @Test
//    void getTask() {
//    }

//    @Test
//    void setName() {
//    }
//
//    @Test
//    void getLength() {
//    }
}
