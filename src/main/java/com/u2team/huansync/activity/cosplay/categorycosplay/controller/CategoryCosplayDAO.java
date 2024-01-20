package com.u2team.huansync.activity.cosplay.categorycosplay.controller;

import com.u2team.huansync.activity.cosplay.categorycosplay.model.CategoryCosplay;
import com.u2team.huansync.persistencia.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase para acceder y manipular la tabla de categorías de cosplay en la base de datos.
 */
public class CategoryCosplayDAO {

    public List<CategoryCosplay> getAllCategories() {
        List<CategoryCosplay> categories = new ArrayList<>();

        try (Connection connection = ConexionBD.MySQLConnection()) {
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

    public void insertCategory(CategoryCosplay category) {
        try (Connection connection = ConexionBD.MySQLConnection()) {
            String sql = "INSERT INTO tbl_categoryCosplay (nameCosplay) VALUES (?)";
            try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, category.getNameCategoryCosplay());
                statement.executeUpdate();

                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        category.setCategoryCosplayId(generatedKeys.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCategory(CategoryCosplay category) {
        try (Connection connection = ConexionBD.MySQLConnection()) {
            String sql = "UPDATE tbl_categoryCosplay SET nameCosplay = ? WHERE categoryCosplayId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, category.getNameCategoryCosplay());
                statement.setInt(2, category.getCategoryCosplayId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCategory(int categoryId) {
        try (Connection connection = ConexionBD.MySQLConnection()) {
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

