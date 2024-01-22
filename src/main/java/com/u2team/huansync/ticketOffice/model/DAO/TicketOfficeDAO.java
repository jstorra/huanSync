package com.u2team.huansync.ticketOffice.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.u2team.huansync.event.model.DAO.EventDAO;
import com.u2team.huansync.event.model.classes.Event;
import com.u2team.huansync.persistence.BDConnection;
import com.u2team.huansync.persistence.Operations;
import com.u2team.huansync.ticketOffice.model.TicketOffice;
import com.u2team.huansync.ticketOffice.model.builders.TicketOfficeBuilder;
import com.u2team.huansync.ticketOffice.model.builders.TicketOfficeBuilderOficial;

public class TicketOfficeDAO implements IDao<TicketOffice> {

   
    public Event getTicketOfficeById(long ticketOfficeId) {
        String ticketOfficeQuery = "SELECT * FROM tbl_ticketOffice WHERE ticketOfficeId = ?";
        
        try (PreparedStatement ticketOfficePs = Operations.getConnection().prepareStatement(ticketOfficeQuery)) {
            ticketOfficePs.setLong(1, ticketOfficeId);
            
            //ResultSet ticketOfficdeRs = Operations.query_db(ticketOfficePs);
            /* 
            if (ticketOfficdeRs.next()) {
                Event event = new Event();
                event.setEventId(ticketOfficdeRs.getLong("eventId"));
                event.setOrganizerId(eventId);(ticketOfficdeRs.getString("personal"));
                return event;
            }*/
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
   
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
    public void save(TicketOffice t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void update(TicketOffice t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(long ticketOfficeId) {
        EventDAO eventDAO = new EventDAO();
        Event event = eventDAO.getById(1);
        event.getStatusEnum().name().equals("FINISHED");

        // Lo anterior en un if e 1 se cambia por un parametro que conecte el ticketOfficeId y por dentro de el eventId
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "DELETE FROM tbl_ticketOffice WHERE ticketOfficeId = ?";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, ticketOfficeId);

            int rows = Operations.insert_update_delete_db(ps);
            if (rows > 0) {
                System.out.println("successful delete event");
                return;
            } else {
                System.out.println("not exists event");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("something was wrong on delete event");
        return;
    }
}
