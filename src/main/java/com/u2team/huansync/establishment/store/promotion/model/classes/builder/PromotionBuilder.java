/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.u2team.huansync.establishment.store.promotion.model.classes.builder;

import com.u2team.huansync.establishment.store.promotion.model.classes.Promotion;


/**
 *
 * @author Kevin Jimenez
 */
public interface PromotionBuilder {
    
    //Se implemento builder porque son muchos atributos
    PromotionBuilder promotionId(long promotionId);
    PromotionBuilder namePromotion(String namePromotion);
    PromotionBuilder description(String description);
    PromotionBuilder statusPromotion(boolean statusPromotion);
    PromotionBuilder percent(int percent);
   
    
    Promotion build();

    public Object eventId(long aLong);
    
    
}
