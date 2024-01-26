package com.u2team.huansync.activity.cosplay.categorycosplay.controller;

import com.u2team.huansync.activity.cosplay.categorycosplay.model.CategoryCosplay;
import com.u2team.huansync.activity.cosplay.categorycosplay.model.CategoryCosplayDAO;

import java.util.List;

/**
 * Controller for managing cosplay categories.
 */

public class CategoryCosplayController {
    private static CategoryCosplayDAO categoryCosplayDAO = new CategoryCosplayDAO();

    /**
     * Retrieves all cosplay categories.
     *
     * @return List of cosplay categories.
     */

    public static List<CategoryCosplay> getAllCategories() {
        return categoryCosplayDAO.getAllCategories();
    }

    /**
     * Inserts a new cosplay category.
     *
     * @param nameCategory Name of the new cosplay category.
     */

    public static void insertCategory(String nameCategory) {
        categoryCosplayDAO.insertCategory(nameCategory);
    }

    /**
     * Updates an existing cosplay category.
     *
     * @param categoryId Identifier of the cosplay category to be updated.
     * @param newNameCategoryCosplay New name for the cosplay category.
     */

    public static void updateCategory(long categoryId, String newNameCategoryCosplay,boolean deletable) {
        categoryCosplayDAO.updateCategory(categoryId, newNameCategoryCosplay,deletable);
    }

    /**
     * Deletes a cosplay category.
     *
     * @param categoryId Identifier of the cosplay category to be deleted.
     */

    public static void deleteCategory(long categoryId) {
        categoryCosplayDAO.deleteCategory(categoryId);
    }
}
