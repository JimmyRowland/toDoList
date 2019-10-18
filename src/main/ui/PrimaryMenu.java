package ui;

import model.ToDoListContainer;
import model.ToDoListReader;
import model.ToDoListWriter;

import java.io.IOException;


public class PrimaryMenu extends ToDoListMenu {
    private ToDoListContainer toDoListContainer;

    public PrimaryMenu(ToDoListContainer toDoListContainer) {
        super();
        this.toDoListContainer = toDoListContainer;
    }

    public PrimaryMenu() {
        readFromFile();
    }

    @Override
    void init() {
        addMenuItem("1", new MenuOption("Add a list", this::primaryMenuAddList));
        addMenuItem("2", new MenuOption("Remove a list", this::primaryMenuRemoveList));
        addMenuItem("3", new MenuOption("View a list", this::primaryMenuViewList));
        addMenuItem("4", new MenuOption("Change your name", this::setName));
        addMenuItem("5", new MenuOption("Write to do list to file", this::saveToDoListToFile));
        addMenuItem("6", new MenuOption("Read to do list from file", this::readFromFile));
        addMenuItem("x", new MenuOption("Exit", this::saveToDoListToFile));
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
        ToDoListWriter w = new ToDoListWriter(toDoListContainer);
        w.write("./data/toDoListData.txt");
    }

    private void readFromFile() {
        ToDoListReader r = new ToDoListReader();
        try {
            this.toDoListContainer = r.read("./data/toDoListData.txt");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }

    // EFFECTS Print out the list's tasks
    @Override
    void printItems() {
        System.out.println(toDoListContainer.getListsPrint());
    }

    private void setName() {
        printOutInputName();
        input.nextLine();
        toDoListContainer.setName(input.nextLine());
    }
}
