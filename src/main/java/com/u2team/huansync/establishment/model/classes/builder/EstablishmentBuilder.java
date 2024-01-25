/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.u2team.huansync.establishment.model.classes.builder;

import com.u2team.huansync.establishment.model.classes.Establishment;

/**
 *
 * @author DeuryZ
 */
public interface EstablishmentBuilder {
      EstablishmentBuilder establishmentId (long establishmentId);
      EstablishmentBuilder nameEstablishment (String nameEstablishment);
      EstablishmentBuilder managerEstablishment (long managerEstablishment);
      EstablishmentBuilder categoryEstablishment (String categoryEstablishment);
      EstablishmentBuilder establishmentEventId (long establishmentEventId);
      Establishment build();
}
