/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.u2team.huansync.establishment.store.product.model.classes;

/**
 *
 * @author Kevin Jimenez
 */
public enum TypeProductEnum {
// llamar a enum TypeProductEnum.MANGA.getName();     
    MANGA("manga"),
    MULTIMEDIA("multimedia"),
    ART("art"),
    FIGURES("figures"),
    SOUVENIRS("souvenirs"),
    CLOTHING("clothing"),
    TECHNOLOGY("technology");

    private String name;

    private TypeProductEnum(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    //Corrected for Jaider
    public void setName(String name) {
        this.name = name;
    }

}
