package com.u2team.huansync.establishment.restaurant.itemMenu.model.classes.builder;

import com.u2team.huansync.establishment.restaurant.itemMenu.model.classes.ItemMenu;
import java.util.List;

/**
 * @author DeuryZ
 * @author dfrincong
 */
public class ItemMenuConcreteBuilder implements ItemMenuBuilder {

    private ItemMenu item = new ItemMenu();

    public ItemMenuConcreteBuilder() {
        this.item = new ItemMenu();
    }

    @Override
    public ItemMenuBuilder itemId(long setItemMenuId) {
        item.setItemMenuId(setItemMenuId);
        return this;
    }

    @Override
    public ItemMenuBuilder nameItemMenu(String nameItemMenu) {
        item.setNameItemMenu(nameItemMenu);
        return this;
    }

    @Override
    public ItemMenuBuilder priceItemMenu(double priceItemMenu) {
        item.setPriceItemMenu(priceItemMenu);
        return this;
    }

    @Override
    public ItemMenuBuilder itemMenuType(String type) {
        item.setItemMenuType(type);
        return this;
    }

    @Override
    public ItemMenuBuilder preparationTime(int preparationTime) {
        item.setPreparationTime(preparationTime);
        return this;
    }

    @Override
    public ItemMenuBuilder ingredients(List<Long> ingredients) {
        item.setListIngredientId(ingredients);
        return this;
    }

    @Override
    public ItemMenu build() {
        return item;
    }

    @Override
    public ItemMenuBuilder establishmentId(long establishmentId) {
        item.setEstablishmentId(establishmentId);
        return this;
    }

}
