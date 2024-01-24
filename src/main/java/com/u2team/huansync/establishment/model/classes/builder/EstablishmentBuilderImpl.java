/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u2team.huansync.establishment.model.classes.builder;

import com.u2team.huansync.establishment.model.classes.Establishment;

/**
 *
 * @author misae
 */
public class EstablishmentBuilderImpl implements EstablishmentBuilder{
    private Establishment establishment;

    public EstablishmentBuilderImpl() {
        this.establishment = new Establishment();
    }

    @Override
    public EstablishmentBuilder establishmentId(long establishmentId) {
        establishment.setEstablishmentId(establishmentId);
        return this;
    }

    @Override
    public EstablishmentBuilder nameEstablishment(String nameEstablishment) {
     establishment.setNameEstablishment(nameEstablishment);
        return this;
    }

    @Override
    public EstablishmentBuilder managerEstablishment(long managerEstablishment) {
     establishment.setManagerEstablishmentId(managerEstablishment);
        return this;
    }

    @Override
    public EstablishmentBuilder categoryEstablishment(String categoryEstablishment) {
       establishment.setCategoyEstablishment(establishment.getCategoyEstablisment(categoryEstablishment));
        return this;
    }

    @Override
    public EstablishmentBuilder establishmentEventId(long establishmentEventId) {
        establishment.setEstablishmentEventId(establishmentEventId);
        return this;
    }
    
    @Override
    public Establishment build() {
        return establishment;
    }


    
}
