package com.u2team.huansync.activity.cosplay.managementCosplay.model;

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

    public int getCosplayId() {
        return this.cosplayId;
    }

    public double getScore() {
        return this.score;
    }

    public String getNameCosplay() {
        return this.nameCosplay;
    }

    public int getParticipantId() {
        return this.participantId;
    }

    public int getActivictyId() {
        return this.activityId;
    }

    public String getparticipantName() {
        return this.participantName;
    }

    public String getdocumentParticipant() {
        return this.documentParticipant;
    }

    public boolean getStatusCosplay() {
        return this.statusCosplay;
    }

    // METTODS SETTERS

    public void setCosplayId(int cosplayId) {
        this.cosplayId = cosplayId;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setNameCosplay(String nameCosplay) {
        this.nameCosplay = nameCosplay;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    public void setActivictyId(int activictyId) {
        this.activityId = activictyId;
    }

    public void setparticipantName(String participantName) {
        this.participantName = participantName;
    }

    public void setStatusCosplay(boolean statusCosplay) {
        this.statusCosplay = statusCosplay;
    }

    // METTOD TOSTRING

    @Override
    public String toString() {
        return "Cosplay{" + "cosplayId=" + cosplayId + ", score=" + score + ","
                + " nameCosplay=" + nameCosplay + ", participantName=" + participantName + '}';
    }

}
