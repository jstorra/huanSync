package com.u2team.huansync.ticketOffice.model.builders;

import com.u2team.huansync.ticketOffice.model.*;

public interface TicketOfficeBuilder {
    TicketOfficeBuilder ticketOfficeId(long ticketOfficeId);
    TicketOfficeBuilder eventId(Event eventId);
    TicketOfficeBuilder location(boolean location);
    TicketOfficeBuilder address(String address);
    TicketOfficeBuilder contactNumber(String contactNumber);
    TicketOfficeBuilder staffId(Event staffIdId);
    TicketOffice build();
}