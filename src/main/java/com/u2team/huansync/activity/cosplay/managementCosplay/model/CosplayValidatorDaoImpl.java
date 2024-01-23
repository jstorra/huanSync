package com.u2team.huansync.activity.cosplay.managementCosplay.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.u2team.huansync.activity.model.ActivityDAO;
import com.u2team.huansync.persistence.BDConnection;

public class CosplayValidatorDaoImpl implements CosplayValidatorDao{
    
    private ActivityDAO activityDao  ;
    private final Connection con;
    
    // query for consulting customers 
    private static final String SELECT_CUSTOMER_QUERY = "SELECT * FROM tbl_customers WHERE customerId = ?";
    // query for consulting cosplays
    private static final String SELECT_COSPLAY_QUERY = "SELECT * FROM tbl_cosplay WHERE cosplayId = ? AND statusCosplay = 1";

    // CONSTRUCTORS

    public  CosplayValidatorDaoImpl() {
        this.activityDao = new ActivityDAO();
        this.con = BDConnection.MySQLConnection();
    }


    



    // VALIDATIONS



     /*testing method*/ 

    public void validateParticipant(int idParticipant) {
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_CUSTOMER_QUERY)) {
            preparedStatement.setInt(1, idParticipant);
            ResultSet rs = preparedStatement.executeQuery();
            if(!rs.next()){
                throw new RuntimeException("The cosplay you want to delete is not in the database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////
 

    @Override
    public void validateCosplay(int idCosplay) {
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_COSPLAY_QUERY)) {
            preparedStatement.setInt(1, idCosplay);
            ResultSet rs = preparedStatement.executeQuery();
            if(!rs.next()){
                throw new RuntimeException("The cosplay you want to delete is not in the database.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            
        }
    }


    @Override
    public void validateAct(Cosplay cosplay){
        Boolean searchAct = activityDao.searchActivity(cosplay.getActivictyId(), "cosplay");
        if(!searchAct){
            throw new RuntimeException("""
                The activity has finished or is not found in the database, 
                this error may also be possible because the activity 
                is not a cosplay type, please review and try again        
                    """
            );
        }
        
    
    }


    @Override
    public void validateCosplayforActPartCospl(Cosplay cosplay) {
        this.validateParticipant(cosplay.getParticipantId());
        this.validateCosplay(cosplay.getCosplayId()) ;
        this.validateAct(cosplay);

    }


   


}
