package com.u2team.huansync.establishment.cash.model.DAO;
import com.u2team.huansync.establishment.DAO.*;
import com.u2team.huansync.establishment.cash.model.classes.CashRegister;
import com.u2team.huansync.establishment.model.classes.Establishment;
import com.u2team.huansync.persistence.BDConnection;
import com.u2team.huansync.persistence.Operations;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CashRegisterDAO implements ISaveDao<CashRegister>, IGetByIdDao<CashRegister>, IGetAll<CashRegister>, IDeleteDao<CashRegister>{

    @Override
    public void save(CashRegister t) {
          Operations.setConnection(BDConnection.MySQLConnection());
        // Create a query and send corresponding information in each field by replacing the character "?" with the information
        String stmInsert = "INSERT INTO tbl_cashRegister (cashRegisterId , statusCash, openingAmount, closingAmount, cashierOperatorId, establishmentsId ) VALUES(?, ?, ?, ?, ?);";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
            ps.setLong(1, t.getCashRegisterId());
            ps.setBoolean(2, t.isStatusCash());
            ps.setDouble(3, t.getOpeningAmount());
            ps.setDouble(4, t.getClosingAmount());
            ps.setLong(5, t.getCashierOperatorId());
            ps.setLong(6, t.getEstablishmentsId());
            // use Operation class with insert_update_delete and verify if the rows in database are affected
            int rows = Operations.insert_update_delete_db(ps);

            if (rows <= 0) {
                System.out.println("Error insert cash register to database");
            } else {
                System.out.println("Successful  insert cash register");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("An error has occurred: " + e.getMessage());
        }
    }

    @Override
    public CashRegister getById(long id) {
       Operations.setConnection(BDConnection.MySQLConnection());
        String stmInsert = "SELECT * FROM tbl_cashRegister WHERE cashRegisterId = ?;";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
            ps.setLong(1, id);
            ResultSet rs = Operations.query_db(ps);
            if (rs.next()) {
                CashRegister cas = new CashRegister();
                cas.setCashRegisterId(rs.getLong("cashRegisterId"));
                cas.setStatusCash(rs.getBoolean("statusCash"));
                cas.setOpeningAmount(rs.getDouble("openingAmount"));
                cas.setClosingAmount(rs.getDouble("closingAmount"));
                cas.setCashierOperatorId(rs.getLong("cashierOperatorId"));
                cas.setEstablishmentsId(rs.getLong("establishmentsId"));
                return cas;
            }
        } 
            catch (SQLException e) {
            e.printStackTrace();
            System.out.println("An error has occurred: " + e.getMessage());
        }
    
     return null;
    }

    @Override
    public List<CashRegister> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
