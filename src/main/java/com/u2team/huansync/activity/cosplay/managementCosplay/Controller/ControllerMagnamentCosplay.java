package com.u2team.huansync.activity.cosplay.managementCosplay.Controller;

import java.util.*;
import com.u2team.huansync.activity.cosplay.managementCosplay.model.Cosplay;
import com.u2team.huansync.activity.cosplay.managementCosplay.model.CosplayBuilderImpl;
import com.u2team.huansync.activity.cosplay.managementCosplay.model.CosplayDaoOperationsCrudImpl;

public class ControllerMagnamentCosplay {
    private CosplayDaoOperationsCrudImpl cosplayDaoOperationsCrudImpl;

    public ControllerMagnamentCosplay() {
        this.cosplayDaoOperationsCrudImpl = new CosplayDaoOperationsCrudImpl();
    }

    // listar
    public List<Cosplay> readAllCosplays(int idActivitieCosplay) {
        /*
         * 
         * WARNING FOR FRONT - ENDS
         * When it comes to scrolling through this list and showing the cosplays, only
         * *show the id of the cosplay, the score, the name of the cosplay and the name
         * of *the participant.
         */

        return cosplayDaoOperationsCrudImpl.readCosplay(idActivitieCosplay);

    }

    public void addCosplay(String nameCosplay, int participantId, int activitieId) {

        Cosplay dtaCosplay = new CosplayBuilderImpl()
                .nameCosplay(nameCosplay)
                .participantId(participantId)
                .activictyId(activitieId)
                .build();
        cosplayDaoOperationsCrudImpl.createCosplay(dtaCosplay);

    }

    public void updateCosplay(int cosplayId, String newNameCosplay) {
        Cosplay dtaCosplay = new CosplayBuilderImpl()
                .cosplayId(cosplayId)
                .nameCosplay(newNameCosplay)
                .build();

        cosplayDaoOperationsCrudImpl.updateCosplay(dtaCosplay);

    }

    public void deleteCosplay(int idCosplay) {

        cosplayDaoOperationsCrudImpl.deleteCosplay(idCosplay);

    }

}
