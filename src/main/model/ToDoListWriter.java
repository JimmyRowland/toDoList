package model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ToDoListWriter {
    private ToDoListContainer toDoListContainer;

    public ToDoListWriter(ToDoListContainer toDoListContainer) {
        this.toDoListContainer = toDoListContainer;
    }

    public void write(String path) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", toDoListContainer.getName());
        jsonObject.put("container", getContainerJsonObject());
        JSONObject testJson = new JSONObject();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            jsonObject.write(writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private JSONArray getContainerJsonObject() {
        JSONArray containerJson = new JSONArray();
        for (int i = 0; i < toDoListContainer.size(); i++) {
            containerJson.put(getToDoListJsonObject(toDoListContainer.getList(i)));
        }
        return containerJson;
    }

    private JSONObject getToDoListJsonObject(ToDoList toDoList) {
        JSONObject toDoListJson = new JSONObject();
        toDoListJson.put("name", toDoList.getName());
        toDoListJson.put("toDo", getTaskListJsonObject(toDoList.getToDoTasks()));
        toDoListJson.put("done", getTaskListJsonObject(toDoList.getDoneTasks()));
        return toDoListJson;
    }

    private JSONArray getTaskListJsonObject(TaskList taskList) {
        JSONArray taskListJson = new JSONArray();
        for (int i = 0; i < taskList.size(); i++) {
            taskListJson.put(getTaskJsonObject(taskList.getTask(i)));
        }
        return taskListJson;
    }

    private JSONObject getTaskJsonObject(Task task) {
        JSONObject taskJson = new JSONObject();
        taskJson.put("name", task.getName());
        taskJson.put("toBeDone", task.getToBeDone());
        taskJson.put("deleted", task.getDeleted());
        taskJson.put("startDate", task.getStartDate());
        taskJson.put("endDate", task.getDueDate());
        return taskJson;

    }
}
