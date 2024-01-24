/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u2team.huansync.establishment.store.product.model.classes.builder;

import com.u2team.huansync.establishment.store.product.model.classes.Product;
import com.u2team.huansync.establishment.store.product.model.classes.TypeProductEnum;

/**
 *
 * @author Dereck Noa
 */
public class ProductConcreteBuilder implements ProductBuilder{

    private Product product = new Product();
    
    @Override
    public ProductBuilder productId(long productId) {
        product.setProductId(productId);
        return this;
    }

    @Override
    public ProductBuilder storeId(long storeId) {
        product.setStoreId(storeId);
        return this;
    }

    @Override
    public ProductBuilder nameProduct(String nameProduct) {
        product.setNameProduct(nameProduct);
        return this;
    }

    @Override
    public ProductBuilder productPrice(Double productPrice) {
        product.setProductPrice(productPrice);
        return this;
    }

    @Override
    public ProductBuilder description(String description) {
        product.setDescription(description);
        return this;
    }

    @Override
    public ProductBuilder manufacturer(String manufacturer) {
        product.setManufacturer(manufacturer);
        return this;
    }

    @Override
    public ProductBuilder quantity(int quantity) {
        product.setQuantity(quantity);
        return this;
    }
    
    //Esto es con el enum
    //Creo que por cada Enum se debe hacer algo diferente
    @Override
    public ProductBuilder type(String type) {
        
        if(type.equalsIgnoreCase("MANGA")){
            product.setType(TypeProductEnum.MANGA);
        }
        
        if(type.equalsIgnoreCase("MULTIMEDIA")){
            product.setType(TypeProductEnum.MULTIMEDIA);
        }
        
        if(type.equalsIgnoreCase("ART")){
            product.setType(TypeProductEnum.ART);
        }
        
        if(type.equalsIgnoreCase("FIGURES")){
            product.setType(TypeProductEnum.FIGURES);
        }
        
        if(type.equalsIgnoreCase("SOUVENIERS")){
            product.setType(TypeProductEnum.SOUVENIRS);
        }
        
        if(type.equalsIgnoreCase("CLOTHING")){
            product.setType(TypeProductEnum.CLOTHING);
        }
        
        if(type.equalsIgnoreCase("TECHNOLOGY")){
            product.setType(TypeProductEnum.TECHNOLOGY);
        }
        
        return this;
    }

    @Override
    public Product build() {
        //Si esta bien
        return product;
    }

    @Override
    public Object eventId(long aLong) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
