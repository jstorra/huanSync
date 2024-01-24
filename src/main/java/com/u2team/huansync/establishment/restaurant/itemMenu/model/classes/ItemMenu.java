package com.u2team.huansync.establishment.restaurant.itemMenu.model.classes;

import com.u2team.huansync.establishment.restaurant.ingredient.model.classes.Ingredient;
import com.u2team.huansync.establishment.restaurant.itemMenu.model.classes.builder.ItemMenuType;
import java.util.List;

/**
 * @author DeuryZ
 * @author dfrincong
 *  Class to manage the dishes (item). The dishes are part of
 * the menu.
 */
public class ItemMenu {

    /**
     * parameters of the Item class
     *
     * @param itemId identification of item.
     * @param name name of item.
     * @param price price of item.
     * @param ingredients contains a list of ingredients for the dish (item).
     * @param type type of item. Can be: appetizer, main course, drink, dessert.
     * @param preparationTime preparation time in minutes of the dish (item).
     */
    private long itemMenuId;
    private String nameItemMenu;
    private double priceItemMenu;
    private List<Long> listIngredientId;
    private ItemMenuType itemMenuType;
    private int preparationTime;
    private long establishmentId;

    public ItemMenu() {
    }

    public ItemMenu(long itemMenuId, String nameItemMenu, double priceItemMenu, List<Long> listIngredientId, ItemMenuType itemMenuType, int preparationTime, long establishmentId) {
        this.itemMenuId = itemMenuId;
        this.nameItemMenu = nameItemMenu;
        this.priceItemMenu = priceItemMenu;
        this.listIngredientId = listIngredientId;
        this.itemMenuType = itemMenuType;
        this.preparationTime = preparationTime;
        this.establishmentId = establishmentId;
    }

    public String getNameItemMenu() {
        return nameItemMenu;
    }

    public void setNameItemMenu(String nameItemMenu) {
        if (" ".equalsIgnoreCase(nameItemMenu) || nameItemMenu.isBlank()) {
            System.out.println("The product name could not be updated. No name was entered.");
        } else {
            this.nameItemMenu = nameItemMenu;
            System.out.println("Name was changed to: " + nameItemMenu);
        }
    }

    public double getPriceItemMenu() {
        return priceItemMenu;
    }

    public void setPriceItemMenu(double priceItemMenu) {
        if (priceItemMenu < 0) {
            System.out.println("The product price could not be updated. The amount entered was less than 0.");
        } else {
            this.priceItemMenu = priceItemMenu;
            System.out.println("Price was changed to: " + priceItemMenu);
        }
    }

    public ItemMenuType getItemMenuType() {
        return itemMenuType;
    }

    public void setItemMenuType(ItemMenuType itemMenuType) {
        this.itemMenuType = itemMenuType;
    }

    public void setItemMenuType(String itemMenuType) {
        if (itemMenuType.equalsIgnoreCase("appetizer")) {
            this.setItemMenuType(ItemMenuType.APPETIZER);
        }
        if (itemMenuType.equalsIgnoreCase("main course")) {
            this.setItemMenuType(ItemMenuType.MAIN_COURSE);
        }
        if (itemMenuType.equalsIgnoreCase("drink")) {
            this.setItemMenuType(ItemMenuType.DRINK);
        }
        if (itemMenuType.equalsIgnoreCase("dessert")) {
            this.setItemMenuType(ItemMenuType.DESSERT);
        }
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

    public long getItemMenuId() {
        return itemMenuId;
    }

    public void setItemMenuId(long itemMenuId) {
        this.itemMenuId = itemMenuId;
    }

    public List<Long> getListIngredientId() {
        return listIngredientId;
    }

    public void setListIngredientId(List<Long> listIngredientId) {
        this.listIngredientId = listIngredientId;
    }

    public long getEstablishmentId() {
        return establishmentId;
    }

    public void setEstablishmentId(long establishmentId) {
        this.establishmentId = establishmentId;
    }

    @Override
    public String toString() {
        return "ItemMenu{" + "itemMenuId=" + itemMenuId + ", nameItemMenu=" + nameItemMenu + ", priceItemMenu=" + priceItemMenu + ", listIngredientId=" + listIngredientId + ", itemMenuType=" + itemMenuType + ", preparationTime=" + preparationTime + '}';
    }

}
