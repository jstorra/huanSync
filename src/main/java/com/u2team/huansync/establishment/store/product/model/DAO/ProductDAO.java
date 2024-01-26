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
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code ProductDAO} class implements various data access operations
 * (CRUD) for the {@code Product} entity using SQL queries.
 * 
 * <p>The methods provided by this class include saving a product, deleting
 * a product, retrieving all products, retrieving a product by its ID, and
 * updating a product's information.
 * 
 * @author sneiderEsteban
 */
public class ProductDAO implements ISaveDao<Product>, IDeleteDao<Product>, IGetAllDao<Product>, IGetByIdDao<Product>, IUpdateDao<Product> {

    /**
     * Saves a new product to the database.
     *
     * @param product The product to be saved.
     */
    @Override
    public void save(Product product) {
        String stmInsert = "INSERT INTO tbl_product(productId, productName, productPrice, description, manufacturer, typeProduct, quantity, establishmentsId) VALUES(?,?,?,?,?,?,?,?);";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
            ps.setLong(1, product.getProductId());
            ps.setString(2, product.getNameProduct());
            ps.setDouble(3, product.getProductPrice());
            ps.setString(4, product.getDescription());
            ps.setString(5, product.getManufacturer());
            ps.setString(6, product.getType().name());
            ps.setInt(7, product.getQuantity());
            ps.setLong(8, product.getStoreId());

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

    /**
     * Deletes a product from the database based on the provided product ID.
     *
     * @param productId The ID of the product to be deleted.
     */
    @Override
    public void delete(long productId) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "DELETE FROM tbl_product WHERE productId = ?;";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, productId);
            int rows = Operations.insert_update_delete_db(ps);
            if (rows > 0) {
                System.out.println("successful delete product");
                return;
            } else {
                System.out.println("not exists product");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("something was wrong on delete product");
    }

    /**
     * Retrieves a list of all products from the database.
     *
     * @return A list containing all products.
     */
    @Override
    public List<Product> getAll() {
        List<Product> productList = new ArrayList<>();
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "SELECT * FROM tbl_product";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ResultSet rs = Operations.query_db(ps);

            while (rs.next()) {
                ProductBuilder eventBuilder = new ProductConcreteBuilder();

                Product sqlProduct = eventBuilder
                        .productId(rs.getLong("productId"))
                        .nameProduct(rs.getString("productName"))
                        .storeId(rs.getLong("establishmentsId"))
                        .productPrice(rs.getDouble("productPrice"))
                        .description(rs.getNString("description"))
                        .manufacturer(rs.getString("manufacturer"))
                        .quantity(rs.getInt("quantity"))
                        .type(rs.getString("typeProduct"))
                        .build();

                productList.add(sqlProduct);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    /**
     * Retrieves a product from the database based on the provided product ID.
     *
     * @param id The ID of the product to be retrieved.
     * @return The product with the specified ID.
     */
    @Override
    public Product getById(long id) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "SELECT * FROM tbl_product where productId = ?;";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, id);

            ResultSet rs = Operations.query_db(ps);

            if (rs.next()) {
                ProductBuilder productBuilder = new ProductConcreteBuilder();

                Product sqlProduct = productBuilder
                        .productId(rs.getLong("productId"))
                        .nameProduct(rs.getString("productName"))
                        .storeId(rs.getLong("establishmentsId"))
                        .productPrice(rs.getDouble("productPrice"))
                        .description(rs.getNString("description"))
                        .manufacturer(rs.getString("manufacturer"))
                        .quantity(rs.getInt("quantity"))
                        .type(rs.getString("typeProduct"))
                        .build();

                return sqlProduct;
            } else {
                System.out.println("ERROR: The id has not been found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Updates the information of an existing product in the database.
     *
     * @param product The updated product information.
     */
    @Override
    public void update(Product product) {
        Product sqlProduct = getById(product.getProductId());

        if (sqlProduct != null) {
            sqlProduct.setNameProduct(product.getNameProduct());
            sqlProduct.setProductPrice(product.getProductPrice());
            sqlProduct.setDescription(product.getDescription());
            sqlProduct.setManufacturer(product.getManufacturer());
            sqlProduct.setQuantity(product.getQuantity());
            sqlProduct.setType(product.getType());
            sqlProduct.setStoreId(product.getStoreId());

            String stmInsert = """
            UPDATE tbl_product
            SET productName  = ?,
                productPrice  = ?,
                description = ?,
                manufacturer  = ?,
                typeProduct  = ?,
                quantity  = ?,
                establishmentsId = ?
            WHERE productId  = ?;
            """;

            try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
                ps.setString(1, product.getNameProduct());
                ps.setDouble(2, product.getProductPrice());
                ps.setString(3, product.getDescription());
                ps.setString(4, product.getManufacturer());
                ps.setString(5, product.getType().name());
                ps.setInt(6, product.getQuantity());
                ps.setLong(7, product.getStoreId());
                ps.setLong(8, product.getProductId());

                System.out.println(ps.toString());

                int rows = Operations.insert_update_delete_db(ps);
                if (rows <= 0) {
                    System.out.println("Cannot update products");
                } else {
                    System.out.println("Successful update products");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("not found results products");
        }
    }
}
