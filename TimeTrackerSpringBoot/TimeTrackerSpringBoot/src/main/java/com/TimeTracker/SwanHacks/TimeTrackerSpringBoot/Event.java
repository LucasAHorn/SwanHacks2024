package com.TimeTracker.SwanHacks.TimeTrackerSpringBoot;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Event {

    @JsonProperty("ID_Number")
    private int id;

    @JsonProperty("Color")
    private String Color;

    @JsonProperty("Activity")
    private String Activity;

    @JsonProperty("Date")
    private String Date;

    @JsonProperty("StartTime")
    private String StartTime;

    @JsonProperty("EndTime")
    private String EndTime;

    private double TaskTime;

    public Event() {

    }

    public Event(int id, String color, String activity, String startTime,
            String endTime, String Date) {
        this.id = id;
        Color = color;
        Activity = activity;
        StartTime = startTime;
        EndTime = endTime;
        this.Date = Date;
        TaskTime = createTaskTime(startTime, endTime);
    }

    /**
     * returns if this is within the specified range (inclusive, exclusive), you
     * can
     *
     *
     * change inputs as needed
     *
     * @param start
     * @param end
     * @return
     */
    public Boolean isInRange(String start, String end) {
        if (StartTime.compareTo(start) <= 0 && EndTime.compareTo(end) >= 0) {
            return false;
        } else {
            return true;
        }
    }

    public double createTaskTime(String start, String end) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime time1Parsed = LocalTime.parse(start, formatter);
        LocalTime time2Parsed = LocalTime.parse(end, formatter);

        // Calculate the difference in minutes
        long minutesDiff = java.time.Duration.between(time1Parsed,
                time2Parsed).toMinutes();

        // Convert the difference to hours (as a double)
        double hoursDiff = minutesDiff / 60.0;
        return hoursDiff;
    }

    public double getTaskTime() {
        return TaskTime;
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

    public String createString() {
        String eventString = "" + id + "" + Color + "" + Activity + "" + StartTime + "" + EndTime + "" + Date;
        return eventString;
    }
}
