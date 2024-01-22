package com.u2team.huansync.activity.cosplay.managementCosplay.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.u2team.huansync.persistence.BDConnection;

public class DaoCosplayImpl implements DaoCosplay {

    private Connection con = BDConnection.MySQLConnection();

    public boolean searchActivity(int id) {
        int idActivity = id;
        String query = "SELECT * FROM tbl_activities WHERE activityId = ? AND LOWER(typeActivity) = 'cosplay';";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, idActivity);
            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean searchParticipant(int id) {
        int idParticipant = id;
        String query = "SELECT * FROM tbl_customers WHERE customerId = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, idParticipant);
            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void validateCosplay(Cosplay cosplay) {
        Boolean searchAct = searchActivity(cosplay.getActivictyId());
        Boolean searchPart = searchParticipant(cosplay.getParticipantId());

        if (searchAct == false || searchPart == false) {
            throw new RuntimeException(
                    "You cannot add an activity that is not cosplay or that is not registered, or the participant to add to the event cannot be found");
        }

    }

    @Override
    public boolean searchCosplay(int id) {
        int idCosplay = id;
        String query = "SELECT * FROM tbl_cosplay WHERE cosplayId = ?";
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
    public void modifyCosplay(int id) {
        // This method is completely missing
    }

    @Override
    public void deleteCosplay(int id) {
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

}
