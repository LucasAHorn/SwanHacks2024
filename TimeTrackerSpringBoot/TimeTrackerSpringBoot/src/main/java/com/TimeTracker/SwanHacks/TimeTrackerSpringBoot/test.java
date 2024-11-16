package com.TimeTracker.SwanHacks.TimeTrackerSpringBoot;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;

public class test {
    public static void main(String args[]) {
        // Creating a JSONObject object
        JSONObject jsonObject = new JSONObject();
        // Inserting key-value pairs into the json object
        jsonObject.put("ID", "1");
        jsonObject.put("Activity", "Fortnite");
        jsonObject.put("Color", 2);
        jsonObject.put("IsSleep", true);
        jsonObject.put("Start", "0100PM");
        jsonObject.put("End", "0200PM");
        jsonObject.put("StartDate", "01/01/1999");
        jsonObject.put("StartDate", "01/01/1999");
        jsonObject.put("Day", "Wednesday");

        try {
            FileWriter file = new FileWriter("./userData.json");
            file.write(jsonObject.toJSONString());
            file.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("JSON file created: " + jsonObject);
    }
}
