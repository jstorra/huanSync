package com.u2team.huansync.ticketOffice.model.DAO;

import java.util.List;

public interface IDao<T> {
    
    T getById(long id);
    
    List<T> getAll();
    
    void save(T t);
    
    void update(T t);
    
    void delete(long id);

}
