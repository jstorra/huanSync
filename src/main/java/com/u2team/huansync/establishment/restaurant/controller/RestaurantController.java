package com.u2team.huansync.establishment.restaurant.controller;

import com.u2team.huansync.establishment.restaurant.model.DAO.RestaurantDAO;
import com.u2team.huansync.establishment.restaurant.model.classes.Restaurant;
import java.util.List;

public class RestaurantController {
    private final static RestaurantDAO restaurantDao = new RestaurantDAO();
    
    public static List<Restaurant> getAllRestaurant(){
        return restaurantDao.getAll();
    }
    
    public static Restaurant getByIdRestaurant(long id){
        return restaurantDao.getById(id);
    }
}
