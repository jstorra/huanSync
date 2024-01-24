package com.u2team.huansync.activity.cosplay.managementCosplay.model;

public interface CosplayValidatorDao {
    // void validateCosplayforActPartCospl(Cosplay cosplay);

    void validateCosplayisActive(int idCosplay);

    void validateCosplayisDesact(int idCosplay);

}
