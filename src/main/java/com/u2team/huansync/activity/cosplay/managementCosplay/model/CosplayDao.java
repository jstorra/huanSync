package com.u2team.huansync.activity.cosplay.managementCosplay.model;

import java.util.List;

public interface CosplayDao {
    public void validateCosplay(Cosplay cosplay);

    public boolean searchCosplay(int id);

    public List<Cosplay> readAll();

    public void addCosplay(Cosplay cosplay);

    public void modifyCosplay(Cosplay cosplay);

    public void desactivateCosplay(int id);
}
