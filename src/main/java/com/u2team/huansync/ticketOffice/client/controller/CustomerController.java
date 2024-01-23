package com.u2team.huansync.ticketOffice.client.controller;

import com.u2team.huansync.ticketOffice.client.model.DAO.CustomerDAO;
import com.u2team.huansync.ticketOffice.client.model.classes.Customer;

import java.util.List;

public class CustomerController {

    private CustomerDAO customerDAO;

    public CustomerController()   {
        this.customerDAO = new CustomerDAO();
    }

    public Customer getByIdCustomer(long customerId){
        return customerDAO.getById(customerId);
    }

    public List<Customer> getAllCustomer(){
        return customerDAO.getAll();
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
