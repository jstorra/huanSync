/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u2team.huansync.ticketOffice.client.model.DAO;

import com.u2team.huansync.persistence.BDConnection;
import com.u2team.huansync.persistence.Operations;
import com.u2team.huansync.ticketOffice.client.model.classes.Costumer;
import com.u2team.huansync.ticketOffice.client.model.classes.builders.CostumerBuilder;
import com.u2team.huansync.ticketOffice.client.model.classes.builders.CostumerConcreteBuilder;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SANTOS
 */
public class CostumerDAO implements IDao<Costumer>{

    @Override
    public Costumer getById(long id) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "SELECT * FROM tbl_costumers where costumerId = ?;";
        
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)){
            ps.setLong(1, id);
            ResultSet rs = Operations.query_db(ps);
            if(rs.next()){
                CostumerBuilder costumerBuilder = new CostumerConcreteBuilder();
                
                Costumer sqlCostumer = costumerBuilder.costumerId(rs.getLong("costumerId"))
                        .nameCostumer(rs.getString("nameCostumer"))
                        .document(rs.getString("document"))
                        .gender(rs.getString("gender"))
                        .birthDate(rs.getDate("birthDate"))
                        .email(rs.getString("emailCustomer"))
                        .phoneNumber(rs.getString("phoneNumber"))
                        .costumerTypeEnum(rs.getString("typeCostumer"))
                        .build();
                
                return sqlCostumer;
            } else {
                System.out.println("Error: The id has not been found");
            }           
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Costumer> getAll() {
        List<Costumer> costumerList = new ArrayList<>();
        
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "SELECT * FROM tbl_costumers";
        
        try(PreparedStatement ps = Operations.getConnection().prepareStatement(stm)){
            ResultSet rs = Operations.query_db(ps);
            
            while (rs.next()){
                CostumerBuilder costumerBuilder = new CostumerConcreteBuilder();
                
                Costumer sqlCostumer = costumerBuilder.costumerId(rs.getLong("costumerId"))
                        .nameCostumer(rs.getString("nameCostumer"))
                        .document(rs.getString("document"))
                        .gender(rs.getString("gender"))
                        .birthDate(rs.getDate("birthDate"))
                        .email(rs.getString("emailCustomer"))
                        .phoneNumber(rs.getString("phoneNumber"))
                        .costumerTypeEnum(rs.getString("typeCostumer"))
                        .build(); 
                
                costumerList.add(sqlCostumer);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return costumerList;
    }

    @Override
    public void save(Costumer costumer) {
        
          String stmInsert = "INSERT INTO tbl_events(nameCostumer , document, gender , birthDate , emailCustomer , phoneNumber , typeCostumer) VALUES (?,?,?,?,?,?,?,)";
          try(PreparedStatement ps =  Operations.getConnection().prepareStatement(stmInsert)){
              ps.setString(1, costumer.getName());
              ps.setString(2, costumer.getDocument());
              ps.setString(3, costumer.getGender());
              ps.setDate(4, (Date) costumer.getBirthDate());
              ps.setString(5, costumer.getEmail());
              ps.setString(6, costumer.getPhoneNumber());
              ps.setString(7, costumer.getCostumerTypeEnum().name());
              
              int rows = Operations.insert_update_delete_db(ps);

              if(rows <= 0){
                  System.out.println("Cannot insert costumer");
              } else{
                  System.out.println("Successful insert costumer");

              }
          }catch (SQLException e){
              e.printStackTrace(); 
    }          
}

    @Override
    public void update(Costumer costumer) {
        Costumer sqlCostumer = getById(costumer.getCostumerId());
        
        if (sqlCostumer != null){
            sqlCostumer.setName(costumer.getName());
            sqlCostumer.setDocument(costumer.getDocument());
            sqlCostumer.setGender(costumer.getGender());
            sqlCostumer.setBirthDate(costumer.getBirthDate());
            sqlCostumer.setEmail(costumer.getEmail());
            sqlCostumer.setPhoneNumber(costumer.getPhoneNumber());
            sqlCostumer.setCostumerTypeEnum(costumer.getCostumerTypeEnum());
            
            String stmInsert = """
                UPDATE tbl_costumers
                SET nameCostumer = ?,
                    document = ?,
                    gender = ?,
                    birthDate = ?,
                    emailCustomer = ?,
                    phoneNumber = ?,
                    typeCostumer = ?,
                    WHERE costumerId = ?;      
                               """;
            
            try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
                 ps.setString(1, costumer.getName());
                 ps.setString(2, costumer.getDocument());
                 ps.setString(3, costumer.getGender());
                 ps.setDate(4, (Date) costumer.getBirthDate());
                 ps.setString(5, costumer.getEmail());
                 ps.setString(6, costumer.getPhoneNumber());
                 ps.setString(7, costumer.getCostumerTypeEnum().name());
              
                 System.out.println(ps.toString());
                 
                int rows = Operations.insert_update_delete_db(ps);
                if (rows <= 0) {
                    System.out.println("Cannot update costumer");
                } else {
                    System.out.println("Successful update costumer");
                }
                 
            }catch (SQLException e){
                e.printStackTrace();
            }
        } else {
          System.out.println("not found results costumer");

        }
    }

    @Override
    public void delete(long costumerId) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "DELETE FROM tbl_costumers WHERE costumerId = ?;";
        
        try(PreparedStatement ps = Operations.getConnection().prepareStatement(stm)){
            ps.setLong(1, costumerId);
            int rows = Operations.insert_update_delete_db(ps);
            if (rows > 0) {
                System.out.println("successful delete client");
                return;
            } else {
                System.out.println("not exists client");
                return;
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        System.out.println("something was wrong on delete client");
        return;
    } 
}
