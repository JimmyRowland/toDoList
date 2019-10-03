package model;

import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PrimaryMenu extends ToDoListMenu {
    private ToDoListContainer toDoListContainer;

    public PrimaryMenu(ToDoListContainer toDoListContainer) {
        super();
        this.toDoListContainer = toDoListContainer;
    }

    @Override
    void init() {
        addMenuItem("1", new MenuOption("Add a list", this::primaryMenuAddList));
        addMenuItem("2", new MenuOption("Remove a list", this::primaryMenuRemoveList));
        addMenuItem("3", new MenuOption("View a list", this::primaryMenuViewList));
        addMenuItem("4", new MenuOption("Write to do list to file", this::saveToDoListToFile));
        addMenuItem("x", new MenuOption("Exit", () -> {
        }));
    }


    @Override
    protected boolean isEnd() {
        switch (getMenuInput()) {
            case "x":
                return true;
            default:
                return false;
        }
    }


    // EFFECTS Add a task to a list
    // MODIFIES list
    private void primaryMenuAddList() {
        System.out.println("Input list name");
        toDoListContainer.add(input.next());
    }

    // EFFECTS Move the selected task to done list
    // MODIFIES list
    private void primaryMenuRemoveList() {
        int userInputIndex = takeUserInputIndex(toDoListContainer.size());
        toDoListContainer.remove(userInputIndex);

    }

    private void primaryMenuViewList() {
        int userInputIndex = takeUserInputIndex(toDoListContainer.size());
        SecondaryMenu secondaryMenu = new SecondaryMenu(toDoListContainer.getList(userInputIndex));
        secondaryMenu.run();
    }

    private void saveToDoListToFile() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", toDoListContainer.getName());
        jsonObject.put("container", getContainerJsonObject());
        JSONObject testJson = new JSONObject();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("./data/toDoListData.txt"));
            jsonObject.write(writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private JSONObject getContainerJsonObject() {
        JSONObject containerJson = new JSONObject();
        for (int i = 0; i < toDoListContainer.size(); i++) {
            containerJson.put(toDoListContainer.getItemName(i), getToDoListJsonObject(toDoListContainer.getList(i)));
        }
        return containerJson;
    }

    private JSONObject getToDoListJsonObject(ToDoList toDoList) {
        JSONObject toDoListJson = new JSONObject();
        toDoListJson.put("toDo", getTaskListJsonObject(toDoList.getToDoTasks()));
        toDoListJson.put("done", getTaskListJsonObject(toDoList.getDoneTasks()));
        return toDoListJson;
    }

    private JSONObject getTaskListJsonObject(TaskList taskList) {
        JSONObject taskListJson = new JSONObject();
        for (int i = 0; i < taskList.size(); i++) {
            taskListJson.put(taskList.getItemName(i), getTaskJsonObject(taskList.getTask(i)));
        }
        return taskListJson;
    }

    private JSONObject getTaskJsonObject(Task task) {
        JSONObject taskJson = new JSONObject();
        taskJson.put("toBeDone", task.getToBeDone());
        taskJson.put("deleted",task.getDeleted());
        taskJson.put("startDate", task.getStartDate());
        taskJson.put("endDate", task.getDueDate());
        return taskJson;

    }

    // EFFECTS Print out the list's tasks
    @Override
    void printItems() {
        System.out.println(toDoListContainer.getListsPrint());
    }
}
