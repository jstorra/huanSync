package com.u2team.huansync.establishment.cash.model.classes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DeuryZ
 */
public class Cash {
    private long cashId;
    private boolean state;
    private long managerId;
    private double openingAmount;
    private double closingAmount;
//    private ArrayList<Order> order;

    public Cash() {
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public double getOpeningAmount() {
        return openingAmount;
    }

    public void setOpeningAmount(double openingAmount) {
        this.openingAmount = openingAmount;
    }

    public double getClosingAmount() {
        return closingAmount;
    }

    public void setClosingAmount(double closingAmount) {
        this.closingAmount = closingAmount;
    }

    public long getCashId() {
        return cashId;
    }

    public void setCashId(long cashId) {
        this.cashId = cashId;
    }

    public long getManagerId() {
        return managerId;
    }

    public void setManagerId(long managerId) {
        this.managerId = managerId;
    }

//    public ArrayList<Order> getOrder() {
//        return order;
//    }

//    public void setOrder(ArrayList<Order> order) {
//        this.order = order;
//    }

    
}

