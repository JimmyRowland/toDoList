package model;

public class TaskInHashmap extends Task {

    private TaskListHashmap taskListHashmap;

    public TaskInHashmap(String name) {
        super(name);
        taskListHashmap = null;
    }

    TaskInHashmap(String name, TaskListHashmap taskListHashmap) {
        super(name);
        taskListHashmap.add(this);
        this.taskListHashmap = taskListHashmap;
    }

    private int calculateHashcode(int... args) {
        int hashCode = 0;
        for (int arg : args) {
            hashCode = hashCode * 34 + arg;
        }
        return hashCode;
    }

    @Override
    public int hashCode() {
        return calculateHashcode(getName().hashCode(), getStartDate().hashCode(), getDueDate().hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        TaskInHashmap argTask = (TaskInHashmap) obj;
        return getName().equals(argTask.getName()) && getStartDate().equals(argTask.getStartDate())
                && getDueDate().equals(argTask.getDueDate());
    }

    TaskListHashmap getTaskListHashmap() {
        return taskListHashmap;
    }

    public void setTaskListHashmap(TaskListHashmap taskListHashmap) {
        boolean isNotInList = !taskListHashmap.containsValue(this) && !taskListHashmap.equals(this.taskListHashmap);
        if (isNotInList) {
            if (this.taskListHashmap != null) {
                this.taskListHashmap.remove(getName());
            }
            this.taskListHashmap = taskListHashmap;
            addTaskToList();
        }
    }

    public void setTaskListHashmap() {
        if (taskListHashmap != null) {
            taskListHashmap.remove(this);
            this.taskListHashmap = null;
        }
    }

    private void addTaskToList() {
        taskListHashmap.add(this);
    }



    @Override
    public void setName(String name) {
        TaskListHashmap tempTaskList = taskListHashmap;
        taskListHashmap.remove(getName());
        super.setName(name);
        tempTaskList.add(this);
    }
}
