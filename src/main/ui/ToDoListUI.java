package ui;

import model.SecondaryMenu;
import model.ToDoListContainer;

import java.util.HashMap;
import java.util.Scanner;

public class ToDoListUI {

    private HashMap<String, Runnable> primaryMenuCommands = new HashMap<>();
    private HashMap<String, Runnable> secondaryMenuCommands = new HashMap<>();


    private void fillPrimaryMenuCommands() {

    }

    private void runRunnableWithParameters() {

    }

//    private void fillSecondaryMenuCommands(){
////        ToDoList userToDoList = new ToDoList("sdfsg");
//        secondaryMenuCommands.put("1", (ToDoList userToDoList, int index)->secondaryMenuAddTask(userToDoList, index));
//        // error I want to add something like a pointer to the hashmap. I can't find such
//        // a working pointer. Method pointer to runnable does not help as I still need to pass parameters here and runnable.run() does not take parameter
//        // for the same reason, lambda function does not take parameters
//        secondaryMenuCommands.put("2",()->secondaryMenuAddTask(userToDoList, index));
//        // valid but not what I want. I want to specify parameters when I invoke the method
//        secondaryMenuCommands.put("3",);
//        secondaryMenuCommands.put("4");
//        secondaryMenuCommands.get("1").run();
//    }


    // EFFECTS print out Welcome to 'creative todolist application\
    private void printSomething() {
        System.out.println("Welcome to \'creative todolist application\'");
    }

    // EFFECTS Print out Todolist is Very Creative
    private void printSomethingMoreCreative() {
        System.out.println("Todolist is Very Creative");
    }

    // EFFECTS print out the main menu
    private void printOutMainMenu() {
        System.out.println("\"what would you like to do [1] create a list, [2] delete an item "
                + "[3] view a list [x] exit\"");
    }

    // EFFECTS print out the secondary menu
    private void printoutListMenu() {
        System.out.println("what would you like to do [1] add a to do list item, [2] cross off an item "
                + "[3] delete an item [4] return to top menu [x] exit");
    }

    // EFFECTS print out Please enter the list name
    public void printOutAddList() {
        System.out.println("Please enter the list name\n");
    }

    // EFFECTS Print out Please enter your name:
    private void printOutInitiation() {
        System.out.println("Please enter your name:\n");
    }

    // EFFECTS print out the name of the toDoList
    private void printOutName(ToDoListContainer toDoListContainer) {
        System.out.println(toDoListContainer.getName());
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
            toDoListContainer.addList("To do list " + i);
//            r1 = random.nextInt(3)+2;
            for (int j = 0; j < r1; j++) {
                toDoListContainer.addTask(i, "Task" + j);
            }
        }
    }

    // EFFECTS print out the todolist name and all its lists
    private void printLists(ToDoListContainer toDoListContainer) {
//        printOutName(toDoList);
//        for(int i=0; i<toDoList.getLength();i++){
        System.out.println(toDoListContainer.getListsPrint());
//        }
    }

    // EFFECTS Print out the indexth list in the todolist name and the list's tasks
    // REQUIRES 0<=index<userToDoList.getLength()
//    private void printTask(ToDoListContainer toDoListContainer, int index) {
//        printOutName(toDoListContainer);
//        System.out.println(toDoListContainer.getName());
//        System.out.println(toDoListContainer.getTasksPrint(index));
//    }

    // EFFECTS print out Please input your list name:
    private void printOutPromptInputListName() {
        System.out.println("Please input your list name:\n");
    }

    // EFFECTS Print out Please enter the index
    private void printOutPromptInputIndex() {
        System.out.println("Please enter the index");
    }


//    // EFFECTS Add a task to a list
//    // MODIFIES useToDoList
//    // REQUIRES 0<=index<userToDoList.getList(index).getSize()
//    private void secondaryMenuAddTask(ToDoListContainer userToDoListContainer, int index) {
//        Scanner input = new Scanner(System.in);
//        String userInputTasks;
//        printOutInputTask();
//        userInputTasks = input.next();
//        userToDoListContainer.getList(index).addTask(userInputTasks);
//        printTask(userToDoListContainer, index);
//    }

    //    // EFFECTS Move the selected task to done list
