package com.u2team.huansync.establishment.restaurant.ingredient.model.classes.buider;

import com.u2team.huansync.establishment.restaurant.ingredient.model.classes.Ingredient;

/**
 *
 * @author dfrincong
 */
public interface IngredientBuilder {
    IngredientBuilder name(String name);
    IngredientBuilder availableQuantity(int availableQuantity);
    Ingredient build();
}
