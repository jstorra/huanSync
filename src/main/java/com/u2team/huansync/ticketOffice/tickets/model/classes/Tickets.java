package com.u2team.huansync.ticketOffice.tickets.model.classes;

public class Tickets {
    private long  ticketId;
    private String nameTicket;
    private double additionalCost;

    private StatusEnum statusEnum;
    private AgeClassificationEnum ageClassificationEnum;

    private long ticketTypeId;
    private long costumerId;
    private long ticketOfficeId;

    public long getTicketTypeId() {
        return ticketTypeId;
    }

    public void setTicketTypeId(long ticketTypeId) {
        this.ticketTypeId = ticketTypeId;
    }

    public long getCostumerId() {
        return costumerId;
    }

    public void setCostumerId(long costumerId) {
        this.costumerId = costumerId;
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

    public AgeClassificationEnum getAgeClassificationEnum() {
        return ageClassificationEnum;
    }

    public void setAgeClassificationEnum(AgeClassificationEnum ageClassificationEnum) {
        this.ageClassificationEnum = ageClassificationEnum;
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
}
