package com.u2team.huansync.activity.cosplay.managementCosplay.model;

public interface CosplayValidatorDao {
    boolean validateParticipantion(int activityId, int participantId);

    boolean validateParticipant(int idParticipant);

    void validateCosplayisActive(int idCosplay);

    void validateCosplayisDesact(int idCosplay);

}
