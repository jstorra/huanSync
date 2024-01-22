package com.u2team.huansync.event.DAO;

public interface IGetByIdFull <T> extends IDao{
    T getById(long id);
}
