package com.u2team.huansync.ticketOffice.tickets.model.classes;

public enum AgeClassificationEnum {
    CHILD("It is a child"), TEEN("It is a teen"), ADULT("It is a adult");
    private String description;
    // Constructor Enum AgeClassification
    AgeClassificationEnum(String description) {
        this.description = description;
    }
    // Getters and Setters AgeClassification
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
