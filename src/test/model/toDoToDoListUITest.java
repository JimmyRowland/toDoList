package model;

import model.ToDoListContainer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ui.PrimaryMenu;
import ui.ToDoListUI;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class toDoToDoListUITest {

    private ToDoListUI ToDoListUI1;
    private ToDoListContainer toDoListContainer;

    private void init(String name) {
        toDoListContainer = new ToDoListContainer(name);
        ToDoListUI1.seed(toDoListContainer);
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
        assertEquals(toDoListContainer.getName(), name);
        assertEquals(toDoListContainer.getItemName(1), "To do list 1");
        assertEquals(toDoListContainer.getList(1).getItemName(1), "Task1");
        toDoListContainer.setName(name + "1");
        assertEquals(toDoListContainer.getName(), name + "1");
        ;
    }

    @ParameterizedTest
    @ValueSource(strings = {"racecar", "radar", "able was I ere I saw elba"})
    void testAddListAndRemovelistAndPrintLists(String listName) {
        init(listName);
        toDoListContainer.add(listName);
        toDoListContainer.add("listToBeRemoved");
        toDoListContainer.add(listName);
        toDoListContainer.add("willNotBeDeleted");
        assertEquals(toDoListContainer.getListsPrint(), listName + "\n" +
                " 0: To do list 0\n" +
                " 1: To do list 1\n" +
                " 2: " + listName + "\n" +
                " 3: listToBeRemoved\n" +
                " 4: " + listName + "\n" +
                " 5: willNotBeDeleted");
        assertEquals(toDoListContainer.size(), 6);
        toDoListContainer.remove(3);
        assertEquals(toDoListContainer.size(), 5);

//        ToDoListUI1.printLists(toDoList);
        assertEquals(toDoListContainer.getListsPrint(), listName + "\n" +
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
        toDoListContainer.addTask(1, taskName);
        toDoListContainer.getList(0).add(taskName);
        toDoListContainer.addTask(1, "doneTask");
        toDoListContainer.addTask(1, "removedTask");
        toDoListContainer.addTask(1, "toBeDone");
        assertEquals(toDoListContainer.getTasksPrint(0), "To do list 0\n" +
                "\t0: Task0true\n" +
                "\t1: Task1true\n" +
                "\t2: " + taskName + "true");
        assertEquals(toDoListContainer.getTasksPrint(1), "To do list 1\n" +
                "\t0: Task0true\n" +
                "\t1: Task1true\n" +
                "\t2: " + taskName + "true\n" +
                "\t3: doneTasktrue\n" +
                "\t4: removedTasktrue\n" +
                "\t5: toBeDonetrue");
        toDoListContainer.getList(1).setTaskDone(3);
        assertEquals(toDoListContainer.getTasksPrint(1), "To do list 1\n" +
                "\t0: Task0true\n" +
                "\t1: Task1true\n" +
                "\t2: " + taskName + "true\n" +
                "\t3: removedTasktrue\n" +
                "\t4: toBeDonetrue\n" +
                "Done\n" +
                "\t0: doneTaskfalse");
        toDoListContainer.getList(1).remove(3);
        assertEquals(toDoListContainer.getTasksPrint(1), "To do list 1\n" +
                "\t0: Task0true\n" +
                "\t1: Task1true\n" +
                "\t2: " + taskName + "true\n" +
                "\t3: toBeDonetrue\n" +
                "Done\n" +
                "\t0: doneTaskfalse");
        toDoListContainer.getList(1).setTaskDone(3);
        toDoListContainer.getList(1).setTaskUndone(1);
        assertEquals(toDoListContainer.getTasksPrint(1), "To do list 1\n" +
                "\t0: Task0true\n" +
                "\t1: Task1true\n" +
                "\t2: " + taskName + "true\n" +
                "\t3: toBeDonetrue\n" +
                "Done\n" +
                "\t0: doneTaskfalse");
        assertEquals(toDoListContainer.getTask(1, 3), "toBeDone");
        assertEquals(toDoListContainer.getList(1).getTask(3).getName(),"toBeDone");

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
