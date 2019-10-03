package helper;

import model.ToDoListContainer;

public interface RunnableWithParameters extends Runnable {

    void runWithToDoList(ToDoListContainer userToDoListContainer);

    void runWithToDoListAndIndex1(ToDoListContainer userToDoListContainer, int index);
    void runWithToDoListAndIndex2(ToDoListContainer userToDoListContainer, int index);
    void runWithToDoListAndIndex3(ToDoListContainer userToDoListContainer, int index);
}
