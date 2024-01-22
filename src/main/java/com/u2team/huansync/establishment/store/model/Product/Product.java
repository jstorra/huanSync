/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u2team.huansync.establishment.store.model.Product;

/**
 *
 * @author sneiderEsteban
 */


import java.util.List; 

public class Product {

 private Long productId;
    private String productName;
    private String description;
    private Double unitPrice;
    private int quantity;
    private ProductType type;
    private String maker;
    private List<Discount> discount;

    public Product(Long productId, String productName, String description, Double unitPrice, int quantity, ProductType type, String maker, List<Discount> discount) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.type = type;
        this.maker = maker;
        this.discount = discount;
    }
   public String getDescription() {
        return description;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
class Inventory {
    private List<Product> products;

    public Inventory(List<Product> products) {
        this.products = products;
    }

    public void sellProduct(Long productId, int quantity) {
        for (Product product : products) {
            if (product.productId.equals(productId)) {
                int currentQuantity = product.getQuantity();
                product.setQuantity(currentQuantity - quantity);
                break;
            }
        }
    }
}
    
}
