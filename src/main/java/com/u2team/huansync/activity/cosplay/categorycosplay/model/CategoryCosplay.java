package com.u2team.huansync.activity.cosplay.categorycosplay.model;

/**
 * Represents a cosplay category with its unique identifier and name.
 */

public class CategoryCosplay {
    private long categoryCosplayId;
    private String nameCategoryCosplay;

    /**
     * Default constructor for CategoryCosplay.
     */

    public CategoryCosplay() {

    }

    /**
     * Parameterized constructor for CategoryCosplay.
     *
     * @param categoryCosplayId   The unique identifier for the cosplay category.
     * @param nameCategoryCosplay The name of the cosplay category.
     */

    public CategoryCosplay(Long categoryCosplayId, String nameCategoryCosplay) {
        this.categoryCosplayId = categoryCosplayId;
        this.nameCategoryCosplay = nameCategoryCosplay;
    }

    /**
     * Gets the unique identifier of the cosplay category.
     *
     * @return The unique identifier of the cosplay category.
     */

    public long getCategoryCosplayId() {
        return categoryCosplayId;
    }

    /**
     * Sets the unique identifier of the cosplay category.
     *
     * @param categoryCosplayId The unique identifier to set for the cosplay category.
     */

    public void setCategoryCosplayId(long categoryCosplayId) {
        this.categoryCosplayId = categoryCosplayId;
    }

    /**
     * Gets the name of the cosplay category.
     *
     * @return The name of the cosplay category.
     */

    public String getNameCategoryCosplay() {
        return nameCategoryCosplay;
    }

    /**
     * Sets the name of the cosplay category.
     *
     * @param nameCategoryCosplay The name to set for the cosplay category.
     */

    public void setNameCategoryCosplay(String nameCategoryCosplay) {
        this.nameCategoryCosplay = nameCategoryCosplay;
    }
}
