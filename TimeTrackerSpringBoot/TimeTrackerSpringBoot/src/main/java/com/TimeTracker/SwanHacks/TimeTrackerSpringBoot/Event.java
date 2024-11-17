package com.TimeTracker.SwanHacks.TimeTrackerSpringBoot;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Event {
    private int id;
    private String Color;
    private String Activity;
    private String Date;
    private String StartTime;
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
}
