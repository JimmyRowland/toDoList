package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.ToDoListUI;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ToDoListWriterReaderTest {

    private ToDoListUI ToDoListUI1;
    private ToDoListContainer toDoListContainer;

    private void init(String name) {
        toDoListContainer = new ToDoListContainer(name);
        ToDoListUI1.seed(toDoListContainer);
    }

    @BeforeEach
    void runBefore() {
        ToDoListUI1 = new ToDoListUI();
        init("writer reader test");
    }

    @Test
    void testWriterReader() {
        ToDoListWriter w = new ToDoListWriter(toDoListContainer);
        ToDoListReader r = new ToDoListReader();
        w.write("./data/testToDoListWriterReader");
        ToDoListContainer testContainer = r.read("./data/testToDoListWriterReader");
        assertContainerEqual(toDoListContainer, testContainer);
    }

    void assertContainerEqual(ToDoListContainer toDoListContainer0, ToDoListContainer toDoListContainer1) {
        assertEquals(toDoListContainer0.getListsPrint(), toDoListContainer1.getListsPrint());
        for (int i = 0; i < (Math.max(toDoListContainer0.size(), toDoListContainer1.size())); i++){
            assertEquals(toDoListContainer0.getTasksPrint(i),toDoListContainer1.getTasksPrint(i));
        }
    }


}