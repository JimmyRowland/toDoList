package model;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

public class ReadJsonTime extends Observable {
    private String time;

    public ReadJsonTime() {
        this.time = "";
    }

    // Copied from deliverable 10 page
    private static JSONObject getJson(String theURL) throws IOException {
        BufferedReader br = null;
        try {
//            String theURL = "https://jimmyfreecodecamp.glitch.me/now";
            URL url = new URL(theURL);
            br = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
//                sb.append(System.lineSeparator());
            }
            return new JSONObject(sb.toString());
        } finally {
            if (br != null) {
                br.close();
            }
        }
//        return new JSONObject();
    }

    private static String getTimeFromAPI() {
        String theURL = "https://jimmyfreecodecamp.glitch.me/now";
        try {
            return (getJson(theURL).get("time").toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";

    }

    public void setTime() {
        this.time = getTimeFromAPI();
        setChanged();
        notifyObservers();

    }

    public String getTime() {
        return time;
    }
}
