
package com.u2team.huansync.event.workerRoles.controller;

import com.u2team.huansync.event.workerRoles.model.DAO.WorkerRoleDao;
import com.u2team.huansync.event.workerRoles.model.classes.WorkerRole;
import java.util.List;

/**
 *
 * @author criis
 */
/**
 * Controller class for managing WorkerRole entities.
 */
public class WorkerRolesController {
    private WorkerRoleDao workerRoleDao;
    
    /**
     * Constructor for WorkerRolesController.
     * Initializes a new WorkerRoleDao instance.
     */
    public WorkerRolesController(){
        this.workerRoleDao = new WorkerRoleDao();
    }
    
    /**
     * Retrieves a WorkerRole by its ID.
     * 
     * @param workerRoleId The ID of the WorkerRole to retrieve.
     * @return The WorkerRole associated with the given ID, or null if not found.
     */
    public WorkerRole getByIdWorkerRole(long workerRoleId) {
        return workerRoleDao.getById(workerRoleId);
    }
    
    /**
     * Retrieves a list of all WorkerRoles.
     * 
     * @return A List of all WorkerRoles.
     */
    public List<WorkerRole> getAllWorkerRoles(){
        return workerRoleDao.getAll();
    }
    
    /**
     * Inserts a new WorkerRole into the database.
     * 
     * @param workerRole The WorkerRole object to insert.
     */
    public void insertWorkerRole(WorkerRole workerRole){
        workerRoleDao.save(workerRole);
    }
    
    /**
     * Deletes a WorkerRole from the database by its ID.
     * 
     * @param workerRoleId The ID of the WorkerRole to delete.
     */
    public void deleteWorkerRole(long workerRoleId){
        workerRoleDao.delete(workerRoleId);
    }
    
    /**
     * Updates an existing WorkerRole in the database.
     * 
     * @param workerRole The WorkerRole object to update.
     */
    public void updateWorkerRole(WorkerRole workerRole){
        workerRoleDao.update(workerRole);
    }
}

