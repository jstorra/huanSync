package com.u2team.huansync.establishment.restaurant.ingredient.model.classes.buider;

import com.u2team.huansync.establishment.restaurant.ingredient.model.classes.Ingredient;

/**
 *
 * @author dfrincong
 */
public class IngredientBuilderImpl implements IngredientBuilder {
    private Ingredient ingredient = new Ingredient();
    
    @Override
    public IngredientBuilder name(String name) {
        ingredient.setName(name);
        return this;
    }

    @Override
    public IngredientBuilder availableQuantity(int availableQuantity) {
        ingredient.setAvailableQuantity(availableQuantity);
        return this;
    }

    @Override
    public Ingredient build() {
        return ingredient;
    }
    
}
