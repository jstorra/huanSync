package com.u2team.huansync.activity.model;

import java.time.LocalTime;

public class Activity {
    private Long activityId;
    private String name;
    private TypeActivity typeActivity;
    private Long categoryCosplayId;
    private int numParticipants;
    private Long eventId;
    private LocalTime startTime;
    private double price;
    private boolean completed;

    public Long getActivityId() {
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
        return typeActivity;
    }

    public void setTypeActivity(TypeActivity typeActivity) {
        this.typeActivity = typeActivity;
    }

    public Long getCategoryCosplayId() {
        return categoryCosplayId;
    }

    public void setCategoryCosplayId(Long categoryCosplayId) {
        this.categoryCosplayId = categoryCosplayId;
    }

    public int getNumParticipants() {
        return numParticipants;
    }

    public void setNumParticipants(int numParticipants) {
        this.numParticipants = numParticipants;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "activityId=" + activityId +
                ", name='" + name + '\'' +
                ", typeActivity=" + typeActivity +
                ", categoryCosplayId=" + categoryCosplayId +
                ", numParticipants=" + numParticipants +
                ", eventId=" + eventId +
                ", startTime=" + startTime +
                ", price=" + price +
                ", completed=" + completed +
                '}';
    }
}
