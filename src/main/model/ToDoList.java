package model;

import java.util.ArrayList;

public class ToDoList extends ListAbstract {
    private Boolean deleted;
    private ArrayList<Task> doneTasks;
    private ArrayList<Task> tasks;

    public ToDoList(String name) {
        super(name);
        this.doneTasks = new ArrayList<Task>();
        deleted = false;
        this.tasks = new ArrayList<>();
    }


    //    public void deleteTask(int index) {
//        tasks.remove(index);
//    }
    //EFFECTS return a print ready task string
    public String getListPrint() {
        String result = getName();
        for (int i = 0; i < size(); i++) {
            result = result.concat("\n\t" + i + ": " + getItemName(i) + getTask(i).getToBeDone());
        }
        for (int i = 0; i < doneTasks.size(); i++) {
            result = result.concat(
                    "\nDone\n\t" + i + ": " + doneTasks.get(i).getName() + doneTasks.get(i).getToBeDone());
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

    //REQUIRES 0<taskIndex<tasks.size()
    //MODIFIES this
    //EFFECTS set indexth task's (in the tasks list) toBeDone status to !toBeDone and remove
    // the task from tasks list and add it to doneTasks list
    public void setTaskDone(int index) {
        tasks.get(index).setDoneStatus();
        doneTasks.add(tasks.get(index));
        tasks.remove(index);
    }

    // REQUIRES 0<taskIndex<tasks.size()
    // MODIFIES this
    // EFFECTS set indexth task's (in hte doneTasks list) toBeDone status to !toBeDone, remove the task from doneTasks
    // list and add it to tasks list
    public void setTaskUndone(int index) {
        doneTasks.get(index).setDoneStatus();
        tasks.add(doneTasks.get(index));
        doneTasks.remove(index);
    }

    //    public Boolean getDeleted() {
//        return deleted;
//    }
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
