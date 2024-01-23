package com.u2team.huansync.activity.model.prize.controller;

import com.u2team.huansync.activity.model.prize.model.Prize;
import com.u2team.huansync.activity.model.prize.model.PrizeDAO;

import java.util.List;

/**
 * The PrizeController class serves as a controller for Prize-related operations,
 * providing a high-level interface between the application and the data access layer.
 */
public class PrizeController {
    // Data Access Object for Prize entities
    private static PrizeDAO prizeDAO = new PrizeDAO();

    /**
     * The PrizeController class serves as a controller for Prize-related operations,
     * providing a high-level interface between the application and the data access layer.
     */
    //view all prizes
    public static List<Prize> getAllPrizes() {
        return prizeDAO.getAllPrizes();
    }

     //get one prize by id
    public static Prize getPrizeById(Long prizeId){
        return prizeDAO.getPrizeById(prizeId);
    }

    //add or insert prize
    public static void insertPrize(Prize prize){
        prizeDAO.insertPrize(prize);
    }

    //update prize by id
    public static void updatePrize(Prize prize){
        prizeDAO.updatePrize(prize);
    }

    //delete prize by id
    public static void deletePrize(Long prizeId){
        prizeDAO.deletePrize(prizeId);
    }
}
