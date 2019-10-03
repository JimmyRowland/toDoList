package model;

public class ToDoList extends ListAbstract {
    private Boolean deleted;
    private TaskList doneTasks;
    private TaskList tasks;

    public ToDoList(String name) {
        super(name);
        this.doneTasks = new TaskList();
        deleted = false;
        this.tasks = new TaskList();
    }


    //EFFECTS return a print ready task string
    public String getListPrint() {
        String result = getName();
        result = result.concat(tasks.getListPrint());
        if (doneTasks.size() > 0) {
            result = result.concat("\nDone").concat(doneTasks.getListPrint());
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
        tasks.add(task);
    }

    //REQUIRES 0<taskIndex<tasks.size()
    //MODIFIES this
    //EFFECTS set indexth task's (in the tasks list) toBeDone status to !toBeDone and remove
    // the task from tasks list and add it to doneTasks list
    public void setTaskDone(int index) {
        tasks.getTask(index).setDoneStatus();
        doneTasks.add(tasks.getTask(index));
        tasks.remove(index);
    }

    // REQUIRES 0<taskIndex<tasks.size()
    // MODIFIES this
    // EFFECTS set indexth task's (in hte doneTasks list) toBeDone status to !toBeDone, remove the task from doneTasks
    // list and add it to tasks list
    public void setTaskUndone(int index) {
        doneTasks.getTask(index).setDoneStatus();
        tasks.add(doneTasks.getTask(index));
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
        return tasks.getItemName(index);
    }


    //REQUIRES 0<taskIndex<tasks.size()
    public Task getTask(int index) {
        return tasks.getTask(index);
    }

    public TaskList getDoneTasks() {
        return doneTasks;
    }

    public TaskList getToDoTasks() {
        return tasks;
    }
}
