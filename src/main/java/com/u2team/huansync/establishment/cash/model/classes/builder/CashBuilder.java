/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.u2team.huansync.establishment.cash.model.classes.builder;

import com.u2team.huansync.establishment.cash.model.classes.Cash;
import java.util.ArrayList;

/**
 *
 * @author DeuryZ
 */

public interface CashBuilder {
    CashBuilder state(boolean state);
    CashBuilder openingAmount(double openingAmount);
    CashBuilder closingAmount(double closingAmount);
//    CashBuilder  order (ArrayList<Order> order);
    Cash build();
}
