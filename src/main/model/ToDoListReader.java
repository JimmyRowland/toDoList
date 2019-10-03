package model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

public class ToDoListReader {

    public ToDoListContainer read(String path) {
        JSONObject toDoListContainerJson = getToDoListContainerFromJson(path);
        ToDoListContainer toDoListContainer = getContainerFromJsonObject(
                toDoListContainerJson.getJSONArray("container"));
        toDoListContainer.setName(toDoListContainerJson.getString("name"));
        return toDoListContainer;
    }

    private JSONObject getToDoListContainerFromJson(String path) {
        String jsonString = "";
        try {
            File file = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(file));
            jsonString = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();

        }

        return new JSONObject(jsonString);
    }

    private ToDoListContainer getContainerFromJsonObject(JSONArray toDoListContainerJson) {
        ArrayList<ToDoList> toDoLists = new ArrayList<>();
        for (int i = 0; i < toDoListContainerJson.length(); i++) {
            toDoLists.add(getToDoListFromJsonObject(toDoListContainerJson.getJSONObject(i)));

        }
        ToDoListContainer toDoListContainer = new ToDoListContainer("", toDoLists);
        return toDoListContainer;
    }

    private ToDoList getToDoListFromJsonObject(JSONObject toDoListJson) {
        ToDoList toDoList = new ToDoList(toDoListJson.getString("name"),
                getTaskListFromJsonObject(toDoListJson.getJSONArray("toDo")),
                getTaskListFromJsonObject(toDoListJson.getJSONArray("done")));

        return toDoList;
    }

    private TaskList getTaskListFromJsonObject(JSONArray taskListJson) {
        TaskList taskList = new TaskList();

        for (int i = 0; i < taskListJson.length(); i++) {
            taskList.add(getTaskFromJsonObject(taskListJson.getJSONObject(i)));

        }
        return taskList;
    }

    private Task getTaskFromJsonObject(JSONObject taskJson) {
        Task task = new Task(taskJson.get("name").toString());
        task.setDeleted(taskJson.getBoolean("deleted"));
        task.setToBeDone(taskJson.getBoolean("toBeDone"));
        Calendar startDate = Calendar.getInstance();
        startDate.setTimeInMillis(taskJson.getLong("startDate"));
        Calendar endDate = Calendar.getInstance();
        endDate.setTimeInMillis(taskJson.getLong("endDate"));
        task.setReminder(startDate, endDate);
        return task;

    }

}
