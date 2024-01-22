package com.u2team.huansync.activity.cosplay.categorycosplay.controller;

import com.u2team.huansync.activity.cosplay.categorycosplay.model.CategoryCosplay;
import java.util.List;

/**
 * Controller for managing cosplay categories.
 */

public class CategoryCosplayController {
    private CategoryCosplayDAO categoryCosplayDAO = new CategoryCosplayDAO();

    /**
     * Retrieves all cosplay categories.
     *
     * @return List of cosplay categories.
     */

    public List<CategoryCosplay> getAllCategories() {
        return categoryCosplayDAO.getAllCategories();
    }

    /**
     * Inserts a new cosplay category.
     *
     * @param nameCategory Name of the new cosplay category.
     */

    public void insertCategory(String nameCategory) {
        categoryCosplayDAO.insertCategory(nameCategory);
    }

    /**
     * Updates an existing cosplay category.
     *
     * @param categoryId Identifier of the cosplay category to be updated.
     * @param newNameCategoryCosplay New name for the cosplay category.
     */

    public void updateCategory(int categoryId, String newNameCategoryCosplay) {
        categoryCosplayDAO.updateCategory(categoryId, newNameCategoryCosplay);
    }

    /**
     * Deletes a cosplay category.
     *
     * @param categoryId Identifier of the cosplay category to be deleted.
     */

    public void deleteCategory(int categoryId) {
        categoryCosplayDAO.deleteCategory(categoryId);
    }
}
