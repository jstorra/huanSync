package com.u2team.huansync.ticketOffice.model.util;

import java.time.LocalDate;
import java.time.LocalTime;

import com.u2team.huansync.event.controller.EventController;
import com.u2team.huansync.event.model.classes.Event;


public class Validations {
    
    public boolean isValidHour(LocalTime startHour) {
        LocalTime currentHour = LocalTime.now();
        return currentHour.isBefore(startHour);
    }

    public boolean isValidDate(LocalDate startDate) {
        LocalDate currentDate = LocalDate.now();
        return currentDate.isBefore(startDate);
    }

    public boolean checkedEvent(long eventId){
        for(Event repeated : EventController.getAllEvents()){
            if (repeated.getEventId() == eventId){
                return true;
            } else {
                return false;
            }
        }
        return false;     
    }
}
