package com.u2team.huansync.ticketOffice.tickets.model.DAO;

import com.u2team.huansync.persistence.BDConnection;
import com.u2team.huansync.persistence.Operations;
import com.u2team.huansync.ticketOffice.tickets.model.classes.Tickets;
import com.u2team.huansync.ticketOffice.tickets.model.classes.builders.TicketBuilder;
import com.u2team.huansync.ticketOffice.tickets.model.classes.builders.TicketConcreteBuilder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketsDAO implements IDao<Tickets>{

    @Override
    public Tickets getById(long id) {

        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "SELECT * FROM tbl_tickets where ticketId = ?;";

        try(PreparedStatement ps = Operations.getConnection().prepareStatement(stm)){
            ps.setLong(1, id);
            ResultSet rs = Operations.query_db(ps);
            if (rs.next()){
                TicketBuilder ticketBuilder = new TicketConcreteBuilder();

                Tickets sqlTickets = ticketBuilder.ticketId(rs.getLong("ticketId"))
                        .nameTicket(rs.getString("nameTicket"))
                        .statusEnum(rs.getString("status"))
                        .additionalCost(rs.getDouble("additionalCost"))
                        .ageClassificationEnum(rs.getString("ageClassification"))
                        .buid();

                        return sqlTickets;
            }
            else {
                System.out.println("ERROR: The id has not been found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Tickets> getAll() {
        List<Tickets> ticketsList = new ArrayList<>();

        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "SELECT * FROM tbl_tickets;";

        try(PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ResultSet rs = Operations.query_db(ps);

            while (rs.next()){
                TicketBuilder ticketBuilder = new TicketConcreteBuilder();

                Tickets sqlTickets = ticketBuilder.ticketId(rs.getLong("ticketId"))
                        .nameTicket(rs.getString("nameTicket"))
                        .statusEnum(rs.getString("status"))
                        .additionalCost(rs.getDouble("additionalCost"))
                        .ageClassificationEnum(rs.getString("ageClassification"))
                        .buid();

                ticketsList.add(sqlTickets);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ticketsList;
    }

    @Override
    public void save(Tickets tickets) {
        String stmInsert = "INSERT INTO tbl_tickets(nameTicket, price, status, additionalCost, costumerId, ticketOfficeId, ticketTypeId) VALUES(?,?,?,?,?,?,?);";

        try(PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)){
            ps.setString(1, tickets.getNameTicket());
            ps.setString(3, tickets.getStatusEnum().name());
            ps.setDouble(4, tickets.getAdditionalCost());
            ps.setLong(5, tickets.getCostumerId());
            ps.setLong(6, tickets.getTicketOfficeId());
            ps.setLong(7, tickets.getTicketTypeId());

            int rows = Operations.insert_update_delete_db(ps);

            if (rows <= 0){
                System.out.println("Cannot push ticket");
            } else{
                System.out.println("Successful push ticket");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Tickets tickets) {
        Tickets sqlTicket = getById(tickets.getTicketId());

        if (sqlTicket != null){
            sqlTicket.setNameTicket(tickets.getNameTicket());
            sqlTicket.setStatusEnum(tickets.getStatusEnum());
            sqlTicket.setAdditionalCost(tickets.getAdditionalCost());
            sqlTicket.setCostumerId(sqlTicket.getCostumerId());
            sqlTicket.setTicketOfficeId(sqlTicket.getTicketOfficeId());
            sqlTicket.setTicketTypeId(sqlTicket.getTicketTypeId());

            String stmInsert = """
            UPDATE tbl_tickets
            SET nameTicket = ?,
                price = ?,
                status = ?,
                additionalCost = ?,
                costumerId = ?,
                ticketOfficeId = ?,
                ticketTypeId = ?
            WHERE ticketId = ?;
                    """;

            try(PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)){
                ps.setString(1, tickets.getNameTicket());
                ps.setString(3, tickets.getStatusEnum().name());
                ps.setDouble(4, tickets.getAdditionalCost());
                ps.setLong(5, tickets.getCostumerId());
                ps.setLong(6, tickets.getTicketOfficeId());
                ps.setLong(7, tickets.getTicketTypeId());
                ps.setLong(8, tickets.getTicketId());

                System.out.println(ps.toString());

                int rows = Operations.insert_update_delete_db(ps);
                if (rows <= 0){
                    System.out.println("Cannot update ticket");
                } else {
                    System.out.println("Successful update ticket");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("not found results ticket");
        }
    }

    @Override
    public void delete(long ticketId) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "DELETE FROM tbl_tickets WHERE ticketId = ?;";

        // use Operation class with insert_update_delete and verify if the rows in database are affected
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, ticketId);
            int rows = Operations.insert_update_delete_db(ps);
            if (rows > 0) {
                System.out.println("successful delete ticket");
                return;
            } else {
                System.out.println("not exists ticket");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("something was wrong on delete ticket");
        return;
    }

}

