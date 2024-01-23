package com.u2team.huansync.ticketOffice.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.u2team.huansync.event.controller.EventController;
import com.u2team.huansync.event.model.classes.Event;
import com.u2team.huansync.persistence.BDConnection;
import com.u2team.huansync.persistence.Operations;
import com.u2team.huansync.ticketOffice.model.classes.TicketOffice;
import com.u2team.huansync.ticketOffice.model.builders.TicketOfficeBuilder;
import com.u2team.huansync.ticketOffice.model.builders.TicketOfficeBuilderOficial;
import com.u2team.huansync.ticketOffice.model.util.Validations;

public class TicketOfficeDAO implements IDao<TicketOffice> {
    
    Event dateTime = (Event) EventController.getAllEvents();
    Validations validation = new Validations();
    LocalDate startDate = dateTime.getDateEvent();
    LocalTime startHour = dateTime.getTimeEvent();

    /**
     * Retrieves and returns an instance of TicketOffice based on the provided ID.
     *
     * @param id The unique identifier of the TicketOffice to be retrieved.
     * @return An instance of TicketOffice if a record with the provided ID is found, or null if not found.
     * @throws SQLException If an error occurs while interacting with the database.
     */
    @Override
    public TicketOffice getById(long id) {

        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "SELECT * FROM tbl_ticketOffice where ticketOfficeId = ?;";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, id);
            ResultSet rs = Operations.query_db(ps);
            if (rs.next()) {
                TicketOfficeBuilder ticketOfficeBuilder = new TicketOfficeBuilderOficial();
                TicketOffice sqlTicketOffice = ticketOfficeBuilder

                        .ticketOfficeId(rs.getLong("ticketOfficeId"))
                        .eventId(rs.getLong("eventId"))
                        .location(rs.getBoolean("location"))
                        .address(rs.getString("address"))
                        .contactNumber(rs.getString("contactNumber"))
                        .staffId(rs.getLong("staffId"))
                        .build();

                return sqlTicketOffice;
            } else {
                System.out.println("ERROR: The id hasn't been found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<TicketOffice> getAllTicketOffice() {
        List<TicketOffice> ticketList = new ArrayList<>();

        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "SELECT * FROM tbl_ticketOffice";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ResultSet rs = Operations.query_db(ps);

            while (rs.next()) {

                TicketOfficeBuilder ticketOfficeBuilder = new TicketOfficeBuilderOficial();

                TicketOffice sqlTicketOffice = ticketOfficeBuilder
                        .ticketOfficeId(rs.getLong("ticketOfficeId"))
                        .eventId(rs.getLong("eventId"))
                        .location(rs.getBoolean("location"))
                        .address(rs.getString("address"))
                        .contactNumber(rs.getString("contactNumber"))
                        .staffId(rs.getLong("staffId"))
                        .build();
                ticketList.add(sqlTicketOffice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ticketList;
    }

    @Override
    public void insertTicketOffice(TicketOffice ticketOffice) {     
        
        if (!validation.isValidDate(startDate) && !validation.isValidHour(startHour)) {
            System.out.println("This ticketOffice was impossible to add because the event has already started");
            return;
        }  else {
            
            String ticketOfficeStm = "INSERT INTO tbl_ticketOffice(eventId, location, address, contactNumber, staffId) VALUES(?,?,?,?,?)";
            try (PreparedStatement ps = Operations.getConnection().prepareStatement(ticketOfficeStm)) {
                ps.setLong(1, ticketOffice.getEventId());
                if (ticketOffice.isLocation() == true) {
                    ps.setNull(3, Types.VARCHAR); 
                } else {
                    ps.setString(3, ticketOffice.getAddress());
                }
                ps.setString(4, ticketOffice.getContactNumber());
                ps.setLong(5, ticketOffice.getStaffId());

                int rows = Operations.insert_update_delete_db(ps);
                if (rows <= 0) {
                    System.out.println("Cannot push ticketOffice");
                } else {
                    System.out.println("Successful push ticketOffice");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }    
    }

    @Override
    public void updateTicketOffice(TicketOffice ticketOffice) {
        TicketOffice sqlTicketOffice = getById(ticketOffice.getTicketOfficeId());

        if(sqlTicketOffice != null){
            sqlTicketOffice.setEventId(ticketOffice.getEventId());
            sqlTicketOffice.setLocation(ticketOffice.isLocation());
            sqlTicketOffice.setAddress(ticketOffice.getAddress());
            sqlTicketOffice.setContactNumber(ticketOffice.getContactNumber());
            sqlTicketOffice.setStaffId(ticketOffice.getStaffId());
        
            if (!validation.isValidDate(startDate) && !validation.isValidHour(startHour)) {
                System.out.println("This ticketOffice was impossible to update because the event has already started");
                return;
            }  else{
                String ticketOfficeStm = "UPDATE tbl_ticketOffice SET eventId = ?, location = ?, address = ?, contactNumber = ?, staffId = ? WHERE ticketOfficeId = ?; ";

                try (PreparedStatement ps = Operations.getConnection().prepareStatement(ticketOfficeStm)){
                    ps.setLong(1, ticketOffice.getEventId());
                    if (ticketOffice.isLocation() == true) {
                        ps.setNull(3, Types.VARCHAR); 
                    } else {
                        ps.setString(3, ticketOffice.getAddress());
                    }
                    ps.setString(4, ticketOffice.getContactNumber());
                    ps.setLong(5, ticketOffice.getStaffId());
                    ps.setLong(6, ticketOffice.getTicketOfficeId());

                    System.out.println(ps.toString());
                    
                    int rows = Operations.insert_update_delete_db(ps);
                    if (rows <= 0) {
                        System.out.println("Cannot update ticketOffice");
                    } else {
                        System.out.println("Successful update ticketOffice");
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                } 
            }
        } else {
                System.out.println("Not found results ticketOffice");
        }
    }

    @Override
    public void deleteTicketOffice(long ticketOfficeId) {
        
        TicketOffice eventId = new TicketOffice();
        Event event = EventController.getByIdEvent(eventId.getEventId());
        if (event.getStatusEnum().name().equalsIgnoreCase("finished")) {
            Operations.setConnection(BDConnection.MySQLConnection());
            String ticketOfficeStm = "DELETE FROM tbl_ticketOffice WHERE ticketOfficeId = ?";
            try (PreparedStatement ps = Operations.getConnection().prepareStatement(ticketOfficeStm)) {
                ps.setLong(1, ticketOfficeId);
                int rows = Operations.insert_update_delete_db(ps);
                if (rows > 0) {
                    System.out.println("successful delete ticketOffice");
                    return;
                } else {
                    System.out.println("not exists ticketOffice or event's status haven't finished");
                    return;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Something was wrong on delete ticketOffice");
        return;
    }
}
