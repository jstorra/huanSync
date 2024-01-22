package com.u2team.huansync.activity.model;

import com.u2team.huansync.event.staff.model.classes.Staff;

import java.time.LocalTime;
import java.util.List;

public interface ActivityBuilder {
    ActivityBuilder name(String name);
    ActivityBuilder typeActivity(TypeActivity typeActivity);
    ActivityBuilder categoryCosplayId(long categoryCosplayId);
    ActivityBuilder numParticipants(int numParticipants);
    ActivityBuilder eventId(long eventId);
    ActivityBuilder startTime(LocalTime startTime);
    ActivityBuilder staff(List<Staff> staff);
    Activity build();
}
