package com.u2team.huansync.event.model.DAO;

import java.util.List;

/**
 *
 * @author Usuario
 * @param <T>
 */

/**
 * Generic Data Access Object (DAO) interface for basic CRUD operations.
 *
 * @param <T> The type of object for which the DAO is defined.
 */
public interface IDao<T> {

    /**
     * Retrieves an object by its unique identifier.
     *
     * @param id The unique identifier of the object.
     * @return The object with the specified identifier, or null if not found.
     */
    T getById(long id);

    /**
     * Retrieves a list of all objects of the specified type.
     *
     * @return A list containing all objects of the specified type.
     */
    List<T> getAll();

    /**
     * Saves a new object to the database.
     *
     * @param t The object to be saved.
     */
    void save(T t);

    /**
     * Updates an existing object in the database.
     *
     * @param t The object containing updated information.
     */
    void update(T t);

    /**
     * Deletes an object from the database based on its unique identifier.
     *
     * @param id The unique identifier of the object to be deleted.
     */
    void delete(long id);
}