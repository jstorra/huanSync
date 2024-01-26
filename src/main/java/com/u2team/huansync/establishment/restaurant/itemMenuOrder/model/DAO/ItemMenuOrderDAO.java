/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u2team.huansync.establishment.restaurant.itemMenuOrder.model.DAO;

import com.u2team.huansync.establishment.DAO.IDeleteDao;
import com.u2team.huansync.establishment.DAO.ISaveDao;
import com.u2team.huansync.establishment.restaurant.itemMenuOrder.model.classes.ItemMenuOrder;
import com.u2team.huansync.event.DAO.IGetAllDao;
import com.u2team.huansync.event.DAO.IGetByIdDao;
import com.u2team.huansync.event.DAO.IUpdateDao;
import com.u2team.huansync.persistence.BDConnection;
import com.u2team.huansync.persistence.Operations;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dfrincong
 */
public class ItemMenuOrderDAO implements ISaveDao<ItemMenuOrder>, IDeleteDao<ItemMenuOrder>,IGetAllDao<ItemMenuOrder>, IGetByIdDao<ItemMenuOrder>, IUpdateDao<ItemMenuOrder> {

    @Override
    public void save(ItemMenuOrder t) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stmInsert = "INSERT INTO tbl_itemMenu_order (orderId, itemMenuId, quantity) VALUES (?, ?, ?)";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
            ps.setLong(1, t.getOrderId());
            ps.setLong(2, t.getItemMenuId());
            ps.setInt(3, t.getQuantity());

            int rows = Operations.insert_update_delete_db(ps);
            if (rows <= 0) {
                System.out.println("Cannot insert in table tbl_itemMenu_order");
            } else {
                System.out.println("Successful insert in table tbl_itemMenu_order");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(long id) {
        Operations.setConnection(BDConnection.MySQLConnection());
        // Create a query and send corresponding information in each field by replacing the character "?" with the information
        String stm = "DELETE FROM tbl_itemMenu_order WHERE orderId = ?;";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, id);
            // use Operation class with insert_update_delete and verify if the rows in database are affected
            int rows = Operations.insert_update_delete_db(ps);
            if (rows <= 0) {
                System.out.println("Error delete order  from database");
            } else {
                System.out.println("Successful  delete order");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("An error has occurred: " + e.getMessage());
        }
    }

    @Override
    public List<ItemMenuOrder> getAll() {
        Operations.setConnection(BDConnection.MySQLConnection());
        // Create a query and send corresponding information in each field by replacing the character "?" with the information
        String stm = "SELECT * FROM tbl_itemMenu_order;";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ResultSet rs = Operations.query_db(ps);
            List<ItemMenuOrder> listItemMenuOrder = new ArrayList<>();
            while (rs.next()) {
                ItemMenuOrder imo = new ItemMenuOrder();
                imo.setOrderId(rs.getLong("orderId"));
                imo.setItemMenuId(rs.getLong("itemMenuId"));
                imo.setQuantity(rs.getInt("quantity"));
                listItemMenuOrder.add(imo);
            }
            return listItemMenuOrder;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("An error has occurred: " + e.getMessage());
        }
        return null;
    }

    @Override
    public ItemMenuOrder getById(long id) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "select * from tbl_itemMenu_order where orderId = ? ;";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, id);
            ResultSet rs = Operations.query_db(ps);

            if (rs.next()) {
                ItemMenuOrder itemMenuOrder = new ItemMenuOrder();
                
                itemMenuOrder.setOrderId(rs.getLong("orderId"));
                itemMenuOrder.setItemMenuId(rs.getLong("itemMenuId"));
                itemMenuOrder.setQuantity(rs.getInt("quantity"));
                return itemMenuOrder;
            } else {
                System.out.println("ERROR: The id has not been found");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(ItemMenuOrder t) {
        ItemMenuOrder sqlItemMenuOrder = getById(t.getOrderId());

        if (sqlItemMenuOrder != null) {
            sqlItemMenuOrder.setOrderId(t.getOrderId());
            sqlItemMenuOrder.setItemMenuId(t.getItemMenuId());
            sqlItemMenuOrder.setQuantity(t.getQuantity());
            
            
            String stmUpdate = """
            UPDATE tbl_itemMenu_order
            SET itmeMenuId = ?,
                quantity = ?
            WHERE orderId = ?;
                               """;

            try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmUpdate)) {

                ps.setLong(1, sqlItemMenuOrder.getItemMenuId());
                
                //With Long I don´t have mistake, but I think it is Int
                ps.setInt(2, sqlItemMenuOrder.getQuantity());
                ps.setLong(3, sqlItemMenuOrder.getOrderId());
                
                
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
    
}
