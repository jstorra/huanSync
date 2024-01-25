package com.u2team.huansync.activity.cosplay.managementQualification.model;

/**
 * Class representing a qualification for a cosplay by a jury member.
 */
public class Qualification {

    private int cosplayid;
    private int juryId;
    private int qualification = 0;

    // METTODS GETTERS

    /**
     * Gets the ID of the cosplay.
     *
     * @return The ID of the cosplay.
     */
    public int getCosplayId() {
        return this.cosplayid;
    }

    /**
     * Gets the ID of the jury member.
     *
     * @return The ID of the jury member.
     */
    public int getJuryId() {
        return this.juryId;
    }

    /**
     * Gets the qualification score.
     *
     * @return The qualification score.
     */
    public int getQualification() {
        return this.qualification;
    }

    // METTODS SETTERS

    /**
     * Sets the ID of the cosplay.
     *
     * @param cosplayId The ID of the cosplay.
     */
    public void setCosplayId(int cosplayid) {
        this.cosplayid = cosplayid;
    }

    /**
     * Sets the ID of the jury member.
     *
     * @param juryId The ID of the jury member.
     */
    public void setJuryId(int juryId) {
        this.juryId = juryId;
    }

    /**
     * Sets the qualification score.
     *
     * @param qualification The qualification score to set.
     */
    public void setQualification(int qualification) {
        this.qualification = qualification;
    }

    /**
     * Returns a string representation of the Qualification object.
     *
     * @return A string representation of the Qualification object.
     */
    @Override
    public String toString() {
        return "Qualification{" + "cosplayid=" + cosplayid + ", juryId=" + juryId + ", qualification=" + qualification
                + '}';
    }

}
