package com.u2team.huansync.activity.model;

import java.time.LocalTime;

public class ActivityBuilderImpl implements ActivityBuilder{
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
    public ActivityBuilder category(Category category) {
        activity.setCategory(category);
        return this;
    }

    @Override
    public ActivityBuilder numParticipants(int numParticipants) {
        activity.setNumParticipans(numParticipants);
        return this;
    }

    @Override
    public ActivityBuilder event(Event event) {
        activity.setEvent(event);
        return null;
    }

    @Override
    public ActivityBuilder hourStaff(LocalTime hourStaff) {
        activity.setHourStart(hourStaff);
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
