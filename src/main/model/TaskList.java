package model;

import java.util.ArrayList;

public class TaskList implements ListObject {
    private ArrayList<Task> tasks;

    TaskList() {
        this.tasks = new ArrayList<>();
    }


    //EFFECTS return a print ready task string
    public String getListPrint() {
        String result = "";
        for (int i = 0; i < size(); i++) {
            result = result.concat("\n\t" + i + ": " + getItemName(i) + getTask(i).getToBeDone());
        }
        return result;
    }

    //EFFECTS return the length of the list
    public int size() {
        return tasks.size();
    }

    //MODIFIES this
    //EFFECTS Add a task named task to the end of the list
    @Override
    public void add(String task) {
        tasks.add(new Task(task));
    }

    public void add(Task task) {
        tasks.add(task);
    }

    //MODIFIES this
    //EFFECTS remove index's task from tasks list
    @Override
    public void remove(int index) {
        tasks.remove(index);
    }


    //REQUIRES 0<taskIndex<tasks.size()
    //EFFECTS return the indexth task name in the list
    public String getItemName(int index) {
        return tasks.get(index).getName();
    }


    //REQUIRES 0<taskIndex<tasks.size()
    public Task getTask(int index) {
        return tasks.get(index);
    }
}
