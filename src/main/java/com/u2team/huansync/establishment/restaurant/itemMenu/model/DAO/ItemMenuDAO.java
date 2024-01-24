package com.u2team.huansync.establishment.restaurant.itemMenu.model.DAO;

import com.u2team.huansync.establishment.restaurant.DAO.*;
import com.u2team.huansync.establishment.restaurant.ingredient.controller.IngredientController;
import com.u2team.huansync.establishment.restaurant.ingredient.model.classes.Ingredient;
import com.u2team.huansync.establishment.restaurant.itemMenu.model.classes.ItemMenu;
import com.u2team.huansync.establishment.restaurant.itemMenu.model.classes.ItemMenuFull;
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
public class ItemMenuDAO implements ISaveDao<ItemMenu>, IDeleteDao<ItemMenu>, IGetAll<ItemMenu>, IGetAllFull<ItemMenuFull>, IGetByIdFull<ItemMenuFull> {

    @Override
    public void save(ItemMenu itemMenu) {
        List<Ingredient> listIngredient = IngredientController.getAllIngredients();
        boolean allIngredients = true;

        if (itemMenu.getListIngredientId() == null) {
            allIngredients = false;
        } else if (itemMenu.getListIngredientId().isEmpty()) {
            allIngredients = false;
        } else {
            List<Long> sqlListIngredient = new ArrayList<>();
            for (Ingredient ingredient : listIngredient) {
                sqlListIngredient.add(ingredient.getIngredientId());
            }
            allIngredients = sqlListIngredient.containsAll(itemMenu.getListIngredientId());
        }

        if (allIngredients) {
            Operations.setConnection(BDConnection.MySQLConnection());
            // Create a query and send corresponding information in each field by replacing the character "?" with the information
            String stmInsert = """
                           INSERT INTO tbl_itemMenu (nameItemMenu, priceItemMenu, itemMenuType, preparationTime)
                           VALUES (?, ?, ?, ?);
                           """;
            try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
                ps.setString(1, itemMenu.getNameItemMenu());
                ps.setDouble(2, itemMenu.getPriceItemMenu());
                ps.setString(3, itemMenu.getItemMenuType().getName());
                ps.setInt(4, itemMenu.getPreparationTime());

//                 use Operation class with insert_update_delete and verify if the rows in database are affected
                int rows = Operations.insert_update_delete_db(ps);
                if (rows <= 0) {
                    System.out.println("Cannot insert into itemMenu");
                } else {
                    System.out.println("Successful insert itemMenu");
                    String lastRow = "SELECT * FROM tbl_itemmenu ORDER BY itemMenuId DESC LIMIT 1;";
                    PreparedStatement ps2 = Operations.getConnection().prepareStatement(lastRow);
                    ResultSet rs = Operations.query_db(ps2);
                    if (rs.next()) {
                        long lastId = rs.getLong("itemMenuId");
                        itemMenu.setItemMenuId(lastId);
                        insertIngredienItemMenu(itemMenu);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("An error has occurred: " + e.getMessage());
            }
        } else {
            System.out.println("All ingredients don't exist");
        }

    }

    private void insertIngredienItemMenu(ItemMenu itemMenu) {
        for (Long ingredient : itemMenu.getListIngredientId()) {
            String stmInsert = """
                           INSERT INTO tbl_ingredients_itemmenu
                           VALUES (?, ?);
                           """;
            try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
                ps.setLong(1, itemMenu.getItemMenuId());
                ps.setLong(2, ingredient);

                int rows = Operations.insert_update_delete_db(ps);
                if (rows <= 0) {
                    System.out.println("Cannot insert into ingredients for itemMenu");
                } else {
                    System.out.println("Successful insert ingredients for itemMenu");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("An error has occurred: " + e.getMessage());
            }
        }

    }

    @Override
    public void delete(long id) {
        Operations.setConnection(BDConnection.MySQLConnection());
        // Create a query and send corresponding information in each field by replacing the character "?" with the information

        String stmDeleteRelation = "DELETE FROM tbl_ingredients_itemmenu WHERE itemMenuId = ?;";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmDeleteRelation)) {
            ps.setLong(1, id);
            // use Operation class with insert_update_delete and verify if the rows in database are affected
            int rows = Operations.insert_update_delete_db(ps);
            if (rows <= 0) {
                System.out.println("Error delete relations  from database");
            } else {
                System.out.println("Successful  delete item");
                String stmDelete = "DELETE FROM tbl_itemmenu WHERE itemMenuId = ?;";
                PreparedStatement ps2 = Operations.getConnection().prepareStatement(stmDelete);
                ps2.setLong(1, id);
                int rows2 = Operations.insert_update_delete_db(ps2);
                if (rows2 <= 0) {
                    System.out.println("Error delete item  from database");
                } else {
                    System.out.println("Successful  delete item");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("An error has occurred: " + e.getMessage());

        }
    }

    @Override
    public List<ItemMenu> getAll() {
        Operations.setConnection(BDConnection.MySQLConnection());
        // Create a query and send corresponding information in each field by replacing the character "?" with the information
        String stmGet = "SELECT * FROM tbl_itemmenu;";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmGet)) {
            ResultSet rs = Operations.query_db(ps);
            List<ItemMenu> listItemMenu = new ArrayList<>();
            while (rs.next()) {
                ItemMenu item = new ItemMenu();
                item.setItemMenuId(rs.getLong("itemMenuId"));
                item.setNameItemMenu(rs.getString("nameItemMenu"));
                item.setPriceItemMenu(rs.getDouble("priceItemMenu"));
                item.setItemMenuType(rs.getString("itemMenuType"));
                item.setPreparationTime(rs.getInt("preparationTime"));
                listItemMenu.add(item);
            }

            for (ItemMenu itemMenu : listItemMenu) {
                List<Long> listIngredients = new ArrayList<>();
                String stmRelations = "SELECT * FROM tbl_ingredients_itemmenu tii WHERE tii.itemMenuId = ?;";
                PreparedStatement ps2 = Operations.getConnection().prepareStatement(stmRelations);
                ps2.setLong(1, itemMenu.getItemMenuId());
                ResultSet rs2 = Operations.query_db(ps2);
                while (rs2.next()) {
                    listIngredients.add(rs2.getLong("ingredientId"));
                    itemMenu.setListIngredientId(listIngredients);
                }
            }

            return listItemMenu;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("An error has occurred: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<ItemMenuFull> getAllFull() {
        Operations.setConnection(BDConnection.MySQLConnection());
        // Create a query and send corresponding information in each field by replacing the character "?" with the information
        String stmGet = "SELECT * FROM tbl_itemmenu;";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmGet)) {
            ResultSet rs = Operations.query_db(ps);
            List<ItemMenuFull> listItemMenu = new ArrayList<>();
            while (rs.next()) {
                ItemMenuFull item = new ItemMenuFull();
                item.setItemMenuId(rs.getLong("itemMenuId"));
                item.setNameItemMenu(rs.getString("nameItemMenu"));
                item.setPriceItemMenu(rs.getDouble("priceItemMenu"));
                item.setItemMenuType(rs.getString("itemMenuType"));
                item.setPreparationTime(rs.getInt("preparationTime"));
                listItemMenu.add(item);
            }

            for (ItemMenuFull itemMenu : listItemMenu) {
                List<Long> listIngredientsId = new ArrayList<>();
                List<Ingredient> listIngredients = new ArrayList<>();

                String stmRelations = "SELECT * FROM tbl_ingredients_itemmenu tii WHERE tii.itemMenuId = ?;";
                PreparedStatement ps2 = Operations.getConnection().prepareStatement(stmRelations);
                ps2.setLong(1, itemMenu.getItemMenuId());
                ResultSet rs2 = Operations.query_db(ps2);
                while (rs2.next()) {
                    Long ingredientId = rs2.getLong("ingredientId");
                    Ingredient ing = IngredientController.getByIdIngredient(ingredientId);
                    listIngredientsId.add(ingredientId);
                    listIngredients.add(ing);
                    itemMenu.setListIngredientId(listIngredientsId);
                    itemMenu.setListIngredients(listIngredients);
                }
            }

            return listItemMenu;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("An error has occurred: " + e.getMessage());
        }
        return null;
    }

    @Override
    public ItemMenuFull getByIdFull(long id) {
        Operations.setConnection(BDConnection.MySQLConnection());
        // Create a query and send corresponding information in each field by replacing the character "?" with the information
        String stmGet = "SELECT * FROM tbl_itemmenu WHERE itemMenuId = ?;";
        
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmGet)) {
            ps.setLong(1, id);
            ResultSet rs = Operations.query_db(ps);
            ItemMenuFull item = new ItemMenuFull();

            while (rs.next()) {
                item.setItemMenuId(rs.getLong("itemMenuId"));
                item.setNameItemMenu(rs.getString("nameItemMenu"));
                item.setPriceItemMenu(rs.getDouble("priceItemMenu"));
                item.setItemMenuType(rs.getString("itemMenuType"));
                item.setPreparationTime(rs.getInt("preparationTime"));
            }

            List<Long> listIngredientsId = new ArrayList<>();
            List<Ingredient> listIngredients = new ArrayList<>();

            String stmRelations = """
                                      select ti.* from tbl_ingredients_itemmenu tii
                                      inner join tbl_itemmenu tmen on tmen.itemMenuId = tii.itemMenuId
                                      inner join tbl_ingredients ti on ti.ingredientId = tii.ingredientId
                                      where tmen.itemMenuId = ?;
                                      """;
            PreparedStatement ps2 = Operations.getConnection().prepareStatement(stmRelations);
            ps2.setLong(1, item.getItemMenuId());
            ResultSet rs2 = Operations.query_db(ps2);
            
            while (rs2.next()) {
                Long ingredientId = rs2.getLong("ingredientId");
                Ingredient ing =  new Ingredient(rs2.getLong("ingredientId"), rs2.getString("nameIngredient"), rs2.getInt("availableQuantity"));
                listIngredientsId.add(ingredientId);
                listIngredients.add(ing);
            }
            item.setListIngredientId(listIngredientsId);
            item.setListIngredients(listIngredients);
            return item;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("An error has occurred: " + e.getMessage());
        }
        return null;
    }

}
