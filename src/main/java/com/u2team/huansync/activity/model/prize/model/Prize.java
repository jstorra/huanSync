package com.u2team.huansync.activity.model.prize.model;

/**
 * Represents a prize in an activity.
 */
public class Prize {
    private Long prizeId;
    private TypePrize typePrize;
    private String description;
    private double price;
    private StatusPrize statusPrize;
    private Long activityId;
    private Long winnerId;

    /**
     * Gets the unique identifier for the prize.
     *
     * @return The prize ID.
     */
    public Long getPrizeId() {
        return prizeId;
    }

    /**
     * Sets the unique identifier for the prize.
     *
     * @param prizeId The prize ID to set.
     */
    public void setPrizeId(Long prizeId) {
        this.prizeId = prizeId;
    }

    /**
     * Gets the type of the prize.
     *
     * @return The type of prize.
     */
    public TypePrize getTypePrize() {
        return typePrize;
    }

    /**
     * Sets the type of the prize.
     *
     * @param typePrize The type of prize to set.
     */
    public void setTypePrize(TypePrize typePrize) {
        this.typePrize = typePrize;
    }

    /**
     * Gets the description of the prize.
     *
     * @return The prize description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the prize.
     *
     * @param description The prize description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the price associated with the prize.
     *
     * @return The prize price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price associated with the prize.
     *
     * @param price The prize price to set.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the status of the prize.
     *
     * @return The status of prize.
     */
    public StatusPrize getStatusPrize() {
        return statusPrize;
    }

    /**
     * Sets the status of the prize.
     *
     * @param statusPrize The status of prize to set.
     */
    public void setStatusPrize(StatusPrize statusPrize) {
        this.statusPrize = statusPrize;
    }

    /**
     * Gets the unique identifier for the activity associated with the prize.
     *
     * @return The activity ID.
     */
    public Long getActivityId() {
        return activityId;
    }

    /**
     * Sets the unique identifier for the activity associated with the prize.
     *
     * @param activityId The activity ID to set.
     */
    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    /**
     * Gets the unique identifier for the winner of the prize.
     *
     * @return The winner ID.
     */
    public Long getWinnerId() {
        return winnerId;
    }

    /**
     * Sets the unique identifier for the winner of the prize.
     *
     * @param winnerId The winner ID to set.
     */
    public void setWinnerId(Long winnerId) {
        this.winnerId = winnerId;
    }

    /**
     * Returns a string representation of the prize, including its attributes.
     *
     * @return A string representation of the prize.
     */
    @Override
    public String toString() {
        return "Prize{" +
                "prizeId=" + prizeId +
                ", typePrize='" + typePrize + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", statusPrize=" + statusPrize +
                ", activityId=" + activityId +
                ", winnerId=" + winnerId +
                '}';
    }
}
