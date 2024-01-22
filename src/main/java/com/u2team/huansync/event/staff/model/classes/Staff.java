
package com.u2team.huansync.event.staff.model.classes;

import java.time.LocalDate;

/**
 *
 * @author criis
 */
public class Staff {
    private long staffId;
    private String staffNumberId;
    private String nameStaff;
    private LocalDate birthdayStaff;
    private StatusStaffEnum statusStaffEnum;
    private long workerRoleId;
    
    //Construter

    public Staff() {
    }

    public Staff(long staffId, String staffNumberId, String nameStaff, LocalDate birthdayStaff, String statusStaffEnum, long workerRoleId) {
        this.staffId = staffId;
        this.staffNumberId = staffNumberId;
        this.nameStaff = nameStaff;
        this.birthdayStaff = birthdayStaff;
        this.statusStaffEnum = getStatusStaffEnum(statusStaffEnum);
        this.workerRoleId = workerRoleId;
    }

    //Getter and Setters

    public long getStaffId() { return staffId; }
    public void setStaffId(long staffId) {
        this.staffId = staffId;
    }

    public String getStaffNumberId() { return staffNumberId; }

    public void setStaffNumberId(String staffNumberId) { this.staffNumberId = staffNumberId; }

    public String getNameStaff() {
        return nameStaff;
    }

    public void setNameStaff(String nameStaff) {
        this.nameStaff = nameStaff;
    }

    public LocalDate getBirthdayStaff() {
        return birthdayStaff;
    }

    public void setBirthdayStaff(LocalDate birthdayStaff) {
        this.birthdayStaff = birthdayStaff;
    }

    public StatusStaffEnum getStatusStaffEnum() {
        return statusStaffEnum;
    }

    public void setStatusStaffEnum(StatusStaffEnum statusStaffEnum) {
        this.statusStaffEnum = statusStaffEnum;
    }

    public long getWorkerRoleId() {
        return workerRoleId;
    }

    public void setWorkerRoleId(long workerRoleId) {
        this.workerRoleId = workerRoleId;
    }

    public StatusStaffEnum getStatusStaffEnum(String statusStaffEnum) {
    StatusStaffEnum statusEnum = null;

    if (statusStaffEnum.equalsIgnoreCase("task_assigned")){
        statusEnum = StatusStaffEnum.TASK_ASSIGNED;
     }
     if (statusStaffEnum.equalsIgnoreCase("no_task_assigned")){
        statusEnum = StatusStaffEnum.NO_TASK_ASSIGNED;
     }
     if (statusStaffEnum.equalsIgnoreCase("dismissed")){
        statusEnum = StatusStaffEnum.DISMISSED;
     }
     if (statusStaffEnum.equalsIgnoreCase("incapacited")){
        statusEnum = StatusStaffEnum.INCAPACITED;
     }

     return statusEnum;
    }

    //toString


    @Override
    public String toString() {
        return "Staff{" +
                "staffId=" + staffId +
                ", staffNumberId='" + staffNumberId + '\'' +
                ", nameStaff='" + nameStaff + '\'' +
                ", birthdayStaff=" + birthdayStaff +
                ", statusStaffEnum=" + statusStaffEnum +
                ", workerRoleId=" + workerRoleId +
                '}';
    }
}
