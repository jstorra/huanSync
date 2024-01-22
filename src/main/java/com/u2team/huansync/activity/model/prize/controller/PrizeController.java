package com.u2team.huansync.activity.model.prize.controller;

import com.u2team.huansync.activity.model.prize.model.Prize;

import java.util.List;

public class PrizeController {
    private static PrizeDAO prizeDAO = new PrizeDAO();

    //view all prizes
    public static List<Prize> getAllPrizes() {
        return prizeDAO.getAllPrizes();
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
    public static void deletePrize(long prizeId){
        prizeDAO.deletePrize(prizeId);
    }
}
