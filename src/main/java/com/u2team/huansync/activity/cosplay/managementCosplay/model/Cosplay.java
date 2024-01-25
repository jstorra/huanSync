package com.u2team.huansync.activity.cosplay.managementCosplay.model;

/**
 * Represents a cosplay entity with various properties.
 */
public class Cosplay {

    // PROPERTIES
    private int cosplayId;
    private double score = 0;
    private String nameCosplay;
    private int participantId;
    private int activityId;
    private boolean statusCosplay = true;

    // propertie NAME apart from the object creation which serves to give the
    // front-end something to consume in a simpler way and thus not have to create
    // another object as such
    private String participantName;
    private String documentParticipant;

    // METTODS GETTERS
    
    /**
     * Gets the ID of the cosplay.
     *
     * @return The cosplay ID.
     */
    public int getCosplayId() {
        return this.cosplayId;
    }

    /**
     * Gets the score of the cosplay.
     *
     * @return The cosplay score.
     */
    public double getScore() {
        return this.score;
    }

    /**
     * Gets the name of the cosplay.
     *
     * @return The cosplay name.
     */ 
    public String getNameCosplay() {
        return this.nameCosplay;
    }

    /**
     * Gets the ID of the participant associated with the cosplay.
     *
     * @return The participant ID.
     */
    public int getParticipantId() {
        return this.participantId;
    }

    /**
     * Gets the ID of the activity associated with the cosplay.
     *
     * @return The activity ID.
     */
    public int getActivictyId() {
        return this.activityId;
    }

    /**
     * Gets the name of the participant associated with the cosplay.
     *
     * @return The participant name.
     */
    public String getparticipantName() {
        return this.participantName;
    }

    /**
     * Gets the document of the participant associated with the cosplay.
     *
     * @return The participant document.
     */
    public String getdocumentParticipant() {
        return this.documentParticipant;
    }

    /**
     * Checks the status of the cosplay.
     *
     * @return The cosplay status.
     */
    public boolean getStatusCosplay() {
        return this.statusCosplay;
    }

    //  SETTERS METTODS

    /**
     * Sets the ID of the cosplay.
     *
     * @param cosplayId The cosplay ID to set.
     */
    public void setCosplayId(int cosplayId) {
        this.cosplayId = cosplayId;
    }

    /**
     * Sets the score of the cosplay.
     *
     * @param score The cosplay score to set.
     */
    public void setScore(double score) {
        this.score = score;
    }

    /**
     * Sets the name of the cosplay.
     *
     * @param nameCosplay The cosplay name to set.
     */
    public void setNameCosplay(String nameCosplay) {
        this.nameCosplay = nameCosplay;
    }

    /**
     * Sets the ID of the participant associated with the cosplay.
     *
     * @param participantId The participant ID to set.
     */
    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    /**
     * Sets the ID of the activity associated with the cosplay.
     *
     * @param activityId The activity ID to set.
     */
    public void setActivictyId(int activictyId) {
        this.activityId = activictyId;
    }

    /**
     * Sets the name of the participant associated with the cosplay.
     *
     * @param participantName The participant name to set.
     */
    public void setparticipantName(String participantName) {
        this.participantName = participantName;
    }

    /**
     * Sets the status of the cosplay.
     *
     * @param statusCosplay The cosplay status to set.
     */
    public void setStatusCosplay(boolean statusCosplay) {
        this.statusCosplay = statusCosplay;
    }

    // METTOD TOSTRING

    /**
     * Returns a string representation of the cosplay object.
     *
     * @return A string representation of the cosplay.
     */
    @Override
    public String toString() {
        return "Cosplay{" + "cosplayId=" + cosplayId + ", score=" + score + ","
                + " nameCosplay=" + nameCosplay + ", participantName=" + participantName + '}';
    }

}
