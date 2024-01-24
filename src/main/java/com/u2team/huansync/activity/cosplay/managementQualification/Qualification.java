package com.u2team.huansync.activity.cosplay.managementQualification;

public class Qualification {
    
    private int cosplayid ;
    private int juryId ;
    private int qualification ;


    //METTODS GETTERS

    private int getCosplayId(){
        return this.cosplayid ;
    }

    private int getJuryId(){
        return this.juryId ;
    }



    private int qualification(){
        return this.qualification ;
    }

    //METTODS SETTERS

    private void setCosplayId (int cosplayid){
        this.cosplayid =cosplayid ;
    }

    private void setJuryId(int juryId){
        this.juryId= juryId;
    }

    private void setQualification(int qualification){
        this.qualification = qualification ;
    }

    @Override
    public String toString() {
        return "Qualification{" + "cosplayid=" + cosplayid + ", juryId=" + juryId + ", qualification=" + qualification + '}';
    }


    
    

}
