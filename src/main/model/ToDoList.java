package model;

import java.util.ArrayList;

public class ToDoList {
    private ArrayList<List> lists;
    private String name;
    private Boolean deleted;

    public ToDoList(String name) {
        this.lists = new ArrayList<List>();
        this.name = name;
    }

    //REQUIRES 0<listIndex<lists.size() 0<taskIndex<lists[listIndex].size()
    // EFFECTS return listIndexth list's taskIndexth task's name in the todolist
    public String getTask(int listIndex, int taskIndex) {
        return lists.get(listIndex).getTaskName(taskIndex);
    }

    //REQUIRES 0<listIndex<lists.size()
    // EFFECTS return a message to user which contains list's name and all the tasks in the list
    public String getTasksPrint(int index) {
        return lists.get(index).getListPrint();
    }

    //REQUIRES 0<listIndex<lists.size()
    // EFFECTS return index's list in the todolist app
    public List getList(int index) {
        return lists.get(index);
    }

    //REQUIRES 0<listIndex<lists.size()
    // EFFECTS remove indexth list in the todolist app.
    public void removeList(int index) {
        lists.remove(index);
    }

    //REQUIRES 0<listIndex<lists.size()
    public String getListName(int index) {
        return lists.get(index).getName();
    }

    public String getListsPrint() {
        String result = name;
        for (int i = 0; i < lists.size(); i++) {
            result = result.concat("\n " + i + ": " + lists.get(i).getName());
        }
        return result;
    }

    //MODIFIES this
    public void addList(String list) {
        lists.add(new List(list));
    }

    public String getName() {
        return name;
    }

    //MODIFIES this
    public void setName(String name) {
        this.name = name;
    }

    //MODIFIES this
    //REQUIRES 0<listIndex<lists.size()
    public void addTask(int listIndex, String taskName) {
        lists.get(listIndex).addTask(taskName);
    }

    public int getLength() {
        return lists.size();
    }
}
