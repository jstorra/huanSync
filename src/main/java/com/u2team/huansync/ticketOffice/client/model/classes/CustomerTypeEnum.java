/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u2team.huansync.ticketOffice.client.model.classes;

/**
 *
 * @author SANTOS
 */
public enum CostumerTypeEnum {
    PARTICIPANT("Is a participant"),
    VISITOR("Is a visitor"),
    WINNER("Is a winner");
    
    private String description;

    private CostumerTypeEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
