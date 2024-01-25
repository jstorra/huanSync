/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u2team.huansync.establishment.order.model.classes;

/**
 *
 * @author Dereck Noa
 */
public class Order {

    private long orderId;
    private int customerId;
    private int establishmentId;
    private int cashRegisterId;
    private int cashierOperatorId;
    private OrderStatusEnum orderStatusEnum;

    //Empty Constructor 
    public Order() {

    }

    //Constructor
    public Order(long orderId, int customerId, int establishmentId, int cashId, int cashierOperatorId, String orderStatusEnum) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.establishmentId = establishmentId;
        this.cashRegisterId = cashId;
        this.cashierOperatorId = cashierOperatorId;
        this.orderStatusEnum = getOrderStatusEnum(orderStatusEnum);
    }

    //Getters and Setters
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

    public int getEstablishmentId() {
        return establishmentId;
    }

    public void setEstablishmentId(int establishmentId) {
        this.establishmentId = establishmentId;
    }

    public int getCashId() {
        return cashRegisterId;
    }

    public void setCashId(int cashId) {
        this.cashRegisterId = cashId;
    }

    public int getCashierOperatorId() {
        return cashierOperatorId;
    }

    public void setCashierOperatorId(int cashierOperatorId) {
        this.cashierOperatorId = cashierOperatorId;
    }

    //It's time to overwrite 2 times
    public void setOrderStatusEnum(OrderStatusEnum orderStatusEnum) {
        this.orderStatusEnum = orderStatusEnum;
    }

    public OrderStatusEnum getOrderStatusEnum(String orderStatus) {
        OrderStatusEnum oStatusEnum = null;
        if (orderStatus.equalsIgnoreCase("REGISTERED")) {
            oStatusEnum = OrderStatusEnum.REGISTERED;
        }
        if (orderStatus.equalsIgnoreCase("PAID")) {
            oStatusEnum = OrderStatusEnum.PAID;
        }
        if (orderStatus.equalsIgnoreCase("DELIVERED")) {
            oStatusEnum = OrderStatusEnum.DELIVERED;
        }
        return oStatusEnum;
    }

    //To String
    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", customerId=" + customerId + ", establishmentId=" + establishmentId + ", cashId=" + cashRegisterId + ", cashierOperatorId=" + cashierOperatorId + ", orderStatusEnum=" + orderStatusEnum + '}';
    }

    public OrderStatusEnum getOrderStatusEnum() {
        return orderStatusEnum;
    }

}
