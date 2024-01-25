/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u2team.huansync.establishment.restaurant.ingredient.controller;

import com.u2team.huansync.establishment.restaurant.ingredient.model.DAO.IngredientDAO;
import com.u2team.huansync.establishment.restaurant.ingredient.model.classes.Ingredient;
import java.util.List;

/**
 *
 * @author misae
 */
public class IngredientController {

    private static final IngredientDAO ingredientDAO = new IngredientDAO();

    public static void insertIngredient(Ingredient ingredient) {
        ingredientDAO.save(ingredient);
    }

    public static List<Ingredient> getAllIngredients() {
        return ingredientDAO.getAll();
    }

    public static Ingredient getByIdIngredient(long id) {
        return ingredientDAO.getById(id);
    }

    public static void deleteIngredient(long ingredientId) {
        ingredientDAO.delete(ingredientId);
    }

    public static void updateIngredient(Ingredient ingredient) {
        ingredientDAO.update(ingredient);
    }

}
