package com.u2team.huansync.activity.model.prize.model;

/**
 * The StatusPrize enum represents the status of a Prize, indicating whether it is available or awarded.
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

    public String getName() {
        return name;
    }


    /**
     * Sets the name of the status.
     *
     * @param name The new name to set.
     */
    public void setName(String name) {
        this.name = name;
    }
}
