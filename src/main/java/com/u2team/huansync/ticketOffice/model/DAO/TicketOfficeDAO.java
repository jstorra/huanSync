package com.u2team.huansync.ticketOffice.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.u2team.huansync.event.controller.EventController;
import com.u2team.huansync.event.model.classes.Event;
import com.u2team.huansync.persistence.BDConnection;
import com.u2team.huansync.persistence.Operations;
import com.u2team.huansync.ticketOffice.model.TicketOffice;
import com.u2team.huansync.ticketOffice.model.builders.TicketOfficeBuilder;
import com.u2team.huansync.ticketOffice.model.builders.TicketOfficeBuilderOficial;

public class TicketOfficeDAO implements IDao<TicketOffice> {
   
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
    public List<TicketOffice> getAll() {
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
    public void save(TicketOffice ticketOffice) {
        //EventController eventControllerTicket = new EventController();
        //Event date = (Event) eventControllerTicket.getAllEvents();
        //date.getDateEvent();
        String ticketOfficeStm = "INSERT INTO tbl_ticketOffice(eventId, location, address, contactNumber, staffId) VALUES(?,?,?,?,?)";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(ticketOfficeStm)){
            ps.setLong(1, ticketOffice.getEventId());
            ps.setBoolean(2, ticketOffice.isLocation());
            ps.setString(3, ticketOffice.getAddress());
            ps.setString(4, ticketOffice.getContactNumber());
            ps.setLong(5, ticketOffice.getStaffId());
        
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(TicketOffice t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(long ticketOfficeId) {
        EventController eventController = new EventController();
        TicketOffice eventId = new TicketOffice();
        Event event = eventController.getById(eventId.getEventId());
        if(event.getStatusEnum().name().equalsIgnoreCase("finished")){
            Operations.setConnection(BDConnection.MySQLConnection());
            String stm = "DELETE FROM tbl_ticketOffice WHERE ticketOfficeId = ?";
            try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
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
        System.out.println("something was wrong on delete ticketOffice");
        return;
    }
}
