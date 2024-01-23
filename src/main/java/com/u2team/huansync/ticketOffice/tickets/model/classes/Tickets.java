package com.u2team.huansync.ticketOffice.tickets.model.classes;

public class Tickets {
    private long  ticketId;
    private String nameTicket;
    private double additionalCost;

    private StatusEnum statusEnum;

    private long ticketTypeId;
    private long customerId;
    private long ticketOfficeId;

    public long getTicketTypeId() {
        return ticketTypeId;
    }

    public void setTicketTypeId(long ticketTypeId) {
        this.ticketTypeId = ticketTypeId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getTicketOfficeId() {
        return ticketOfficeId;
    }

    public void setTicketOfficeId(long ticketOfficeId) {
        this.ticketOfficeId = ticketOfficeId;
    }

    public StatusEnum getStatusEnum() {
        return statusEnum;
    }

    public void setStatusEnum(StatusEnum statusEnum) {
        this.statusEnum = statusEnum;
    }

    public String getNameTicket() {
        return nameTicket;
    }

    public void setNameTicket(String nameTicket) {
        this.nameTicket = nameTicket;
    }

    public double getAdditionalCost() {
        return additionalCost;
    }

    public void setAdditionalCost(double additionalCost) {
        this.additionalCost = additionalCost;
    }

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "ticketId=" + ticketId +
                ", nameTicket='" + nameTicket + '\'' +
                ", additionalCost=" + additionalCost +
                ", statusEnum=" + statusEnum +
                ", ticketTypeId=" + ticketTypeId +
                ", customerId=" + customerId +
                ", ticketOfficeId=" + ticketOfficeId +
                '}';
    }
}
