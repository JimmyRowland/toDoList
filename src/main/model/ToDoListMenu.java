package model;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public abstract class ToDoListMenu implements Menu, MenuEditor {
    static Scanner input;
    private static String menuInput;
    private Map<String, MenuOption> menu;

    ToDoListMenu() {
        this.menu = new TreeMap<>();
        this.menuInput = "Do nothing";
        input = new Scanner(System.in);
        init();
    }

    abstract void init();

    @Override
    public void takeUserInput() {
        menuInput = input.next();
        while (!isValidUserInput()) {
            System.out.println("Please enter a valid option");
            menuInput = input.next();
        }
    }

    boolean isValidUserInput() {
        return menu.containsKey(getMenuInput());
    }

    @Override
    public String printMenu() {
        StringBuilder result = new StringBuilder("What do you want to do:\n");
        menu.forEach((key, value) -> result.append("[").append(key).append("] ").append(value.getName()).append("\n"));
        return result.toString();
    }

    abstract void printItems();

    @Override
    public void run() {
        while (!isEnd()) {
            printItems();
            System.out.println(printMenu());
            takeUserInput();
            runMenuOption(getMenuInput());
        }
    }

    @Override
    public void addMenuItem(String key, MenuOption menuOption) {
        menu.put(key, menuOption);
    }

    @Override
    public void removeMenuItem(String key) {
        menu.remove(key);
    }

    @Override
    public void runMenuOption(String option) {
        menu.get(option).run();
    }

    String getMenuInput() {
        return menuInput;
    }

    // EFFECTS Print out Please enter the index
    void printOutPromptInputIndex() {
        System.out.println("Please enter the index");
    }

    int takeUserInputIndex(int upperBond) {
        printOutPromptInputIndex();
        int userInputIndex = Integer.parseInt(input.next());
        if (userInputIndex >= upperBond || userInputIndex < 0) {
            System.out.println("Out of index");
            userInputIndex = Integer.parseInt(input.next());
        }
        return userInputIndex;
    }


    protected abstract boolean isEnd();


}
