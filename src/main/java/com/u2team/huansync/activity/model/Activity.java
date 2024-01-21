package com.u2team.huansync.activity.model;

import java.time.LocalTime;
import java.util.List;

public class Activity {
    private Long activityId;
    private String name;
    private TypeActivity TypeActivity;
    private int categoryCosplayId;
    private int numParticipants;
    private int eventId;
    private LocalTime startTime;
    private List<Staff> staff;

    public Long getActivityIdId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeActivity getTypeActivity() {
        return TypeActivity;
    }

    public void setTypeActivity(TypeActivity typeActivity) {
        TypeActivity = typeActivity;
    }

    public int getIdCategoryCosplay() {
        return categoryCosplayId;
    }

    public void setCategoryCosplayId(int categoryCosplayId) {
        this.categoryCosplayId = categoryCosplayId;
    }

    public int getNumParticipants() {
        return numParticipants;
    }

    public void setNumParticipants(int numParticipants) {
        this.numParticipants = numParticipants;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public List<Staff> getStaff() {
        return staff;
    }

    public void setStaff(List<Staff> staff) {
        this.staff = staff;
    }
}
