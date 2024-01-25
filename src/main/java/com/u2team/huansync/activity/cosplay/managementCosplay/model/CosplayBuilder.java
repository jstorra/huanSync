package com.u2team.huansync.activity.cosplay.managementCosplay.model;

/**
 * Interface for building instances of the Cosplay class using the builder pattern.
 */
public interface CosplayBuilder {

    /**
     * Sets the cosplay ID for the builder.
     *
     * @param cosplayId The cosplay ID to set.
     * @return The CosplayBuilder instance for method chaining.
     */
    CosplayBuilder cosplayId( int cosplayId) ;

    /**
     * Sets the score for the builder.
     *
     * @param score The cosplay score to set.
     * @return The CosplayBuilder instance for method chaining.
     */
    CosplayBuilder score( double score) ;

    /**
     * Sets the name of the cosplay for the builder.
     *
     * @param nameCosplay The cosplay name to set.
     * @return The CosplayBuilder instance for method chaining.
     */
    CosplayBuilder nameCosplay(String nameCosplay);

    /**
     * Sets the participant ID for the builder.
     *
     * @param participantId The participant ID to set.
     * @return The CosplayBuilder instance for method chaining.
     */
    CosplayBuilder participantId(int participantId);

    /**
     * Sets the activity ID for the builder.
     *
     * @param activityId The activity ID to set.
     * @return The CosplayBuilder instance for method chaining.
     */
    CosplayBuilder activictyId(int activictyId);

    /**
     * Sets the name of the participant for the builder.
     *
     * @param participantName The participant name to set.
     * @return The CosplayBuilder instance for method chaining.
     */
    CosplayBuilder participantName(String participantName);

    /**
     * Builds and returns a Cosplay instance with the set properties.
     *
     * @return A Cosplay instance with the set properties.
     */
    Cosplay build();
}
