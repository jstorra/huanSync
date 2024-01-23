package com.u2team.huansync.activity.cosplay.managementCosplay.model;

import java.sql.SQLException;
import java.util.List;

public interface CosplayDaoOperationsCrud {
    
    public List<Cosplay> readCosplay();

    public void createCosplay(Cosplay cosplay);

    public void updateCosplay(Cosplay cosplay) throws SQLException;

    public void deleteCosplay(int idCosplay);
}
