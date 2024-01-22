/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u2team.huansync.event.equipment.model.DAO;


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
public class EquipmentDAO implements ISaveDao<Equipment> {


    @Override
    public void save(Equipment equipment) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stmInsert = "INSERT INTO tbl_equipment(nameEquipment, quantity, statusStaff) VALUES (?,?,?);";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
            ps.setString(1, equipment.getNameEquipment());
            ps.setLong(2, equipment.getQuantity());
           //continuar
            
            

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
    
    
}
