package ui;

import ui.exceptions.InvalidUserInputException;
import ui.exceptions.UserInputNotANumberException;
import ui.exceptions.UserInputTooLongException;

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

    // With recursion bad and dumb exceptions
    @Override
    public void takeUserInput() {
        try {
            String output = input.next();
            menuInput = uselessInputWithException(output);
        } catch (UserInputTooLongException e) {
            System.out.println(e.getMessage() + "And you computer is a piece of crap");
            takeUserInput();
        } catch (UserInputNotANumberException e) {
            System.out.println(e.getMessage() + " You dumb");
            takeUserInput();
        } catch (InvalidUserInputException e) {
            System.out.println(e.getMessage());
            takeUserInput();
        } finally {
            System.out.println("Totally printing something useful");
        }
    }

    public String uselessInputWithException(String output)
            throws InvalidUserInputException {
        if (output.length() > 10) {
            throw new UserInputTooLongException();
        } else {
            if (!output.equals("x")) {
                try {
                    Integer.parseInt(output);
                } catch (NumberFormatException e) {
                    throw new UserInputNotANumberException();
                }
            }
            if (!isValidUserInput(output)) {
                throw new InvalidUserInputException("Please enter a valid input");
            }
        }
        return output;
    }

    private boolean isValidUserInput(String input) {
        return menu.containsKey(input);
    }
    // No recursion
//    @Override
//    public void takeUserInput() {
//        menuInput = input.next();
//        while (!isValidUserInput()) {
//            System.out.println("Please enter a valid option");
//            menuInput = input.next();
//        }
//    }
//    private boolean isValidUserInput() {
//        return menu.containsKey(getMenuInput());
//    }


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

//    @Override
//    public void removeMenuItem(String key) {
//        menu.remove(key);
//    }

    @Override
    public void runMenuOption(String option) {
        menu.get(option).run();
    }

    String getMenuInput() {
        return menuInput;
    }

    // EFFECTS Print out Please enter the index
    private void printOutPromptInputIndex() {
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

    // EFFECTS Print out Please enter your name:
    void printOutInputName() {
        System.out.println("Please enter your name:\n");
    }

    protected abstract boolean isEnd();


}
