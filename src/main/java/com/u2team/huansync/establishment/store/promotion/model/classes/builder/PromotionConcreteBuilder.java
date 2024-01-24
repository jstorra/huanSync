package com.u2team.huansync.establishment.store.promotion.model.classes.builder;


import com.u2team.huansync.establishment.store.promotion.model.classes.Promotion;
import com.u2team.huansync.establishment.store.promotion.model.classes.builder.PromotionBuilder;




//@author sneideresteban


// FALTA TERMINAR 

public class PromotionConcreteBuilder implements PromotionBuilder{

    private Promotion promotion = new Promotion();
    
    
    @Override
    public PromotionBuilder promotionId(long promotionId) {
        promotion.setPromotionId(promotionId);
        return this; 

    }

    @Override
    public PromotionBuilder namePromotion(String namePromotion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PromotionBuilder description(String description) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PromotionBuilder statusPromotion(boolean statusPromotion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PromotionBuilder percent(int percent) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Promotion build() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object eventId(long aLong) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
   
    
}
