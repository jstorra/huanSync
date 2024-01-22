package com.u2team.huansync.event.model.classes;

public class EventStaff {
    private long eventId;
    private long staffId;

    public EventStaff(long eventId, long staffId) {
        this.eventId = eventId;
        this.staffId = staffId;
    }
    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public long getStaffId() {
        return staffId;
    }

    public void setStaffId(long staffId) {
        this.staffId = staffId;
    }

    @Override
    public String toString() {
        return "EventStaff{" +
                "eventId=" + eventId +
                ", staffId=" + staffId +
                '}';
    }
}
