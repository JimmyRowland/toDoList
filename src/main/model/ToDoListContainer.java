package model;

import java.util.ArrayList;

public class ToDoListContainer {
    private ArrayList<ToDoList> toDoLists;
    private String name;
    private Boolean deleted;

    public ToDoListContainer(String name) {
        this.toDoLists = new ArrayList<ToDoList>();
        this.name = name;
    }

    //REQUIRES 0<listIndex<lists.size() 0<taskIndex<lists[listIndex].size()
    // EFFECTS return listIndexth list's taskIndexth task's name in the todolist
    public String getTask(int listIndex, int taskIndex) {
        return toDoLists.get(listIndex).getTaskName(taskIndex);
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
    public void removeList(int index) {
        toDoLists.remove(index);
    }

    //REQUIRES 0<listIndex<lists.size()
    // EFFECTS return index's list name in the toDoList
    public String getListName(int index) {
        return toDoLists.get(index).getName();
    }

    // EFFECTS return a string that contains the toDOLIst name and all its lists
    public String getListsPrint() {
        String result = name;
        for (int i = 0; i < toDoLists.size(); i++) {
            result = result.concat("\n " + i + ": " + toDoLists.get(i).getName());
        }
        return result;
    }

    //MODIFIES this
    // EFFECTS Add a list named list to toDoList
    public void addList(String list) {
        toDoLists.add(new ToDoList(list));
    }

    // EFFECTS return the name of the list
    public String getName() {
        return name;
    }

    //MODIFIES this
    // EFFECTS Set the list name to name
    public void setName(String name) {
        this.name = name;
    }

    //MODIFIES this
    //REQUIRES 0<listIndex<lists.size()
    // EFFECTS Add a task named taskName to listIndexth list
    public void addTask(int listIndex, String taskName) {
        toDoLists.get(listIndex).addTask(taskName);
    }

    // EFFECTS return the size of the list,
    public int getSize() {
        return toDoLists.size();
    }
}
