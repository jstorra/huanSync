package com.u2team.huansync.activity.cosplay.managementCosplay.model;

public interface CosplayValidatorDao {
    void validateCosplayforActPartCospl(Cosplay cosplay);
    void validateCosplay(int idCosplay);
    void validateAct(Cosplay cosplay) ;
    
    
} 
