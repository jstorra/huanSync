package com.u2team.huansync.activity.cosplay.managementCosplay.model;

public class Cosplay {

    // PROPERTIES
    private int cosplayId ;
    private double score ;
    private String nameCosplay ;
    private int participantId ;
    private int activityId ;

    // CONSTRUCTORS


    public Cosplay(){

    }

    public Cosplay (int cosplayId,double score , String nameCosplay , int participantId , int activictyId){
        this.setCosplayId(cosplayId);
        this.setScore(score);
        this.setNameCosplay(nameCosplay);
        this.setParticipantId(participantId);
        this.setActivictyId(activictyId);
    }


    // METTODS GETTERS

    public int getCosplayId() {
        return this.cosplayId ;
    }


    public double getScore() {
        return this.score ;
    }


    public String getNameCosplay() {
        return this.nameCosplay ;
    }


    public int getParticipantId() {
        return this.participantId ;
    }


    public int getActivictyId(){
        return this.activityId ;
    }


    // METTODS SETTERS

    public void setCosplayId(int cosplayId) {
        this.cosplayId = cosplayId ;
    }


    public void setScore(double score) {
        this.score = score ;
    }


    public void setNameCosplay(String nameCosplay) {
        this.nameCosplay = nameCosplay;
    }

    public void setParticipantId(int participantId){
        this.participantId = participantId ;
    }

    public void setActivictyId(int activictyId){
        this.activityId = activictyId ;
    }

    @Override
    public String toString() {
        return "Cosplay{" + "cosplayId=" + cosplayId + ", score=" + score + ", nameCosplay=" + nameCosplay + ", participantId=" + participantId + ", activityId=" + activityId + '}';
    }

    
    
    
}
