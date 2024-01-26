package com.u2team.huansync.activity.cosplay.managementQualification.controller;
import java.util.List;
import com.u2team.huansync.activity.cosplay.managementQualification.model.QualificationDaoImp;

public class ControllerQualification {
    private QualificationDaoImp qualificationDaoImp;

    /**
     * Constructor for initializing the controller with a ControllerQualification instance.
     */
    public ControllerQualification() {
        this.qualificationDaoImp = new QualificationDaoImp();
    }


    public int numberQualification (int idCosplay) {
        int numbersItems = qualificationDaoImp.listJuryQualifications(idCosplay).size();
        return numbersItems ;

    }

    public void sendQualification(int idCosplay, List<Integer>Qualifications){
         qualificationDaoImp.send(idCosplay,Qualifications);
    }
}