//    // MODIFIES useToDoList
//    // REQUIRES 0<=index<userToDoList.getList(index).getSize()
//    private void secondaryMenuSetTaskDone(ToDoListContainer userToDoListContainer, int index) {
//        Scanner input = new Scanner(System.in);
//        int userInputTasks;
//        printOutPromptInputIndex();
//        userInputTasks = Integer.parseInt(input.next());
//        if (userInputTasks >= userToDoListContainer.getList(index).getSize() || userInputTasks < 0) {
//            System.out.println("Out of index");
//            userInputTasks = Integer.parseInt(input.next());
//        }
//        userToDoListContainer.getList(index).setTaskDone(userInputTasks);
//        printTask(userToDoListContainer, index);
//    }
//
//    // EFFECTS Remove the selected task
//    // MODIFIES useToDoList
//    // REQUIRES 0<=index<userToDoList.getList(index).getSize()
//    private void secondaryMenuRemoveTask(ToDoListContainer userToDoListContainer, int index) {
//        Scanner input = new Scanner(System.in);
//        int userInputTasks;
//        printOutPromptInputIndex();
//        userInputTasks = Integer.parseInt(input.next());
//        if (userInputTasks >= userToDoListContainer.getList(index).getSize() || userInputTasks < 0) {
//            System.out.println("Out of index");
//            userInputTasks = Integer.parseInt(input.next());
//        }
//        userToDoListContainer.getList(index).removeTask(userInputTasks);
//        printTask(userToDoListContainer, index);
//
//    }
//
    // EFFECTS Ask user which list to show and print out the list menu. Then return the index.
    // MODIFIES useToDoList
    // REQUIRES 0<=index<userToDoList.getLength()
    private int secondaryMenuInit(ToDoListContainer userToDoListContainer) {
        Scanner input = new Scanner(System.in);
        printOutPromptInputIndex();
//        userInputTasks = input.next();
        int index = Integer.parseInt(input.next());
        while (index < 0 || index >= userToDoListContainer.getSize()) {
            System.out.println("Out of index");
            index = Integer.parseInt(input.next());
        }
//        printTask(userToDoListContainer, index);
        printoutListMenu();
        return index;
    }
