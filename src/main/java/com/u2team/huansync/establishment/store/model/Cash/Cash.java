/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u2team.huansync.establishment.store.model.Cash;

import com.u2team.huansync.establishment.store.model.Order.Order;
import java.util.List;

/**
 *
 * @author sneiderEsteban
 */

public class Cash {
    
    private long cashId; 
    private boolean state; 
    private long managerId; 
    private double openingAmount; 
    private double closingAmount; 
    private List<Order> order; 

    public Cash(long CashId, boolean state, long managerId, double openingAmount, double closingAmount, List<Order> order) {
        this.cashId = CashId;
        this.state = state;
        this.managerId = managerId;
        this.openingAmount = openingAmount;
        this.closingAmount = closingAmount;
        this.order = order;
    }
   
 public void stateCash(){
      
    while (state== false){
    
}
}
    
}
    
    


