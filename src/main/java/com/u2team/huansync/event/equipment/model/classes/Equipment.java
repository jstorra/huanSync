package com.u2team.huansync.event.equipment.model.classes;

/**
 *
 * @author criis
 */
public class Equipment {
    private long equipmentId;
    private String nameEquipment;
    private long quantity;
    private StatusEquipmentEnum statusEquipmentEnum;

    public Equipment() {
    }

    
    public Equipment(long equipmentId, String nameEquipment, long quantity, StatusEquipmentEnum statusEquipmentEnum) {
        this.equipmentId = equipmentId;
        this.nameEquipment = nameEquipment;
        this.quantity = quantity;
        this.statusEquipmentEnum = statusEquipmentEnum;
    }

    public long getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(long equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getNameEquipment() {
        return nameEquipment;
    }

    public void setNameEquipment(String nameEquipment) {
        this.nameEquipment = nameEquipment;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
     public StatusEquipmentEnum getStatusEquipmentEnum (){
        return statusEquipmentEnum;
    }


    public StatusEquipmentEnum getStatusEquipmentEnum( String statusEquipmentEnum ) {
        StatusEquipmentEnum statusEquipment = null;

        if( statusEquipmentEnum.equalsIgnoreCase("ON_SITE")   ){
            statusEquipment = StatusEquipmentEnum.ON_SITE;
        }
        if( statusEquipmentEnum.equalsIgnoreCase("IN_SITE")  ){
            statusEquipment = StatusEquipmentEnum.IN_STOCK;
        }

        return statusEquipment;
    }
    
   
    public void setStatusEquipmentEnum(StatusEquipmentEnum statusEquipmentEnum) {
        this.statusEquipmentEnum = statusEquipmentEnum;
    }

    @Override
    public String toString() {
        return "Equipment{" + "equipmentId=" + equipmentId + ", nameEquipment=" + nameEquipment + ", quantity=" + quantity + ", statusEquipmentEnum=" + statusEquipmentEnum + '}';
    }
}
