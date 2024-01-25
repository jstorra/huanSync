/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u2team.huansync.establishment.restaurant.itemMenuOrder.model.classes;

/**
 *
 * @author dfrincong
 */
public class ItemMenuOrder {
    private long orderId;
    private long itemMenuId;
    private int quantity;

    public ItemMenuOrder() {
    }

    public ItemMenuOrder(long orderId, long itemMenuId, int quantity) {
        this.orderId = orderId;
        this.itemMenuId = itemMenuId;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getItemMenuId() {
        return itemMenuId;
    }

    public void setItemMenuId(long itemMenuId) {
        this.itemMenuId = itemMenuId;
    }

    @Override
    public String toString() {
        return "ItemMenuOrder{" + 
                "orderId=" + orderId + 
                ", itemMenuId=" + itemMenuId +
                ", quantity=" + quantity + '}';
    }
}
