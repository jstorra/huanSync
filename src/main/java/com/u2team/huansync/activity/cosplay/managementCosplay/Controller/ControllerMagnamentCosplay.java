package com.u2team.huansync.activity.cosplay.managementCosplay.Controller;

import java.util.List;
import com.u2team.huansync.activity.cosplay.managementCosplay.model.Cosplay;
import com.u2team.huansync.activity.cosplay.managementCosplay.model.CosplayBuilder;
import com.u2team.huansync.activity.cosplay.managementCosplay.model.CosplayBuilderImpl;
import com.u2team.huansync.activity.cosplay.managementCosplay.model.CosplayDaoOperationsCrudImpl;





public class ControllerMagnamentCosplay {
    private  CosplayDaoOperationsCrudImpl cosplayDaoOperationsCrudImpl ;
    
    public ControllerMagnamentCosplay(){
        this.cosplayDaoOperationsCrudImpl = new CosplayDaoOperationsCrudImpl();
    }


    // listar 
    public List<Cosplay> readAllCosplays(){
        /*
         * 
         * WARNING FOR FRONT - ENDS
         * When it comes to scrolling through this list and showing the cosplays, only *show the id of the cosplay, the score, the name of the cosplay and the name of *the participant.
         */

        return cosplayDaoOperationsCrudImpl.readCosplay();
    }

    public void addCosplay(String nameCosplay , int participantId , int activitieId){
         
        Cosplay dtaCosplay =
        new  CosplayBuilderImpl()
        .nameCosplay(nameCosplay)
        .participantId(participantId)
        .activictyId(activitieId)
        .build();

        cosplayDaoOperationsCrudImpl.createCosplay(dtaCosplay);

    }

    private void modifyCosplay(int cosplayId , String newNameCosplay){
        Cosplay dtaCosplay =
        new  CosplayBuilderImpl()
        .cosplayId(cosplayId)
        .nameCosplay(newNameCosplay)
        .build();

        cosplayDaoOperationsCrudImpl.updateCosplay(dtaCosplay);
    }

    private void desactivateCosplay(int idCosplay){
        cosplayDaoOperationsCrudImpl.deleteCosplay(idCosplay);
    }
        
}
