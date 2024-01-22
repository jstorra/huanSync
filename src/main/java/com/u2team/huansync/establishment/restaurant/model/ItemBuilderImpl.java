package com.u2team.huansync.establishment.restaurant.model;

import java.util.List;

/**
 * @author DeuryZ
 * @author dfrincong
 */
public class ItemBuilderImpl implements ItemBuilder {
    
    private Item item = new Item();

    @Override
    public ItemBuilder itemId(long itemId) {
        item.setItemId(itemId);
        return this;
    }

    @Override
    public ItemBuilder name(String name) {
        item.setName(name);
        return this;
    }

    @Override
    public ItemBuilder price(double price) {
        item.setPrice(price);
        return this;
    }

    @Override
    public ItemBuilder ingredients(List<Ingredient> ingredients) {
        item.setIngredients(ingredients);
        return this;
    }

    @Override
    public ItemBuilder type(ItemType type) {
        item.setType(type);
        return this;
    }

    @Override
    public ItemBuilder preparationTime(int preparationTime) {
        item.setPreparationTime(preparationTime);
        return this;
    }

    @Override
    public Item build() {
        return item;
    }
    
}
