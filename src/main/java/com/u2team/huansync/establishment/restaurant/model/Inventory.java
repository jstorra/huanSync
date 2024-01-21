/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u2team.huansync.establishment.restaurant.model;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author DeuryZ
 */

public class Inventory {
    private List<Ingredient> ingredientList;

    public Inventory() {
        this.ingredientList = new ArrayList<>();
    }

    public void addIngredient(Ingredient ingredient) {
        ingredientList.add(ingredient);
    }

    public void updateIngredientQuantity(String ingredientName, int newQuantity) {
        for (Ingredient ingredient : ingredientList) {
            if (ingredient.getName().equals(ingredientName)) {
                ingredient.setAvailableQuantity(newQuantity);
                return;
            }
        }
        System.out.println("Ingredient not found: " + ingredientName);
    }

}
