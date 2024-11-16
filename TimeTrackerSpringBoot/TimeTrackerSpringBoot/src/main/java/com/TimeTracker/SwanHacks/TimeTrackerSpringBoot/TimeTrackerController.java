package com.TimeTracker.SwanHacks.TimeTrackerSpringBoot;

import java.util.*;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TimeTrackerController {

    private Map<Integer, Event> timeChart = new HashMap<>();

    @GetMapping("/")
    public String hello() {
        return "This Works!";
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
