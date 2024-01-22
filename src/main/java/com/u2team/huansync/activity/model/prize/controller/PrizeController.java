package com.u2team.huansync.activity.model.prize.controller;

import com.u2team.huansync.activity.model.prize.model.Prize;
import com.u2team.huansync.activity.model.prize.model.PrizeBuilderImpl;
import com.u2team.huansync.activity.model.prize.model.StatusPrize;

import java.util.List;

public class PrizeController {
    private PrizeDAO prizeDAO = new PrizeDAO();

    //view all prizes
    public List<Prize> getAllPrizes() {
        return prizeDAO.getAllPrizes();
    }

    //get one prize by id
    public Prize getPrizeById(long prizeId){
        return prizeDAO.getPrizeById(prizeId);
    }

    //add or insert prize
    public void insertPrize(String newTypePrize, String newDescription, Double newPrice, StatusPrize newStatus, long newActivityId, long newWinnerId){
        Prize prize = new PrizeBuilderImpl()
                .typePrize(newTypePrize)
                .description(newDescription)
                .price(newPrice)
                .statusPrize(newStatus)
                .activityId(newActivityId)
                .winnerId(newWinnerId)
                .build();
        prizeDAO.addPrize(prize);
    }

    //update prize by id
    public void updatePrize(int prizeId, String newTypePrize, String newDescription, Double newPrice, StatusPrize newStatus, long newActivityId, long newWinnerId){
        Prize prize = new Prize();
        prize.setTypePrize(newTypePrize);
        prize.setDescription(newDescription);
        prize.setPrice(newPrice);
        prize.setStatusPrize(newStatus);
        prize.setActivityId(newActivityId);
        prize.setActivityId(newWinnerId);
        prizeDAO.updatePrize(prize);
    }

    //delete prize by id
    public void deletePrize(long prizeId){
        prizeDAO.deletePrize(prizeId);
    }
}
