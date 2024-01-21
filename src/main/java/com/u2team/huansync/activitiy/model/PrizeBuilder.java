/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.u2team.huansync.activitiy.model;

/**
 *
 * @author viole
 */
public interface PrizeBuilder {
    
    PrizeBuilder typePrize(Typeprize type);
    PrizeBuilder description (String description);
    PrizeBuilder price (double price);
    PrizeBuilder status (StatusPrize status);
    PrizeBuilder activity (Activity activity);
    PrizeBuilder winner (Costumer winner);
    Prize build();

    
    
    
}
