/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u2team.huansync.establishment.store.productOrder.model.classes;

import com.u2team.huansync.establishment.DAO.ISaveDao;
import com.u2team.huansync.establishment.store.product.controller.ProductController;
import com.u2team.huansync.establishment.store.product.model.classes.Product;
import com.u2team.huansync.persistence.BDConnection;
import com.u2team.huansync.persistence.Operations;
import java.sql.*;
import java.util.ArrayList;
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
    // en vez de id un ?   
        List<Product> productList = new ArrayList<>();
        String stm = "select * from tbl_product_order WHERE orderId = ?;";     
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)){
            ps.setLong(1, orderId);
            
            ResultSet rs = Operations.query_db(ps);
            
            while(rs.next()){
                productList.add(ProductController.getById(rs.getLong("productId")));
            }
            return productList;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    private double calcularSubtotalPedido(Long orderId){
        List<Product> productList = getAllProduct(orderId);

        double subtotal = 0; 
        if (productList != null && !productList.isEmpty()){
            
            for (Product product : productList){
              subtotal += product.getProductPrice() * getQuantity();
            }
            System.out.println("Subtotal del pedido:"+ subtotal);          
        } else {
            System.out.println("El pedido no contiene Productos");
                    
        }
        return subtotal;
        
    }
    
    private double calcularSubtotalPedido(int descPorcentaje,Long orderId){
        List<Product> productList = getAllProduct(orderId);
        
        double subtotal = 0; 
        if (productList != null && !productList.isEmpty()){
            
            for (Product product : productList){
                subtotal += product.getProductPrice() * getQuantity();
            }
          subtotal = subtotal - (subtotal * (descPorcentaje/100));
            System.out.println("Subtotal del pedido:"+ subtotal);          
        } else {
            System.out.println("El pedido no contiene Productos");
                    
        }
        return subtotal;
        
    }
    
    private void updateInventory(Long orderId){
        Operations.setConnection(BDConnection.MySQLConnection());
        String stmUpdate = "UPDATE tbl_product SET quantity = ? WHERE productId = ?";
        String stm = "SELECT * FROM tbl_product_order WHERE orderId = ?;";
        try(PreparedStatement ps = Operations.getConnection().prepareStatement(stm)){
            ps.setLong(1,orderId);
            ResultSet rs = Operations.query_db(ps);
            while(rs.next()){
                try(PreparedStatement psUpdate = Operations.getConnection().prepareStatement(stmUpdate)){
                    ps.setLong(2,rs.getInt("productId"));
                    Product pro = ProductController.getById(rs.getInt("productId"));
                    int calculado = pro.getQuantity() - rs.getInt("quantitiy");
                    ps.setInt(1,calculado);
                    ps.executeQuery();
                }catch(SQLException exUp){
                    exUp.printStackTrace();
                }
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
}


