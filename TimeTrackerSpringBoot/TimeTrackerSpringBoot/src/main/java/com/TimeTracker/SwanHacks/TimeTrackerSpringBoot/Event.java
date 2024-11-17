package com.TimeTracker.SwanHacks.TimeTrackerSpringBoot;

public class Event {
    private int id;
    private int Color;
    private String Activity;
    private String Date;
    private String StartTime;
    private String EndTime;

    public Event() {

    }

    public Event(int id, int color, String activity, String startTime,
            String endTime) {
        this.id = id;
        Color = color;
        Activity = activity;
        StartTime = startTime;
        EndTime = endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getColor() {
        return Color;
    }

    public void setColor(int color) {
        Color = color;
    }

    public String getActivity() {
        return Activity;
    }

    public void setActivity(String activity) {
        Activity = activity;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

}
