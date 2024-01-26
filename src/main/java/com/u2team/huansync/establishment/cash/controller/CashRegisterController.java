/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u2team.huansync.establishment.cash.controller;

import com.u2team.huansync.establishment.cash.model.DAO.CashRegisterDAO;
import com.u2team.huansync.establishment.cash.model.classes.CashRegister;
import java.util.List;

/**
 *
 * @author misae
 */
public class CashRegisterController {
    public final static CashRegisterDAO cashRegisterDAO = new CashRegisterDAO();
    
    public static void InsertCashRegister(CashRegister cashRegister){
        cashRegisterDAO.save(cashRegister);
    }
    
    public static CashRegister getByIdCashRegister(long id){
        return cashRegisterDAO.getById(id);
    }
    
    public static List<CashRegister> getAllCashRegister(){
        return cashRegisterDAO.getAll();
    }
}
