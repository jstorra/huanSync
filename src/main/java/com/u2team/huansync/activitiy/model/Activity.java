package com.u2team.huansync.activitiy.model;

import java.time.LocalTime;
import java.util.List;

public class Activity {
    private String name;
    private TypeActivity TypeActivity;
    private Category category;
    private int numParticipans;
    private Event event;
    private LocalTime hourStart;
    private List<Staff> staff;

    
    public Activity(String name, TypeActivity typeActivity, Category category, int numParticipans, Event event,
            LocalTime hourStart, List<Staff> staff) {
        this.name = name;
        this.TypeActivity = typeActivity;
        this.category = category;
        this.numParticipans = numParticipans;
        this.event = event;
        this.hourStart = hourStart;
        this.staff = staff;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getNumParticipans() {
        return numParticipans;
    }

    public void setNumParticipans(int numParticipans) {
        this.numParticipans = numParticipans;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public LocalTime getHourStart() {
        return hourStart;
    }

    public void setHourStart(LocalTime hourStart) {
        this.hourStart = hourStart;
    }

    public List<Staff> getStaff() {
        return staff;
    }

    public void setStaff(List<Staff> staff) {
        this.staff = staff;
    }
}
