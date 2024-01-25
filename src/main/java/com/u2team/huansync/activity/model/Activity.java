package com.u2team.huansync.activity.model;

import java.time.LocalTime;

/**
 * Represents an activity within an event.
 */
public class Activity {
    private Long activityId;
    private String nameActivity;
    private TypeActivity typeActivity;
    private Long categoryCosplayId;
    private int numParticipants;
    private Long eventId;
    private LocalTime startTime;
    private double price;
    private boolean completed;

    /**
     * Gets the unique identifier for the activity.
     *
     * @return The activity ID.
     */
    public Long getActivityId() {
        return activityId;
    }

    /**
     * Sets the unique identifier for the activity.
     *
     * @param activityId The activity ID to set.
     */
    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    /**
     * Gets the name of the activity.
     *
     * @return The activity name.
     */
    public String getNameActivity() {
        return nameActivity;
    }

    /**
     * Sets the name of the activity.
     *
     * @param nameActivity The activity name to set.
     */
    public void setNameActivity(String nameActivity) {
        this.nameActivity = nameActivity;
    }

    /**
     * Gets the type of the activity.
     *
     * @return The type of activity.
     */
    public TypeActivity getTypeActivity() {
        return typeActivity;
    }

    /**
     * Sets the type of the activity.
     *
     * @param typeActivity The type of activity to set.
     */
    public void setTypeActivity(TypeActivity typeActivity) {
        this.typeActivity = typeActivity;
    }

    /**
     * Gets the category ID for cosplay-related activities.
     *
     * @return The category ID for cosplay activities.
     */
    public Long getCategoryCosplayId() {
        return categoryCosplayId;
    }

    /**
     * Sets the category ID for cosplay-related activities.
     *
     * @param categoryCosplayId The category ID for cosplay activities to set.
     */
    public void setCategoryCosplayId(Long categoryCosplayId) {
        this.categoryCosplayId = categoryCosplayId;
    }

    /**
     * Gets the number of participants for the activity.
     *
     * @return The number of participants.
     */
    public int getNumParticipants() {
        return numParticipants;
    }

    /**
     * Sets the number of participants for the activity.
     *
     * @param numParticipants The number of participants to set.
     */
    public void setNumParticipants(int numParticipants) {
        this.numParticipants = numParticipants;
    }

    /**
     * Gets the unique identifier for the event associated with the activity.
     *
     * @return The event ID.
     */
    public Long getEventId() {
        return eventId;
    }

    /**
     * Sets the unique identifier for the event associated with the activity.
     *
     * @param eventId The event ID to set.
     */
    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    /**
     * Gets the start time of the activity.
     *
     * @return The start time.
     */
    public LocalTime getStartTime() {
        return startTime;
    }

    /**
     * Sets the start time of the activity.
     *
     * @param startTime The start time to set.
     */
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    /**
     * Gets the price associated with the activity.
     *
     * @return The activity price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price associated with the activity.
     *
     * @param price The activity price to set.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Checks if the activity is marked as completed.
     *
     * @return True if the activity is completed, false otherwise.
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     * Sets the completion status of the activity.
     *
     * @param completed The completion status to set.
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    /**
     * Returns a string representation of the activity, including its attributes.
     *
     * @return A string representation of the activity.
     */
    @Override
    public String toString() {
        return "Activity{" +
                "activityId=" + activityId +
                ", name='" + nameActivity + '\'' +
                ", typeActivity=" + typeActivity +
                ", categoryCosplayId=" + categoryCosplayId +
                ", numParticipants=" + numParticipants +
                ", eventId=" + eventId +
                ", startTime=" + startTime +
                ", price=" + price +
                ", completed=" + completed +
                '}';
    }
}
