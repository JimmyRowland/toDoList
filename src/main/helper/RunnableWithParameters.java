package helper;

import model.ToDoList;

public interface RunnableWithParameters extends Runnable {

    void runWithToDoList(ToDoList userToDoList);

    void runWithToDoListAndIndex1(ToDoList userToDoList, int index);
    void runWithToDoListAndIndex2(ToDoList userToDoList, int index);
    void runWithToDoListAndIndex3(ToDoList userToDoList, int index);
}
