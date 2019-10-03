package model;

class MenuOption {
    private Runnable action;
    private String name;

    MenuOption(String name, Runnable action) {
        this.name = name;
        this.action = action;
    }

    public void run() {
        action.run();
    }

    public String getName() {
        return name;
    }
}
