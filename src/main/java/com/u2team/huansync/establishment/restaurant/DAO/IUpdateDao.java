package com.u2team.huansync.establishment.restaurant.DAO;

/**
 *
 * @author misae
 */
public interface IUpdateDao <T>  extends IDao {
    void update(T t);
}
