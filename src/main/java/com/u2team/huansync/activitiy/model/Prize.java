/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.u2team.huansync.activitiy.model;

/**
 *
 * @author viole
 */
public class Prize {

    //attributes
    public TypePrize typePrize; 
    public String description;
    public double price;
    public StatusPrize status;
    public Activity activity;
    public Costumer winner;
    
    //void constructor method
    public Prize(){
        
    }

    // getters
    public TypePrize getTypePrize() {
        return typePrize;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public StatusPrize getStatus() {
        return status;
    }

    public Activity getActivity() {
        return activity;
    }

    public Costumer getWinner() {
        return winner;
    }
    
    // setters

    public void setTypePrize(TypePrize typePrize) {
        this.typePrize = typePrize;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStatus(StatusPrize status) {
        this.status = status;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void setWinner(Costumer winner) {
        this.winner = winner;
    }
    
    
    
}
