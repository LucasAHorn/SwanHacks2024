package com.TimeTracker.SwanHacks.TimeTrackerSpringBoot;

import java.io.IOException;
import java.util.*;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.simple.JSONObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@RestController
@RequestMapping("/api")
public class TimeTrackerController {

    private final ObjectMapper objectMapper = new ObjectMapper();

    private ArrayList<Event> timeChart = new ArrayList<Event>();

    @GetMapping("/test")
    public ResponseEntity<Object> hello() {
        Map<String, Object> data = new HashMap<>();
        data.put("message", "Hello from Spring Boot!");
        data.put("timeStamp", new Date());
        return ResponseEntity.ok(data);
    }

    public String uploadJsonFile(@RequestParam("file") MultipartFile file) {
        // Read the file content as JSON
        Event givenTime = new Event();
        JsonNode jsonNode = null;

        try {
            jsonNode = objectMapper.readTree(file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Example of how to access the JSON data
        @SuppressWarnings("null")
        int Id = jsonNode.path("Id").asInt();
        String Activity = jsonNode.path("Activity").asText();
        String Description = jsonNode.path("Description").asText();
        int color = jsonNode.path("age").asInt();
        int IsSleep = jsonNode.path("IsSleep").asInt();

        String name = jsonNode.path("name").asText();
        int age = jsonNode.path("age").asInt();

        // Return a success message with some details from the JSON
        return String.format("Received JSON file with name: %s and age: %d", name, age);
    }

    // This can be used for testing, will return to react
    @GetMapping("/data")
    public ResponseEntity<Object> tester() {
        Map<String, Object> data = new HashMap<>();

        data.put("Activtiy", "lalala");

        data.put("message", "Hello from Spring Boot!");
        return ResponseEntity.ok(data);
    }

    @GetMapping("/data/getAll")
    public ArrayList<ResponseEntity<Object>> getAll() {
        Map<String, Object> data = new HashMap<>();

        ArrayList<ResponseEntity<Object>> all = new ArrayList<ResponseEntity<Object>>();

        for (Event e : timeChart) {
            data.put("id", e.getId());
            data.put("color", e.getColor());
            data.put("isSleep", e.getIsSleep());
            data.put("Activity", e.getActivity());
            data.put("date", e.getDate());
            data.put("StartTime", e.getStartTime());
            data.put("EndTime", e.getEndTime());

            all.add(ResponseEntity.ok(data));
        }

        data.put("Activtiy", "lalala");

        data.put("message", "Hello from Spring Boot!");
        return all;
    }

    public void Sort() {
        ArrayList<Event> sortedList = new ArrayList<Event>();

        for (int i = 1; i < timeChart.size(); ++i) {
            Event key = timeChart.get(i);
            int j = i - 1;

            /*
             * Move elements of arr[0..i-1], that are
             * greater than key, to one position ahead
             * of their current position
             */
            // Check to see if this sort works
            while (j >= 0 && timeChart.get(j).getDate().compareTo(key.getDate()) < 0) {
                timeChart.set(j + 1, timeChart.get(j));
                j = j - 1;
            }
            timeChart.set(j + 1, key);
        }

    }

    @GetMapping("/data/test")
    public String displayString(@RequestParam String inputString) {
        return "You entered: " + inputString;
    }

    // @GetMapping("/data/{id}")
    // public TimeTracker get(@PathVariable String id) {
    // TimeTracker photo = db.get(id);
    // if (photo == null)
    // throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    // return photo;
    // }

    // @DeleteMapping("/data/{id}")
    // public void remove(@PathVariable String id) {
    // TimeTracker photo = db.remove(id);
    // if (photo == null)
    // throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    // }

}
