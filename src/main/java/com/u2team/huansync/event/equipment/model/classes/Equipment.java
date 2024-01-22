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

    
    public Equipment(long equipmentId, String nameEquipment, long quantity, String statusEquipmentEnum) {
        this.equipmentId = equipmentId;
        this.nameEquipment = nameEquipment;
        this.quantity = quantity;
        this.statusEquipmentEnum = getStatusEquipmentEnum(statusEquipmentEnum);
    }


    public void setStatusEquipmentEnum(StatusEquipmentEnum statusEquipmentEnum) {
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
    
    public StatusEquipmentEnum getStatusEquipmentEnum(String statusEquipmentEnum) {
        StatusEquipmentEnum statusEnum = null;
                
        if (statusEquipmentEnum.equalsIgnoreCase("in_stock")){
            statusEnum = StatusEquipmentEnum.IN_STOCK;
         }
         if (statusEquipmentEnum.equalsIgnoreCase("on _site")){
              statusEnum = StatusEquipmentEnum.ON_SITE;
         }
         return statusEnum;
    }

    
    @Override
    public String toString() {
        return "Equipment{" + "equipmentId=" + equipmentId + ", nameEquipment=" + nameEquipment + ", quantity=" + quantity + ", statusEquipmentEnum=" + statusEquipmentEnum + '}';
    }
    
    
    
}
