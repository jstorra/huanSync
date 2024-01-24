package com.u2team.huansync.establishment.restaurant.ingredient.model.DAO;

import com.u2team.huansync.establishment.DAO.IGetAll;
import com.u2team.huansync.establishment.restaurant.ingredient.model.classes.Ingredient;
import com.u2team.huansync.event.DAO.IDeleteDao;
import com.u2team.huansync.event.DAO.IGetByIdDao;
import com.u2team.huansync.event.DAO.ISaveDao;
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
 * @author misae
 */
public class IngredientDAO implements IGetAll<Ingredient>, ISaveDao<Ingredient>, IGetByIdDao<Ingredient>, IDeleteDao<Ingredient>, IUpdateDao<Ingredient> {

    @Override
    public Ingredient getById(long ingredientId) {
        Operations.setConnection(BDConnection.MySQLConnection());
        // Create a query and send corresponding information in each field by replacing the character "?" with the information
        String stmInsert = "SELECT * FROM tbl_ingredients WHERE ingredientId = ?;";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
            ps.setLong(1, ingredientId);
            ResultSet rs = Operations.query_db(ps);
            List<Ingredient> listIngredient = new ArrayList<>();
            if (rs.next()) {
                Ingredient ing = new Ingredient();
                ing.setIngredientId(rs.getLong("ingredientId"));
                ing.setNameIngredient(rs.getString("nameIngredient"));
                ing.setAvailableQuantity(rs.getInt("availableQuantity"));
                ing.setEstablishmentId(rs.getLong("establishmentId"));
                return ing;
            } else {
                System.out.println("Not found ingredient");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("An error has occurred: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Ingredient> getAll() {
        Operations.setConnection(BDConnection.MySQLConnection());
        // Create a query and send corresponding information in each field by replacing the character "?" with the information
        String stmInsert = "SELECT * FROM tbl_ingredients;";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
            ResultSet rs = Operations.query_db(ps);
            List<Ingredient> listIngredient = new ArrayList<>();
            while (rs.next()) {
                Ingredient ing = new Ingredient();
                ing.setIngredientId(rs.getLong("ingredientId"));
                ing.setNameIngredient(rs.getString("nameIngredient"));
                ing.setAvailableQuantity(rs.getInt("availableQuantity"));
                ing.setEstablishmentId(rs.getLong("establishmentId"));
                listIngredient.add(ing);
            }
            return listIngredient;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("An error has occurred: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void save(Ingredient t) {
        Operations.setConnection(BDConnection.MySQLConnection());
        // Create a query and send corresponding information in each field by replacing the character "?" with the information
        String stmInsert = "INSERT INTO tbl_ingredients (nameIngredient, availableQuantity, establishmentId) VALUES(?, ?, ?);";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
            ps.setString(1, t.getNameIngredient());
            ps.setInt(2, t.getAvailableQuantity());
            ps.setLong(3, t.getEstablishmentId());
            // use Operation class with insert_update_delete and verify if the rows in database are affected
            int rows = Operations.insert_update_delete_db(ps);

            if (rows <= 0) {
                System.out.println("Error insert ingredient to database");
            } else {
                System.out.println("Successful  insert ingredient");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("An error has occurred: " + e.getMessage());
        }
    }

    @Override
    public void delete(long ingredientId) {
        Operations.setConnection(BDConnection.MySQLConnection());
        // Create a query and send corresponding information in each field by replacing the character "?" with the information
        String stmInsert = "DELETE FROM tbl_ingredients WHERE ingredientId = ?;";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
            ps.setLong(1, ingredientId);
            // use Operation class with insert_update_delete and verify if the rows in database are affected
            int rows = Operations.insert_update_delete_db(ps);
            if (rows <= 0) {
                System.out.println("Error delete ingredient  from database");
            } else {
                System.out.println("Successful  delete ingredient");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("An error has occurred: " + e.getMessage());
        }
    }

    @Override
    public void update(Ingredient ingredient) {
        Ingredient sqlIngredient = getById(ingredient.getIngredientId());

        if (sqlIngredient != null) {
            sqlIngredient.setNameIngredient(ingredient.getNameIngredient());
            sqlIngredient.setAvailableQuantity(ingredient.getAvailableQuantity());
            sqlIngredient.setEstablishmentId(ingredient.getEstablishmentId());
            Operations.setConnection(BDConnection.MySQLConnection());
            // Create a query and send corresponding information in each field by replacing the character "?" with the information
            String stmInsert = """
                           UPDATE tbl_ingredients 
                           SET nameIngredient = ?,
                           availableQuantity = ?,
                           establishmentId = ?
                           WHERE ingredientId = ?
                           """;
            try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
                ps.setString(1, sqlIngredient.getNameIngredient());
                ps.setInt(2, sqlIngredient.getAvailableQuantity());
                ps.setLong(3, sqlIngredient.getEstablishmentId());
                ps.setLong(4, sqlIngredient.getIngredientId());

                // use Operation class with insert_update_delete and verify if the rows in database are affected
                int rows = Operations.insert_update_delete_db(ps);

                if (rows <= 0) {
                    System.out.println("Error update ingredient to database");
                } else {
                    System.out.println("Successful  update ingredient");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("An error has occurred: " + e.getMessage());
            }

        } else {
            System.out.println("Ingredient to update not found");
        }
    }

}
