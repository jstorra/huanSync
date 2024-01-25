package com.u2team.huansync.activity.cosplay.managementCosplay.model;

/**
 * Implementation of the CosplayBuilder interface for constructing instances of the Cosplay class.
 */
public class CosplayBuilderImpl implements CosplayBuilder {

    private Cosplay cosplay = new Cosplay() ;

    /**
     * Sets the cosplay ID for the builder.
     *
     * @param cosplayId The cosplay ID to set.
     * @return The CosplayBuilder instance for method chaining.
     */
    @Override
    public CosplayBuilder cosplayId(int cosplayId) {
        cosplay.setCosplayId(cosplayId);
        return this ;
    }

    /**
     * Sets the score for the builder.
     *
     * @param score The cosplay score to set.
     * @return The CosplayBuilder instance for method chaining.
     */
    @Override
    public CosplayBuilder score(double score) {
        cosplay.setScore(score);
        return this ;
    }

    /**
     * Sets the name of the cosplay for the builder.
     *
     * @param nameCosplay The cosplay name to set.
     * @return The CosplayBuilder instance for method chaining.
     */
    @Override
    public CosplayBuilder nameCosplay(String nameCosplay) {
        cosplay.setNameCosplay(nameCosplay);
        return this ;
    }

    /**
     * Sets the participant ID for the builder.
     *
     * @param participantId The participant ID to set.
     * @return The CosplayBuilder instance for method chaining.
     */
    @Override
    public CosplayBuilder participantId(int participantId) {
        cosplay.setParticipantId(participantId);
        return this ;
    }

    /**
     * Sets the activity ID for the builder.
     *
     * @param activityId The activity ID to set.
     * @return The CosplayBuilder instance for method chaining.
     */
    @Override
    public CosplayBuilder activictyId(int activictyId) {
        cosplay.setActivictyId(activictyId);
        return this ;
    }

    /**
     * Sets the name of the participant for the builder.
     *
     * @param participantName The participant name to set.
     * @return The CosplayBuilder instance for method chaining.
     */
    @Override
    public CosplayBuilder participantName(String participantName) {
        cosplay.setparticipantName(participantName);
        return this ;
    }

    /**
     * Builds and returns a Cosplay instance with the set properties.
     *
     * @return A Cosplay instance with the set properties.
     */
    @Override
    public Cosplay build() {
       return cosplay ;
    }

   
    
}
