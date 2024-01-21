package com.u2team.huansync.activity.model;


import java.time.LocalTime;

public interface ActivityBuilder {
    ActivityBuilder name(String name);
    ActivityBuilder typeActivity(TypeActivity typeActivity);
    ActivityBuilder category(Category category);
    ActivityBuilder numParticipants(int numParticipants);
    ActivityBuilder event(Event event);
    ActivityBuilder hourStaff(LocalTime hourStaff);
    ActivityBuilder staff(List<Staff> staff);
    Activity build();


}
