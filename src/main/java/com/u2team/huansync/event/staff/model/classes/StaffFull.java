
package com.u2team.huansync.event.staff.model.classes;

import com.u2team.huansync.event.workerRoles.model.classes.WorkerRole;

/**
 *
 * @author criis
 */
public class StaffFull extends Staff{
    
    private WorkerRole workerRole;

    public StaffFull(WorkerRole workerRole) {
        this.workerRole = workerRole;
    }

    public StaffFull(WorkerRole workerRole, String nameStaff, String birthdayStaff, String statusStaffEnum, long workerRoleId) {
        super(nameStaff, birthdayStaff, statusStaffEnum, workerRoleId);
        this.workerRole = workerRole;
    }

    public WorkerRole getWorkerRole() {
        return workerRole;
    }

    public void setWorkerRole(WorkerRole workerRole) {
        this.workerRole = workerRole;
    }
    
}
