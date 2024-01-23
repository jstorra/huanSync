package com.u2team.huansync.establishment.restaurant.Item.model.classes.builder;
/**
 * @author dfrincong
 * Class to manage the types of dishes in the menu.
 */
public enum ItemType {
    APPETIZER("appetizer"),
    MAIN_COURSE("main course"),
    DRINK("drink"),
    DESSERT("dessert");
    /**
     * @param name indicates the name of the type of dish (item).
     */
    private final String name;

    private ItemType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    

//    public boolean isValidType(String value) {
//        for (ProductType type : ProductType.values()) {
//            if (type.name.equalsIgnoreCase(value)) {
//                return true;
//            }
//        }
//        return false;
//    }
}
