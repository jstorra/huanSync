package com.u2team.huansync.ticketOffice.tickets.controller;

import com.u2team.huansync.ticketOffice.tickets.model.DAO.TicketsDAO;
import com.u2team.huansync.ticketOffice.tickets.model.classes.Tickets;

import java.util.List;

public class TicketsController {
    private TicketsDAO ticketsDAO;

    public TicketsController(){
        this.ticketsDAO = new TicketsDAO();
    }

    public Tickets getById(long ticketsId){
        return ticketsDAO.getById(ticketsId);
    }

    public List<Tickets> getAllTickets(){
        return ticketsDAO.getAll();
    }

    public void insertTickets(Tickets tickets){
        ticketsDAO.save(tickets);
    }

    public void deleteTickets(long ticketsId){
        ticketsDAO.delete(ticketsId);
    }

    public void updateTickets(Tickets tickets){
        ticketsDAO.update(tickets);
    }
}
