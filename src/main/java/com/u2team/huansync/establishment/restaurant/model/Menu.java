package com.u2team.huansync.establishment.restaurant.model;

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

    public Menu(Restaurant restaurant) {
        this.restaurant = restaurant;
        this.menu = new ArrayList<>();
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
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
