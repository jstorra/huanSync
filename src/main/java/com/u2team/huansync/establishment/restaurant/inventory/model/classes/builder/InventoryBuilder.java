package com.u2team.huansync.establishment.restaurant.inventory.model.classes.builder;

import com.u2team.huansync.establishment.restaurant.ingredient.model.classes.Ingredient;
import com.u2team.huansync.establishment.restaurant.inventory.model.classes.Inventory;
import com.u2team.huansync.establishment.restaurant.model.Restaurant;
import java.util.List;

/**
 *
 * @author dfrincong
 */
public interface InventoryBuilder {
    InventoryBuilder ingredientList(List<Ingredient> ingredientList);
    InventoryBuilder restaurant(Restaurant restaurant);
    Inventory build();
}
