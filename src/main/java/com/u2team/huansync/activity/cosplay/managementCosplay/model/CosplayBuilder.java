package com.u2team.huansync.activity.cosplay.managementCosplay.model;

public interface CosplayBuilder {
    CosplayBuilder cosplayId( int cosplayId) ;
    CosplayBuilder score( double score) ;
    CosplayBuilder nameCosplay(String nameCosplay);
    CosplayBuilder participantId(int participantId);
    CosplayBuilder activictyId(int activictyId);
    Cosplay build();
}
