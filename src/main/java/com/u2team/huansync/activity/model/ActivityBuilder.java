package com.u2team.huansync.activity.model;

import java.time.LocalTime;

/**
 * Interface for building Activity objects using a builder pattern.
 */
public interface ActivityBuilder {

    /**
     * Sets the activity ID for the ActivityBuilder.
     *
     * @param activityId The activity ID to set.
     * @return The ActivityBuilder instance.
     */
    ActivityBuilder activityId(Long activityId);

    /**
     * Sets the name for the ActivityBuilder.
     *
     * @param nameActivity The name to set.
     * @return The ActivityBuilder instance.
     */
    ActivityBuilder nameActivity(String nameActivity);

    /**
     * Sets the type of activity for the ActivityBuilder.
     *
     * @param typeActivity The type of activity to set.
     * @return The ActivityBuilder instance.
     */
    ActivityBuilder typeActivity(TypeActivity typeActivity);

    /**
     * Sets the category cosplay ID for the ActivityBuilder.
     *
     * @param categoryCosplayId The category cosplay ID to set.
     * @return The ActivityBuilder instance.
     */
    ActivityBuilder categoryCosplayId(Long categoryCosplayId);

    /**
     * Sets the number of participants for the ActivityBuilder.
     *
     * @param numParticipants The number of participants to set.
     * @return The ActivityBuilder instance.
     */
    ActivityBuilder numParticipants(int numParticipants);

    /**
     * Sets the event ID for the ActivityBuilder.
     *
     * @param eventId The event ID to set.
     * @return The ActivityBuilder instance.
     */
    ActivityBuilder eventId(Long eventId);

    /**
     * Sets the start time for the ActivityBuilder.
     *
     * @param startTime The start time to set.
     * @return The ActivityBuilder instance.
     */
    ActivityBuilder startTime(LocalTime startTime);

    /**
     * Sets the price for the ActivityBuilder.
     *
     * @param price The price to set.
     * @return The ActivityBuilder instance.
     */
    ActivityBuilder price(double price);

    /**
     * Sets the completion status for the ActivityBuilder.
     *
     * @param completed The completion status to set.
     * @return The ActivityBuilder instance.
     */
    ActivityBuilder completed(boolean completed);

    /**
     * Builds and returns the Activity object based on the set parameters.
     *
     * @return The constructed Activity object.
     */
    Activity build();
}
