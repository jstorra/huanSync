package com.u2team.huansync.establishment.restaurant.menu.model.classes.builder;

import com.u2team.huansync.establishment.restaurant.itemMenu.model.classes.ItemMenu;
import com.u2team.huansync.establishment.restaurant.menu.model.classes.Menu;
import com.u2team.huansync.establishment.restaurant.model.Restaurant;
import java.util.List;

/**
 *
 * @author dfrincogn
 */
public class MenuBuilderImpl implements MenuBuilder {
    private Menu menu = new Menu();
    
    @Override
    public MenuBuilder restaurant(Restaurant restaurant) {
        menu.setRestaurant(restaurant);
        return this;
    }

    @Override
    public MenuBuilder menu(List<ItemMenu> menuItems) {
        menu.setMenu(menuItems);
        return this;
    }

    @Override
    public Menu build() {
        return menu;
    }
    
}
