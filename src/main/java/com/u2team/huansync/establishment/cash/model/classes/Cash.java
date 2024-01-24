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
    private List<Long> listOrderId;

    public Cash() {
    }

    public Cash(long cashId, boolean state, long managerId, double openingAmount, double closingAmount, List<Long> listOrderId) {
        this.cashId = cashId;
        this.state = state;
        this.managerId = managerId;
        this.openingAmount = openingAmount;
        this.closingAmount = closingAmount;
        this.listOrderId = listOrderId;
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

    public List<Long> getListOrderId() {
        return listOrderId;
    }

    public void setListOrderId(List<Long> listOrderId) {
        this.listOrderId = listOrderId;
    }

    
}

