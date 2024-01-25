/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.u2team.huansync.establishment.restaurant.model.DAO;

import com.u2team.huansync.establishment.DAO.*;
import com.u2team.huansync.establishment.restaurant.itemMenu.controller.ItemMenuController;
import com.u2team.huansync.establishment.restaurant.itemMenu.model.classes.ItemMenu;
import com.u2team.huansync.establishment.restaurant.model.classes.Restaurant;
import com.u2team.huansync.persistence.BDConnection;
import com.u2team.huansync.persistence.Operations;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author misae
 */
public class RestaurantDAO implements IGetAll<Restaurant>, IGetByIdDao<Restaurant> {

    @Override
    public List<Restaurant> getAll() {
        Operations.setConnection(BDConnection.MySQLConnection());
        // Create a query and send corresponding information in each field by replacing the character "?" with the information
        String stmGet = "SELECT * FROM tbl_establishments;";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmGet)) {
            ResultSet rs = Operations.query_db(ps);
            List<Restaurant> listRestaurants = new ArrayList<>();

            while (rs.next()) {
                List<ItemMenu> listItemMenu = new ArrayList<>();
                Restaurant res = new Restaurant();
                res.setEstablishmentId(rs.getLong("establishmentId"));
                res.setNameEstablishment(rs.getString("nameEstablishment"));
                res.setManagerEstablishmentId(rs.getLong("managerEstablishmentId"));
                res.setEstablishmentEventId(rs.getLong("eventId"));
                res.setCategoyEstablishment(res.getCategoyEstablisment(rs.getString("categoryEstablishment")));

                String stm2 = "SELECT * FROM tbl_itemmenu WHERE establishmentId = ?;";
                PreparedStatement ps2 = Operations.getConnection().prepareStatement(stm2);
                ps2.setLong(1, res.getEstablishmentId());
                ResultSet rs2 = Operations.query_db(ps2);
                while (rs2.next()) {
                    long itemMenuId = rs2.getLong("itemMenuId");
                    ItemMenu item = ItemMenuController.getByIdFull(itemMenuId);
                    listItemMenu.add(item);
                }
                res.setListItemMenu(listItemMenu);
                listRestaurants.add(res);
            }
            return listRestaurants;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("An error has occurred: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Restaurant getById(long id) {
Operations.setConnection(BDConnection.MySQLConnection());
        // Create a query and send corresponding information in each field by replacing the character "?" with the information
        String stmGet = "SELECT * FROM tbl_establishments WHERE establishmentId = ?;";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmGet)) {
            
            ps.setLong(1, id);
            ResultSet rs = Operations.query_db(ps);

            if (rs.next()) {
                List<ItemMenu> listItemMenu = new ArrayList<>();
                Restaurant res = new Restaurant();
                res.setEstablishmentId(rs.getLong("establishmentId"));
                res.setNameEstablishment(rs.getString("nameEstablishment"));
                res.setManagerEstablishmentId(rs.getLong("managerEstablishmentId"));
                res.setEstablishmentEventId(rs.getLong("eventId"));
                res.setCategoyEstablishment(res.getCategoyEstablisment(rs.getString("categoryEstablishment")));

                String stm2 = "SELECT * FROM tbl_itemmenu WHERE establishmentId = ?;";
                PreparedStatement ps2 = Operations.getConnection().prepareStatement(stm2);
                ps2.setLong(1, res.getEstablishmentId());
                ResultSet rs2 = Operations.query_db(ps2);
                while (rs2.next()) {
                    long itemMenuId = rs2.getLong("itemMenuId");
                    ItemMenu item = ItemMenuController.getByIdFull(itemMenuId);
                    listItemMenu.add(item);
                }
                res.setListItemMenu(listItemMenu);
                return res;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("An error has occurred: " + e.getMessage());
        }
        return null;
    }

}
