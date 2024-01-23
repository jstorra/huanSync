package com.u2team.huansync.activity.model;

public enum TypeActivity {
    COSPLAY("cosplay"), TRIVIA("trivia");

    private String name;

    private TypeActivity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
