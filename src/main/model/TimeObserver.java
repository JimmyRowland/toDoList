package model;

import java.util.Observable;
import java.util.Observer;

public class TimeObserver implements Observer {
    public void setTimeForTest(String timeForTest) {
        this.timeForTest = timeForTest;
    }

    public String getTimeForTest() {
        return timeForTest;
    }

    private String timeForTest;

    @Override
    public void update(Observable o, Object arg) {
        ReadJsonTime readJsonTime = (ReadJsonTime) o;
        setTimeForTest(readJsonTime.getTime());
        System.out.println(getTimeForTest());
    }
}
