package com.u2team.huansync.ticketOffice.controller;

import java.util.List;

import com.u2team.huansync.ticketOffice.model.DAO.TicketOfficeDAO;
import com.u2team.huansync.ticketOffice.model.classes.TicketOffice;

public class TicketOfficeController {
    
    private TicketOfficeDAO ticketOfficeDAO;

    public TicketOfficeController() {
        this.ticketOfficeDAO = new TicketOfficeDAO();
    }

    public TicketOffice getByIdTicketOffice(long ticketOfficeId){
        return ticketOfficeDAO.getById(ticketOfficeId);
    }

    public List<TicketOffice>  getAllTicketOffice(){
        return ticketOfficeDAO.getAllTicketOffice();

    }

    public void insertTicketOffice(TicketOffice ticketOffice){
        ticketOfficeDAO.insertTicketOffice(ticketOffice);
    }

    public void updateTicketOffice(TicketOffice ticketOffice){
        ticketOfficeDAO.updateTicketOffice(ticketOffice);
    }

    public void deleteTicketOffice(long ticketOfficeId){
        ticketOfficeDAO.deleteTicketOffice(ticketOfficeId);
    }  
}
