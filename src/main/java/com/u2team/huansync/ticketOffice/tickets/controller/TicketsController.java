package com.u2team.huansync.ticketOffice.tickets.controller;

import com.u2team.huansync.ticketOffice.tickets.model.DAO.TicketsDAO;
import com.u2team.huansync.ticketOffice.tickets.model.classes.Tickets;

import java.util.List;

public class TicketsController {
    private static TicketsDAO ticketsDAO = new TicketsDAO();

    public static Tickets getById(long ticketsId){
        return ticketsDAO.getById(ticketsId);
    }

    public static List<Tickets> getAllTickets(){
        return ticketsDAO.getAll();
    }

    public static void insertTickets(Tickets tickets){
        ticketsDAO.save(tickets);
    }

    public static void deleteTickets(long ticketsId){
        ticketsDAO.delete(ticketsId);
    }

    public static void updateTickets(Tickets tickets){
        ticketsDAO.update(tickets);
    }
}
