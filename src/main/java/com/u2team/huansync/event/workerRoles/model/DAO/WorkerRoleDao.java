/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u2team.huansync.event.workerRoles.model.DAO;

import com.u2team.huansync.event.model.DAO.IDao;
import com.u2team.huansync.event.model.classes.Event;
import com.u2team.huansync.event.model.classes.builders.EventBuilder;
import com.u2team.huansync.event.model.classes.builders.EventConcreteBuilder;
import com.u2team.huansync.event.workerRoles.model.classes.WorkerRole;
import com.u2team.huansync.persistence.BDConnection;
import com.u2team.huansync.persistence.Operations;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class WorkerRoleDao implements IDao<WorkerRole> {

    @Override
    public WorkerRole getById(long id) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "select * from tbl_workerRoles where workerRoleId = ? ;";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, id);
            ResultSet rs = Operations.query_db(ps);
            if (rs.next()) {
                WorkerRole workerRole = new WorkerRole();
                workerRole.setWorkerRoleId(rs.getLong("workerRoleId"));
             
                workerRole.setWorkerRoleName(rs.getString("nameWorkerRole" ));
                List<String> listActivities = Arrays.asList(rs.getString("activitiesWorkerRole").split("\\|"));
                workerRole.setActivitiesWorkerRole(listActivities);
                return workerRole;
            } else {
                System.out.println("ERROR: The id has not been found");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<WorkerRole> getAll() {
        List<WorkerRole> workerRolesList = new ArrayList<>();
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "select * from tbl_workerRoles ;";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {

            ResultSet rs = Operations.query_db(ps);
            
            while(rs.next()){
                WorkerRole workerRole = new WorkerRole();
                workerRole.setWorkerRoleName(rs.getString("nameWorkerRole" ));
                List<String> listActivities = Arrays.asList(rs.getString("activitiesWorkerRole").split("\\|"));
                workerRole.setActivitiesWorkerRole(listActivities);
                workerRolesList.add(workerRole);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return workerRolesList;
    }

    @Override
    public void save(WorkerRole t) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stmInsert = "INSERT INTO tbl_workerRoles (nameWorkerRole,activitiesWorkerRole) VALUES (?,?);";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
            ps.setString(1, t.getWorkerRoleName());
            String activitiesWorkerRole = String.join("|",   t.getActivitiesWorkerRole());
            ps.setString(2, activitiesWorkerRole);
            
            int rows = Operations.insert_update_delete_db(ps);
            if (rows <= 0) {
                System.out.println("Cannot insert worker role");
            } else {
                System.out.println("Successful insert of worker role");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        
    }

    // cambiar nombre setActivitiesWokerRole por workerRoleActivities
    
    @Override
    public void update(WorkerRole workerRole) {
        
        WorkerRole sqlWorkerRole =   getById(workerRole.getWorkerRoleId());
        
        if (sqlWorkerRole != null) {
            sqlWorkerRole.setWorkerRoleName(workerRole.getWorkerRoleName()); 
            sqlWorkerRole.setActivitiesWorkerRole(workerRole.getActivitiesWorkerRole()); 
            String stmUpdate = """
            UPDATE tbl_workerRoles
            SET nameWorkerRole = ?,
                activitiesWorkerRole = ?
            WHERE workerRoleId = ?;
                               """;
            
            
            try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmUpdate)){

                ps.setString(1, sqlWorkerRole.getWorkerRoleName());
                String activitiesWorkerRole = String.join("|",   sqlWorkerRole.getActivitiesWorkerRole());
                ps.setString(2, activitiesWorkerRole);
                ps.setLong(3 , sqlWorkerRole.getWorkerRoleId());
                System.out.println(ps.toString());
                int rows = Operations.insert_update_delete_db(ps);
                if (rows <= 0) {
                    System.out.println("Cannot update worker role");
                } else {
                    System.out.println("Successful update of worker role");
                }
             
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        
    }

    @Override
    public void delete(long workerRoleId) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "DELETE FROM tbl_workerRoles WHERE workerRoleId = ?;";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, workerRoleId);
            int rows = Operations.insert_update_delete_db(ps);
            if (rows > 0) {
                System.out.println("succesful delete workerRole");
                return;
            } else {
                System.out.println("not exists workerRole");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("something was wrong on delete workerRole");
        return;

    }

   
    
    
}
