
package com.u2team.huansync.establishment.model.classes.builder;

public enum CategoryEstablishment {
    STORE("store"),
    RESTAURANT("restaurant");
        /**
     * @param name indicates the name of the type of dish (item).
     */
    private final String category;

    private CategoryEstablishment(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
