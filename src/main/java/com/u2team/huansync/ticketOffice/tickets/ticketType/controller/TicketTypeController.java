package com.u2team.huansync.ticketOffice.tickets.ticketType.controller;

import com.u2team.huansync.ticketOffice.tickets.ticketType.model.DAO.TicketTypeDAO;
import com.u2team.huansync.ticketOffice.tickets.ticketType.model.classes.TicketType;

import java.util.List;

public class TicketTypeController {
    private static TicketTypeDAO ticketTypeDAO = new TicketTypeDAO();

    public static TicketType getByIdTicketType (long ticketTypeId){
        return ticketTypeDAO.getById(ticketTypeId);
    }

    public static List<TicketType> getAllTicketType (){
        return ticketTypeDAO.getAll();
    }

    public static void insertTicketType(TicketType ticketType){
        ticketTypeDAO.save(ticketType);
    }

    public static void updateTicketType(TicketType ticketType){
        ticketTypeDAO.update(ticketType);
    }

    public static void deleteTicketType(long ticketTypeId){
        ticketTypeDAO.delete(ticketTypeId);
    }
}
