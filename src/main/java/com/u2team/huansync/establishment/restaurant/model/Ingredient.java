package com.u2team.huansync.establishment.restaurant.model;
/**
 * @author DeuryZ
 * @author dfrincong
 * Class for the creation of the ingredients that have the dishes (item).
 */
public class Ingredient {
    /**
     * @param name is the way in which the dish will be displayed on the menu and to the customer.
     * @param quantity is to know whether or not a dish can be prepared
     * depending on whether the ingredient is available or not.
     */
    private String name;
    private int availableQuantity;

    public Ingredient(String name, int availableQuantity) {
        this.name = name;
        this.availableQuantity = availableQuantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (" ".equalsIgnoreCase(name) || name.isBlank()) {
            System.out.println("The ingredient name could not be updated. No name was entered.");
        } else {
            this.name = name;
            System.out.println("Name was changed to: " + name);
        }
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int newQuantity) {
        if (newQuantity < 0) {
            System.out.println("The ingredient quantity could not be updated. The amount entered was less than 0.");
        } else {
            this.availableQuantity = newQuantity;
            System.out.println("The ingredient quantity was changed to: " + newQuantity);
        }
    }

    @Override
    public String toString() {
        return "Ingredient {" + "name= " + name + ", availableQuantity= " + availableQuantity + '}';
    }
}
