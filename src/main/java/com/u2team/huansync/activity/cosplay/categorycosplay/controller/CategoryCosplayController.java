package com.u2team.huansync.activity.cosplay.categorycosplay.controller;

import com.u2team.huansync.activity.cosplay.categorycosplay.model.CategoryCosplay;
import java.util.List;

/**
 * Controlador para la gestión de categorias de cosplay.
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
     * @param nameCategory Nombre de la nueva categoría de cosplay.
     */
    public void insertCategory(String nameCategory) {
        categoryCosplayDAO.insertCategory(nameCategory);
    }

    /**
     * Actualiza una categoría de cosplay existente.
     *
     * @param categoryId          Identificador de la categoría de cosplay a actualizar.
     * @param newNameCategoryCosplay Nuevo nombre para la categoría de cosplay.
     */
    public void updateCategory(int categoryId, String newNameCategoryCosplay) {

        categoryCosplayDAO.updateCategory(categoryId,newNameCategoryCosplay);
    }

    /**
     * Elimina una categoría de cosplay.
     *
     * @param categoryId Identificador de la categoría de cosplay a eliminar.
     */
    public void deleteCategory(int categoryId) {
        categoryCosplayDAO.deleteCategory(categoryId);
    }
}
