package com.u2team.huansync.establishment.order.model.DAO;
import com.u2team.huansync.establishment.DAO.IDeleteDao;
import com.u2team.huansync.establishment.DAO.IGetAllDao;
import com.u2team.huansync.establishment.DAO.ISaveDao;
import com.u2team.huansync.establishment.order.model.classes.Order;
import com.u2team.huansync.persistence.BDConnection;
import com.u2team.huansync.persistence.Operations;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.u2team.huansync.event.DAO.IGetByIdDao;
import com.u2team.huansync.event.DAO.IUpdateDao;
import java.util.Arrays;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Kevin
 */

//Here implements de rest of the CRUD
public class OrderDao implements ISaveDao<Order>, IDeleteDao<Order>,IGetAllDao<Order>, IGetByIdDao<Order>, IUpdateDao<Order>{

    @Override
    public void save(Order order) {
        
        
        /// Create a query and send corresponding information in each field by replacing the character "?" with the information
        //String stmInsert = "INSERT INTO tbl_order(orderId,customerId,establishmentId,cashRegisterId,cashierOperatorId,orderStatusEnum) VALUES(?,?,?,?,?,?);";
        //Test if save data for autoincrement
        String stmInsert = "INSERT INTO tbl_order(orderId,customerId,establishmentId,cashRegisterId,cashierOperatorId,orderStatusEnum) VALUES(?,?,?,?,?,?);";
        
        //PreparedStatement es de sql y Operations de Mariño
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
            ps.setLong(1, order.getOrderId());
            ps.setInt(2, order.getCustomerId());
            ps.setInt(3, order.getEstablishmentId());
            ps.setInt(4, order.getCashId());
            ps.setInt(5, order.getCashierOperatorId());
            
            //Put name to correct the mistake
            /////////Corregir esta linea
            ps.setString(6, order.getOrderStatusEnum().name()); 



            // use Operation class with insert_update_delete and verify if the rows in database are affected
            int rows = Operations.insert_update_delete_db(ps);
            if (rows <= 0) {
                System.out.println("Cannot push event");
            } else {
                System.out.println("Successful push event");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void delete(long productId) {
      Operations.setConnection(BDConnection.MySQLConnection());
      String stm = "DELETE FROM tbl_order WHERE orderId = ?;";
      try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, productId);
            int rows = Operations.insert_update_delete_db(ps);
            if (rows > 0) {
                System.out.println("successful delete event");
                return;
            } else {
                System.out.println("not exists event");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("something was wrong on delete event");
        return;
    }

    @Override
    public List<Order> getAll() {
        List<Order> orderList = new ArrayList<>();
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "select * from tbl_order;";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {

            ResultSet rs = Operations.query_db(ps);

            while (rs.next()) {
                Order order = new Order();
                
                //String stmInsert = "INSERT INTO tbl_order(orderId,customerId,establishmentId,cashRegisterId,cashierOperatorId,orderStatusEnum) VALUES(?,?,?,?,?,?);";
                
                //The differentes atributes in the SQL
                order.setOrderId(rs.getLong("orderId"));
                order.setCustomerId(rs.getInt("customerId"));
                order.setEstablishmentId(rs.getInt("establishmentId"));
                order.setCashId(rs.getInt("cashRegisterId"));
                order.setCashierOperatorId(rs.getInt("cashierOperatorId"));
                
                //In order.java in the method getOrderStatusEnum I fixed the mistake
                order.setOrderStatusEnum(order.getOrderStatusEnum(rs.getString("orderStatusEnum")));
                
                //Don´t forgett this to add the order
                orderList.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }

    @Override
    public Order getById(long orderId) {
        
        
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "select * from tbl_order where orderId = ? ;";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, orderId);
            ResultSet rs = Operations.query_db(ps);
            if (rs.next()) {
                Order order = new Order();
                order.setOrderId(rs.getLong("orderId"));
                order.setCustomerId(rs.getInt("customerId"));
                order.setEstablishmentId(rs.getInt("establishmentId"));
                order.setCashId(rs.getInt("cashRegisterId"));
                order.setCashierOperatorId(rs.getInt("cashierOperatorId"));
                
                order.setOrderStatusEnum(order.getOrderStatusEnum(rs.getString("orderStatusEnum")));
                
//                List<String> listActivities = Arrays.asList(rs.getString("activitiesWorkerRole").split("\\|"));
//                order.setWorkerRoleActivities(listActivities);
                
                return order;
            } else {
                System.out.println("ERROR: The id has not been found");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Order order) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
        
        
        Order sqlOrder = getById(order.getOrderId());

        if (sqlOrder != null) {
            
            //Without orderId for now
            sqlOrder.setCustomerId(order.getCustomerId());
            sqlOrder.setEstablishmentId(order.getEstablishmentId());
            sqlOrder.setCashId(order.getCashId());
            sqlOrder.setCashierOperatorId(order.getCashierOperatorId());
            
            //Verified if it is okay
            sqlOrder.setOrderStatusEnum(order.getOrderStatusEnum());
            
            
            String stmUpdate = """
            UPDATE tbl_order
            SET customerId = ?,
                establishmentId = ?,
                cashRegisterId = ?,
                cashierOperatorId = ?,
                orderStatusEnum = ?
            WHERE orderId = ?;
                               """;

            try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmUpdate)) {

                ps.setInt(1, sqlOrder.getCustomerId());
                ps.setInt(2, sqlOrder.getEstablishmentId());
                ps.setInt(3, sqlOrder.getCashId());
                ps.setInt(4, sqlOrder.getCashierOperatorId());
                
                //Verified if it is okay
                
                ps.setString(5, sqlOrder.getOrderStatusEnum().name());
                
                ps.setLong(6, sqlOrder.getOrderId());
                
                System.out.println(ps.toString());
                int rows = Operations.insert_update_delete_db(ps);
                if (rows <= 0) {
                    System.out.println("Cannot update worker role");
                } else {
                    System.out.println("Successful update of worker role");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        
        
    
    }
    
    
    
}
