/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u2team.huansync.establishment.store.product.controller;

import com.u2team.huansync.establishment.store.product.model.DAO.ProductDAO;
import com.u2team.huansync.establishment.store.product.model.classes.Product;

/**
 *
 * @author Dereck Noa
 */
public class ProductController {
    
    //Instanciar
    private static ProductDAO productDAO = new ProductDAO();
    
    public static void insertProduct(Product product){
        productDAO.save(product);
    }
}
