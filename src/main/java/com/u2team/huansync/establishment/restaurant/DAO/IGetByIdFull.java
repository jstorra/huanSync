/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.u2team.huansync.establishment.restaurant.DAO;

/**
 *
 * @author misae
 */
public interface IGetByIdFull<T> extends IDao{
    T getByIdFull(long id  );
}
