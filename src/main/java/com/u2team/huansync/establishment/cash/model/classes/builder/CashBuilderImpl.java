/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u2team.huansync.establishment.cash.model.classes.builder;

import com.u2team.huansync.establishment.cash.model.classes.Cash;
import java.util.ArrayList;

/**
 *
 * @author DeuryZ
 */

public class CashBuilderImpl implements CashBuilder{
    
    private Cash cash = new Cash();
            

    @Override
    public CashBuilder state(boolean state) {
        cash.setState(false);
        return this;
    }

    public CashBuilder managerId(long managerId) {
        cash.setManagerId(managerId);
        return this;
    }

    @Override
    public CashBuilder openingAmount(double openingAmount) {
        cash.setOpeningAmount(openingAmount);
        return this;
    }

    @Override
    public CashBuilder closingAmount(double closingAmount) {
        cash.setClosingAmount(closingAmount);
        return this;
    }

    @Override
    public Cash build() {
        return cash;
    }

    public CashBuilder cashId(long cashId) {
        cash.setCashId(cashId);
        return this;
    }

//    @Override
//    public CashBuilder order(ArrayList<Order> order) {
//        cash.setOrder(order);
//        return this;
//    }
    
    
    
}
