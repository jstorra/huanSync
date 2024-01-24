package com.u2team.huansync.establishment.store.promotion.controller;

import com.u2team.huansync.establishment.store.promotion.model.DAO.PromotionDAO;
import com.u2team.huansync.establishment.store.promotion.model.classes.Promotion;
import java.util.List;

/**
 * The {@code PromotionController} class is responsible for managing promotions
 * and interacting with the {@code PromotionDAO}.
 *
 * @author sneideresteban
 */
public class PromotionController {

    // Instance of PromotionDAO
    private static PromotionDAO promotionDAO = new PromotionDAO();

    /**
     * Inserts a new promotion into the data store.
     *
     * @param promotion The promotion to be inserted.
     */
    public static void insertProduct(Promotion promotion) {
        promotionDAO.save(promotion);
    }

    /**
     * Deletes a promotion based on the provided promotion ID.
     *
     * @param promotionId The ID of the promotion to be deleted.
     */
    public static void delete(long promotionId) {
        promotionDAO.delete(promotionId);
    }

    /**
     * Retrieves a promotion based on the provided promotion ID.
     *
     * @param promotionId The ID of the promotion to be retrieved.
     * @return The promotion with the specified ID.
     */
    public static Promotion getById(long promotionId) {
        return promotionDAO.getById(promotionId);
    }

    /**
     * Retrieves a list of all promotions from the data store.
     *
     * @return A list containing all promotions.
     */
    public static List<Promotion> getAll() {
        return promotionDAO.getAll();
    }
}
