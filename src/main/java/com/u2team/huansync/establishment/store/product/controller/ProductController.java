/**
 * This class serves as the controller for handling operations related to products in the HuanSync application.
 * It interacts with the {@link ProductDAO} to perform CRUD (Create, Read, Update, Delete) operations on products.
 * <p>
 * The methods provided in this class are utilized by the HuanSync application to manage product-related functionalities.
 * </p>
 *
 * @author Kevin Esteban
 */
package com.u2team.huansync.establishment.store.product.controller;

import com.u2team.huansync.establishment.store.product.model.DAO.ProductDAO;
import com.u2team.huansync.establishment.store.product.model.classes.Product;

import java.util.List;

/**
 * The {@code ProductController} class provides methods for managing products, including insertion, deletion,
 * retrieval, and updating of product information. These methods interact with the underlying {@link ProductDAO}
 * to perform database operations.
 */
public class ProductController {

    // Instantiate the ProductDAO
    private static ProductDAO productDAO = new ProductDAO();

    /**
     * Inserts a new product into the database.
     *
     * @param product The object to be inserted.
     */
    public static void insertProduct(Product product) {
        productDAO.save(product);
    }

    /**
     * Deletes a product from the database based on the given product ID.
     *
     * @param productId The ID of the product to be deleted.
     */
    public static void delete(long productId) {
        productDAO.delete(productId);
    }

    /**
     * Retrieves a list of all products stored in the database.
     *
     * @return A list of {@link Product} objects representing all products.
     */
    public static List<Product> getAll() {
        return productDAO.getAll();
    }

    /**
     * Retrieves a specific product from the database based on the given product ID.
     *
     * @param productId The ID of the product to be retrieved.
     * @return The {@link Product} object corresponding to the provided ID.
     */
    public static Product getById(long productId) {
        return productDAO.getById(productId);
    }

    /**
     * Updates the information of an existing product in the database.
     *
     * @param product The {@link Product} object containing updated information.
     */
    public static void updateProduct(Product product) {
        productDAO.update(product);
    }
}
