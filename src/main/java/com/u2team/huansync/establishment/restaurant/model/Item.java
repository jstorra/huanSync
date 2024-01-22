package com.u2team.huansync.establishment.restaurant.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DeuryZ
 * @author dfrincong
 * Class to manage the dishes (item). The dishes are part of the menu.
 */
public class Item {

    /**
     * parameters of the Product class
     *
     * 
     * @param name name of item.
     * @param price price of item.
     * @param type type of item. Can be: appetizer, main course, drink, dessert.
     * @param ingredients contains a list of ingredients for the dish.
     */
    private long itemId;
    private String name;
    private double price;
    private List<Ingredient> ingredients;
    private ItemType type;
    private int preparationTime;

    public Item() {
        
    }

    

   
    public long getItemId() {
        return itemId;
    }

 
    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (" ".equalsIgnoreCase(name) || name.isBlank()) {
            System.out.println("The product name could not be updated. No name was entered.");
        } else {
            this.name = name;
            System.out.println("Name was changed to: " + name);
        }

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            System.out.println("The product price could not be updated. The amount entered was less than 0.");
        } else {
            this.price = price;
            System.out.println("Price was changed to: " + price);
        }
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getType() {
        return type.getName();
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(int preparationTime) {
        if (preparationTime <= 0) {
            System.out.println("The product preparation time could not be updated. The preparation time entered must be greater than 0 minutes.");
        } else {
            this.preparationTime = preparationTime;
        }
    }
}
