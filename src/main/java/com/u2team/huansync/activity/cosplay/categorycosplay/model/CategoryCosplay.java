package com.u2team.huansync.activity.cosplay.categorycosplay.model;


public class CategoryCosplay {
    private long categoryCosplayId;
    private String nameCategoryCosplay;

    /*Constructor*/
    public CategoryCosplay() {

    }

    public CategoryCosplay(Long categoryCosplayId, String nameCategoryCosplay) {
        this.categoryCosplayId = categoryCosplayId;
        this.nameCategoryCosplay = nameCategoryCosplay;
    }

    /*Getters and Setters*/
    public long getCategoryCosplayId() {
        return categoryCosplayId;
    }

    public void setCategoryCosplayId(long categoryCosplayId) {
        this.categoryCosplayId = categoryCosplayId;
    }

    public String getNameCategoryCosplay() {
        return nameCategoryCosplay;
    }

    public void setNameCategoryCosplay(String nameCategoryCosplay) {
        this.nameCategoryCosplay = nameCategoryCosplay;
    }
}
