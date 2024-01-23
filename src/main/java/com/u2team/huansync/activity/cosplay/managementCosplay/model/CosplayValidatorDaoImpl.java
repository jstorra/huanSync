package com.u2team.huansync.activity.cosplay.managementCosplay.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.u2team.huansync.activity.model.ActivityDAO;
import com.u2team.huansync.persistence.BDConnection;

public class CosplayValidatorDaoImpl implements CosplayValidatorDao {

    private ActivityDAO activityDao;
    private final Connection con;

    // query for consulting customers
    private static final String SELECT_CUSTOMER_QUERY = "SELECT * FROM tbl_cosplay cp WHERE cp.participantId in(SELECT c.customerId from tbl_customers c)  and cp.participantId = ? and cp.statusCosplay =true ";
    // query for consulting cosplays
    private static final String SELECT_COSPLAY_QUERY = "SELECT * FROM tbl_cosplay WHERE cosplayId = ? AND statusCosplay = true";

    // CONSTRUCTORS

    public CosplayValidatorDaoImpl() {
        this.activityDao = new ActivityDAO();
        this.con = BDConnection.MySQLConnection();
    }

    // VALIDATIONS

    /* testing method */

    public boolean validateParticipant(int idParticipant) {
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_CUSTOMER_QUERY)) {
            preparedStatement.setInt(1, idParticipant);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                throw new Exception("Error: El participante ya se encuentra concursando");
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception appropriately, e.g., log the error or throw a different
            // exception
            return false; // If an exception occurs, you might want to return false here
        }

        return true; // Return true if the participant is not already participating
    }

    ///////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void validateCosplayisActive(int idCosplay) {
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_COSPLAY_QUERY)) {
            preparedStatement.setInt(1, idCosplay);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                throw new Exception("The cosplay you want to delete is not in the database.");
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void validateCosplayisDesact(int idCosplay) {
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_COSPLAY_QUERY)) {
            preparedStatement.setInt(1, idCosplay);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next() == false) {
                throw new Exception("The cosplay you want to delete is not in the database.");
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
