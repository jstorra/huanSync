package com.u2team.huansync.establishment.restaurant.inventory.model.classes;
import com.u2team.huansync.establishment.restaurant.ingredient.model.classes.Ingredient;
import com.u2team.huansync.establishment.restaurant.model.Restaurant;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author DeuryZ
 * @author dfrincong
 */

public class Inventory {
    /**
     * 
     */
    private List<Ingredient> ingredientList;
    private Restaurant restaurant;

    public Inventory(Restaurant restaurant) {
        this.ingredientList = new ArrayList<>();
        this.restaurant = restaurant;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredientList.add(ingredient);
    }

    public void updateIngredientQuantity(String ingredientName, int newQuantity) {
        for (Ingredient ingredient : ingredientList) {
            if (ingredient.getName().equals(ingredientName)) {
                ingredient.setAvailableQuantity(newQuantity);
                return;
            }
        }
        System.out.println("Ingredient not found: " + ingredientName);
    }
    
    public void removeIngredient() {
        
    }
    
    public void decreaseQuantity() {
        
    }
    
    public void increaseQuantity() {
        
    }
    
}
