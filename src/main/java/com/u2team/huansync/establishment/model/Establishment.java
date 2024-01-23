package com.u2team.huansync.establishment.model;

public class Establishment {
    private long stablishmentId;
    private String name;
    private int localNumber;
//    private Employee manager;
    private String category;

    public Establishment() {
    }

    public long getStablishmentId() {
        return stablishmentId;
    }

    public void setStablishmentId(long stablishmentId) {
        this.stablishmentId = stablishmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLocalNumber() {
        return localNumber;
    }

    public void setLocalNumber(int localNumber) {
        this.localNumber = localNumber;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


}
