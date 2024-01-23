package com.u2team.huansync.establishment.restaurant.itemMenu.model.classes.builder;

/**
 * @author dfrincong
 * Class to manage the types of dishes in the menu.
 */
public enum ItemMenuType {
    APPETIZER("appetizer"),
    MAIN_COURSE("main course"),
    DRINK("drink"),
    DESSERT("dessert");
    /**
     * @param name indicates the name of the type of dish (item).
     */
    private final String name;

    private ItemMenuType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
}
