package com.u2team.huansync.activity.cosplay.managementCosplay.model;

public class CosplayBuilderImpl implements CosplayBuilder {

    private Cosplay cosplay = new Cosplay() ;

    @Override
    public CosplayBuilder cosplayId(int cosplayId) {
        cosplay.setCosplayId(cosplayId);
        return this ;
    }

    @Override
    public CosplayBuilder score(double score) {
        cosplay.setScore(score);
        return this ;
    }

    @Override
    public CosplayBuilder nameCosplay(String nameCosplay) {
        cosplay.setNameCosplay(nameCosplay);
        return this ;
    }

    @Override
    public CosplayBuilder participantId(int participantId) {
        cosplay.setParticipantId(participantId);
        return this ;
    }

    @Override
    public CosplayBuilder activictyId(int activictyId) {
        cosplay.setActivictyId(activictyId);
        return this ;
    }


    @Override
    public CosplayBuilder participantName(String participantName) {
        cosplay.setparticipantName(participantName);
        return this ;
    }

    @Override
    public Cosplay build() {
       return cosplay ;
    }

   
    
}
