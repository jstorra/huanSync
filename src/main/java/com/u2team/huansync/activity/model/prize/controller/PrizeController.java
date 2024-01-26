package com.u2team.huansync.activity.model.prize.controller;

import com.u2team.huansync.activity.model.prize.model.Prize;
import com.u2team.huansync.activity.model.prize.model.PrizeDAO;

import java.util.List;

/**
 * Controller class for managing prizes.
 */
public class PrizeController {
    private static PrizeDAO prizeDAO = new PrizeDAO();

    /**
     * Retrieves a list of all prizes.
     *
     * @return List of all prizes.
     */
    public static List<Prize> getAllPrizes() {
        return prizeDAO.getAllPrizes();
    }

    /**
     * Retrieves a single prize by its ID.
     *
     * @param prizeId The ID of the prize to retrieve.
     * @return The prize with the specified ID.
     */
    public static Prize getPrizeById(Long prizeId) {
        return prizeDAO.getPrizeById(prizeId);
    }

    /**
     * Inserts a new prize into the system.
     *
     * @param prize The prize to be inserted.
     */
    public static void insertPrize(Prize prize) {
        prizeDAO.insertPrize(prize);
    }

    /**
     * Updates an existing prize by its ID.
     *
     * @param prize The updated prize object.
     */
    public static void updatePrize(Prize prize) {
        prizeDAO.updatePrize(prize);
    }

    /**
     * Deletes a prize by its ID.
     *
     * @param prizeId The ID of the prize to be deleted.
     */
    public static void deletePrize(Long prizeId) {
        prizeDAO.deletePrize(prizeId);
    }
}
