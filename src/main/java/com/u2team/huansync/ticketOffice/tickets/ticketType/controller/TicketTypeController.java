package com.u2team.huansync.ticketOffice.tickets.ticketType.controller;

import com.u2team.huansync.ticketOffice.tickets.ticketType.model.DAO.TicketTypeDAO;
import com.u2team.huansync.ticketOffice.tickets.ticketType.model.classes.TicketType;

import java.util.List;

public class TicketTypeController {
    private TicketTypeDAO ticketTypeDAO;

    public TicketTypeController() {
        this.ticketTypeDAO = new TicketTypeDAO();
    }

    public TicketType getByIdTicketType (long ticketTypeId){
        return ticketTypeDAO.getById(ticketTypeId);
    }

    public List<TicketType> getAllTicketType (){
        return ticketTypeDAO.getAll();
    }

    public void insertTicketType(TicketType ticketType){
        ticketTypeDAO.save(ticketType);
    }

    public void updateTicketType(TicketType ticketType){
        ticketTypeDAO.update(ticketType);
    }

    public void deleteTicketType(long ticketTypeId){
        ticketTypeDAO.delete(ticketTypeId);
    }
}
