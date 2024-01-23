package com.u2team.huansync.activity.model.prize.model;

/**
 * The PrizeBuilder interface provides a builder pattern for creating Prize objects.
 * It allows the step-by-step construction of Prize instances with optional parameters.
 */
public interface PrizeBuilder {
    PrizeBuilder prizeId(Long prizeId);
    PrizeBuilder typePrize(TypePrize type);
    PrizeBuilder description(String description);
    PrizeBuilder price(double price);
    PrizeBuilder statusPrize(StatusPrize statusPrize);
    PrizeBuilder activityId(Long activityId);
    PrizeBuilder winnerId(Long winnerId);
    Prize build();
}
