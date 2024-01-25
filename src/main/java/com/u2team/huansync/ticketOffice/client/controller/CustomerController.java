/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u2team.huansync.ticketOffice.client.controller;

import com.u2team.huansync.ticketOffice.client.model.DAO.CustomerDAO;
import com.u2team.huansync.ticketOffice.client.model.classes.Customer;

import java.util.List;

/**
 * Controller class for managing interactions between the UI and the Customer data model.
 * This class provides methods to perform CRUD operations on customer entities.
 *
 * Usage example:
 * <pre>{@code
 * CustomerController customerController = new CustomerController();
 *
 * // Retrieve a customer by ID
 * Customer customer = customerController.getByIdCustomer(1);
 *
 * // Retrieve all customers
 * List<Customer> allCustomers = customerController.getAllCustomer();
 *
 * // Save a new customer
 * Customer newCustomer = new Customer();
 * // Set customer properties...
 * customerController.insertCustomer(newCustomer);
 *
 * // Update an existing customer
 * Customer existingCustomer = customerController.getByIdCustomer(1);
 * // Modify customer properties...
 * customerController.updateCustomer(existingCustomer);
 *
 * // Delete a customer by ID
 * customerController.deleteCustomer(1);
 * }</pre>
 *
 * @author [Your Name]
 */
public class CustomerController {

    /**
     * The CustomerDAO instance for interacting with the data model.
     */
    private CustomerDAO customerDAO;

    /**
     * Constructs a new CustomerController instance with a default CustomerDAO.
     */
    public CustomerController() {
        this.customerDAO = new CustomerDAO();
    }

    /**
     * Retrieves a customer by its unique identifier.
     *
     * @param customerId The unique identifier of the customer.
     * @return The customer with the specified identifier, or null if not found.
     */
    public Customer getByIdCustomer(long customerId) {
        return customerDAO.getById(customerId);
    }

    /**
     * Retrieves a list of all customers.
     *
     * @return A list containing all customers.
     */
    public List<Customer> getAllCustomer() {
        return customerDAO.getAll();
    }

    /**
     * Inserts a new customer into the data model.
     *
     * @param customer The customer to be inserted.
     */
    public void insertCustomer(Customer customer) {
        customerDAO.save(customer);
    }

    /**
     * Deletes a customer by its unique identifier from the data model.
     *
     * @param customerId The unique identifier of the customer to be deleted.
     */
    public void deleteCustomer(long customerId) {
        customerDAO.delete(customerId);
    }

    /**
     * Updates an existing customer in the data model.
     *
     * @param customer The customer to be updated.
     */
    public void updateCustomer(Customer customer) {
        customerDAO.update(customer);
    }
}
