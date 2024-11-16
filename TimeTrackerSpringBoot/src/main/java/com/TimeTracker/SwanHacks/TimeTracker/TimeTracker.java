package com.TimeTracker.SwanHacks.TimeTracker;

public class TimeTracker {

    private String id;

    private String fileName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public TimeTracker() {

    }

    public TimeTracker(String id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }

}
