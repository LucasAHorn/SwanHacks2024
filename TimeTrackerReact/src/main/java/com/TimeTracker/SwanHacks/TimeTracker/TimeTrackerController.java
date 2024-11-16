package com.TimeTracker.SwanHacks.TimeTracker;

import java.util.*;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TimeTrackerController {

    private Map<String, TimeTracker> db = new HashMap<>() {
        {
            put("1", new TimeTracker("1", "hello.jpg"));
        }
    };

    @GetMapping("/")
    public String hello() {
        return "This Works!";
    }

    @GetMapping("/data")
    public Collection<TimeTracker> get() {
        return db.values();
    }

    @GetMapping("/data")
    public ResponseEntity<Object> helloWorld() {
        Map<String, Object> data = new HashMap<>();
        data.put("message", "Hello from Spring Boot!");
        data.put("timeStamp", new Date());
        return ResponseEntity.ok(data);
    }

    @GetMapping("/data/{id}")
    public TimeTracker get(@PathVariable String id) {
        TimeTracker photo = db.get(id);
        if (photo == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    @DeleteMapping("/data/{id}")
    public void remove(@PathVariable String id) {
        TimeTracker photo = db.remove(id);
        if (photo == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

}
