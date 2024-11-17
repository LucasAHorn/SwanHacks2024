// package com.TimeTracker.SwanHacks.TimeTrackerSpringBoot.text;
// // package com.TimeTracker.SwanHacks.TimeTrackerSpringBoot.text;

// import java.io.FileWriter;
// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;
// import java.util.stream.Collectors;
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

// private ArrayList<Event> eventsList;
// public static void main(String args[]) {
// // ArrayList<Event> eventsList = new ArrayList<Event>();
// // // eventsList.add(new Event(2, "red", "red", "red", "red", "red"));
// // // eventsList.add(new Event(2, "yellow", "yellow", "yellow", "yellow",
// // // "yellow"));

// // // ObjectMapper objectMapper = new ObjectMapper();

// // // try {
// // // // Write the list of events to a JSON file
// // // objectMapper.writeValue(new File("./userData.json"), eventsList);
// // // System.out.println("Data has been written to events.json");

// // // } catch (IOException e) {
// // // e.printStackTrace();
// // // }

// // // ObjectMapper mapper = new ObjectMapper();

// // // try {
// // // JsonNode jsonData = mapper.readTree(new File("userData.json"));
// // // System.out.println(jsonData);
// // // System.out.println(jsonData.getNodeType());

// // // for (int i = 0; i < jsonData.size(); i++) {

// // // }
// // // } catch (IOException e) {
// // // e.printStackTrace();
// // // }

// String time1 = "11:30";
// String time2 = "12:00";

// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
// LocalTime time1Parsed = LocalTime.parse(time1, formatter);
// LocalTime time2Parsed = LocalTime.parse(time2, formatter);

// // // Calculate the difference in minutes
// long minutesDiff = java.time.Duration.between(time1Parsed,
// time2Parsed).toMinutes();

// // Convert the difference to hours (as a double)
// double hoursDiff = minutesDiff / 60.0;

// // Print the result
// System.out.println("Difference in hours: " + hoursDiff);

// ArrayList<Event> eventsList = new ArrayList<Event>();

// eventsList.add(new Event(2, "5", "vine", "03:00", "09:00", "1999-04-12"));
// eventsList.add(new Event(2, "5", "vine", "03:00", "09:00", "1999-04-12"));
// eventsList.add(new Event(2, "5", "Fortnite", "01:00", "20:00",
// "1999-04-12"));
// eventsList.add(new Event(2, "5", "Tik", "03:00", "04:00", "1999-04-12"));
// eventsList.add(new Event(2, "5", "Tok", "01:00", "23:00", "1999-04-12"));
// eventsList.add(new Event(2, "5", "vine", "03:00", "09:00", "1999-04-12"));
// eventsList.add(new Event(2, "5", "vine", "03:00", "09:00", "1999-04-12"));
// eventsList.add(new Event(2, "5", "vine", "03:00", "09:00", "1999-04-12"));

// HashMap<String, Double> activity = new HashMap<>();

// for (Event e : eventsList) {
// if (activity.containsKey(e.getActivity())) {
// activity.put(e.getActivity(), activity.get(e.getActivity()) +
// e.getTaskTime());
// } else {
// activity.put(e.getActivity(), e.getTaskTime());
// }
// }

// Map<String, Double> map = new HashMap<>();
// map.put("apple", 10.5);
// map.put("banana", 7.2);
// map.put("cherry", 0.2);
// map.put("pie", 2.2);
// map.put("orange", 3.2);
// map.put("grape", 4.2);
// map.put("fruit", 7.2);
// map.put("yellow", 5.2);
// map.put("what", 107.2);

// List<String> topKeys = getTopKeys(activity, 4);
// List<String> bottomKeys = getBottomKeys(activity, 4);
// System.out.println(topKeys);
// System.out.println(bottomKeys);

// for (Event e : eventsList){
// System.out.println(e.createString());
// }
// sort();

// for (Event e : eventsList){
// System.out.println(e.createString());
// }

// }

// public static List<String> getTopKeys(Map<String, Double> map, int n) {
// // Handle case where the map has fewer than 'n' elements by limiting the
// // result
// // to map size
// return map.entrySet()
// .stream()
// .sorted((entry1, entry2) -> Double.compare(entry2.getValue(),
// entry1.getValue())) // Sort by value
// // descending
// .limit(n) // Limit to top 'n' entries
// .map(Map.Entry::getKey) // Extract the keys
// .collect(Collectors.toList()); // Collect into a List
// }

// public static List<String> getBottomKeys(Map<String, Double> map, int n) {
// // Sort the map by value in ascending order and get the bottom 'n' keys
// return map.entrySet() // Convert map entries (key-value pairs) to a set
// .stream() // Create a Stream from the set of entries
// .sorted(Map.Entry.comparingByValue()) // Sort by value ascending
// .limit(n) // Limit to the bottom 'n' entries
// .map(Map.Entry::getKey) // Map the sorted entries to only the keys
// .collect(Collectors.toList()); // Collect the keys into a List
// }

// public void sort() {

// for (int i = 1; i < eventsList.size(); ++i) {
// Event val = eventsList.get(i);
// int j = i - 1;

// while (j >= 0 && eventsList.get(j).getDate().compareTo(val.getDate()) < 0) {
// eventsList.set(j + 1, eventsList.get(j));
// j = j - 1;
// }
// eventsList.set(j + 1, val);
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
// // e.printStackTrace();
// }
// // // System.out.println("JSON file created: " + jsonObject);
