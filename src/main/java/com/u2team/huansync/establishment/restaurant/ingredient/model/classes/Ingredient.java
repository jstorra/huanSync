package com.u2team.huansync.establishment.restaurant.ingredient.model.classes;

/**
 * @author DeuryZ
 * @author dfrincong Class for the creation of the ingredients that have the
 * dishes (item).
 */
public final class Ingredient {

    /**
     * @param name is the way in which the dish will be displayed on the menu
     * and to the customer.
     * @param quantity is to know whether or not a dish can be prepared
     * depending on whether the ingredient is available or not.
     */

    private long ingredientId;
    private String nameIngredient;
    private int availableQuantity;
    private long establishmentId;

    public Ingredient() {
    }

    public Ingredient(long ingredientId, String name, int availableQuantity, long establishmentId) {
        this.ingredientId = ingredientId;
        setNameIngredient(name);
        setAvailableQuantity(availableQuantity);
        this.establishmentId = establishmentId;
    }

    public String getNameIngredient() {
        return nameIngredient;
    }

    public void setNameIngredient(String name) {
        if (" ".equalsIgnoreCase(name) || name.isBlank()) {
            System.out.println("The ingredient name could not be updated. No name was entered.");
        } else {
            this.nameIngredient = name;
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

    public long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public long getEstablishmentId() {
        return establishmentId;
    }

    public void setEstablishmentId(long establishmentId) {
        this.establishmentId = establishmentId;
    }

    @Override
    public String toString() {
        return "Ingredient{" + "ingredientId=" + ingredientId + ", name=" + nameIngredient + ", availableQuantity=" + availableQuantity + '}';
    }

}
