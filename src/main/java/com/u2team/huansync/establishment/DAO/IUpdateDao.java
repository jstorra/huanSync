/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.u2team.huansync.establishment.DAO;

/**
 *
 * @author user
 */
public interface IUpdateDao<T> extends IDao{
    /**
     
Updates an existing object in the database.*
@param t The object containing updated information.*/
void update(T t);
}
