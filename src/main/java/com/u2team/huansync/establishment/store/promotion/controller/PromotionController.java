package com.u2team.huansync.establishment.store.promotion.controller;

import com.u2team.huansync.establishment.store.promotion.model.DAO.PromotionDAO;
import com.u2team.huansync.establishment.store.promotion.model.classes.Promotion;


//@author sneideresteban
public class PromotionController {
    
    //Instanciar
    private static PromotionDAO promotionDAO = new PromotionDAO();
    
    //The methods that I created after the static or void "names" were called in HuanSync to test them
    //save, getAll y update se encuentran en todas las interfaces de Dao dentro del codigo
    public static void insertProduct(Promotion promotion){
        promotionDAO.save(promotion);
    }
    public static void delete(long promotionId){
        promotionDAO.delete(promotionId);
        
    }
 
    
    public static Promotion getById(long promotionId){
        return promotionDAO.getById(promotionId); 
    }
    
    
     public static void updateProduct(Promotion promotion) {
        promotionDAO.update(promotion);
    }
  
    
}