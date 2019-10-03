package model;

import java.util.ArrayList;

public abstract class ListAbstract extends ItemAbstract implements ListObject {

    ListAbstract(String name) {
        super(name);
    }


    //REQUIRES 0<taskIndex<tasks.size()
    //EFFECTS return the indexth task name in the list
    public abstract String getItemName(int index);

}
