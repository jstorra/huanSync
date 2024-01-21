package com.u2team.huansync.establishment.restaurant.model;

//import java.util.List;

public class Product {
    /**
     * parameters of the Product class
     * @param idProduct identification number of product.
     * @param name name of product.
     * @param price price of product.
     * @param type type of product. Can be: appetizer, main course, drink, dessert.
     * @param ingredients contains a list of product ingredients.
     */
    private int idProduct; // ?
    private String name;
    private double price;
    private ProductType type;
    private int preparationTime; 
//    private List<Ingredient> ingredients;
    
    public Product(int idProduct, String name, double price, ProductType type, int preparationTime) {
        this.idProduct = idProduct;
        this.name = name;
        this.price = price;
        this.type = type;
        this.preparationTime = preparationTime;
//        this.ingredients = ingredients;
    }
    
    /**
     * Method to get the product id
     * @return current product id
     */
    public int getIdProduct() {
        return idProduct;
    }
    /**
     * Method to set the product id
     * @return void. Just set the current product id
     */
    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (" ".equalsIgnoreCase(name) || name.isBlank()) {
            System.out.println("The product name could not be updated. No name was entered.");
        } else {
            this.name = name;
            System.out.println("Name was changed to: " + name );
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
            System.out.println("Price was changed to: " + price );
        }
    }

    public String getType() {
        return type.getName();
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

//    public List<Ingredient> getIngredients() {
//        return ingredients;
//    }
//
//    public void setIngredients(List<Ingredient> ingredients) {
//        this.ingredients = ingredients;
//    }
    
    
    
    
    
}
