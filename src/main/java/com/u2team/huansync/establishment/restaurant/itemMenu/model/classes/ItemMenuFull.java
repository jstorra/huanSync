/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u2team.huansync.establishment.restaurant.itemMenu.model.classes;

import com.u2team.huansync.establishment.restaurant.ingredient.model.classes.Ingredient;
import com.u2team.huansync.establishment.restaurant.itemMenu.model.classes.builder.ItemMenuType;
import java.util.List;

/**
 *
 * @author misae
 */
public class ItemMenuFull extends ItemMenu{
    
    private List<Ingredient> listIngredients;

    public ItemMenuFull() {
    }

    public ItemMenuFull(List<Ingredient> listIngredients, long itemMenuId, String nameItemMenu, double priceItemMenu, List<Long> listIngredientId, ItemMenuType itemMenuType, int preparationTime, long establishmentId) {
        super(itemMenuId, nameItemMenu, priceItemMenu, listIngredientId, itemMenuType, preparationTime, establishmentId);
        this.listIngredients = listIngredients;
    }

    public List<Ingredient> getListIngredients() {
        return listIngredients;
    }

    public void setListIngredients(List<Ingredient> listIngredients) {
        this.listIngredients = listIngredients;
    }

    @Override
    public String toString() {
        return super.toString() + "  ItemMenuFull{" + "listIngredients=" + listIngredients + '}';
    }

}
