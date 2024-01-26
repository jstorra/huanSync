package com.u2team.huansync.establishment.cash.model.classes;

/**
 * The Cash class represents a cash register within an establishment.
 * It contains information about the state of the cash register, the manager's identifier,
 * the opening amount, the closing amount, and the list of associated order identifiers.
 */
public class CashRegister {
    private long cashRegisterId ;
    private boolean statusCash ;
    private long cashierOperatorId;
    private double openingAmount;
    private double closingAmount ;
    private long establishmentsId;
    

    /**
     * Default constructor for the Cash class.
     */
    public CashRegister() {
    }

    public CashRegister(long cashRegisterId, boolean statusCash, long cashierOperatorId, double openingAmount, double closingAmount, long establishmentsId) {
        this.cashRegisterId = cashRegisterId;
        this.statusCash = statusCash;
        this.cashierOperatorId = cashierOperatorId;
        this.openingAmount = openingAmount;
        this.closingAmount = closingAmount;
        this.establishmentsId = establishmentsId;
    }
    
    

    public long getCashRegisterId() {
        return cashRegisterId;
    }

    public void setCashRegisterId(long cashRegisterId) {
        this.cashRegisterId = cashRegisterId;
    }

    public boolean isStatusCash() {
        return statusCash;
    }

    public void setStatusCash(boolean statusCash) {
        this.statusCash = statusCash;
    }

    public long getCashierOperatorId() {
        return cashierOperatorId;
    }

    public void setCashierOperatorId(long cashierOperatorId) {
        this.cashierOperatorId = cashierOperatorId;
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

    public long getEstablishmentsId() {
        return establishmentsId;
    }

    public void setEstablishmentsId(long establishmentsId) {
        this.establishmentsId = establishmentsId;
    }

    @Override
    public String toString() {
        return "CashRegister{" + "cashRegisterId=" + cashRegisterId + ", statusCash=" + statusCash + ", cashierOperatorId=" + cashierOperatorId + ", openingAmount=" + openingAmount + ", closingAmount=" + closingAmount + ", establishmentsId=" + establishmentsId + '}';
    }

    
}
