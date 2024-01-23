package com.u2team.huansync.establishment.restaurant.menu.model.classes.builder;

import com.u2team.huansync.establishment.restaurant.itemMenu.model.classes.ItemMenu;
import com.u2team.huansync.establishment.restaurant.menu.model.classes.Menu;
import com.u2team.huansync.establishment.restaurant.model.Restaurant;
import java.util.List;

/**
 *
 * @author dfrincong
 */
public interface MenuBuilder {
    MenuBuilder restaurant(Restaurant restaurant);
    MenuBuilder menu(List<ItemMenu> menu);
    Menu build();
}
