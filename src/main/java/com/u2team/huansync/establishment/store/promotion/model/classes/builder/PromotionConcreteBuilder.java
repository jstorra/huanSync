package com.u2team.huansync.establishment.store.promotion.model.classes.builder;


import com.u2team.huansync.establishment.store.promotion.model.classes.Promotion;
import com.u2team.huansync.establishment.store.promotion.model.classes.builder.PromotionBuilder;




//@author sneideresteban



public class PromotionConcreteBuilder implements PromotionBuilder{

    private Promotion promotion = new Promotion();
    
    
    @Override
    public PromotionBuilder promotionId(long promotionId) {
        promotion.setPromotionId(promotionId);
        return this; 

    }

    @Override
    public PromotionBuilder namePromotion(String namePromotion) {
        promotion.setNamePromotion(namePromotion); 
        return this; 
    }

    @Override
    public PromotionBuilder description(String description) {
        promotion.setDescription(description); 
        return this; 
    }

    @Override
    public PromotionBuilder statusPromotion(boolean statusPromotion) {
        promotion.setStatusPromotion(statusPromotion);
        return this; 
    }

    @Override
    public PromotionBuilder percent(int percent) {
        promotion.getPercent();
        return this;
              
    }

    @Override
    public Promotion build() {
        return promotion; 
    }

    @Override
    public Object eventId(long aLong) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    
}
