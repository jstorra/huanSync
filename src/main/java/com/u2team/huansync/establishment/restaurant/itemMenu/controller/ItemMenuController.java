package com.u2team.huansync.establishment.restaurant.itemMenu.controller;

import com.u2team.huansync.establishment.restaurant.itemMenu.model.DAO.ItemMenuDAO;
import com.u2team.huansync.establishment.restaurant.itemMenu.model.classes.ItemMenu;
import com.u2team.huansync.establishment.restaurant.itemMenu.model.classes.ItemMenuFull;
import java.util.List;

/**
 *
 * @author misae
 */
public class ItemMenuController {

    private final static ItemMenuDAO itemMenuDAO = new ItemMenuDAO();

    public static void insertItemMenu(ItemMenu itemMenu) {
        itemMenuDAO.save(itemMenu);
    }

    public static void deleteItemMenu(long id) {
        itemMenuDAO.delete(id);
    }

    public static List<ItemMenu> getAllItemMenu() {
        return itemMenuDAO.getAll();
    }

    public static List<ItemMenuFull> getAllFullItemMenu() {
        return itemMenuDAO.getAllFull();
    }
    public static ItemMenuFull getByIdFull(long id){
        return itemMenuDAO.getByIdFull(id);
    }
}
