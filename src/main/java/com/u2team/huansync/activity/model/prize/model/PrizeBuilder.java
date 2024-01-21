package com.u2team.huansync.activity.model.prize.model;

public interface PrizeBuilder {
    PrizeBuilder typePrize(String type);
    PrizeBuilder description(String description);
    PrizeBuilder price(double price);
    PrizeBuilder statusPrize(StatusPrize statusPrize);
    PrizeBuilder activityId(Long activityId);
    PrizeBuilder winnerId(Long winnerId);
    Prize build();
}
