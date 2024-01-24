package com.u2team.huansync.activity.cosplay.managementCosplay.model;

import java.sql.*;
import java.util.*;
import com.u2team.huansync.persistence.BDConnection;

/**
 * Implementation of CosplayDaoOperationsCrud interface for CRUD operations on Cosplay entities.
 */
public class CosplayDaoOperationsCrudImpl implements CosplayDaoOperationsCrud {

    // VALIDATIONS
    private CosplayValidatorDaoImpl cosplayValidator;

    // QUERIS

    // query for list cosplays

    private static final String SELECT_COSPLAYS = """
        select
        c.cosplayId as cosplay_id ,
        c.score as score_participant ,
        c.nameCosplay as name_cosplay,
        cst.nameCustomer as name_participant
        from tbl_cosplay c
        join tbl_customers cst on cst.customerId = c.participantId
        join tbl_activities act on act.activityId = c.activityId
        where c.statusCosplay = true and act.completed = false and act.typeActivity = 'cosplay'
        and act.activityId = ?
        """;

    // query of inserts cosplay in database for the table tbl_cosplays
    private static final String INSERT_TABLE_COSPLAY = "INSERT INTO tbl_cosplay (score,nameCosplay,participantId,activityId,statusCosplay ) VALUES (?,?,?,?,?)";

    // query for update table cosplay
    private static final String UPDATE_TABLE_COSPLAY = "UPDATE tbl_cosplay tc SET nameCosplay = ? WHERE tc.cosplayId = ?";

    // this query desactivate the cosplay in the database
    private static final String DELETE_TABLE_COSPLAY = "UPDATE tbl_cosplay tc SET statusCosplay = 0 WHERE tc.cosplayId = ?";

    // CONSTRUCTORS
    public CosplayDaoOperationsCrudImpl() {
        // this.con = BDConnection.MySQLConnection();
        this.cosplayValidator = new CosplayValidatorDaoImpl();
    }

    // OPERACTIONS

    /**
     * Retrieves a list of cosplays based on the provided activity ID.
     *
     * @param idActivity The ID of the activity associated with the cosplays.
     * @return A list of cosplays.
     */
    @Override
    public List<Cosplay> readCosplay(int idActivitie) {
        List<Cosplay> cosplayList = new ArrayList<>();
        try (Connection con = BDConnection.MySQLConnection();
             PreparedStatement preparedStatement = con.prepareStatement(SELECT_COSPLAYS)) {
            // Agrega el parámetro al PreparedStatement
            preparedStatement.setInt(1, idActivitie);
    
            // Ejecuta la consulta y obtén el ResultSet
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    Cosplay cosplayBuild = new CosplayBuilderImpl()
                            .cosplayId(rs.getInt("cosplay_id"))
                            .score(rs.getDouble("score_participant"))
                            .nameCosplay(rs.getString("name_cosplay"))
                            .participantName(rs.getString("name_participant"))
                            .build();
                    // Agrega a la lista
                    cosplayList.add(cosplayBuild);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cosplayList;
    }
    

    /**
     * Creates a new cosplay entity in the database.
     *
     * @param cosplay The cosplay entity to be created.
     */
    @Override
    public void createCosplay(Cosplay cosplay) {
        try (Connection con = BDConnection.MySQLConnection()) {
            if (cosplayValidator.validateParticipant(cosplay.getParticipantId()) 
            && cosplayValidator.validateParticipantion(cosplay.getActivictyId(),
             cosplay.getParticipantId())) {

                try (PreparedStatement preparedStatement = con.prepareStatement(INSERT_TABLE_COSPLAY)) {
                    preparedStatement.setDouble(1, cosplay.getScore());
                    preparedStatement.setString(2, cosplay.getNameCosplay());
                    preparedStatement.setInt(3, cosplay.getParticipantId());
                    preparedStatement.setInt(4, cosplay.getActivictyId());
                    preparedStatement.setBoolean(5, cosplay.getStatusCosplay());
                    preparedStatement.executeUpdate();

                }

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Updates an existing cosplay entity in the database.
     *
     * @param cosplay The cosplay entity to be updated.
     */
    @Override
    public void updateCosplay(Cosplay cosplay) {
        try (Connection con = BDConnection.MySQLConnection()) {
            cosplayValidator.validateCosplayisActive(cosplay.getCosplayId());
            try (PreparedStatement preparedStatement = con.prepareStatement(UPDATE_TABLE_COSPLAY)) {
                preparedStatement.setString(1, cosplay.getNameCosplay());
                preparedStatement.setInt(2, cosplay.getCosplayId());
                preparedStatement.executeUpdate();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Deletes a cosplay entity from the database based on the provided cosplay ID.
     *
     * @param idCosplay The ID of the cosplay to be deleted.
     */
    @Override
    public void deleteCosplay(int idCosplay) {
        try (Connection con = BDConnection.MySQLConnection()) {
            cosplayValidator.validateCosplayisDesact(idCosplay);
            try (PreparedStatement preparedStatement = con.prepareStatement(DELETE_TABLE_COSPLAY)) {
                preparedStatement.setInt(1, idCosplay);
                preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
