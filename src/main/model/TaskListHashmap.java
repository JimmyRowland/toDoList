package model;

import java.util.HashMap;

public class TaskListHashmap implements ListObject {

    private HashMap<String, TaskInHashmap> tasks;

    public TaskListHashmap() {
        this.tasks = new HashMap<>();
    }

    @Override
    public int size() {
        return tasks.size();
    }

    @Override
    public void add(String name) {
        TaskInHashmap taskInHashmap = new TaskInHashmap(name, this);
        add(taskInHashmap);
    }

    public void add(TaskInHashmap taskInHashmap) {
        if (!tasks.containsKey(taskInHashmap.getName()) && !this.equals(taskInHashmap.getTaskListHashmap())) {
            taskInHashmap.setTaskListHashmap(this);
            tasks.put(taskInHashmap.getName(), taskInHashmap);
        }

    }

    public boolean containsValue(TaskInHashmap task) {
        return tasks.containsValue(task);
    }

    public boolean containsKey(TaskInHashmap task) {
        return tasks.containsKey(task.getName());
    }

    @Override
    public void remove(int index) {
        remove(index + "");
    }

    public void remove(TaskInHashmap taskInHashmap) {
        remove(taskInHashmap.getName());
    }

    public void remove(String name) {
        if (tasks.containsKey(name) && tasks.get(name).getTaskListHashmap().equals(this)) {
            TaskInHashmap task = tasks.get(name);
            tasks.remove(name);
            task.setTaskListHashmap();
        }
    }

    public TaskInHashmap getTask(String key) {
        return tasks.get(key);
    }
}
