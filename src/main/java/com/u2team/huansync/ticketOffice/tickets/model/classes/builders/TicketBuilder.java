package com.u2team.huansync.ticketOffice.tickets.model.classes.builders;


import com.u2team.huansync.ticketOffice.tickets.model.classes.Tickets;

public interface TicketBuilder {
    TicketBuilder ticketId(long ticketId);
    TicketBuilder nameTicket(String nameTicket);
    TicketBuilder additionalCost(double additionalCost);
    TicketBuilder statusEnum(String statusEnum);
    TicketBuilder ageClassificationEnum(String ageClassificationEnum);
    TicketBuilder ticketTypeId(long ticketTypeId);
    TicketBuilder costumerId(long costumerId);
    TicketBuilder ticketOfficeId(long ticketOfficeId);

    Tickets buid();


}
