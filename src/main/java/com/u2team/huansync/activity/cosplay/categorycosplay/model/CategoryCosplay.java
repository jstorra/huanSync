package com.u2team.huansync.activity.cosplay.categorycosplay.model;


public class CategoryCosplay {
    private int categoryCosplayId;
    private String nameCategoryCosplay;


    /*Constructor*/
    public CategoryCosplay() {

    }

    public CategoryCosplay(int categoryCosplayId, String nameCategoryCosplay) {
        this.categoryCosplayId = categoryCosplayId;
        this.nameCategoryCosplay = nameCategoryCosplay;
    }


    /*Getters and Setters*/
    public int getCategoryCosplayId() {
        return categoryCosplayId;
    }

    public void setCategoryCosplayId(int categoryCosplayId) {
        this.categoryCosplayId = categoryCosplayId;
    }

    public String getNameCategoryCosplay() {
        return nameCategoryCosplay;
    }

    public void setNameCategoryCosplay(String nameCategoryCosplay) {
        this.nameCategoryCosplay = nameCategoryCosplay;
    }
}
