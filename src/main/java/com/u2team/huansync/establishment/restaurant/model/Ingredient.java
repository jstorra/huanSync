package com.u2team.huansync.establishment.restaurant.model;
/**
 * @author DeuryZ
 * @param name  is the way in which the dish will be displayed on the menu and to the customer.
 * @param quantity is to know whether or not a dish can be prepared depending on whether the ingredient is available or not.
 */
public class Ingredient {
    private String name;
    private int availableQuantity;

    public Ingredient(String name, int availableQuantity) {
        this.name = name;
        this.availableQuantity = availableQuantity;
    }

    public String getName() {
        return name;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int newQuantity) {
        this.availableQuantity = newQuantity;
    }

}
