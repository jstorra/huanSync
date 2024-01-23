package com.u2team.huansync.establishment.restaurant.menu.model.classes.builder;

import com.u2team.huansync.establishment.restaurant.Item.model.classes.Item;
import com.u2team.huansync.establishment.restaurant.menu.model.classes.Menu;
import com.u2team.huansync.establishment.restaurant.model.Restaurant;
import java.util.List;

/**
 *
 * @author dfrincong
 */
public interface MenuBuilder {
    MenuBuilder restaurant(Restaurant restaurant);
    MenuBuilder menu(List<Item> menu);
    Menu build();
}
