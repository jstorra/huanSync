package com.u2team.huansync.establishment.store.promotion.model.classes;

import com.u2team.huansync.establishment.store.product.model.classes.Product;


//
//@author sneideresteban
//

public class Promotion{
    private long promotionId;
    private String namePromotion; 
    private String description ; 
    private boolean statusPromotion; 
    private int percent; 

    public Promotion() {
    }

    
    public Promotion(long promotionId, String namePromotion, String description, boolean statusPromotion, int percent) {
        this.promotionId = promotionId;
        this.namePromotion = namePromotion;
        this.description = description;
        this.statusPromotion = statusPromotion;
        this.percent = percent;
    }
    
    public long getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(long promotionId) {
        this.promotionId = promotionId;
    }

    public String getNamePromotion() {
        return namePromotion;
    }

    public void setNamePromotion(String namePromotion) {
        this.namePromotion = namePromotion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatusPromotion() {
        return statusPromotion;
    }

    public void setStatusPromotion(boolean statusPromotion) {
        this.statusPromotion = statusPromotion;
    }

    @Override
    public String toString() {
        return "Promotion{" + "promotionId=" + promotionId + ", namePromotion=" + namePromotion + ", description=" + description + ", statusPromotion=" + statusPromotion + ", percent=" + percent + '}';
    }
    
    

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

   
    
    
} 