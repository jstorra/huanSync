package com.u2team.huansync.event.workerRoles.model.classes;

import java.util.List;

/**
 *
 * @author Edgar Pinzon
 */

/**
 * Represents a wirkerRole with  properties such as workerRoleId, workerRoleName, capacity, workerRoleActivities.
 * This class provides methods to access and modify the attributes of the workerRole.
*/

public class WorkerRole {

    // Class Attributes


    // Unique identifier for the workerRole.
    private long workerRoleId;

     // Name of the workerRole.
    private String workerRoleName;

    // List with strings representing the activities performed by the workerRole
    private List<String> workerRoleActivities;


    /**
     * Void constructor 
     * Empty constructor to create an instance of workerRole without defined attributes
    */


    public WorkerRole() {
    }


    /**
     * Parameterized constructor to initialize atributes with provided values.
     *
     * @param workerRoleName              Name of the workerRole.
     * @param Activites              List with strings representing the activities performed by the workerRole.   
    */


    public WorkerRole(String workerRoleName, List<String> Activites) {
        this.workerRoleName = workerRoleName;
        this.workerRoleActivities = Activites;
    }


    // Get and set methods for workerRole id
    public long getWorkerRoleId() {
        return workerRoleId;
    }

    public void setWorkerRoleId(long workerRoleId) {
        this.workerRoleId = workerRoleId;
    }

    // Get and set methods for workerRole name

    public String getWorkerRoleName() {
        return workerRoleName;
    }

    public void setWorkerRoleName(String workerRoleName) {
        this.workerRoleName = workerRoleName;
    }


    // Get and set methods for the activities of the workerRole
    public List<String> getWorkerRoleActivities() {
        return workerRoleActivities;
    }

    public void setWorkerRoleActivities(List<String> workerRoleActivities) {
        this.workerRoleActivities = workerRoleActivities;
    }

    /**
     * Overrides the default toString method to provide a string representation of the workerRole object.
     *
     * @return A string representation of the workerRole object.
    */

    @Override
    public String toString() {
        return "WorkerRole{" + "workerRoleId=" + workerRoleId + ", workerRoleName=" + workerRoleName + ", workerRoleActivities=" + workerRoleActivities + '}';
    }

    
}
