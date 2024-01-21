/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.u2team.huansync.activitiy.model;

/**
 *
 * @author viole
 */
public class PrizeBuilderImpl implements PrizeBuilder{


    private Prize prize = new Prize();
    
    @Override
    public PrizeBuilder typePrize(Typeprize type) {
        vprize.setTypePrize(type);
        return this;
    }

    @Override
    public PrizeBuilder description(String description) {
        prize.setDescription(description);
        return this;
    }

    @Override
    public PrizeBuilder price(double price) {
        prize.setPrice(price);
        return this;
    }

    @Override
    public PrizeBuilder status(StatusPrize status) {
        prize.setStatus(status);
        return this;
    }

    @Override
    public PrizeBuilder activity(Activity activity) {
        prize.setActivity(activity);
        return this;
    }

    @Override
    public PrizeBuilder winner(Costumer winner) {
        prize.setWinner(winner);
        return this;
    }

    @Override
    public Prize build() {
        return prize;
    }
}
