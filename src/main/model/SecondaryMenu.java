package model;

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
        addMenuItem("4", new MenuOption("Return to the top menu", () -> {
        }));
        addMenuItem("x", new MenuOption("Exit", () -> {
        }));
    }

    @Override
    boolean isValidUserInput() {
        return containsKey(getMenuInput());
    }

    @Override
    protected boolean isEnd() {
        switch (getMenuInput()) {
            case "4":
            case "x":
                return true;
            default:
                return false;
        }
    }

//    // EFFECTS Print out Input task name
//    private void printOutInputTask() {
//        System.out.println("Input task name");
//    }


    // EFFECTS Add a task to a list
    // MODIFIES list
    private void secondaryMenuAddTask() {
        System.out.println("Input task name");
        list.addTask(input.next());
        printTasks();
    }

    // EFFECTS Move the selected task to done list
    // MODIFIES list
    private void secondaryMenuSetTaskDone() {
        printOutPromptInputIndex();
        int userInputIndex = takeUserInputIndex(list.getSize());
        list.setTaskDone(userInputIndex);
        printTasks();
    }

    // EFFECTS Remove the selected task
    // MODIFIES useToDoList
    // REQUIRES 0<=index<userToDoList.getList(index).getSize()
    private void secondaryMenuRemoveTask() {
        printOutPromptInputIndex();
        int userInputIndex = takeUserInputIndex(list.getSize());
        list.removeTask(userInputIndex);
        printTasks();

    }

    // EFFECTS Print out the list's tasks
    private void printTasks() {
        System.out.println(list.getListPrint());
    }

}
