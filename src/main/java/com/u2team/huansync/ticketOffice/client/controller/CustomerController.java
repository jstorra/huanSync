package com.u2team.huansync.ticketOffice.client.controller;

import com.u2team.huansync.ticketOffice.client.model.DAO.CostumerDAO;
import com.u2team.huansync.ticketOffice.client.model.classes.Costumer;

public class CostumerController {

    private CostumerDAO costumerDAO;

    public CostumerController()   {
        this.costumerDAO = new CostumerDAO();
    }
    
    public Costumer getById(long costumerId){
        return costumerDAO.getById(costumerId);
    }
    
    public void insertCostumer (Costumer costumer){
        costumerDAO.save(costumer);
    }
    
    public void deleteEvent(long costumerId){
        costumerDAO.delete(costumerId);
    }
    
    public void updateCostumer(Costumer costumer){
        costumerDAO.update(costumer);
    }
}
