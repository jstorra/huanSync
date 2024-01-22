package com.u2team.huansync.activity.model.prize.model;

public class Prize {
    private long prizeId;
    private String typePrize;
    private String description;
    private double price;
    private StatusPrize statusPrize;
    private long activityId;
    private long winnerId;

    public long getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(long prizeId) {
        this.prizeId = prizeId;
    }

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

    public long getActivityId() {
        return activityId;
    }

    public void setActivityId(long activityId) {
        this.activityId = activityId;
    }

    public long getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(long winnerId) {
        this.winnerId = winnerId;
    }

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