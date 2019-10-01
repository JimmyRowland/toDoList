package helper;

import model.ToDoList;

public class MenuRunnableHelper implements RunnableWithParameters {
    private int index;
    private ToDoList userToDoList;

    public MenuRunnableHelper(ToDoList userToDoList, int index){
        this.index = index;
        this.userToDoList = userToDoList;

    }

    @Override
    public void runWithToDoList(ToDoList userToDoList) {

    }

    @Override
    public void runWithToDoListAndIndex1(ToDoList userToDoList, int index) {

    }

    @Override
    public void runWithToDoListAndIndex2(ToDoList userToDoList, int index) {

    }

    @Override
    public void runWithToDoListAndIndex3(ToDoList userToDoList, int index) {

    }



    @Override
    public void run() {

    }
}
