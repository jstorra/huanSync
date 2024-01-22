package com.u2team.huansync.ticketOffice.model;

public class TicketOffice {

    private long ticketOfficeId;
    private Event eventId;
    private boolean location;
    private String address;
    private String contactNumber;
    private Event staffId;
    
    public TicketOffice() {
    }
    
    
    public long getTicketOfficeId() {
        return ticketOfficeId;
    }

    public void setTicketOfficeId(long ticketOfficeId){
        this.ticketOfficeId = ticketOfficeId;
    }

    public Event getEventId() {
        return eventId;
    }


    public void setEventId(Event eventId) {
        this.eventId = eventId;
    }


    public Event getStaffId() {
        return staffId;
    }


    public void setStaffId(Event staffId) {
        this.staffId = staffId;
    }


    public boolean isLocation() {
        return location;
    }

    public void setLocation(boolean location) {
        this.location = location;
    }


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }


    @Override
    public String toString() {
        return "TicketOfficeId was assigned to:"+
                "\n ticketOfficeId: " + ticketOfficeId +
                "\n eventId: " + eventId + 
                "\n InPlace: " + location + 
                "\n Address: " + address + 
                "\n ContactNumber: " + contactNumber + 
                "\n staffId: " + staffId + 
                "****************************************";
    }    
}
