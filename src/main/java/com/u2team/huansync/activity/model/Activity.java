package com.u2team.huansync.activity.model;

import com.u2team.huansync.event.staff.model.classes.Staff;

import java.time.LocalTime;
import java.util.List;

public class Activity {
    private long activityId;
    private String name;
    private TypeActivity typeActivity;
    private long categoryCosplayId;
    private int numParticipants;
    private long eventId;
    private LocalTime startTime;
    private long price;
    private boolean completed;

    public long getActivityId() {
        return activityId;
    }

    public void setActivityId(long activityId) {
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

    public long getCategoryCosplayId() {
        return categoryCosplayId;
    }

    public void setCategoryCosplayId(long categoryCosplayId) {
        this.categoryCosplayId = categoryCosplayId;
    }

    public int getNumParticipants() {
        return numParticipants;
    }

    public void setNumParticipants(int numParticipants) {
        this.numParticipants = numParticipants;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
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
