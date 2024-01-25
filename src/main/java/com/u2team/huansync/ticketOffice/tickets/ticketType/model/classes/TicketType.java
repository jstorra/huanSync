package com.u2team.huansync.ticketOffice.tickets.ticketType.model.classes;

public class TicketType {
    private long ticketTypeId;
    private String nameTicketType;
    private String description;
    private double price;

    public TicketType() {
    }

    
    
    public TicketType(long ticketTypeId, String nameTicketType, String description, double price) {
        this.ticketTypeId = ticketTypeId;
        this.nameTicketType = nameTicketType;
        this.description = description;
        this.price = price;
    }

    
    
    public long getTicketTypeId() {
        return ticketTypeId;
    }

    public void setTicketTypeId(long ticketTypeId) {
        this.ticketTypeId = ticketTypeId;
    }

    public String getNameTicketType() {
        return nameTicketType;
    }

    public void setNameTicketType(String nameTicketType) {
        this.nameTicketType = nameTicketType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "TicketType{" +
                "ticketTypeId=" + ticketTypeId +
                ", nameTicketType='" + nameTicketType + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
