package com.u2team.huansync.ticketOffice.model.util;

import java.time.LocalDate;
import java.time.LocalTime;

import com.u2team.huansync.event.controller.EventController;
import com.u2team.huansync.event.model.classes.Event;


public class Validations {
    
    public static boolean isValidHour(LocalTime startHour) {
        LocalTime currentHour = LocalTime.now();
        return currentHour.isBefore(startHour);
    }

    public static boolean isValidDate(LocalDate startDate) {
        LocalDate currentDate = LocalDate.now();
        return currentDate.isBefore(startDate);
    }
    // Metodos para verificar dia y hora y comparar taquillas con eventos si ya estan
    public static boolean checkedEvent(long eventId){
        for(Event repeated : EventController.getAllEvents()){
            return repeated.getEventId() == eventId;
        }
        return false;     
    }
}
