package com.u2team.huansync.establishment.restaurant.model.classes.builder;

import com.u2team.huansync.establishment.restaurant.model.Restaurant;

/**
 *
 * @author dfrincong
 */
public interface RestaurantBuilder {
    RestaurantBuilder name(String name);
    Restaurant build();
}