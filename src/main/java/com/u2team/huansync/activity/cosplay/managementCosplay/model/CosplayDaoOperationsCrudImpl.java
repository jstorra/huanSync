package com.u2team.huansync.activity.cosplay.managementCosplay.model;
import java.sql.*;
import java.util.*;
import com.u2team.huansync.persistence.BDConnection;

public class CosplayDaoOperationsCrudImpl implements CosplayDaoOperationsCrud {

    // VALIDATIONS
    private CosplayValidatorDaoImpl cosplayValidator  ;

    //QUERIS

    // query for list cosplays

    private static final String  SELECT_COSPLAYS=
    """
        select 
        c.cosplayId as cosplay_id ,
        c.score as score_participant ,
        c.nameCosplay as name_cosplay, 
        cst.nameCustomer as name_participant
        from tbl_cosplay c 
        join tbl_customers cst on cst.customerId = c.participantId        
    """;

    // query of inserts cosplay in database for the table tbl_cosplays
    private static final String  INSERT_TABLE_COSPLAY="INSERT INTO tbl_cosplay (score,nameCosplay,participantId,activityId,statusCosplay ) VALUES (?,?,?,?,?)";

    // query for update table cosplay
    private static final String UPDATE_TABLE_COSPLAY = "UPDATE tbl_cosplay tc SET nameCosplay = ? WHERE tc.cosplayId = ?";

    //this query desactivate the cosplay in the database
    private static final String DELETE_TABLE_COSPLAY ="UPDATE tbl_cosplay tc SET statusCosplay = 0 WHERE tc.cosplayId = ?";
    

    // CONSTRUCTORS
    public  CosplayDaoOperationsCrudImpl() {
        //this.con = BDConnection.MySQLConnection();
        this.cosplayValidator= new CosplayValidatorDaoImpl();
    }
   


    //OPERACTIONS

    

    @Override
    public List<Cosplay> readCosplay() {
        List<Cosplay> cosplayList = new ArrayList<>();
        try (Connection con = BDConnection.MySQLConnection();
            PreparedStatement preparedStatement = con.prepareStatement(SELECT_COSPLAYS)) {
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                Cosplay cosplayBuild = new CosplayBuilderImpl()
                .cosplayId(rs.getInt("cosplay_id"))
                .score(rs.getDouble("score_participant"))
                .nameCosplay(rs.getString("name_cosplay"))
                .participantName(rs.getString("name_participant"))
                .build();
                // add to list
                cosplayList.add(cosplayBuild);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cosplayList;
    }

@Override
public void createCosplay(Cosplay cosplay) {
    try (Connection con = BDConnection.MySQLConnection()) {
        /*
         * Mandatory method to validate the cosplay to be able to add it
         */
        cosplayValidator.validateCosplayforActPartCospl(cosplay);
        ////

        try (PreparedStatement preparedStatement = con.prepareStatement(INSERT_TABLE_COSPLAY)) {
            preparedStatement.setDouble(1, cosplay.getScore());
            preparedStatement.setString(2, cosplay.getNameCosplay());
            preparedStatement.setInt(3, cosplay.getParticipantId());
            preparedStatement.setInt(4, cosplay.getActivictyId());
            preparedStatement.setBoolean(5, cosplay.getStatusCosplay());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}

@Override
public void updateCosplay(Cosplay cosplay) throws SQLException {
    try (Connection con = BDConnection.MySQLConnection()) {
        cosplayValidator.validateCosplay(cosplay.getCosplayId());
        try (PreparedStatement preparedStatement = con.prepareStatement(UPDATE_TABLE_COSPLAY)) {
            preparedStatement.setString(1, cosplay.getNameCosplay());
            preparedStatement.setInt(2, cosplay.getCosplayId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    } catch (RuntimeException e) {
        System.out.println(e.getMessage());
    }
}

    @Override
    public void deleteCosplay(int idCosplay) {
        try (Connection con = BDConnection.MySQLConnection()) {
            cosplayValidator.validateCosplay(idCosplay);
            try (PreparedStatement preparedStatement = con.prepareStatement(DELETE_TABLE_COSPLAY)) {
                preparedStatement.setInt(1, idCosplay);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException("Error executing deleteCosplay query", e);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error in deleteCosplay", e);
        }
    }



   
}
