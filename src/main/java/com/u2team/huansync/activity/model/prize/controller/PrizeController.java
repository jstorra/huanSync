package com.u2team.huansync.activity.model.prize.controller;

import java.util.List;

import com.u2team.huansync.activity.model.prize.model.Prize;

/**
 * Controlador para la gestión de premios.
 */
public class PrizeController {
    private PrizeDAO prizeDAO = new PrizeDAO();
    /**
     * Obtiene todos los premios.
     *
     * @return Lista de premios.
     */
    public List<Prize> getAllPrizes() {
        return prizeDAO.getAllPrizes();
    }

    /**
     * Inserta un nuevo premio.
     *
     * @param typePrize Tipo del nuevo premio.
     * @param description Descripción del nuevo premio.
     * @param price Precio del nuevo premio.
     */
    public void insertPrize(String typePrize, String description, double price) {
        Prize prize = new Prize();
        prize.setTypePrize(typePrize);
        prize.setDescription(description);
        prize.setPrice(price);
        prizeDAO.addPrize(prize);
    }

    /**
     * Actualiza un premio existente.
     *
     * @param prizeId Identificador del premio a actualizar.
     * @param newTypePrize Nuevo tipo para el premio.
     * @param newDescription Nueva descripción para el premio.
     * @param newPrice Nuevo precio para el premio.
     */
    public void updatePrize(int prizeId, String newTypePrize, String newDescription, double newPrice) {
        Prize prize = new Prize();
        prize.setPrizeId(prizeId);
        prize.setTypePrize(newTypePrize);
        prize.setDescription(newDescription);
        prize.setPrice(newPrice);
        prizeDAO.updatePrize(prize);
    }

    /**
     * Elimina un premio.
     *
     * @param prizeId Identificador del premio a eliminar.
     */
    public void deletePrize(int prizeId) { 
        prizeDAO.deletePrize(prizeId);
    }
}
