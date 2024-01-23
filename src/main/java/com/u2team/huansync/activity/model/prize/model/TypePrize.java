package com.u2team.huansync.activity.model.prize.model;

public enum TypePrize {
    MANGA("manga"),
    MULTIMEDIA("multimedia"),
    ART("art"),
    FIGURES("figures"),
    SOUVENIERS("souveniers"),
    CLOTHINGS("clothings"),
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
