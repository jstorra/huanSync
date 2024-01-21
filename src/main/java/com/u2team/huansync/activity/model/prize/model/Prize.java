package com.u2team.huansync.activity.model.prize.model;

public class Prize {
    private String typePrize;
    private String description;
    private double price;
    private StatusPrize statusPrize;
    private Long activityId;
    private Long winnerId;

    public String getTypePrize() {
        return typePrize;
    }

    public void setTypePrize(String typePrize) {
        this.typePrize = typePrize;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public StatusPrize getStatusPrize() {
        return statusPrize;
    }

    public void setStatusPrize(StatusPrize statusPrize) {
        this.statusPrize = statusPrize;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Long getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(Long winnerId) {
        this.winnerId = winnerId;
    }
}
