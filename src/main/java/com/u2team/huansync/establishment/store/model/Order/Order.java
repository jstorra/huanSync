/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u2team.huansync.establishment.store.model.Order;

/**
 *
 * @author sneid
 */
public abstract class Order {
    // Customer y cash tiene que ser listados 
    private long orderId; 
    private int customerId; 
    private long establishmentId;
    private int cashId; 
    private StatusOrder status; 

    public Order(long orderId, int customerId, long establishmentId, int cashId, StatusOrder status) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.establishmentId = establishmentId;
        this.cashId = cashId;
        this.status = status;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public long getEstablishmentId() {
        return establishmentId;
    }

    public void setEstablishmentId(long establishmentId) {
        this.establishmentId = establishmentId;
    }

    public int getCashId() {
        return cashId;
    }

    public void setCashId(int cashId) {
        this.cashId = cashId;
    }

    public StatusOrder getStatus() {
        return status;
    }

    public void setStatus(StatusOrder status) {
        this.status = status;
    }
    
    
    
    
}
