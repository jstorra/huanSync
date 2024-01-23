package com.u2team.huansync.activity.model.prize.model;

/**
 * The TypePrize enum represents the different types or categories of prizes that can be awarded.
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

    private TypePrize(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
