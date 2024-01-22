/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u2team.huansync.ticketOffice.client.model.classes.builders;

import com.u2team.huansync.ticketOffice.client.model.classes.Customer;

import java.util.Date;

/**
 *
 * @author SANTOS
 */
public interface CustomerBuilder {

    CustomerBuilder customerId(long customerId);
    CustomerBuilder nameCustomer(String nameCustomer);
    CustomerBuilder document(String document);
    CustomerBuilder gender(String gender);
    CustomerBuilder birthDate(Date birthDate);
    CustomerBuilder email(String email);
    CustomerBuilder phoneNumber(String phoneNumber);
    CustomerBuilder customerTypeEnum(String customerTypeEnum);
    Customer build();
}
