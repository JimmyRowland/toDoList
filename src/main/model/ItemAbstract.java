package model;

public abstract class ItemAbstract implements Item {
    private String name;

    ItemAbstract(String name) {
        this.name = name;
    }

    //EFFECTS return task's name
    @Override
    public String getName() {
        return name;
    }

    // MODIFIES this
    // EFFECTS set task's name to name
    @Override
    public void setName(String name) {
        this.name = name;
    }
}
