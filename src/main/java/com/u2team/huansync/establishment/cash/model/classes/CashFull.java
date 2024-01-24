/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u2team.huansync.establishment.cash.model.classes;

import java.util.List;

/**
 *
 * @author user
 */
public class CashFull extends Cash{
    private List<Long> listOrders;

    public CashFull(List<Long> listOrders) {
        this.listOrders = listOrders;
    }

    public CashFull(List<Long> listOrders, long cashId, boolean state, long managerId, double openingAmount, double closingAmount, List<Long> listOrderId) {
        super(cashId, state, managerId, openingAmount, closingAmount, listOrderId);
        this.listOrders = listOrders;
    }

    public List<Long> getListOrders() {
        return listOrders;
    }

    public void setListOrders(List<Long> listOrders) {
        this.listOrders = listOrders;
    }

    
}
