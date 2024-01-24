package com.u2team.huansync.activity.cosplay.managementCosplay.Controller;

import java.util.*;
import com.u2team.huansync.activity.cosplay.managementCosplay.model.Cosplay;
import com.u2team.huansync.activity.cosplay.managementCosplay.model.CosplayBuilderImpl;
import com.u2team.huansync.activity.cosplay.managementCosplay.model.CosplayDaoOperationsCrudImpl;

/**
 * Controller class for managing cosplay operations.
 */
public class ControllerMagnamentCosplay {
    private CosplayDaoOperationsCrudImpl cosplayDaoOperationsCrudImpl;

    /**
     * Constructor for initializing the controller with a CosplayDaoOperationsCrudImpl instance.
     */
    public ControllerMagnamentCosplay() {
        this.cosplayDaoOperationsCrudImpl = new CosplayDaoOperationsCrudImpl();
    }

    /**
     * Retrieves a list of cosplays based on the provided activity ID.
     *
     * @param idActivitieCosplay The ID of the activity associated with the cosplays.
     * @return A list of cosplays containing only essential information for front-ends.
     */
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

    /**
     * Adds a new cosplay with the provided information.
     *
     * @param nameCosplay  The name of the cosplay.
     * @param participantId The ID of the participant associated with the cosplay.
     * @param activitieId   The ID of the activity associated with the cosplay.
     */
    public void addCosplay(String nameCosplay, int participantId, int activitieId) {

        Cosplay dtaCosplay = new CosplayBuilderImpl()
                .nameCosplay(nameCosplay)
                .participantId(participantId)
                .activictyId(activitieId)
                .build();
        cosplayDaoOperationsCrudImpl.createCosplay(dtaCosplay);

    }

    /**
     * Updates the name of a cosplay with the provided information.
     *
     * @param cosplayId      The ID of the cosplay to be updated.
     * @param newNameCosplay The new name for the cosplay.
     */
    public void updateCosplay(int cosplayId, String newNameCosplay) {
        Cosplay dtaCosplay = new CosplayBuilderImpl()
                .cosplayId(cosplayId)
                .nameCosplay(newNameCosplay)
                .build();

        cosplayDaoOperationsCrudImpl.updateCosplay(dtaCosplay);

    }

    /**
     * Deletes a cosplay with the provided ID.
     *
     * @param idCosplay The ID of the cosplay to be deleted.
     */
    public void deleteCosplay(int idCosplay) {

        cosplayDaoOperationsCrudImpl.deleteCosplay(idCosplay);

    }

}
