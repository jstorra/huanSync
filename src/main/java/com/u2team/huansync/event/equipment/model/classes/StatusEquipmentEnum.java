package com.u2team.huansync.event.equipment.model.classes;

/**
 * @author criis
 */
public enum StatusEquipmentEnum {
    IN_STOCK ("The item is on the warehouse"),
    ON_SITE ("The item is on the Event's Location");
    
    private String description;

    private StatusEquipmentEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}