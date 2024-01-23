package com.u2team.huansync.activity.cosplay.managementCosplay.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.u2team.huansync.persistence.BDConnection;

public class DaoCosplayImpl implements CosplayDao {

    private Connection con = BDConnection.MySQLConnection();

    @Override
    public boolean searchCosplay(int id) {
        int idCosplay = id;
        // validate if exists cosplay and status cosplay is active
        String query = "SELECT * FROM tbl_cosplay WHERE cosplayId = ? and statusCosplay = 1";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, idCosplay);
            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void validateCosplay(Cosplay cosplay) {
        /*
         * Boolean searchAct = searchActivity(cosplay.getActivictyId());
         * Boolean searchPart = searchParticipant(cosplay.getParticipantId());
         * Boolean searchCosplay = searchCosplay(cosplay.getCosplayId()) ;
         * 
         * 
         * 
         * if (searchAct == false || searchPart == false) {
         * throw new RuntimeException(
         * "You cannot add an activity that is not cosplay or that is not registered, or the participant to add to the event cannot be found"
         * );
         * }
         * 
         */

    }

    @Override
    public List<Cosplay> readAll() {
        List<Cosplay> cosplayList = new ArrayList<>();
        String query = "SELECT * FROM tbl_cosplay";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                CosplayBuilderImpl cosplayBuilderImpl = new CosplayBuilderImpl();
                Cosplay cosplayBuild = cosplayBuilderImpl.cosplayId(rs.getInt("cosplayID"))
                        .score(rs.getDouble("score"))
                        .nameCosplay(rs.getString("nameCosplay"))
                        .participantId(rs.getInt("participantId"))
                        .activictyId(rs.getInt("activityId"))
                        .build();
                // add list
                cosplayList.add(cosplayBuild);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cosplayList;
    }

    @Override
    public void addCosplay(Cosplay cosplay) {
        try {
            /*
             * Mandatory method to validate the cosplay to be able to add it
             */
            validateCosplay(cosplay);
            ////
            Cosplay objCosplay = cosplay;
            String query = "INSERT INTO tbl_cosplay (score,nameCosplay,participantId,activityId ) VALUES (?,?,?,?)";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setDouble(1, objCosplay.getScore());
                preparedStatement.setString(2, objCosplay.getNameCosplay());
                preparedStatement.setInt(3, objCosplay.getParticipantId());
                preparedStatement.setInt(4, objCosplay.getActivictyId());
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void modifyCosplay(Cosplay cosplay) {

        try {
            Cosplay objCosplay = cosplay;
            boolean searchCosplay = searchCosplay(cosplay.getCosplayId());
            if (!searchCosplay) {
                throw new RuntimeException("The cosplay you want to delete is not in the database.");
            }

            String query = "UPDATE tbl_cosplay tc SET nameCosplay = ? WHERE tc.cosplayId = ?";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setString(1, objCosplay.getNameCosplay());
                preparedStatement.setInt(2, objCosplay.getCosplayId());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void desactivateCosplay(int id) {
        try {
            int idCosplay = id;
            boolean searchCosplay = searchCosplay(idCosplay);
            if (!searchCosplay) {
                throw new RuntimeException("The cosplay you want to delete is not in the database.");
            }

            String query = "DELETE FROM tbl_cosplay WHERE cosplayId = ?";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setInt(1, idCosplay);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        DaoCosplayImpl daoCosplayImpl = new DaoCosplayImpl();

        CosplayBuilderImpl cosplayBuilderImpl = new CosplayBuilderImpl();

        Cosplay cosplayBuild = cosplayBuilderImpl
                .cosplayId(1)
                .nameCosplay("goku")
                .build();

        daoCosplayImpl.modifyCosplay(cosplayBuild);

    }

}
