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

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api")
public class TimeTrackerController {

    private final ObjectMapper objectMapper = new ObjectMapper();

    private ArrayList<Event> timeChart = new ArrayList<Event>();

    @GetMapping("/api/test")
    public String hello() {
        return "This Works!";
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

    @PostMapping("/upload")
    public ResponseEntity<String> uploadJsonFile(@RequestBody Object myObject) {
        // Process the JSON object
        System.out.println(myObject);

        return ResponseEntity.ok("JSON file received successfully");
    }

    // @GetMapping("/data")
    // public Collection<TimeTracker> get() {
    // return db.values();
    // }

    @GetMapping("/data")
    public ResponseEntity<Object> helloWorld() {
        Map<String, Object> data = new HashMap<>();
        data.put("message", "Hello from Spring Boot!");
        data.put("timeStamp", new Date());
        return ResponseEntity.ok(data);
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
