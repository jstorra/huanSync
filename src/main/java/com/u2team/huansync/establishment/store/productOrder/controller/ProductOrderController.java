/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u2team.huansync.establishment.store.productOrder.controller;

import com.u2team.huansync.establishment.store.productOrder.model.DAO.ProductOrderDAO;
import com.u2team.huansync.establishment.store.productOrder.model.classes.ProductOrder;
import java.util.List;

/**
 *
 * @author Dereck Noa
 */
public class ProductOrderController {
    
    //Instanciar
    private static ProductOrderDAO productOrderDao = new ProductOrderDAO();
    
    //The methods that I created after the static or void "names" were called in HuanSync to test them
    //save, getAll and update are found in all Dao interfaces within the code
    public static void insertProductOrder(ProductOrder productOrder){
        productOrderDao.save(productOrder);
    }
    
    public static void deleteProductOrder(long productOrderId){
        productOrderDao.delete(productOrderId);
    }
    
    public static  List<ProductOrder> getAllProductOrder(){
        return productOrderDao.getAll();
    }
    
    public static ProductOrder getByIdProductOrder(long productOrderId){
        return productOrderDao.getById(productOrderId); 
    }
    
    public static void updateProductOrder(ProductOrder productOrder) {
        productOrderDao.update(productOrder);
    }
    
    
}
