package com.u2team.huansync.activity.cosplay.managementCosplay.model;

import java.util.List;

public interface DaoCosplay {
    public boolean searchCosplay(int id) ;
    public List<Cosplay> readAll()  ;
    public void  addCosplay(Cosplay cosplay) ;
    public void modifyCosplay(int id) ;
    public void deleteCosplay(int id) ;
}
