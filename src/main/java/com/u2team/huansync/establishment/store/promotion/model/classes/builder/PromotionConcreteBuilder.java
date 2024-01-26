package com.u2team.huansync.establishment.store.promotion.model.classes.builder;

import com.u2team.huansync.establishment.store.promotion.model.classes.Promotion;

/**
 * The {@code PromotionConcreteBuilder} class implements the {@code PromotionBuilder}
 * interface to construct instances of the {@code Promotion} class using a concrete
 * builder pattern.
 * 
 * @author sneideresteban
 */
public class PromotionConcreteBuilder implements PromotionBuilder {

    // The promotion object being constructed
    private Promotion promotion = new Promotion();

    /**
     * Sets the promotionId for the {@code Promotion} being constructed.
     *
     * @param promotionId The promotionId to set.
     * @return The current instance of the builder.
     */
    @Override
    public PromotionBuilder promotionId(long promotionId) {
        promotion.setPromotionId(promotionId);
        return this;
    }

    /**
     * Sets the namePromotion for the {@code Promotion} being constructed.
     *
     * @param namePromotion The namePromotion to set.
     * @return The current instance of the builder.
     */
    @Override
    public PromotionBuilder namePromotion(String namePromotion) {
        promotion.setNamePromotion(namePromotion);
        return this;
    }

    /**
     * Sets the description for the {@code Promotion} being constructed.
     *
     * @param description The description to set.
     * @return The current instance of the builder.
     */
    @Override
    public PromotionBuilder description(String description) {
        promotion.setDescription(description);
        return this;
    }

    /**
     * Sets the statusPromotion for the {@code Promotion} being constructed.
     *
     * @param statusPromotion The statusPromotion to set.
     * @return The current instance of the builder.
     */
    @Override
    public PromotionBuilder statusPromotion(boolean statusPromotion) {
        promotion.setStatusPromotion(statusPromotion);
        return this;
    }

    /**
     * Sets the percent for the {@code Promotion} being constructed.
     *
     * @param percent The percent to set.
     * @return The current instance of the builder.
     */
    @Override
    public PromotionBuilder percent(int percent) {
        promotion.setPercent(percent);
        return this;
    }

    /**
     * Builds and returns an instance of the {@code Promotion} class based
     * on the provided information.
     *
     * @return An instance of the {@code Promotion} class.
     */
    @Override
    public Promotion build() {
        return promotion;
    }

    /**
     * Placeholder method for an unrelated object ID.
     *
     * @param aLong An unrelated object ID.
     * @return The current instance of the builder.
     * @throws UnsupportedOperationException Always thrown, as this method is not supported.
     */
    @Override
    public Object eventId(long aLong) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
