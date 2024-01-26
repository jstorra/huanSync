package com.u2team.huansync.activity.model;

import java.time.LocalTime;

/**
 * Implementation of the ActivityBuilder interface for constructing Activity objects.
 */
public class ActivityBuilderImpl implements ActivityBuilder {
    private Activity activity = new Activity();

    @Override
    public ActivityBuilder activityId(Long activityId) {
        activity.setActivityId(activityId);
        return this;
    }

    @Override
    public ActivityBuilder nameActivity(String nameActivity) {
        activity.setNameActivity(nameActivity);
        return this;
    }

    @Override
    public ActivityBuilder typeActivity(TypeActivity typeActivity) {
        activity.setTypeActivity(typeActivity);
        return this;
    }

    @Override
    public ActivityBuilder categoryCosplayId(Long categoryCosplayId) {
        activity.setCategoryCosplayId(categoryCosplayId);
        return this;
    }

    @Override
    public ActivityBuilder numParticipants(int numParticipants) {
        activity.setNumParticipants(numParticipants);
        return this;
    }

    @Override
    public ActivityBuilder eventId(Long eventId) {
        activity.setEventId(eventId);
        return this;
    }

    @Override
    public ActivityBuilder startTime(LocalTime startTime) {
        activity.setStartTime(startTime);
        return this;
    }

    @Override
    public ActivityBuilder price(double price) {
        activity.setPrice(price);
        return this;
    }

    @Override
    public ActivityBuilder completed(boolean completed) {
        activity.setCompleted(completed);
        return this;
    }

    @Override
    public Activity build() {
        return activity;
    }
}