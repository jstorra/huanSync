/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.u2team.huansync.establishment.store.product.model.classes.builder;

import com.u2team.huansync.establishment.store.product.model.classes.Product;

/**
 *
 * @author Kevin Jimenez
 */
public interface ProductBuilder {
    
    //Se implemento builder porque son muchos atributos
    ProductBuilder productId(long productId);
    ProductBuilder storeId(long storeId);
    ProductBuilder nameProduct(String nameProduct);
    ProductBuilder productPrice(Double productPrice);
    ProductBuilder description(String description);
    ProductBuilder manufacturer(String manufacturer);
    ProductBuilder quantity(int quantity);
    
    //Este que es enum se coloca en String
    ProductBuilder type(String type);
    
    Product build();
    
    
}
