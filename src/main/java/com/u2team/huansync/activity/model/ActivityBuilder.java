package com.u2team.huansync.activity.model;

import java.time.LocalTime;
import java.util.List;

public interface ActivityBuilder {
    ActivityBuilder name(String name);
    ActivityBuilder typeActivity(TypeActivity typeActivity);
    ActivityBuilder categoryCosplayId(int categoryCosplayId);
    ActivityBuilder numParticipants(int numParticipants);
    ActivityBuilder eventId(int eventId);
    ActivityBuilder startTime(LocalTime startTime);
    ActivityBuilder staff(List<Staff> staff);
    Activity build();
}
