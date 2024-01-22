package com.u2team.huansync.event.DAO;

import java.util.List;

public interface IGetAllFull <T> extends IDao{
    List<T> getAllFull();
}
