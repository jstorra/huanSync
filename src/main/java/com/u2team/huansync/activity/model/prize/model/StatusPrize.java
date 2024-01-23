package com.u2team.huansync.activity.model.prize.model;

public enum StatusPrize {
    AVAILABLE("available"), AWARDED("awarded");

    private String name;

    private StatusPrize(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
