package com.u2team.huansync.event.workerRoles.model.classes;

import java.util.List;



public class WorkerRole {

    private long workerRoleId;
    private String workerRoleName;
    private List<String>activitiesWorkerRole;

    public WorkerRole() {
    }

    
    public WorkerRole(String workerRoleName, List<String> Activites) {
        this.workerRoleName = workerRoleName;
        this.activitiesWorkerRole = Activites;
    }

    public long getWorkerRoleId() {
        return workerRoleId;
    }

    public void setWorkerRoleId(long workerRoleId) {
        this.workerRoleId = workerRoleId;
    }

    public String getWorkerRoleName() {
        return workerRoleName;
    }

    public void setWorkerRoleName(String workerRoleName) {
        this.workerRoleName = workerRoleName;
    }

    public List<String> getActivitiesWorkerRole() {
        return activitiesWorkerRole;
    }

    public void setActivitiesWorkerRole(List<String> activitiesWorkerRole) {
        this.activitiesWorkerRole = activitiesWorkerRole;
    }

    
   

    @Override
    public String toString() {
        return "WorkerRole{" + "workerRoleId=" + workerRoleId + ", workerRoleName=" + workerRoleName + ", activitiesWorkerRole=" + activitiesWorkerRole + '}';
    }



    
    
    
    
    
    

}