/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u2team.huansync.establishment.store.model.Order;

import com.u2team.huansync.establishment.store.model.Product.Product;
import java.util.List;

/**
 *
 * @author sneiderEsteban
 */
public class OrderStore extends Order {
    
    public OrderStore(long orderId, int customerId, long establishmentId, int cashId, StatusOrder status) {
        super(orderId, customerId, establishmentId, cashId, status);
    }
    
      private List<Product> productOrdered;
    
    
}
