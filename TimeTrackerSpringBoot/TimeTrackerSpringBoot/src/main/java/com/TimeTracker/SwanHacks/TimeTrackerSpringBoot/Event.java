package com.TimeTracker.SwanHacks.TimeTrackerSpringBoot;

public class Event {
    private int id;
    private int Color;
    private String Activity;
    private String Description;
    private boolean IsSleep;
    private String StartTime;
    private String EndTime;

    public Event() {

    }

    public Event(int id, int color, String activity, String description, boolean isSleep, String startTime,
            String endTime) {
        this.id = id;
        Color = color;
        Activity = activity;
        Description = description;
        IsSleep = isSleep;
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

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public boolean isIsSleep() {
        return IsSleep;
    }

    public void setIsSleep(boolean isSleep) {
        IsSleep = isSleep;
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

}
