/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u2team.huansync.establishment.store.product.model.classes;

/**
 *
 * @author Kevin Jimenez and sneiderEsteban
 */
public class Product {
    
    private long productId;
    private long storeId;
    private String nameProduct;
    private Double productPrice;
    private String description;
    private String manufacturer; 
    private int quantity;
    private TypeProductEnum type;
    
    //Constructor vacio y uno lleno con todo
    public Product() {
        
    }

    public Product(long productId, long storeId, String nameProduct, Double productPrice, String description, String manufacturer, int quantity, TypeProductEnum type) {
        this.productId = productId;
        this.storeId = storeId;
        this.nameProduct = nameProduct;
        this.productPrice = productPrice;
        this.description = description;
        this.manufacturer = manufacturer;
        this.quantity = quantity;
        this.type = type;
    }
    
    //Getters y setters
    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getStoreId() {
        return storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
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

    public TypeProductEnum getType() {
        return type;
    }

    public void setType(TypeProductEnum type) {
        this.type = type;
    }
    
    //to String
    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", storeId=" + storeId + ", nameProduct=" + nameProduct + ", productPrice=" + productPrice + ", description=" + description + ", manufacturer=" + manufacturer + ", quantity=" + quantity + ", type=" + type + '}';
    }
    
    

}
