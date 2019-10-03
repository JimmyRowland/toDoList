package helper;

import model.ToDoListContainer;

public class MenuRunnableHelper implements RunnableWithParameters {
    private int index;
    private ToDoListContainer userToDoListContainer;

    public MenuRunnableHelper(ToDoListContainer userToDoListContainer, int index){
        this.index = index;
        this.userToDoListContainer = userToDoListContainer;

    }

    @Override
    public void runWithToDoList(ToDoListContainer userToDoListContainer) {

    }

    @Override
    public void runWithToDoListAndIndex1(ToDoListContainer userToDoListContainer, int index) {

    }

    @Override
    public void runWithToDoListAndIndex2(ToDoListContainer userToDoListContainer, int index) {

    }

    @Override
    public void runWithToDoListAndIndex3(ToDoListContainer userToDoListContainer, int index) {

    }



    @Override
    public void run() {

    }
}
