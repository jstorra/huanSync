package com.u2team.huansync.ticketOffice.model.util;

import java.time.LocalDate;
import java.time.LocalTime;


public class Validations {
    
    
    public boolean isValidHour(LocalTime startHour) {
        LocalTime currentHour = LocalTime.now();
        return currentHour.isBefore(startHour);
    }

    public boolean isValidDate(LocalDate startDate) {
        LocalDate currentDate = LocalDate.now();
        return currentDate.isBefore(startDate);
    }
}
