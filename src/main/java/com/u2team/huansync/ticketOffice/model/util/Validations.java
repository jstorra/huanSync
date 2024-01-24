package com.u2team.huansync.ticketOffice.model.util;

import java.time.LocalDate;
import java.time.LocalTime;

import com.u2team.huansync.ticketOffice.controller.TicketOfficeController;
import com.u2team.huansync.ticketOffice.model.classes.TicketOffice;


public class Validations {
    
    public static boolean isValidHour(LocalTime startHour) {
        LocalTime currentHour = LocalTime.now();
        return startHour.isAfter(currentHour);
    }

    public static boolean isValidDate(LocalDate startDate) {
        LocalDate currentDate = LocalDate.now();
        return startDate.isAfter(currentDate);
    }

    public static boolean checkedEvent(long eventId){
        for(TicketOffice repeated : TicketOfficeController.getAllTicketOffice()){
            return repeated.getEventId() == eventId;
        }
        return false;    
    }

    public static boolean checkedStaff(long staffId){
        for(TicketOffice repeated2 : TicketOfficeController.getAllTicketOffice()){
            return repeated2.getStaffId() == staffId;
        }
        return false;    
    }
}
