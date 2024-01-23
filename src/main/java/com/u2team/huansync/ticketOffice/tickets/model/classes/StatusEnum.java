package com.u2team.huansync.ticketOffice.tickets.model.classes;

public enum StatusEnum {
    RESERVED("It is reserved"), PAID("It is paid");
    private String description;

    // Constructor Enum status
    StatusEnum(String description) {
        this.description = description;
    }
    // Getters and setters status
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
