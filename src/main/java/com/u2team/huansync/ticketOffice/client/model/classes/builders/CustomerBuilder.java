/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u2team.huansync.ticketOffice.client.model.classes.builders;

import com.u2team.huansync.ticketOffice.client.model.classes.Costumer;

import java.util.Date;

/**
 *
 * @author SANTOS
 */
public interface CostumerBuilder {

    CostumerBuilder costumerId(long costumerId);
    CostumerBuilder nameCostumer(String nameCostumer);
    CostumerBuilder document(String document);
    CostumerBuilder gender(String gender);
    CostumerBuilder birthDate(Date birthDate);
    CostumerBuilder email(String email);
    CostumerBuilder phoneNumber(String phoneNumber);
    CostumerBuilder costumerTypeEnum(String costumerTypeEnum);
    Costumer build();
}
