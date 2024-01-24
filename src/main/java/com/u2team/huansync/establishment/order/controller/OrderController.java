/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u2team.huansync.establishment.order.controller;

import com.u2team.huansync.establishment.order.model.DAO.OrderDao;
import com.u2team.huansync.establishment.order.model.classes.Order;
import java.util.List;

/**
 *
 * @author user
 */
public class OrderController {
    
    //Instanciar
    private static OrderDao orderDao = new OrderDao();
    
    //The methods that I created after the static or void "names" were called in HuanSync to test them
    //save, getAll and update are found in all Dao interfaces within the code
    public static void insertOrder(Order order){
        orderDao.save(order);
    }
    
    public static void deleteOrder(long orderId){
        orderDao.delete(orderId);
    }
    
    public static  List<Order> getAllOrder(){
        return orderDao.getAll();
    }
    
    public static Order getByIdOrder(long orderId){
        return orderDao.getById(orderId); 
    }
    
    public static void updateOrder(Order order) {
        orderDao.update(order);
    }
    
    
    
}
