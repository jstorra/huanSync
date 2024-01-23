package com.u2team.huansync.activity.model.prize.model;

/**
 * Enumeration representing the status of a prize.
 */
public enum StatusPrize {
    AVAILABLE("available"), AWARDED("awarded");

    private String name;

    /**
     * Constructs a StatusPrize enum with the specified name.
     *
     * @param name The name of the status.
     */
    private StatusPrize(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the status.
     *
     * @return The name of the status.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the status.
     *
     * @param name The name of the status to set.
     */
    public void setName(String name) {
        this.name = name;
    }
}
