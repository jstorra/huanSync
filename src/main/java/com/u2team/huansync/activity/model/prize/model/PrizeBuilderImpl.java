package com.u2team.huansync.activity.model.prize.model;

public class PrizeBuilderImpl implements PrizeBuilder{
    private Prize prize = new Prize();
    
    @Override
    public PrizeBuilder typePrize(String type) {
        prize.setTypePrize(type);
        return this;
    }

    @Override
    public PrizeBuilder description(String description) {
        prize.setDescription(description);
        return this;
    }

    @Override
    public PrizeBuilder price(double price) {
        prize.setPrice(price);
        return this;
    }

    @Override
    public PrizeBuilder statusPrize(StatusPrize statusPrize) {
        prize.setStatusPrize(statusPrize);
        return this;
    }

    @Override
    public PrizeBuilder activityId(Long activityId) {
        prize.setActivityId(activityId);
        return this;
    }

    @Override
    public PrizeBuilder winnerId(Long winnerId) {
        prize.setWinnerId(winnerId);
        return this;
    }

    @Override
    public Prize build() {
        return prize;
    }
}
