/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u2team.huansync.establishment.store.product.model.DAO;

import com.u2team.huansync.establishment.DAO.IDeleteDao;
import com.u2team.huansync.establishment.DAO.ISaveDao;
import com.u2team.huansync.establishment.store.product.model.classes.Product;
import com.u2team.huansync.persistence.Operations;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Kevin Jimenez
 */
public class ProductDAO implements ISaveDao<Product>, IDeleteDao<Product>{

    //Conexion con la base de datos
    
    @Override
    public void save(Product product) {
        
        // Create a query and send corresponding information in each field by replacing the character "?" with the information
        String stmInsert = "INSERT INTO tbl_product(productId,productName,productPrice,description,manufacturer,typeProduct,quantity,storeId) VALUES(?,?,?,?,?,?,?,?);";
        
        //PreparedStatement es de sql y Operations de Mariño
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
            ps.setLong(1, product.getProductId());
            ps.setString(2, product.getNameProduct());
            ps.setDouble(3, product.getProductPrice());
            ps.setString(4, product.getDescription());
            ps.setString(5, product.getManufacturer());
            ps.setString(6, product.getType().name());
            ps.setInt(7, product.getQuantity());
            ps.setLong(8, product.getStoreId());

            // use Operation class with insert_update_delete and verify if the rows in database are affected
            int rows = Operations.insert_update_delete_db(ps);
            if (rows <= 0) {
                System.out.println("Cannot push event");
            } else {
                System.out.println("Successful push event");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    //Aca se creara el CRUB

    @Override
    public void delete(long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
