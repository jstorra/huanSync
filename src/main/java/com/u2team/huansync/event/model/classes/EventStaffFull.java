package com.u2team.huansync.event.model.classes;

import com.u2team.huansync.event.staff.model.classes.Staff;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author Christian Pardo
 *
 */
public class EventStaffFull extends Event{

    private List<Staff> staff;

    public EventStaffFull() {
    }

    public EventStaffFull(long eventId, String nameEvent, String country, String city, String address, int peopleCapacity, int storeCapacity, int restaurantCapacity, LocalDate dateEvent, LocalTime timeEvent, long organizerId, AgeClassificationEnum ageClassification, StatusEnum statusEnum, List<Staff> staff) {
        super(eventId, nameEvent, country, city, address, peopleCapacity, storeCapacity, restaurantCapacity, dateEvent, timeEvent, organizerId, ageClassification, statusEnum);
        this.staff = staff;
    }

    public List<Staff> getStaff() {
        return staff;
    }

    public void setStaff(List<Staff> staff) {
        this.staff = staff;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("\n ===== \n");
        if(staff != null){
            for (Staff s : staff){
                sb.append(s + "\n");
            }
        }
        return sb.toString();
    }
}