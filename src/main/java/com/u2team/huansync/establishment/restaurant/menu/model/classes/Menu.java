package com.u2team.huansync.establishment.restaurant.menu.model.classes;

import com.u2team.huansync.establishment.restaurant.itemMenu.model.classes.ItemMenu;
import com.u2team.huansync.establishment.restaurant.model.Restaurant;
import java.util.List;

/**
 *
 * @author dfrincong
 */
public class Menu {
    /**
     * 
     */
    private Restaurant restaurant;
    private List<ItemMenu> menu;

    public Menu() {
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<ItemMenu> getMenu() {
        return menu;
    }

    public void setMenu(List<ItemMenu> menu) {
        this.menu = menu;
    }
    /**
     * 
     * @param item 
     */
    public void addItem(ItemMenu item) {
        
    }
    
    public void getItem() {
        
    }
    
    public void updateItem() {
        
    }
    
    public void removeItem() {
        
    }
}
