/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.u2team.huansync.establishment.DAO;

/**
 *
 * @author sneideresteban
 */
public interface ISaveDao<T> extends IDao{
    /**
     
Saves a new object to the database.*
@param t The object to be saved.*/
void save(T t);
}