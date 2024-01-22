/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u2team.huansync.event.equipment.model.DAO;


import com.u2team.huansync.event.DAO.IDeleteDao;
import com.u2team.huansync.event.DAO.ISaveDao;
import com.u2team.huansync.event.equipment.model.classes.Equipment;
import com.u2team.huansync.persistence.BDConnection;
import com.u2team.huansync.persistence.Operations;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author criis
 */
public class EquipmentDAO implements ISaveDao<Equipment>, IDeleteDao<Equipment> {


    @Override
    public void save(Equipment equipment) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stmInsert = "INSERT INTO tbl_equipment(nameEquipment, quantity, statusStaff) VALUES (?,?,?);";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
            ps.setString(1, equipment.getNameEquipment());
            ps.setLong(2, equipment.getQuantity());
            ps.setString(3, equipment.getStatusEquipmentEnum().name());
            
            int rows = Operations.insert_update_delete_db(ps);
            if (rows <= 0) {
                System.out.println("Cannot insert Equipment");
            } else {
                System.out.println("Successful insert of Equipment");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(long idEquipment) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "DELETE FROM tbl_equipment WHERE equipmentId = ?;";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, idEquipment);
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
