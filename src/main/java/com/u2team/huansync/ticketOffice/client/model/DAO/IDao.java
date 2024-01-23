/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u2team.huansync.ticketOffice.client.model.DAO;

import java.util.List;

/**
 *
 * @author SANTOS
 */
public interface IDao<T> {
    
    T getById(long id);


    
    List<T> getAll();
    
    void save(T t);
    
    void update(T t);
    
    void delete(long id);

    boolean searchParticipant(int id);

}
