/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u2team.huansync.establishment.store.model.Product;

/**
 *
 * @author sneiderEsteban
 */


//import com.u2team.huansync.establishment.store.model.Discount.Discount;

//import java.util.List; 

public class Product {

    private Long productId;
    private int establishmentid; 
    private String productName;
    private Double productPrice;
    private String description;
    private String manufacturer; 
    private int quantity;
    private TypeProduct type;

    public Product(Long productId, int establishmentid, String productName, Double productPrice, String description, String manufacturer, int quantity, TypeProduct type) {
        this.productId = productId;
        this.establishmentid = establishmentid;
        this.productName = productName;
        this.productPrice = productPrice;
        this.description = description;
        this.manufacturer = manufacturer;
        this.quantity = quantity;
        this.type = type;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getEstablishmentid() {
        return establishmentid;
    }

    public void setEstablishmentid(int establishmentid) {
        this.establishmentid = establishmentid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public TypeProduct getType() {
        return type;
    }

    public void setType(TypeProduct type) {
        this.type = type;
    }

 
    
    
}
