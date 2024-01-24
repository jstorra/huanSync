/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.u2team.huansync.establishment.model.classes.builder;

/**
 *
 * @author user
 */
public enum CategoryEstablishment {
    STORE("store"),
    RESTAURANT("restaurant");
        /**
     * @param name indicates the name of the type of dish (item).
     */
    private final String category;

    private CategoryEstablishment(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
