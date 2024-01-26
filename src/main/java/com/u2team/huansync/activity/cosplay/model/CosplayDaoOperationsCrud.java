package com.u2team.huansync.activity.cosplay.model;

import java.util.*;

/**
 * Interface defining CRUD operations for Cosplay entities in a data access object.
 */
public interface CosplayDaoOperationsCrud {

    /**
     * Reads and retrieves a list of cosplays based on the provided activity ID.
     *
     * @param idActivity The ID of the activity associated with the cosplays.
     * @return A list of cosplays.
     */
    public List<Cosplay> readCosplay(int idActivitie);

    /**
     * Creates a new cosplay entity in the database.
     *
     * @param cosplay The cosplay entity to be created.
     */
    public void createCosplay(Cosplay cosplay);

    /**
     * Updates an existing cosplay entity in the database.
     *
     * @param cosplay The cosplay entity to be updated.
     */
    public void updateCosplay(Cosplay cosplay);

    /**
     * Deletes a cosplay entity from the database based on the provided cosplay ID.
     *
     * @param idCosplay The ID of the cosplay to be deleted.
     */
    public void deleteCosplay(int idCosplay);
}
