package com.u2team.huansync.establishment.restaurant.inventory.model.classes.builder;

import com.u2team.huansync.establishment.restaurant.ingredient.model.classes.Ingredient;
import com.u2team.huansync.establishment.restaurant.inventory.model.classes.Inventory;
import com.u2team.huansync.establishment.restaurant.model.Restaurant;
import java.util.List;

/**
 *
 * @author dfrincong
 */
public class InventoryBuilderImpl implements InventoryBuilder {
    private Inventory inventory = new Inventory();
    
    @Override
    public InventoryBuilder ingredientList(List<Ingredient> ingredientList) {
        inventory.setIngredientList(ingredientList);
        return this;
    }

    @Override
    public InventoryBuilder restaurant(Restaurant restaurant) {
        inventory.setRestaurant(restaurant);
        return this;
    }

    @Override
    public Inventory build() {
        return inventory;
    }
    
}
