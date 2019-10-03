package model;

import java.util.ArrayList;

public class ToDoListContainer extends ListAbstract {
    private ArrayList<ToDoList> toDoLists;
    private Boolean deleted;

    public ToDoListContainer(String name) {
        super(name);
        this.toDoLists = new ArrayList<ToDoList>();
    }

    ToDoListContainer(String name, ArrayList<ToDoList> toDoLists) {
        super(name);
        this.toDoLists = toDoLists;
    }

    ;

    //REQUIRES 0<listIndex<lists.size() 0<taskIndex<lists[listIndex].size()
    // EFFECTS return listIndexth list's taskIndexth task's name in the todolist
    public String getTask(int listIndex, int taskIndex) {
        return toDoLists.get(listIndex).getItemName(taskIndex);
    }

    //REQUIRES 0<listIndex<lists.size()
    // EFFECTS return a message to user which contains list's name and all the tasks in the list
    public String getTasksPrint(int index) {
        return toDoLists.get(index).getListPrint();
    }

    //REQUIRES 0<listIndex<lists.size()
    // EFFECTS return index's list in the todolist app
    public ToDoList getList(int index) {
        return toDoLists.get(index);
    }

    //REQUIRES 0<listIndex<lists.size()
    // EFFECTS remove indexth list in the todolist app.
    @Override
    public void remove(int index) {
        toDoLists.remove(index);
    }

    //REQUIRES 0<listIndex<lists.size()
    // EFFECTS return index's list name in the toDoList
    @Override
    public String getItemName(int index) {
        return toDoLists.get(index).getName();
    }

    // EFFECTS return a string that contains the toDOLIst name and all its lists
    public String getListsPrint() {
        String result = getName();
        for (int i = 0; i < size(); i++) {
            result = result.concat("\n " + i + ": " + getList(i).getName());
        }
        return result;
    }

    //MODIFIES this
    // EFFECTS Add a list named list to toDoList
    @Override
    public void add(String list) {
        toDoLists.add(new ToDoList(list));
    }


    //MODIFIES this
    //REQUIRES 0<listIndex<lists.size()
    // EFFECTS Add a task named taskName to listIndexth list
    public void addTask(int listIndex, String taskName) {
        toDoLists.get(listIndex).add(taskName);
    }

    // EFFECTS return the size of the list,
    @Override
    public int size() {
        return toDoLists.size();
    }
}
