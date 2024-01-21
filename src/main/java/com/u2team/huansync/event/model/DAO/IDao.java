package com.u2team.huansync.event.model.DAO;

import java.util.List;

/**
 *
 * @author Usuario
 * @param <T>
 */
public interface IDao<T> {
    
    T getById(long id);
    
    List<T> getAll();
    
    void save(T t);
    
    void update(T t);
    
    void delete(long id);
}