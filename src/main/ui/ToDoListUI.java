package ui;

import model.ToDoList;

import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Function;

public class ToDoListUI {

    private HashMap<String, Runnable> primaryMenuCommands = new HashMap<>();
    private HashMap<String, Runnable> secondaryMenuCommands = new HashMap<>();


    private void fillPrimaryMenuCommands(){

    }

    private void runRunnableWithParameters(){

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
    private void printOutName(ToDoList toDoList) {
        System.out.println(toDoList.getName());
    }

    // MODIFIES ToDoList
    // EFFECTS Fill the toDoList by a 2 List with 2 tasks in each list
    public void seed(ToDoList toDoList) {
        // Randomize seeding
//        Random random = new Random();
//        int r = random.nextInt(3)+2;
        int r = 2;
        int r1 = 2;
        for (int i = 0; i < r; i++) {
            toDoList.addList("To do list " + i);
//            r1 = random.nextInt(3)+2;
            for (int j = 0; j < r1; j++) {
                toDoList.addTask(i, "Task" + j);
            }
        }
    }

    // EFFECTS print out the todolist name and all its lists
    private void printLists(ToDoList toDoList) {
//        printOutName(toDoList);
//        for(int i=0; i<toDoList.getLength();i++){
        System.out.println(toDoList.getListsPrint());
//        }
    }

    // EFFECTS Print out the indexth list in the todolist name and the list's tasks
    // REQUIRES 0<=index<userToDoList.getLength()
    private void printTask(ToDoList toDoList, int index) {
        printOutName(toDoList);
        System.out.println(toDoList.getName());
        System.out.println(toDoList.getTasksPrint(index));
    }

    // EFFECTS print out Please input your list name:
    private void printOutPromptInputListName() {
        System.out.println("Please input your list name:\n");
    }

    // EFFECTS Print out Please enter the index
    private void printOutPromptInputIndex() {
        System.out.println("Please enter the index");
    }

    // EFFECTS Print out Input task name
    private void printOutInputTask() {
        System.out.println("Input task name");
    }

    // EFFECTS Add a task to a list
    // MODIFIES useToDoList
    // REQUIRES 0<=index<userToDoList.getList(index).getSize()
    private void secondaryMenuAddTask(ToDoList userToDoList, int index) {
        Scanner input = new Scanner(System.in);
        String userInputTasks;
        printOutInputTask();
        userInputTasks = input.next();
        userToDoList.getList(index).addTask(userInputTasks);
        printTask(userToDoList, index);
    }

    // EFFECTS Move the selected task to done list
    // MODIFIES useToDoList
    // REQUIRES 0<=index<userToDoList.getList(index).getSize()
    private void secondaryMenuSetTaskDone(ToDoList userToDoList, int index) {
        Scanner input = new Scanner(System.in);
        int userInputTasks;
        printOutPromptInputIndex();
        userInputTasks = Integer.parseInt(input.next());
        if (userInputTasks >= userToDoList.getList(index).getSize() || userInputTasks < 0) {
            System.out.println("Out of index");
            userInputTasks = Integer.parseInt(input.next());
        }
        userToDoList.getList(index).setTaskDone(userInputTasks);
        printTask(userToDoList, index);
    }

    // EFFECTS Remove the selected task
    // MODIFIES useToDoList
    // REQUIRES 0<=index<userToDoList.getList(index).getSize()
    private void secondaryMenuRemoveTask(ToDoList userToDoList, int index) {
        Scanner input = new Scanner(System.in);
        int userInputTasks;
        printOutPromptInputIndex();
        userInputTasks = Integer.parseInt(input.next());
        if (userInputTasks >= userToDoList.getList(index).getSize() || userInputTasks < 0) {
            System.out.println("Out of index");
            userInputTasks = Integer.parseInt(input.next());
        }
        userToDoList.getList(index).removeTask(userInputTasks);
        printTask(userToDoList, index);

    }

    // EFFECTS Ask user which list to show and print out the list menu. Then return the index.
    // MODIFIES useToDoList
    // REQUIRES 0<=index<userToDoList.getLength()
    private int secondaryMenuInit(ToDoList userToDoList) {
        Scanner input = new Scanner(System.in);
        printOutPromptInputIndex();
//        userInputTasks = input.next();
        int index = Integer.parseInt(input.next());
        while (index < 0 || index >= userToDoList.getSize()) {
            System.out.println("Out of index");
            index = Integer.parseInt(input.next());
        }
        printTask(userToDoList, index);
        printoutListMenu();
        return index;
    }

    //MODIFIES ToDoList
    //EFFECTS add task, set task to done, or remove tasks according to user input
    private String secondaryMenu(ToDoList userToDoList) {
//        String userInputTasks;
//        String userInput;
        Scanner input = new Scanner(System.in);
//        printOutPromptInputIndex();
////        userInputTasks = input.next();
//        int index = Integer.parseInt(input.next());
//        printTask(userToDoList, index);
//        printoutListMenu();
        int index = secondaryMenuInit(userToDoList);
        String userInput = input.next();
        while (true) {
            switch (userInput) {
                case "1":
                    secondaryMenuAddTask(userToDoList, index);
//                    printOutInputTask();
//                    userInputTasks = input.next();
//                    userToDoList.getList(index).addTask(userInputTasks);
//                    printTask(userToDoList, index);
                    break;
                case "2":
                    secondaryMenuSetTaskDone(userToDoList, index);
//                    printOutPromptInputIndex();
//                    userInputTasks = input.next();
//                    userToDoList.getList(index).setTaskDone(Integer.parseInt(userInputTasks));
//                    printTask(userToDoList, index);
                    break;
                case "3":
                    secondaryMenuRemoveTask(userToDoList, index);
//                    printOutPromptInputIndex();
//                    userInputTasks = input.next();
//                    userToDoList.getList(index).removeTask(Integer.parseInt(userInputTasks));
//                    printTask(userToDoList, index);
                    break;
                case "x":
                case "4":
                    return userInput;
                default:
                    System.out.println("Invalid input\n");
            }
//            if(userInput.equals("1")){
//                printOutInputTask();
//                userInputTasks=input.next();
//                userToDoList.getList(index).addTask(userInputTasks);
//                printTask(userToDoList,index);
//            }
//            else if(userInput.equals("2")){
//                printOutInputIndex();
//                userInputTasks=input.next();
//                userToDoList.getList(index).setTaskDone(Integer.parseInt(userInputTasks));
//                printTask(userToDoList,index);
//            }
//            else if(userInput.equals("3")){
//                printOutInputIndex();
//                userInputTasks=input.next();
//                userToDoList.getList(index).removeTask(Integer.parseInt(userInputTasks));
//                printTask(userToDoList,index);
//            }else if (userInput.equals("x")){return(userInput);}
//
            printoutListMenu();
            userInput = input.next();
        }
//        return userInput;
    }



    //MODIFIES userToDoList
    //EFFECTS Add list to userToDoList, remove list to userToDoList, or move to secondary menu
    private void runMainMenu(ToDoList userToDoList) {
        Scanner input = new Scanner(System.in);
        String userInput="1";
        String userInputTasks = "";
//        userInput = "1";
        while (!userInput.equals("x")) {
            printLists(userToDoList);
            printOutMainMenu();
            userInput = input.next();
            switch (userInput) {
                case "1":
                    printOutPromptInputListName();
                    userInputTasks = input.next();
                    userToDoList.addList(userInputTasks);
                    printLists(userToDoList);
                    break;
                case "2":
                    printLists(userToDoList);
                    printOutPromptInputIndex();
                    userInputTasks = input.next();
                    userToDoList.removeList(Integer.parseInt(userInputTasks));
                    printLists(userToDoList);
                    break;
                case "3":
//                    printOutInputIndex();
//                    userInputTasks=input.next();
//                    int index = Integer.parseInt(userInputTasks);
//                    printTask(userToDoList,index);
//                    printoutListMenu();
//                    userInput=input.next();
                    userInput = secondaryMenu(userToDoList);
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
        ToDoList userToDoList = new ToDoList(userInput);
        seed(userToDoList);
//        printLists(userToDoList);
//        printOutMainMenu();
//        userInput=input.next();
        runMainMenu(userToDoList);


    }
}
