package com.u2team.huansync.activity.model.prize.model;

/** The Prize class represents a prize that can be awarded in a certain activity
 */
public class Prize {
    /** Unique identifier for the prize*/
    private Long prizeId;
    private TypePrize typePrize;
    private String description;

    /** Monetary value of the prize*/
    private double price;

    /**Status of the prize (Available, Awarded)*/
    private StatusPrize statusPrize;

    /** Identifier of the activity associated with the prize*/
    private Long activityId;

    /**Identifier of the winner (if applicable)*/
    private Long winnerId;


    /**Getters and Setters*/

    public Long getPrizeId() {
        return prizeId;
    }

    /**@param prizeId The new prizeId to set*/
    public void setPrizeId(Long prizeId) {
        this.prizeId = prizeId;
    }

    public TypePrize getTypePrize() {
        return typePrize;
    }

    /**@param typePrize The new typePrize to set.*/
    public void setTypePrize(TypePrize typePrize) {
        this.typePrize = typePrize;
    }

    public String getDescription() {
        return description;
    }

    /**@param description The new description to set.*/
    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    /**@param price The new price to set*/
    public void setPrice(double price) {
        this.price = price;
    }

    public StatusPrize getStatusPrize() {
        return statusPrize;
    }

    /**@param statusPrize The new statusPrize to set*/
    public void setStatusPrize(StatusPrize statusPrize) {
        this.statusPrize = statusPrize;
    }

    public Long getActivityId() {
        return activityId;
    }

    /**@param activityId The new activityId to set.*/
    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Long getWinnerId() {
        return winnerId;
    }

    /**@param winnerId The new winnerId to set.*/
    public void setWinnerId(Long winnerId) {
        this.winnerId = winnerId;
    }


    /**Generates a string representation of the Prize object.
    *@return A string representation of the Prize.*/
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