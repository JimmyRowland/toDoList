package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class ReadJsonTimeTest {
    ReadJsonTime readJsonTime;
    TimeObserver timeObserver;

    @BeforeEach
    public void setup(){
        readJsonTime = new ReadJsonTime();
        timeObserver = new TimeObserver();
        readJsonTime.addObserver(timeObserver);
    }


    @Test
    void getTime() {
        assertNotEquals(readJsonTime.getTime(),timeObserver.getTimeForTest());

        readJsonTime.setTime();
        assertEquals(readJsonTime.getTime(),timeObserver.getTimeForTest());

//        assertEquals(Calendar.getInstance().getTime().toString().substring(0,11), ReadJsonTime.getTime().substring(0,11));
    }
}