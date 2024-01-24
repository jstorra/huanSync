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
import com.u2team.huansync.establishment.order.model.classes.OrderStatusEnum;
import com.u2team.huansync.event.DAO.IGetByIdDao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Kevin
 */

//Here implements de rest of the CRUD
public class OrderDao implements ISaveDao<Order>, IDeleteDao<Order>,IGetAllDao<Order>, IGetByIdDao<Order>{

    @Override
    public void save(Order order) {
        
        
        // Create a query and send corresponding information in each field by replacing the character "?" with the information
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
            ps.setString(6, order.getOrderStatusEnum().name()); // Corrected this line



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
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
        
        //Class Operations are used to configure the connection with database and send a Query saved in variable stm
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "SELECT * FROM tbl_order where orderId = ?;";

        //ps (prepareStatement) receives stm and replaces "?" for the variable with the index: "1" with "id"
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, orderId);

            // The result of the query is saved in the "rs" variable to apply logic.
            ResultSet rs = Operations.query_db(ps);

            // rs.next() -> Means if there is an answer, execute logic
            if (rs.next()) {

                
                
////                // Create builder with concrete Builder -> (Concrete builder creates the object step by step)
////                ProductBuilder productBuilder = new ProductConcreteBuilder();
////
////                // Creates an event object and use eventBuilder for constructs it using the information from the query(rs) (field by field)
////                Product sqlProduct = productBuilder
////                        .productId(rs.getLong("productId"))
////                        .nameProduct(rs.getString("productName"))
////                        .storeId(rs.getLong("storeId"))
////                        .productPrice(rs.getDouble("productPrice"))
////                        .description(rs.getNString("description"))
////                        .manufacturer(rs.getString("manufacturer"))
////                        .quantity(rs.getInt("quantity"))
////                        .build();
////
////                //return contructed object sqlEvent
                
                
////                return sqlProduct;
            } else {
                System.out.println("ERROR: The id has not been found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Return null always because this method should return something
        return null;
    }
    
    
    
}
