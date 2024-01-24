package com.u2team.huansync.establishment.DAO;

/**
 *
 * @author misae
 */
public interface IUpdateDao <T>  extends IDao {
    void update(T t);
}
