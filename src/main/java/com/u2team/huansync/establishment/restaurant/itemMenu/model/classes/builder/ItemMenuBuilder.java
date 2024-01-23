package com.u2team.huansync.establishment.restaurant.itemMenu.model.classes.builder;

import com.u2team.huansync.establishment.restaurant.itemMenu.model.classes.ItemMenu;
import com.u2team.huansync.establishment.restaurant.ingredient.model.classes.Ingredient;
import java.util.List;

/**
 * @author DeuryZ
 * @author dfrincong
 */
public interface ItemMenuBuilder {
     ItemMenuBuilder itemId (long itemId);
     ItemMenuBuilder nameItemMenu (String name);
     ItemMenuBuilder priceItemMenu (double price);
     ItemMenuBuilder itemMenuType (ItemMenuType type);
      ItemMenuBuilder ingredients(List<Ingredient> ingredients);
     ItemMenuBuilder preparationTime (int preparationTime);
     ItemMenu build();
}
