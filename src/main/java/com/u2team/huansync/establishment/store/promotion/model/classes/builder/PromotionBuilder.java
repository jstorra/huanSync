/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.u2team.huansync.establishment.store.promotion.model.classes.builder;

import com.u2team.huansync.establishment.store.promotion.model.classes.Promotion;

/**
 * The {@code PromotionBuilder} interface defines methods for constructing
 * instances of the {@code Promotion} class using a builder pattern.
 * Implementing classes must provide implementations for these methods to
 * build a {@code Promotion} object step by step.
 * 
 * @author sneideEsteban
 */
public interface PromotionBuilder {
    
    /**
     * Sets the promotionId for the {@code Promotion} being constructed.
     *
     * @param promotionId The promotionId to set.
     * @return The current instance of the builder.
     */
    PromotionBuilder promotionId(long promotionId);

    /**
     * Sets the namePromotion for the {@code Promotion} being constructed.
     *
     * @param namePromotion The namePromotion to set.
     * @return The current instance of the builder.
     */
    PromotionBuilder namePromotion(String namePromotion);

    /**
     * Sets the description for the {@code Promotion} being constructed.
     *
     * @param description The description to set.
     * @return The current instance of the builder.
     */
    PromotionBuilder description(String description);

    /**
     * Sets the statusPromotion for the {@code Promotion} being constructed.
     *
     * @param statusPromotion The statusPromotion to set.
     * @return The current instance of the builder.
     */
    PromotionBuilder statusPromotion(boolean statusPromotion);

    /**
     * Sets the percent for the {@code Promotion} being constructed.
     *
     * @param percent The percent to set.
     * @return The current instance of the builder.
     */
    PromotionBuilder percent(int percent);
   
    /**
     * Builds and returns an instance of the {@code Promotion} class based
     * on the provided information.
     *
     * @return An instance of the {@code Promotion} class.
     */
    Promotion build();

    /**
     * Placeholder method for an unrelated object ID.
     *
     * @param aLong An unrelated object ID.
     * @return The current instance of the builder.
     */
    public Object eventId(long aLong);
}
