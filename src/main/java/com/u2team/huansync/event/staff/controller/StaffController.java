package com.u2team.huansync.event.staff.controller;

import com.u2team.huansync.event.staff.model.DAO.StaffDAO;
import com.u2team.huansync.event.staff.model.classes.Staff;
import java.util.List;

/**
 *
 * @author criis
 */
/**
 * Controller class for managing staff-related operations.
 * This class provides methods to interact with the StaffDAO for CRUD operations.
 */
public class StaffController {
    private StaffDAO staffDAO;

    /**
     * Constructor to initialize StaffController.
     * It initializes a new instance of StaffDAO.
     */
    public StaffController(){
        this.staffDAO = new StaffDAO();
    }
    
    /**
     * Retrieves a staff member by their ID.
     *
     * @param staffId The ID of the staff member to retrieve.
     * @return Staff object corresponding to the provided ID, or null if not found.
     */
    public Staff getByIdStaff(long staffId){
        return staffDAO.getById(staffId);
    }
    
     /**
     * Retrieves all staff members.
     *
     * @return A list of all staff members and match the workerRoleId .
     */
    public Staff getByIdFullStaff(long staffId){
        return staffDAO.getByIdFull(staffId);
    }
    
    /**
     * Retrieves all staff members.
     *
     * @return A list of all staff members.
     */
    public List<Staff> getAllStaff(){
        return staffDAO.getAll();
    }
    
    /**
     * Inserts a new staff member into the database.
     *
     * @param staff The Staff object to be inserted.
     */
    public void insertStaff(Staff staff){
        staffDAO.save(staff);
    }
    
    /**
     * Deletes a staff member from the database by their ID.
     *
     * @param staffId The ID of the staff member to delete.
     */
    public void deleteStaff(long staffId){
        staffDAO.delete(staffId);
    }

    /**
     * Updates the information of an existing staff member in the database.
     *
     * @param staff The Staff object with updated information.
     */
    public void updateStaff(Staff staff){
        staffDAO.update(staff);
    }
}
