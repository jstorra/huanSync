/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u2team.huansync.establishment.store.product.model.DAO;

import com.u2team.huansync.establishment.DAO.IDeleteDao;
import com.u2team.huansync.establishment.DAO.IGetAllDao;
import com.u2team.huansync.establishment.DAO.IGetByIdDao;
import com.u2team.huansync.establishment.DAO.ISaveDao;
import com.u2team.huansync.establishment.DAO.IUpdateDao;
import com.u2team.huansync.establishment.store.product.model.classes.Product;
import com.u2team.huansync.establishment.store.product.model.classes.builder.ProductBuilder;
import com.u2team.huansync.establishment.store.product.model.classes.builder.ProductConcreteBuilder;
import com.u2team.huansync.persistence.BDConnection;
import com.u2team.huansync.persistence.Operations;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kevin Jimenez
 */
public class ProductDAO implements ISaveDao<Product>, IDeleteDao<Product>, IGetAllDao<Product>,IUpdateDao<Product>,IGetByIdDao<Product>{

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
   
   
    //Aca se creara el CRUD
    
    // CRUD DELETE 

    @Override
    public void delete(long productId) {
      Operations.setConnection(BDConnection.MySQLConnection());
      String stm = "DELETE FROM tbl_product WHERE productId = ?;";
      try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, productId);
            int rows = Operations.insert_update_delete_db(ps);
            if (rows > 0) {
                System.out.println("successful delete event");
                return;
            } else {
                System.out.println("not exists event");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("something was wrong on delete event");
        return;
    }

        // CRUD AND getall
    @Override
    public List<Product> getAll() {
           List<Product> productList = new ArrayList<>();
          Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "SELECT * FROM tbl_product";
           try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ResultSet rs = Operations.query_db(ps);

            // As long as there is a row of data in the query, it will execute:
            while (rs.next()) {

                // Create builder with concrete Builder -> (Concrete builder creates the object step by step)
                ProductBuilder eventBuilder = new ProductConcreteBuilder();

                // Creates an event object and constructs it using the information from the query(rs) (field by field)
                Product sqlProduct = eventBuilder
                        .productId(rs.getLong("productId"))
                        .nameProduct(rs.getString("productName"))
                        .storeId(rs.getLong("storeId"))
                        .productPrice(rs.getDouble("productPrice"))
                        .description(rs.getNString("description"))
                        .manufacturer(rs.getString("manufacturer"))
                        .quantity(rs.getInt("quantity"))
                        
                        // Build object
                        .build();
                // Add each new object into the list "eventList"
                productList.add(sqlProduct);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Returns the list with objects inside
        return productList;
        

        //GetById 
        
    }

    @Override
    public Product getById(long id) {
 //Class Operations are used to configure the connection with database and send a Query saved in variable stm
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "SELECT * FROM tbl_product where productId = ?;";

        //ps (prepareStatement) receives stm and replaces "?" for the variable with the index: "1" with "id"
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, id);

            // The result of the query is saved in the "rs" variable to apply logic.
            ResultSet rs = Operations.query_db(ps);

            // rs.next() -> Means if there is an answer, execute logic
            if (rs.next()) {

                // Create builder with concrete Builder -> (Concrete builder creates the object step by step)
                ProductBuilder productBuilder = new ProductConcreteBuilder();

                // Creates an event object and use eventBuilder for constructs it using the information from the query(rs) (field by field)
                Product sqlProduct = productBuilder
                        .productId(rs.getLong("productId"))
                        .nameProduct(rs.getString("productName"))
                        .storeId(rs.getLong("storeId"))
                        .productPrice(rs.getDouble("productPrice"))
                        .description(rs.getNString("description"))
                        .manufacturer(rs.getString("manufacturer"))
                        .quantity(rs.getInt("quantity"))
                        .build();

                //return contructed object sqlEvent
                return sqlProduct;
            } else {
                System.out.println("ERROR: The id has not been found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Return null always because this method should return something
        return null;
    }

    @Override
    public void update(Product t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    }
    
    
    
    
    

    
    
    
 



