/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u2team.huansync.ticketOffice.model;

/**
 *
 * @author SANTOS
 */
public interface IDao<T> {
    
    void save(T t);
    void update(T t);
}
