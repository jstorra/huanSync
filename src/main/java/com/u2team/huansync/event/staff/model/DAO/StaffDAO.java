/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u2team.huansync.event.staff.model.DAO;

import com.u2team.huansync.event.model.DAO.IDao;
import com.u2team.huansync.event.staff.model.classes.Staff;
import com.u2team.huansync.persistence.BDConnection;
import com.u2team.huansync.persistence.Operations;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author criis
 */
public class StaffDAO implements IDao<Staff> {

    @Override
    public Staff getById(long id) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "select * from tbl_staff where staffId = ? ;";
        
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, id);
            ResultSet rs = Operations.query_db(ps);
            if (rs.next()) {
                Staff staff = new Staff();
                staff.setStaffId(rs.getLong("staffId"));
                staff.setNameStaff(rs.getString("nameStaff"));
                staff.setBirthdayStaff(LocalDate.parse(rs.getString("birthdayStaff")));
                staff.setStatusStaffEnum(staff.getStatusStaffEnum(rs.getString("statusStaff")));
                staff.setWorkerRoleId(rs.getInt("roleWorkId"));
                
                
                return staff;
            } else {
                System.out.println("ERROR: The id has not been found");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Staff> getAll() {
        List<Staff> listStaff = new ArrayList<>();
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "SELECT * FROM tbl_staff";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ResultSet rs = Operations.query_db(ps);
            while(rs.next()){
                Staff staff = new Staff();
                staff.setStaffId(rs.getLong("staffId"));
                staff.setNameStaff(rs.getString("nameStaff"));
                staff.setBirthdayStaff(LocalDate.parse(rs.getString("birthdayStaff")));
                staff.setStatusStaffEnum(staff.getStatusStaffEnum(rs.getString("statusStaff")));
                staff.setWorkerRoleId(rs.getInt("roleWorkId"));
                listStaff.add(staff);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listStaff;
    }

    @Override
    public void save(Staff t) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stmInsert = "INSERT INTO tbl_staff(nameStaff, birthdayStaff, statusStaff, roleWorkID) VALUES (?,?,?,?);";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
            ps.setString(1, t.getNameStaff());
            ps.setString(2, t.getBirthdayStaff().toString());
            ps.setString(3, t.getStatusStaffEnum().name());
            ps.setLong(4, t.getWorkerRoleId());

            int rows = Operations.insert_update_delete_db(ps);
            if (rows <= 0) {
                System.out.println("Cannot insert Staff member");
            } else {
                System.out.println("Successful insert of Staff member");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Staff t) {
        Operations.setConnection(BDConnection.MySQLConnection());
    }

    @Override
    public void delete(long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
