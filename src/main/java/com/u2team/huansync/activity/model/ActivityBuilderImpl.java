package com.u2team.huansync.activity.model;

import java.time.LocalTime;
import java.util.List;

public class ActivityBuilderImpl implements ActivityBuilder {
    private Activity activity =  new Activity();

    @Override
    public ActivityBuilder name(String name) {
        activity.setName(name);
        return this;
    }

    @Override
    public ActivityBuilder typeActivity(TypeActivity typeActivity) {
        activity.setTypeActivity(typeActivity);
        return this;
    }

    @Override
    public ActivityBuilder categoryCosplayId(long categoryCosplayId) {
        activity.setCategoryCosplayId(categoryCosplayId);
        return this;
    }

    @Override
    public ActivityBuilder numParticipants(int numParticipants) {
        activity.setNumParticipants(numParticipants);
        return this;
    }

    @Override
    public ActivityBuilder eventId(long eventId) {
        activity.setEventId(eventId);
        return null;
    }

    @Override
    public ActivityBuilder startTime(LocalTime startTime) {
        activity.setStartTime(startTime);
        return this;
    }

    @Override
    public ActivityBuilder staff(List<Staff> staff) {
        activity.setStaff(staff);
        return this;
    }

    @Override
    public Activity build() {
        return activity;
    }
}
