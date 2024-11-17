package com.TimeTracker.SwanHacks.TimeTrackerSpringBoot;

public class Event {
    private int id;
    private String Color;
    private String Activity;
    private String Date;
    private String StartTime;
    private String EndTime;

    public Event() {

    }

    public Event(int id, String color, String activity, String startTime,
            String endTime) {
        this.id = id;
        Color = color;
        Activity = activity;
        StartTime = startTime;
        EndTime = endTime;
    }

    /**
     * returns if this is within the specified range (inclusive, exclusive), you can change inputs as needed
     * @param start
     * @param end
     * @return
     */
    public Boolean isInRange(String start, String end) {
        // TODO: implement:
        return false;
    }

    public int getId() {
        return id;
    }

    public String getColor() {
        return Color;
    }

    public String getActivity() {
        return Activity;
    }

    public String getStartTime() {
        return StartTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public String getDate() {
        return Date;
    }
}
