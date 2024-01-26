package com.u2team.huansync.establishment.cash.model.classes.builder;

import com.u2team.huansync.establishment.cash.model.classes.CashRegister;

public interface CashRegisterBuilder {

    CashRegisterBuilder statusCash(boolean statusCash);
    CashRegisterBuilder openingAmount(double openingAmount);
    CashRegisterBuilder closingAmount(double closingAmount);
    CashRegisterBuilder cashRegisterId(long cashRegisterId);
    CashRegisterBuilder establishmentsId(long establishmentsId);
    CashRegisterBuilder cashierOperatorId(long cashierOperatorId);
    CashRegister build();
}
