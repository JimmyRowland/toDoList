package ui;

import model.PrimaryMenu;
import model.ToDoListContainer;

import java.util.Scanner;

public class ToDoListUI {

    // EFFECTS print out Welcome to 'creative todolist application\
    private void printSomething() {
        System.out.println("Welcome to \'creative todolist application\'");
    }

    // EFFECTS Print out Todolist is Very Creative
    private void printSomethingMoreCreative() {
        System.out.println("Todolist is Very Creative");
    }


    // EFFECTS Print out Please enter your name:
    private void printOutInitiation() {
        System.out.println("Please enter your name:\n");
    }



    // MODIFIES ToDoList
    // EFFECTS Fill the toDoList by a 2 List with 2 tasks in each list
    public void seed(ToDoListContainer toDoListContainer) {
        // Randomize seeding
//        Random random = new Random();
//        int r = random.nextInt(3)+2;
        int r = 2;
        int r1 = 2;
        for (int i = 0; i < r; i++) {
            toDoListContainer.add("To do list " + i);
//            r1 = random.nextInt(3)+2;
            for (int j = 0; j < r1; j++) {
                toDoListContainer.addTask(i, "Task" + j);
            }
        }
    }


    //EFFECT create new ToDoList and open the topMenu
    void run() {

        printSomething();
        printSomethingMoreCreative();
        printOutInitiation();
        Scanner input = new Scanner(System.in);
        String userInput = input.next();
        ToDoListContainer userToDoListContainer = new ToDoListContainer(userInput);
        seed(userToDoListContainer);
        PrimaryMenu primaryMenu = new PrimaryMenu(userToDoListContainer);
        primaryMenu.run();


    }
}
