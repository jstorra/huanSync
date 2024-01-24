package com.u2team.huansync.activity.cosplay.categorycosplay.model;

import com.u2team.huansync.persistence.BDConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object (DAO) for managing operations related to cosplay categories in the database.
 */

public class CategoryCosplayDAO {

    /**
     * Retrieves all cosplay categories from the database.
     *
     * @return List of cosplay categories.
     */

    public List<CategoryCosplay> getAllCategories() {
        List<CategoryCosplay> categories = new ArrayList<>();

        try (Connection connection = BDConnection.MySQLConnection()) {
            String sql = "SELECT * FROM tbl_categoryCosplay";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    CategoryCosplay category = new CategoryCosplay();
                    category.setCategoryCosplayId(resultSet.getInt("categoryCosplayId"));
                    category.setNameCategoryCosplay(resultSet.getString("nameCosplay"));
                    categories.add(category);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categories;
    }

    /**
     * Inserts a new cosplay category into the database.
     *
     * @param nameCategory Name of the new cosplay category.
     */

    public void insertCategory(String nameCategory) {
        try (Connection connection = BDConnection.MySQLConnection()) {
            String sql = "INSERT INTO tbl_categoryCosplay (nameCosplay) VALUES (?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, nameCategory);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates an existing cosplay category in the database.
     *
     * @param categoryId              Identifier of the cosplay category to be updated.
     * @param newNameCategoryCosplay New name for the cosplay category.
     */

    public void updateCategory(int categoryId, String newNameCategoryCosplay) {
        try (Connection connection = BDConnection.MySQLConnection()) {
            String sql = "UPDATE tbl_categoryCosplay SET nameCosplay = ? WHERE categoryCosplayId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, newNameCategoryCosplay);
                statement.setInt(2, categoryId);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes a cosplay category from the database.
     *
     * @param categoryId Identifier of the cosplay category to be deleted.
     */

    public void deleteCategory(int categoryId) {
        try (Connection connection = BDConnection.MySQLConnection()) {
            String sql = "DELETE FROM tbl_categoryCosplay WHERE categoryCosplayId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, categoryId);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
