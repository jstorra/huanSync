/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u2team.huansync.ticketOffice.client.model.classes.builders;

import com.u2team.huansync.ticketOffice.client.model.classes.Customer;
import com.u2team.huansync.ticketOffice.client.model.classes.CustomerTypeEnum;

import java.util.Date;

/**
 *
 * @author SANTOS
 */
public class CustomerConcreteBuilder implements CustomerBuilder {

    private Customer customer = new Customer();


    @Override
    public CustomerBuilder customerId(long costumerId) {
        customer.setCustomerId(costumerId);
        return this;
    }

    @Override
    public CustomerBuilder nameCustomer(String nameCostumer) {
        customer.setName(nameCostumer);
        return this;
    }

    @Override
    public CustomerBuilder document(String document) {
        customer.setDocument(document);
        return this;
    }

    @Override
    public CustomerBuilder gender(String gender) {
        customer.setGender(gender);
        return this;
    }

    @Override
    public CustomerBuilder birthDate(Date birthDate) {
        customer.setBirthDate(birthDate);
        return this;
    }

    @Override
    public CustomerBuilder email(String email) {
        customer.setEmail(email);
        return this;
    }

    @Override
    public CustomerBuilder phoneNumber(String phoneNumber) {
        customer.setPhoneNumber(phoneNumber);
        return this;
    }

    @Override
    public CustomerBuilder customerTypeEnum(String customerTypeEnum) {
        if(customerTypeEnum.equalsIgnoreCase("participant")){
            customer.setCustomerTypeEnum(CustomerTypeEnum.PARTICIPANT);
        }
        if(customerTypeEnum.equalsIgnoreCase("visitor")){
            customer.setCustomerTypeEnum(CustomerTypeEnum.VISITOR);
        }
        if(customerTypeEnum.equalsIgnoreCase("winner")){
            customer.setCustomerTypeEnum(CustomerTypeEnum.WINNER);
        }
        return this;
    }

    @Override
    public Customer build() {
        return null;
    }
}
