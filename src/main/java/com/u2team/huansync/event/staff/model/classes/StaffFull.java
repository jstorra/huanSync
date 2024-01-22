
package com.u2team.huansync.event.staff.model.classes;

import com.u2team.huansync.event.workerRoles.model.classes.WorkerRole;

import java.time.LocalDate;

/**
 *
 * @author criis
 */
public class StaffFull extends Staff{
    private WorkerRole workerRole;

    public StaffFull() {
    }

    public StaffFull(long staffId, String staffNumberId, String nameStaff, LocalDate birthdayStaff, String statusStaffEnum, long workerRoleId, WorkerRole workerRole) {
        super(staffId, staffNumberId, nameStaff, birthdayStaff, statusStaffEnum, workerRoleId);
        this.workerRole = workerRole;
    }

    public WorkerRole getWorkerRole() {
        return workerRole;
    }

    public void setWorkerRole(WorkerRole workerRole) {
        this.workerRole = workerRole;
    }

    @Override
    public String toString() {
        return super.toString() +
                " " + workerRole +
                '}';
    }
}
