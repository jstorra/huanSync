package com.u2team.huansync.establishment.restaurant.menu.model.classes;

import com.u2team.huansync.establishment.restaurant.Item.model.classes.Item;
import com.u2team.huansync.establishment.restaurant.model.Restaurant;
import java.util.ArrayList;
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
    private List<Item> menu;

    public Menu() {
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<Item> getMenu() {
        return menu;
    }

    public void setMenu(List<Item> menu) {
        this.menu = menu;
    }
    /**
     * 
     * @param item 
     */
    public void addItem(Item item) {
        
    }
    
    public void getItem() {
        
    }
    
    public void updateItem() {
        
    }
    
    public void removeItem() {
        
    }
}
