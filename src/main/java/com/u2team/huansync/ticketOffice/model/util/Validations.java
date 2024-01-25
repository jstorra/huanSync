package com.u2team.huansync.ticketOffice.model.util;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

import com.u2team.huansync.persistence.BDConnection;
import com.u2team.huansync.persistence.Operations;
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

    public static boolean checkedStaffStatus(long staffId) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String query = "SELECT staffId, statusStaff FROM tbl_staff WHERE statusStaff = 'no_task_assigned';";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(query)) {
            ResultSet rs = Operations.query_db(ps);

            while (rs.next()) {
                long idStaff = rs.getLong("staffId");
                //String typeStatus = rs.getString("statusStaff");

                for(TicketOffice repeated3 : TicketOfficeController.getAllTicketOffice()){
                        return repeated3.getStaffId() == idStaff;
                }                
            }           
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean updateStaff(String statusChange, long staffId) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String query = "UPDATE tbl_staff SET statusStaff = ? WHERE staffId = ?";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(query)) {
            ps.setString(1, statusChange);
            ps.setLong(2, staffId);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

