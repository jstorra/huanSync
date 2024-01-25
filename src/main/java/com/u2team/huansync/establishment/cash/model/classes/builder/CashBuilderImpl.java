package com.u2team.huansync.establishment.cash.model.classes.builder;
import com.u2team.huansync.establishment.cash.model.classes.CashRegister;

public class CashBuilderImpl implements CashRegisterBuilder {

    private CashRegister cash;

    public CashBuilderImpl(CashRegister cash) {
        this.cash = new CashRegister();
    }

    @Override
    public CashRegisterBuilder statusCash(boolean statusCash) {
        cash.setStatusCash(statusCash);
        return this;
    }

    @Override
    public CashRegisterBuilder openingAmount(double openingAmount) {
        cash.setOpeningAmount(openingAmount);
        return this;
    }

    @Override
    public CashRegisterBuilder closingAmount(double closingAmount) {
        cash.setClosingAmount(closingAmount);
        return this;
    }

    @Override
    public CashRegisterBuilder cashRegisterId(long cashRegisterId) {
        cash.setCashRegisterId(cashRegisterId);
        return this;
    }

    @Override
    public CashRegisterBuilder establishmentsId(long establishmentsId) {
        cash.setEstablishmentsId(establishmentsId);
        return this;
    }

    @Override
    public CashRegisterBuilder cashierOperatorId(long cashierOperatorId) {
        cash.setCashierOperatorId(cashierOperatorId);
        return this;
    }
    @Override
    public CashRegister build() {
        return cash;
    }

}
