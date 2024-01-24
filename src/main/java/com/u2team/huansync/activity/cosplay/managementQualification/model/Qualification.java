package com.u2team.huansync.activity.cosplay.managementQualification.model;

public class Qualification {
    
    private int cosplayid ;
    private int juryId ;
    private int qualification = 0 ;


    //METTODS GETTERS

    public int getCosplayId(){
        return this.cosplayid ;
    }

    public int getJuryId(){
        return this.juryId ;
    }



    public int qualification(){
        return this.qualification ;
    }

    //METTODS SETTERS

    public void setCosplayId (int cosplayid){
        this.cosplayid =cosplayid ;
    }

    public void setJuryId(int juryId){
        this.juryId= juryId;
    }

    public void setQualification(int qualification){
        this.qualification = qualification ;
    }

    @Override
    public String toString() {
        return "Qualification{" + "cosplayid=" + cosplayid + ", juryId=" + juryId + ", qualification=" + qualification + '}';
    }


    
    

}
