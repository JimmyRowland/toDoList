package ui;

import model.ToDoListContainer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.exceptions.InvalidUserInputException;
import ui.exceptions.UserInputNotANumberException;
import ui.exceptions.UserInputTooLongException;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class PrimaryMenuTest {

    private ToDoListUI ToDoListUI1;
    private ToDoListContainer toDoListContainer;
    private PrimaryMenu primaryMenu;

    private void init(String name) {
        toDoListContainer = new ToDoListContainer(name);
        ToDoListUI1.seed(toDoListContainer);
        primaryMenu = new PrimaryMenu(toDoListContainer);

    }

    @BeforeEach
    void runBefore() {
        ToDoListUI1 = new ToDoListUI();
        init("something");

    }

    @Test
    void uselessInputWithException() {
        // https://stackoverflow.com/questions/6415728/junit-testing-with-simulated-user-input
//        ByteArrayInputStream in = new ByteArrayInputStream("My string".getBytes());
//        System.setIn(in);
//        System.setIn(in);
        try {
            assertEquals("1", primaryMenu.uselessInputWithException("1"));
            System.out.println("pass");
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
        assertEquals("x", primaryMenu.uselessInputWithException("x"));
        assertThrows(InvalidUserInputException.class, () -> primaryMenu.uselessInputWithException("100"));
        assertThrows(UserInputNotANumberException.class, () -> primaryMenu.uselessInputWithException("i"));
        assertThrows(UserInputTooLongException.class, () -> primaryMenu.uselessInputWithException("100sdfgsregdfbdxfb"));


    }
}