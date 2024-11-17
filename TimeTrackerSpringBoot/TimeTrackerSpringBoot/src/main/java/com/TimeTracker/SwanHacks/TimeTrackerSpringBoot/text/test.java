// package com.TimeTracker.SwanHacks.TimeTrackerSpringBoot.text;
// // package com.TimeTracker.SwanHacks.TimeTrackerSpringBoot.text;

// import java.io.FileWriter;
// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.List;
// import java.io.File;
// import java.io.FileReader;
// import com.google.gson.Gson;
// import com.google.gson.reflect.TypeToken;
// import java.io.FileReader;
// import java.io.IOException;
// import java.lang.reflect.Type;
// import java.time.LocalTime;
// import java.time.format.DateTimeFormatter;
// import java.util.List;

// import com.fasterxml.jackson.databind.JsonNode;
// import com.fasterxml.jackson.databind.ObjectMapper;

// import org.json.simple.JSONObject;

// import com.TimeTracker.SwanHacks.TimeTrackerSpringBoot.Event;
// import com.fasterxml.jackson.databind.ObjectMapper;

// public class test {
// public static void main(String args[]) {
// ArrayList<Event> eventsList = new ArrayList<Event>();
// eventsList.add(new Event(2, "red", "red", "red", "red", "red"));
// eventsList.add(new Event(2, "yellow", "yellow", "yellow", "yellow",
// "yellow"));

// ObjectMapper objectMapper = new ObjectMapper();

// try {
// // Write the list of events to a JSON file
// objectMapper.writeValue(new File("./userData.json"), eventsList);
// System.out.println("Data has been written to events.json");

// } catch (IOException e) {
// e.printStackTrace();
// }

// ObjectMapper mapper = new ObjectMapper();

// try {
// JsonNode jsonData = mapper.readTree(new File("userData.json"));
// System.out.println(jsonData);
// System.out.println(jsonData.getNodeType());

// for (int i = 0; i < jsonData.size(); i++) {

// }
// } catch (IOException e) {
// e.printStackTrace();
// }

// String time1 = "11:30";
// String time2 = "12:00";

// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
// LocalTime time1Parsed = LocalTime.parse(time1, formatter);
// LocalTime time2Parsed = LocalTime.parse(time2, formatter);

// // Calculate the difference in minutes
// long minutesDiff = java.time.Duration.between(time1Parsed,
// time2Parsed).toMinutes();

// // Convert the difference to hours (as a double)
// double hoursDiff = minutesDiff / 60.0;

// // Print the result
// System.out.println("Difference in hours: " + hoursDiff);

// }
// }

// // Creating a JSONObject object
// // JSONObject jsonObject = new JSONObject();
// // // Inserting key-value pairs into the json object
// // jsonObject.put("ID", "1");
// // jsonObject.put("Activity", "Fortnite");
// // jsonObject.put("Color", 2);
// // jsonObject.put("IsSleep", true);
// // jsonObject.put("Start", "0100PM");
// // jsonObject.put("End", "0200PM");
// // jsonObject.put("StartDate", "01/01/1999");
// // jsonObject.put("StartDate", "01/01/1999");
// // jsonObject.put("Day", "Wednesday");

// // try {
// // FileWriter file = new FileWriter("./userData.json");
// // file.write(jsonObject.toJSONString());
// // file.close();
// // } catch (IOException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }

// // jsonObject.put("ID", "2");
// // jsonObject.put("Activity", "PUBG");
// // jsonObject.put("Color", 5);
// // jsonObject.put("IsSleep", false);
// // jsonObject.put("Start", "200");
// // jsonObject.put("End", "181818");
// // jsonObject.put("StartDate", "01sd9");
// // jsonObject.put("StartDate", "0asd9");
// // jsonObject.put("Day", "Friday");

// // try {
// // FileWriter file = new FileWriter("./userData.json");
// // file.append(jsonObject.toJSONString() + "\n");
// // file.close();
// // } catch (IOException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
// // System.out.println("JSON file created: " + jsonObject);
