package com.u2team.huansync.activity.model.prize.model;

/**
 * Interface for building Prize objects using a builder pattern.
 */
public interface PrizeBuilder {

    /**
     * Sets the prize ID for the PrizeBuilder.
     *
     * @param prizeId The prize ID to set.
     * @return The PrizeBuilder instance.
     */
    PrizeBuilder prizeId(Long prizeId);

    /**
     * Sets the type of the prize for the PrizeBuilder.
     *
     * @param type The type of prize to set.
     * @return The PrizeBuilder instance.
     */
    PrizeBuilder typePrize(TypePrize type);

    /**
     * Sets the description for the PrizeBuilder.
     *
     * @param description The description to set.
     * @return The PrizeBuilder instance.
     */
    PrizeBuilder description(String description);

    /**
     * Sets the price for the PrizeBuilder.
     *
     * @param price The price to set.
     * @return The PrizeBuilder instance.
     */
    PrizeBuilder price(double price);

    /**
     * Sets the status of the prize for the PrizeBuilder.
     *
     * @param statusPrize The status of prize to set.
     * @return The PrizeBuilder instance.
     */
    PrizeBuilder statusPrize(StatusPrize statusPrize);

    /**
     * Sets the activity ID for the PrizeBuilder.
     *
     * @param activityId The activity ID to set.
     * @return The PrizeBuilder instance.
     */
    PrizeBuilder activityId(Long activityId);

    /**
     * Sets the winner ID for the PrizeBuilder.
     *
     * @param winnerId The winner ID to set.
     * @return The PrizeBuilder instance.
     */
    PrizeBuilder winnerId(Long winnerId);

    /**
     * Builds and returns the Prize object based on the set parameters.
     *
     * @return The constructed Prize object.
     */
    Prize build();
}
