/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u2team.huansync.establishment.store.product.model.DAO;

import com.u2team.huansync.establishment.DAO.ISaveDao;
import com.u2team.huansync.establishment.store.product.model.classes.Product;
import com.u2team.huansync.persistence.Operations;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Kevin Jimenez
 */
public class ProductDAO implements ISaveDao<Product>{

    //Conexion con la base de datos
    
    @Override
    public void save(Product product) {
        
        // Create a query and send corresponding information in each field by replacing the character "?" with the information
        String stmInsert = "INSERT INTO tbl_product(productName,productPrice,description,manufacturer,typeProduct,quantity,storeId) VALUES(?,?,?,?,?,?,?);";
        
        //PreparedStatement es de sql y Operations de Mariño
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
            ps.setString(1, product.getNameProduct());
            ps.setDouble(2, product.getProductPrice());
            ps.setString(3, product.getDescription());
            ps.setString(4, product.getManufacturer());
            ps.setString(5, product.getType().name());
            ps.setInt(6, product.getQuantity());
            ps.setLong(7, product.getStoreId());

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
    
    
    
}
