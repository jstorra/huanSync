package com.u2team.huansync.activity.model.prize.model;

/**
 * The PrizeBuilderImpl class implements the PrizeBuilder interface, providing
 * a concrete implementation for constructing Prize objects using the builder pattern.
 * It allows the step-by-step construction of Prize instances with optional parameters.
 */
public class PrizeBuilderImpl implements PrizeBuilder{
    // The Prize instance being constructed
    private Prize prize = new Prize();

    /**@return The PrizeBuilderImpl instance for method chaining.*/
    @Override
    public PrizeBuilder prizeId(Long prizeId) {
        prize.setPrizeId(prizeId);
        return this;
    }

    @Override
    public PrizeBuilder typePrize(TypePrize type) {
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

    /**
     * Builds and returns the Prize instance based on the provided parameters.
     *
     * @return The constructed Prize object.
     */
    @Override
    public Prize build() {
        return prize;
    }
}
