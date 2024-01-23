/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.u2team.huansync.establishment.model.classes.builder;

/**
 *
 * @author DeuryZ
 */
public interface EstablishmentBuilder {
      EstablishmentBuilder stablishmentId (long stablishmentId);
      EstablishmentBuilder name (String name);
      EstablishmentBuilder localNumber (int localNumber);
//  EstablishmentBuilder manager (Employee manager);
      EstablishmentBuilder category (String category);
      EstablishmentBuilder build();
}
