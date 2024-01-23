/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u2team.huansync.establishment.model.classes.builder;

import com.u2team.huansync.establishment.model.Establishment;

/**
 *
 * @author misae
 */
public class EstablishmentBuilderImpl implements EstablishmentBuilder{
    private Establishment  establishment = new Establishment();
    @Override
    public EstablishmentBuilder stablishmentId(long stablishmentId) {
        establishment.setStablishmentId(stablishmentId);
        return this;
    }

    @Override
    public EstablishmentBuilder name(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public EstablishmentBuilder localNumber(int localNumber) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public EstablishmentBuilder category(String category) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public EstablishmentBuilder build() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
