package com.u2team.huansync.establishment.store.productOrder.model.DAO;

import com.u2team.huansync.establishment.DAO.ISaveDao;
import com.u2team.huansync.establishment.store.productOrder.model.classes.ProductOrder;
import com.u2team.huansync.persistence.BDConnection;
import com.u2team.huansync.persistence.Operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductOrderDAO implements ISaveDao<ProductOrder> {
    @Override
    public void save(ProductOrder productOrder) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stmInsert = "INSERT INTO tbl_product_order (order_id, product_id, quantity) VALUES (?, ?, ?)";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
            ps.setLong(1, productOrder.getOrderId());
            ps.setLong(2, productOrder.getProductId());
            ps.setInt(3, productOrder.getQuantity());


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



}
