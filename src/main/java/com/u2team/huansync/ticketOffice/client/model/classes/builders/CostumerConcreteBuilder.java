/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u2team.huansync.ticketOffice.client.model.classes.builders;

import com.u2team.huansync.ticketOffice.client.model.classes.Costumer;
import com.u2team.huansync.ticketOffice.client.model.classes.CostumerTypeEnum;
import java.util.Date;

/**
 *
 * @author SANTOS
 */
public class CostumerConcreteBuilder implements CostumerBuilder {

    private Costumer costumer = new Costumer();


    @Override
    public CostumerBuilder costumerId(long costumerId) {
        costumer.setCostumerId(costumerId);
        return this;
    }

    @Override
    public CostumerBuilder nameCostumer(String nameCostumer) {
        costumer.setName(nameCostumer);
        return this;
    }

    @Override
    public CostumerBuilder document(String document) {
        costumer.setDocument(document);
        return this;
    }

    @Override
    public CostumerBuilder gender(String gender) {
        costumer.setGender(gender);
        return this;
    }

    @Override
    public CostumerBuilder birthDate(Date birthDate) {
        costumer.setBirthDate(birthDate);
        return this;
    }

    @Override
    public CostumerBuilder email(String email) {
        costumer.setEmail(email);
        return this;
    }

    @Override
    public CostumerBuilder phoneNumber(String phoneNumber) {
        costumer.setPhoneNumber(phoneNumber);
        return this;
    }

    @Override
    public CostumerBuilder costumerTypeEnum(String costumerTypeEnum) {
        if(costumerTypeEnum.equalsIgnoreCase("participant")){
            costumer.setCostumerTypeEnum(CostumerTypeEnum.PARTICIPANT);
        }
        if(costumerTypeEnum.equalsIgnoreCase("visitor")){
            costumer.setCostumerTypeEnum(CostumerTypeEnum.VISITOR);
        }
        if(costumerTypeEnum.equalsIgnoreCase("winner")){
            costumer.setCostumerTypeEnum(CostumerTypeEnum.WINNER);
        }
        return this;
    }

    @Override
    public Costumer build() {
        return null;
    }
}
