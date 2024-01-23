package com.u2team.huansync.establishment.restaurant.model.classes.builder;

import com.u2team.huansync.establishment.restaurant.model.Restaurant;

/**
 *
 * @author dfrincong
 */
public class RestaurantBuilderImpl implements RestaurantBuilder {
    Restaurant restaurant = new Restaurant();

    @Override
    public RestaurantBuilder name(String name) {
        restaurant.setName(name);
        return this;
    }

    @Override
    public Restaurant build() {
        return restaurant;
    }
    
}