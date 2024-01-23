/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u2team.huansync.ticketOffice.client.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.u2team.huansync.persistence.BDConnection;
import com.u2team.huansync.persistence.Operations;
import com.u2team.huansync.ticketOffice.client.model.classes.Customer;
import com.u2team.huansync.ticketOffice.client.model.classes.builders.CustomerBuilder;
import com.u2team.huansync.ticketOffice.client.model.classes.builders.CustomerConcreteBuilder;

/**
 *
 * @author SANTOS
 */
public class CustomerDAO implements IDao<Customer>{

    @Override
    public Customer getById(long id) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "SELECT * FROM tbl_customers WHERE customerId = ?;";
        
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)){
            ps.setLong(1, id);
            ResultSet rs = Operations.query_db(ps);
            if(rs.next()){
                CustomerBuilder customerBuilder = new CustomerConcreteBuilder();
                Customer sqlCustomer = customerBuilder.customerId(rs.getLong("customerId"))
                .nameCustomer(rs.getString("nameCustomer"))
                .document(rs.getString("document"))
                .gender(rs.getString("gender"))
                .birthDate(rs.getDate("birthDate"))
                .email(rs.getString("emailCustomer"))
                .phoneNumber(rs.getString("phoneNumber"))
                .customerTypeEnum(rs.getString("typeCustomer"))
                .build();
                
                return sqlCustomer;
            } else {
                System.out.println("Error: The id has not been found");
            }           
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean searchParticipant(int id) {

        Operations.setConnection(BDConnection.MySQLConnection());
        String query = "SELECT * FROM tbl_customers WHERE customerId = ?";
        int idParticipant = id;
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(query)) {
            ps.setInt(1, idParticipant);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
// no pasa nada, lo pruebo asi?
    @Override
    public List<Customer> getAll() {
        List<Customer> customerList = new ArrayList<>();
        
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "SELECT * FROM tbl_customers";
        
        try(PreparedStatement ps = Operations.getConnection().prepareStatement(stm)){
            ResultSet rs = Operations.query_db(ps);
            
            while (rs.next()){
                CustomerBuilder customerBuilder = new CustomerConcreteBuilder();
                
                Customer sqlCustomer = customerBuilder.customerId(rs.getLong("customerId"))
                        .nameCustomer(rs.getString("nameCustomer"))
                        .document(rs.getString("document"))
                        .gender(rs.getString("gender"))
                        .birthDate(rs.getDate("birthDate"))
                        .email(rs.getString("emailCustomer"))
                        .phoneNumber(rs.getString("phoneNumber"))
                        .customerTypeEnum(rs.getString("typeCustomer"))
                        .build(); 
                
                customerList.add(sqlCustomer);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return customerList;
    }



    @Override
    public void save(Customer customer) {
        
          String stmInsert = "INSERT INTO tbl_events(nameCostumer , document, gender , birthDate , emailCustomer , phoneNumber , typeCostumer) VALUES (?,?,?,?,?,?,?)";
          try(PreparedStatement ps =  Operations.getConnection().prepareStatement(stmInsert)){
              ps.setString(1, customer.getName());
              ps.setString(2, customer.getDocument());
              ps.setString(3, customer.getGender());
              ps.setDate(4, customer.getBirthDate());
              ps.setString(5, customer.getEmail());
              ps.setString(6, customer.getPhoneNumber());
              ps.setString(7, customer.getCustomerTypeEnum().name());
              
              int rows = Operations.insert_update_delete_db(ps);

              if(rows <= 0){
                  System.out.println("Cannot insert customer");
              } else{
                  System.out.println("Successful insert customer");

              }
          }catch (SQLException e){
              e.printStackTrace(); 
    }          
}

    @Override
    public void update(Customer customer) {
        Customer sqlCustomer = getById(customer.getCustomerId());
        
        if (sqlCustomer != null){
            sqlCustomer.setName(customer.getName());
            sqlCustomer.setDocument(customer.getDocument());
            sqlCustomer.setGender(customer.getGender());
            sqlCustomer.setBirthDate(customer.getBirthDate());
            sqlCustomer.setEmail(customer.getEmail());
            sqlCustomer.setPhoneNumber(customer.getPhoneNumber());
            sqlCustomer.setCustomerTypeEnum(customer.getCustomerTypeEnum());
            
            String stmInsert = """
                UPDATE tbl_costumers
                SET nameCostumer = ?,
                    document = ?,
                    gender = ?,
                    birthDate = ?,
                    emailCustomer = ?,
                    phoneNumber = ?,
                    typeCostumer = ?,
                    WHERE customerId = ?;      
                               """;
            
            try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
                 ps.setString(1, customer.getName());
                 ps.setString(2, customer.getDocument());
                 ps.setString(3, customer.getGender());
                 ps.setDate(4, customer.getBirthDate());
                 ps.setString(5, customer.getEmail());
                 ps.setString(6, customer.getPhoneNumber());
                 ps.setString(7, customer.getCustomerTypeEnum().name());
              
                 System.out.println(ps.toString());
                 
                int rows = Operations.insert_update_delete_db(ps);
                if (rows <= 0) {
                    System.out.println("Cannot update customer");
                } else {
                    System.out.println("Successful update customer");
                }
                 
            }catch (SQLException e){
                e.printStackTrace();
            }
        } else {
          System.out.println("not found results customer");

        }
    }

    @Override
    public void delete(long customerId) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "DELETE FROM tbl_costumers WHERE customerId = ?;";
        
        try(PreparedStatement ps = Operations.getConnection().prepareStatement(stm)){
            ps.setLong(1, customerId);
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
