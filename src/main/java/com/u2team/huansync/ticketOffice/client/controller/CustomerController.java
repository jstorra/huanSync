package com.u2team.huansync.ticketOffice.client.controller;

import com.u2team.huansync.ticketOffice.client.model.DAO.CustomerDAO;
import com.u2team.huansync.ticketOffice.client.model.classes.Customer;

public class CustomerController {

    private CustomerDAO customerDAO;

    public CustomerController()   {
        this.customerDAO = new CustomerDAO();
    }
    
    public Customer getById(long customerId){
        return customerDAO.getById(customerId);
    }
    
    public void insertCustomer (Customer customer){
        customerDAO.save(customer);
    }
    
    public void deleteCustomer(long customerId){
        customerDAO.delete(customerId);
    }
    
    public void updateCustomer(Customer customer){
        customerDAO.update(customer);
    }
}