//
//    //MODIFIES ToDoList
//    //EFFECTS add task, set task to done, or remove tasks according to user input
//    private String secondaryMenu(ToDoListContainer userToDoListContainer) {
////        String userInputTasks;
////        String userInput;
//        Scanner input = new Scanner(System.in);
////        printOutPromptInputIndex();
//////        userInputTasks = input.next();
////        int index = Integer.parseInt(input.next());
////        printTask(userToDoList, index);
////        printoutListMenu();
//        int index = secondaryMenuInit(userToDoListContainer);
//        String userInput = input.next();
//        while (true) {
//            switch (userInput) {
//                case "1":
//                    secondaryMenuAddTask(userToDoListContainer, index);
////                    printOutInputTask();
////                    userInputTasks = input.next();
////                    userToDoList.getList(index).addTask(userInputTasks);
////                    printTask(userToDoList, index);
//                    break;
//                case "2":
//                    secondaryMenuSetTaskDone(userToDoListContainer, index);
////                    printOutPromptInputIndex();
////                    userInputTasks = input.next();
////                    userToDoList.getList(index).setTaskDone(Integer.parseInt(userInputTasks));
////                    printTask(userToDoList, index);
//                    break;
//                case "3":
//                    secondaryMenuRemoveTask(userToDoListContainer, index);
////                    printOutPromptInputIndex();
////                    userInputTasks = input.next();
////                    userToDoList.getList(index).removeTask(Integer.parseInt(userInputTasks));
////                    printTask(userToDoList, index);
//                    break;
//                case "x":
//                case "4":
//                    return userInput;
//                default:
//                    System.out.println("Invalid input\n");
//            }
////            if(userInput.equals("1")){
////                printOutInputTask();
////                userInputTasks=input.next();
////                userToDoList.getList(index).addTask(userInputTasks);
////                printTask(userToDoList,index);
////            }
////            else if(userInput.equals("2")){
////                printOutInputIndex();
////                userInputTasks=input.next();
////                userToDoList.getList(index).setTaskDone(Integer.parseInt(userInputTasks));
////                printTask(userToDoList,index);
////            }
////            else if(userInput.equals("3")){
////                printOutInputIndex();
////                userInputTasks=input.next();
////                userToDoList.getList(index).removeTask(Integer.parseInt(userInputTasks));
////                printTask(userToDoList,index);
////            }else if (userInput.equals("x")){return(userInput);}
////
//            printoutListMenu();
//            userInput = input.next();
//        }
////        return userInput;
//    }


    //MODIFIES userToDoList
    //EFFECTS Add list to userToDoList, remove list to userToDoList, or move to secondary menu
    private void runMainMenu(ToDoListContainer userToDoListContainer) {
        Scanner input = new Scanner(System.in);
        String userInput = "1";
        String userInputTasks = "";
//        userInput = "1";
        while (!userInput.equals("x")) {
            printLists(userToDoListContainer);
            printOutMainMenu();
            userInput = input.next();
            switch (userInput) {
                case "1":
                    printOutPromptInputListName();
                    userInputTasks = input.next();
                    userToDoListContainer.addList(userInputTasks);
                    printLists(userToDoListContainer);
                    break;
                case "2":
                    printLists(userToDoListContainer);
                    printOutPromptInputIndex();
                    userInputTasks = input.next();
                    userToDoListContainer.removeList(Integer.parseInt(userInputTasks));
                    printLists(userToDoListContainer);
                    break;
                case "3":
//                    printOutInputIndex();
//                    userInputTasks=input.next();
//                    int index = Integer.parseInt(userInputTasks);
//                    printTask(userToDoList,index);
//                    printoutListMenu();
//                    userInput=input.next();
                    int index = secondaryMenuInit(userToDoListContainer);
                    SecondaryMenu secondaryMenu = new SecondaryMenu(userToDoListContainer.getList(index));
                    secondaryMenu.run();
//                    userInput = secondaryMenu(userToDoListContainer);
//                    System.out.println(userInput);
                    break;
                case "x":
                    break;
                default:
                    System.out.println("Invalid input\n");
            }

//            if(userInput.equals("1")){
//                printOutInputListName();
//                userInputTasks=input.next();
//                userToDoList.addList(userInputTasks);
//                printLists(userToDoList);
//            }
//            else if(userInput.equals("2")){
//                printLists(userToDoList);
//                printOutInputIndex();
//                userInputTasks=input.next();
//                userToDoList.removeList(Integer.parseInt(userInputTasks));
//                printLists(userToDoList);
//
//            }else if (userInput.equals("3")){
//                printOutInputIndex();
//                userInputTasks=input.next();
//                int index = Integer.parseInt(userInputTasks);
//                printTask(userToDoList,index);
//                printoutListMenu();
//                userInput=input.next();
//                while(!userInput.equals("x")&&!userInput.equals("4")){
//                    if(userInput.equals("1")){
//                        printOutInputTask();
//                        userInputTasks=input.next();
//                        userToDoList.getList(index).addTask(userInputTasks);
//                        printTask(userToDoList,index);
//                    }
//                    else if(userInput.equals("2")){
//                        printOutInputIndex();
//                        userInputTasks=input.next();
//                        userToDoList.getList(index).setTaskDone(Integer.parseInt(userInputTasks));
//                        printTask(userToDoList,index);
//                    }
//                    else if(userInput.equals("3")){
//                        printOutInputIndex();
//                        userInputTasks=input.next();
//                        userToDoList.getList(index).removeTask(Integer.parseInt(userInputTasks));
//                        printTask(userToDoList,index);
//                    }
//                    printoutListMenu();
//                    userInput=input.next();
//                }
//            }
        }
    }

    //    public void test (ToDoList toDoList1){
//        toDoList1.addList("To do list " + 1);
//    }
    //EFFECT create new ToDoList and open the topMenu
    void run() {

        printSomething();
        printSomethingMoreCreative();
        printOutInitiation();
        Scanner input = new Scanner(System.in);
        String userInput = input.next();
        ToDoListContainer userToDoListContainer = new ToDoListContainer(userInput);
        seed(userToDoListContainer);
//        printLists(userToDoList);
//        printOutMainMenu();
//        userInput=input.next();
        runMainMenu(userToDoListContainer);


    }
}
