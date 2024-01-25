package com.u2team.huansync.establishment.store.productOrder.model.DAO;

import com.u2team.huansync.establishment.DAO.IDeleteDao;
import com.u2team.huansync.establishment.DAO.IGetAllDao;
import com.u2team.huansync.establishment.DAO.IGetByIdDao;
import com.u2team.huansync.establishment.DAO.ISaveDao;
import com.u2team.huansync.establishment.DAO.IUpdateDao;
import com.u2team.huansync.establishment.store.productOrder.model.classes.ProductOrder;
import com.u2team.huansync.persistence.BDConnection;
import com.u2team.huansync.persistence.Operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductOrderDAO implements ISaveDao<ProductOrder>, IDeleteDao<ProductOrder>,IGetAllDao<ProductOrder>, IGetByIdDao<ProductOrder>, IUpdateDao<ProductOrder> {
    @Override
    public void save(ProductOrder productOrder) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stmInsert = "INSERT INTO tbl_product_order (orderId, productId, quantity, promotionId) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
            ps.setLong(1, productOrder.getOrderId());
            ps.setLong(2, productOrder.getProductId());
            ps.setInt(3, productOrder.getQuantity());
            ps.setLong(4, productOrder.getProductId());


            int rows = Operations.insert_update_delete_db(ps);
            if (rows <= 0) {
                System.out.println("Cannot insert in table product_order");
            } else {
                System.out.println("Successful insert in tableproduct_order");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(long productOrderId) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "DELETE FROM tbl_product_order WHERE orderId = ?;";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
              ps.setLong(1, productOrderId);
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
    public List<ProductOrder> getAll() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
        
        List<ProductOrder> productOrderList = new ArrayList<>();
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "select * from tbl_order;";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {

            ResultSet rs = Operations.query_db(ps);

            while (rs.next()) {
                ProductOrder productOrder = new ProductOrder();
                
                //String stmInsert = "INSERT INTO tbl_order(orderId,customerId,establishmentId,cashRegisterId,cashierOperatorId,orderStatusEnum) VALUES(?,?,?,?,?,?);";
                
//                private long orderId;
//                private long productId;
//                private int quantity;
//                private long promotionId;

//            String stmInsert = "INSERT INTO tbl_product_order (orderId, productId, quantity, promotionId) VALUES (?, ?, ?, ?)";
                
                
                
                //The differentes atributes in the SQL
                productOrder.setOrderId(rs.getLong("orderId"));
                productOrder.setProductId(rs.getLong("productId"));
                productOrder.setQuantity(rs.getInt("quantity"));
                productOrder.setProductId(rs.getLong("promotionId"));
                
                //Don´t forgett this to add the order
                productOrderList.add(productOrder);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productOrderList;
        
    }

    @Override
    public ProductOrder getById(long productOrderId) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "select * from tbl_product_order where orderId = ? ;";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, productOrderId);
            ResultSet rs = Operations.query_db(ps);
            
            //                private long orderId;
//                private long productId;
//                private int quantity;
//                private long promotionId;

//            String stmInsert = "INSERT INTO tbl_product_order (orderId, productId, quantity, promotionId) VALUES (?, ?, ?, ?)";
 
            
            if (rs.next()) {
                ProductOrder productOrder = new ProductOrder();
                
                productOrder.setOrderId(rs.getLong("orderId"));
                productOrder.setProductId(rs.getLong("productId"));
                productOrder.setQuantity(rs.getInt("quantity"));
                productOrder.setProductId(rs.getLong("promotionId"));
                
//                List<String> listActivities = Arrays.asList(rs.getString("activitiesWorkerRole").split("\\|"));
//                order.setWorkerRoleActivities(listActivities);
                
                return productOrder;
            } else {
                System.out.println("ERROR: The id has not been found");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
        
        
    }

    @Override
    public void update(ProductOrder productOrder) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    
        ProductOrder sqlProductOrder = getById(productOrder.getOrderId());

        if (sqlProductOrder != null) {
            
//            String stmInsert = "INSERT INTO tbl_product_order (orderId, productId, quantity, promotionId) VALUES (?, ?, ?, ?)";

//                private long orderId;
//                private long productId;
//                private int quantity;
//                private long promotionId;


            //Without orderId for now
            sqlProductOrder.setProductId(productOrder.getProductId());
            sqlProductOrder.setQuantity(productOrder.getQuantity());
            sqlProductOrder.setPromotionId(productOrder.getPromotionId());
            
            
            String stmUpdate = """
            UPDATE tbl_product_order
            SET productId = ?,
                quantity = ?,
                promotionId = ?
            WHERE orderId = ?;
                               """;

            try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmUpdate)) {

                ps.setLong(1, sqlProductOrder.getProductId());
                
                //With Long I don´t have mistake, but I think it is Int
                ps.setInt(2, sqlProductOrder.getQuantity());
                
                
                ps.setLong(3, sqlProductOrder.getPromotionId());
                ps.setLong(4, sqlProductOrder.getOrderId());
                
                
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
