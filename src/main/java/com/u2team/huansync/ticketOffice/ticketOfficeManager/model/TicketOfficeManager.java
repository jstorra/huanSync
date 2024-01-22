package com.u2team.huansync.ticketOffice.ticketOfficeManager.model;

//import com.u2team.huansync.ticketOffice.model.Event;
import com.u2team.huansync.ticketOffice.model.TicketOffice;

public class TicketOfficeManager {

    private TicketOffice ticketOffice;
    //private Event event;


    public TicketOfficeManager(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }


    public TicketOffice getTicketOffice() {
        return ticketOffice;
    }

    public void setTicketOffice(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;    
    }
}
