package com.u2team.huansync.establishment.restaurant.model;

public enum ProductType {
    APPETIZER("appetizer"),
    MAIN_COURSE("main course"),
    DRINK("drink"),
    DESSERT("dessert");

    private final String name;

    private ProductType(String name) {
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
