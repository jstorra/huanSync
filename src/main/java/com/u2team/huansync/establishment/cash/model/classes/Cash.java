package com.u2team.huansync.establishment.cash.model.classes;

import java.util.ArrayList;
import java.util.List;

/**
 * The Cash class represents a cash register within an establishment.
 * It contains information about the state of the cash register, the manager's identifier,
 * the opening amount, the closing amount, and the list of associated order identifiers.
 */
public class Cash {
    private long cashId;
    private boolean state;
    private long managerId;
    private double openingAmount;
    private double closingAmount;
    private List<Long> listOrderId;

    /**
     * Default constructor for the Cash class.
     */
    public Cash() {
    }

    /**
     * Constructor for the Cash class with parameters.
     *
     * @param cashId        Unique identifier of the cash register.
     * @param state         State of the cash register (active or inactive).
     * @param managerId     Identifier of the manager associated with the cash register.
     * @param openingAmount Opening amount of the cash register.
     * @param closingAmount Closing amount of the cash register.
     * @param listOrderId   List of order identifiers associated with the cash register.
     */
    public Cash(long cashId, boolean state, long managerId, double openingAmount, double closingAmount, List<Long> listOrderId) {
        this.cashId = cashId;
        this.state = state;
        this.managerId = managerId;
        this.openingAmount = openingAmount;
        this.closingAmount = closingAmount;
        this.listOrderId = listOrderId;
    }

    /**
     * Gets the state of the cash register.
     *
     * @return State of the cash register (true if active, false if inactive).
     */
    public boolean isState() {
        return state;
    }

    /**
     * Sets the state of the cash register.
     *
     * @param state New state of the cash register (true for active, false for inactive).
     */
    public void setState(boolean state) {
        this.state = state;
    }

    /**
     * Gets the opening amount of the cash register.
     *
     * @return Opening amount of the cash register.
     */
    public double getOpeningAmount() {
        return openingAmount;
    }

    /**
     * Sets the opening amount of the cash register.
     *
     * @param openingAmount New opening amount of the cash register.
     */
    public void setOpeningAmount(double openingAmount) {
        this.openingAmount = openingAmount;
    }

    /**
     * Gets the closing amount of the cash register.
     *
     * @return Closing amount of the cash register.
     */
    public double getClosingAmount() {
        return closingAmount;
    }

    /**
     * Sets the closing amount of the cash register.
     *
     * @param closingAmount New closing amount of the cash register.
     */
    public void setClosingAmount(double closingAmount) {
        this.closingAmount = closingAmount;
    }

    /**
     * Gets the unique identifier of the cash register.
     *
     * @return Unique identifier of the cash register.
     */
    public long getCashId() {
        return cashId;
    }

    /**
     * Sets the unique identifier of the cash register.
     *
     * @param cashId New unique identifier of the cash register.
     */
    public void setCashId(long cashId) {
        this.cashId = cashId;
    }

    /**
     * Gets the identifier of the manager associated with the cash register.
     *
     * @return Identifier of the manager associated with the cash register.
     */
    public long getManagerId() {
        return managerId;
    }

    /**
     * Sets the identifier of the manager associated with the cash register.
     *
     * @param managerId New identifier of the manager associated with the cash register.
     */
    public void setManagerId(long managerId) {
        this.managerId = managerId;
    }

    /**
     * Gets the list of order identifiers associated with the cash register.
     *
     * @return List of order identifiers associated with the cash register.
     */
    public List<Long> getListOrderId() {
        return listOrderId;
    }

    /**
     * Sets the list of order identifiers associated with the cash register.
     *
     * @param listOrderId New list of order identifiers associated with the cash register.
     */
    public void setListOrderId(List<Long> listOrderId) {
        this.listOrderId = listOrderId;
    }
}
