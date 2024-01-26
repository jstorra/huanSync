/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.u2team.huansync.establishment.DAO;

/**
 *
 * @author user
 */
import java.util.List;

public interface IGetAllDao<T> extends IDao{
    /**
     
Retrieves a list of all objects of the specified type.*
@return A list containing all objects of the specified type.*/
List<T> getAll();
}