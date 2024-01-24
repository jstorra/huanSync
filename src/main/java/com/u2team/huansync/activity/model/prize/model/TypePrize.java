package com.u2team.huansync.activity.model.prize.model;

/**
 * Enumeration representing the types of prizes.
 */
public enum TypePrize {
    MANGA("manga"),
    MULTIMEDIA("multimedia"),
    ART("art"),
    FIGURES("figures"),
    SOUVENIRS("souvenirs"),
    CLOTHING("clothing"),
    TECHNOLOGY("technology");

    private String name;

    /**
     * Constructs a TypePrize enum with the specified name.
     *
     * @param name The name of the prize type.
     */
    private TypePrize(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the prize type.
     *
     * @return The name of the prize type.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the prize type.
     *
     * @param name The name of the prize type to set.
     */
    public void setName(String name) {
        this.name = name;
    }
}
