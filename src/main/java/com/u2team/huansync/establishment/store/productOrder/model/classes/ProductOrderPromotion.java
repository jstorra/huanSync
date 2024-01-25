/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u2team.huansync.establishment.store.productOrder.model.classes;

import com.u2team.huansync.establishment.DAO.ISaveDao;
import com.u2team.huansync.establishment.store.product.model.classes.Product;
import com.u2team.huansync.persistence.BDConnection;
import com.u2team.huansync.persistence.Operations;
import static java.awt.PageAttributes.MediaType.B;
import java.util.List;

/**
 *
 * @author sneiderEsteban
 */
public class ProductOrderPromotion extends ProductOrder implements ISaveDao {
    
    private long promocion; 
    
    
    
    public ProductOrderPromotion(long promocion, long orderId, long productId, int quantity) {
        super(orderId, productId, quantity);
        this.promocion = promocion;
    }

    @Override
    public void save(Object t) {
        

    }

   private List<Product> getAllProduct(Long orderId){
       Operations.setConnection(BDConnection.MySQLConnection());
       
       return null;
   }
    
    
    
}
