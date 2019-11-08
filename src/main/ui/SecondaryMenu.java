package ui;

import model.TaskList;
import model.ToDoList;

public class SecondaryMenu extends ToDoListMenu {
    private ToDoList list;

    public SecondaryMenu(ToDoList list) {
        super();
        this.list = list;

    }

    @Override
    void init() {
        addMenuItem("1", new MenuOption("Add a task", this::secondaryMenuAddTask));
        addMenuItem("2", new MenuOption("Set a task done", this::secondaryMenuSetTaskDone));
        addMenuItem("3", new MenuOption("Remove a task", this::secondaryMenuRemoveTask));
        addMenuItem("4", new MenuOption("Rename the list", this::setName));
        addMenuItem("5", new MenuOption("Return to the top menu", () -> {
        }));
        addMenuItem("x", new MenuOption("Exit", () -> {
        }));
    }


    @Override
    protected boolean isEnd() {
        switch (getMenuInput()) {
            case "5":
            case "x":
                return true;
            default:
                return false;
        }
    }


    // EFFECTS Add a task to a list
    // MODIFIES list
    private void secondaryMenuAddTask() {
        System.out.println("Input task name");
        list.add(input.next());
    }

    // EFFECTS Move the selected task to done list
    // MODIFIES list
    private void secondaryMenuSetTaskDone() {
        int userInputIndex = takeUserInputIndex(list.size());
        list.setTaskDone(userInputIndex);

    }

    // EFFECTS Remove the selected task
    // MODIFIES useToDoList
    // REQUIRES 0<=index<userToDoList.getList(index).getSize()
    private void secondaryMenuRemoveTask() {
        int userInputIndex = takeUserInputIndex(list.size());
        list.remove(userInputIndex);


    }


    // EFFECTS Print out the list's tasks
    @Override
    void printItems() {
//        System.out.println(list.getListPrint());
        System.out.println(getPrint());
    }

    void setName() {
        printOutInputName();
        input.nextLine();
        list.setName(input.nextLine());
    }

    private String getPrint() {
        // high coupling example
        String result = list.getName();
        result = result.concat(list.getToDoTasks().getListPrint());
        TaskList doneTasks = list.getDoneTasks();
        if (doneTasks.size() > 0) {
            result = result.concat("\nDone").concat(doneTasks.getListPrint());
        }

        return result;
    }

}
