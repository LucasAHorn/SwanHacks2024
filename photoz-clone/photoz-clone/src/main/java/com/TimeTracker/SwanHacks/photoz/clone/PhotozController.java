package com.TimeTracker.SwanHacks.photoz.clone;

import java.util.HashMap;
import java.util.*;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhotozController {

    private Map<String, Photo> db = new HashMap<>() {
        {
            put("1", new Photo("1", "hello.jpg"));
        }
    };

    @GetMapping("/")
    public String hello() {
        return "This Works!";
    }

    @GetMapping("/photoz")
    public Collection<Photo> get() {
        return db.values();
    }

    @GetMapping("/photoz/{id}")
    public Photo get(@PathVariable String id) {
        Photo photo = db.get(id);
        if (photo == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    @DeleteMapping("/photoz/{id}")
    public void remove(@PathVariable String id) {
        Photo photo = db.remove(id);
        if (photo == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

}
