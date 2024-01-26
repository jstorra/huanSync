/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.u2team.huansync.establishment.order.model.classes;

/**
 *
 * @author Kevin Dwight
 */
public enum OrderStatusEnum {
    
    //Modified
    REGISTERED("REGISTERED"), // The order has been placed and recorded in the system.
    PAID("PAID"),       // The order has been paid for by the customer.
    DELIVERED("DELIVERED");   // The order has been delivered to the customer.
    
    private String name;
    
    private OrderStatusEnum(String name) {
        this.name = name;
    }
    
    public String getNameOrder() {
        return name;
    }
}
