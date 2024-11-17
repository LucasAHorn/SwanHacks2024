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

    // call function that makes the arraylist

    private final ObjectMapper objectMapper = new ObjectMapper();

    private ArrayList<Event> eventsList = new ArrayList<Event>();

    // This can be used for testing, will return to react
    @GetMapping("/data")
    public ResponseEntity<Object> tester() {
        Map<String, Object> data = new HashMap<>();

        data.put("Activtiy", "lalala");

        data.put("message", "Hello from Spring Boot!");
        return ResponseEntity.ok(data);
    }

    @GetMapping("/EventsRange")
    public ResponseEntity<HashMap<String, List<HashMap<String, String>>>> getActivities(
            @RequestParam("start") String startDate,
            @RequestParam("end") String endDate) {

        HashMap<String, List<HashMap<String, String>>> returnedHashMap = new HashMap<>();
        ArrayList<HashMap<String, String>> arr = new ArrayList();
        HashMap<String, String> EventDescription;
        for (Event e : eventsList) {
            if (e.isInRange(startDate, endDate)) {  // TODO: implement the function
                EventDescription = new HashMap<>();
                EventDescription.put("ID", "" + e.getId());
                EventDescription.put("Color", e.getColor());
                EventDescription.put("Activity", e.getActivity());
                EventDescription.put("EndTime", e.getEndTime());
                EventDescription.put("StartTime", e.getEndTime());
                arr.add(EventDescription);
            }
        }
        returnedHashMap.put("Events", arr);

        // Fetch activities for the given date range
        return ResponseEntity.ok(returnedHashMap);
    }


    public void Sort() {
        ArrayList<Event> sortedList = new ArrayList<Event>();

        for (int i = 1; i < eventsList.size(); ++i) {
            Event val = eventsList.get(i);
            int j = i - 1;

            /*
             * Move elements of arr[0..i-1], that are
             * greater than key, to one position ahead
             * of their current position
             */
            // Check to see if this sort works
            while (j >= 0 && eventsList.get(j).getDate().compareTo(val.getDate()) < 0) {
                eventsList.set(j + 1, eventsList.get(j));
                j = j - 1;
            }
            eventsList.set(j + 1, val);
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
