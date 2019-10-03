package model;

public interface Menu {
    void run();

    //    void init();
//
    void takeUserInput();

    String printMenu();

    void runMenuOption(String option);
}
