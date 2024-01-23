package com.u2team.huansync.ticketOffice.controller;

import java.util.List;

import com.u2team.huansync.ticketOffice.model.DAO.TicketOfficeDAO;
import com.u2team.huansync.ticketOffice.model.classes.TicketOffice;

public class TicketOfficeController {
    
    private static TicketOfficeDAO ticketOfficeDAO = new TicketOfficeDAO();

    public static TicketOffice getByIdTicketOffice(long ticketOfficeId){
        return ticketOfficeDAO.getById(ticketOfficeId);
    }

    public static List<TicketOffice>  getAllTicketOffice(){
        return ticketOfficeDAO.getAllTicketOffice();

    }

    public static void insertTicketOffice(TicketOffice ticketOffice){
        ticketOfficeDAO.insertTicketOffice(ticketOffice);
    }

    public static void updateTicketOffice(TicketOffice ticketOffice){
        ticketOfficeDAO.updateTicketOffice(ticketOffice);
    }

    public static void deleteTicketOffice(long ticketOfficeId){
        ticketOfficeDAO.deleteTicketOffice(ticketOfficeId);
    }  
}
