package com.u2team.huansync.establishment.restaurant.model;

import java.util.List;

/**
 * @author DeuryZ
 * @author dfrincong
 */
public interface ItemBuilder {
     ItemBuilder itemId (long itemId);
     ItemBuilder name (String name);
     ItemBuilder price (double price);
     ItemBuilder ingredients (List<Ingredient> ingredients);
     ItemBuilder type (ItemType type);
     ItemBuilder preparationTime (int preparationTime);
     Item build();
}
