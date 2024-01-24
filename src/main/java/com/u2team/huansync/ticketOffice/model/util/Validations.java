package com.u2team.huansync.ticketOffice.model.util;

import java.time.LocalDate;
import java.time.LocalTime;

import com.u2team.huansync.ticketOffice.controller.TicketOfficeController;
import com.u2team.huansync.ticketOffice.model.classes.TicketOffice;

/**
 * Utility class for performing various validations.
 */
public class Validations {

    /**
     * Checks if the provided start time and date are valid in relation to the current date and time.
     *
     * @param starHour The start time to be validated.
     * @param startDate The start date to be validated.
     * @return true if the start time and date are valid, false otherwise.
     */
    public static boolean isValidDateTime(LocalTime starHour, LocalDate startDate) {
        LocalDate currentDate = LocalDate.now();
        LocalTime currentHour = LocalTime.now();

        if (currentDate.isBefore(startDate)) {
            return true;
        } else if (currentHour.isBefore(starHour)) {
            return true;
        } else if (currentDate.equals(startDate)) {
            return false;
        } else {
            return false;
        }
    }

    /**
     * Checks if an event with the specified event ID exists.
     *
     * @param eventId The unique identifier of the event to be checked.
     * @return true if an event with the specified ID exists, false otherwise.
     */
    public static boolean checkedEvent(long eventId) {
        for (TicketOffice repeated : TicketOfficeController.getAllTicketOffice()) {
            return repeated.getEventId() == eventId;
        }
        return false;
    }

    /**
     * Checks if a staff with the specified staff ID exists.
     *
     * @param staffId The unique identifier of the staff to be checked.
     * @return true if a staff with the specified ID exists, false otherwise.
     */
    public static boolean checkedStaff(long staffId) {
        for (TicketOffice repeated2 : TicketOfficeController.getAllTicketOffice()) {
            return repeated2.getStaffId() == staffId;
        }
        return false;
    }
}

