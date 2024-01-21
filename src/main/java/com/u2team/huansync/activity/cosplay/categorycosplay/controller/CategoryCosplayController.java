package com.u2team.huansync.activity.cosplay.categorycosplay.controller;

import com.u2team.huansync.activity.cosplay.categorycosplay.model.CategoryCosplay;
import java.util.List;

/**
 * Controlador para la gestión de categorías de cosplay.
 */
public class CategoryCosplayController {
    private CategoryCosplayDAO categoryCosplayDAO = new CategoryCosplayDAO();
    /**
     * Obtiene todas las categorías de cosplay.
     *
     * @return Lista de categorías de cosplay.
     */
    public List<CategoryCosplay> getAllCategories() {
        return categoryCosplayDAO.getAllCategories();
    }

    /**
     * Inserta una nueva categoría de cosplay.
     *
     * @param nameCategoryCosplay Nombre de la nueva categoría de cosplay.
     */
    public void insertCategory(String nameCategoryCosplay) {
        CategoryCosplay category = new CategoryCosplay();
        category.setNameCategoryCosplay(nameCategoryCosplay);
        categoryCosplayDAO.insertCategory(category);
    }

    /**
     * Actualiza una categoría de cosplay existente.
     *
     * @param categoryId          Identificador de la categoría de cosplay a actualizar.
     * @param newNameCategoryCosplay Nuevo nombre para la categoría de cosplay.
     */
    public void updateCategory(long categoryId, String newNameCategoryCosplay) {
        CategoryCosplay category = new CategoryCosplay();
        category.setCategoryCosplayId(categoryId);
        category.setNameCategoryCosplay(newNameCategoryCosplay);
        categoryCosplayDAO.updateCategory(category);
    }

    /**
     * Elimina una categoría de cosplay.
     *
     * @param categoryId Identificador de la categoría de cosplay a eliminar.
     */
    public void deleteCategory(long categoryId) {
        categoryCosplayDAO.deleteCategory(categoryId);
    }
}
