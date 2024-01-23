package com.u2team.huansync.activity.model;

import java.time.LocalTime;

public interface ActivityBuilder {
    ActivityBuilder activityId(Long activityId);
    ActivityBuilder name(String name);
    ActivityBuilder typeActivity(TypeActivity typeActivity);
    ActivityBuilder categoryCosplayId(Long categoryCosplayId);
    ActivityBuilder numParticipants(int numParticipants);
    ActivityBuilder eventId(Long eventId);
    ActivityBuilder startTime(LocalTime startTime);
    ActivityBuilder price(double price);
    ActivityBuilder completed(boolean completed);
    Activity build();
}
