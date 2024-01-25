package com.u2team.huansync.establishment.model.DAO;

import com.u2team.huansync.establishment.DAO.*;
import com.u2team.huansync.establishment.model.classes.Establishment;
import com.u2team.huansync.persistence.BDConnection;
import com.u2team.huansync.persistence.Operations;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class EstablishmentDAO implements IGetByIdDao<Establishment>, IGetAll<Establishment>, ISaveDao<Establishment>, IDeleteDao<Establishment> {

    @Override
    public Establishment getById(long id) {
        Operations.setConnection(BDConnection.MySQLConnection());
        // Create a query and send corresponding information in each field by replacing the character "?" with the information
        String stmInsert = "SELECT * FROM tbl_establishments WHERE establishmentId = ?;";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
            ps.setLong(1, id);
            ResultSet rs = Operations.query_db(ps);
            if (rs.next()) {
                Establishment est = new Establishment();
                est.setEstablishmentId(rs.getLong("establishmentId"));
                est.setNameEstablishment(rs.getString("nameEstablishment"));
                est.setManagerEstablishmentId(rs.getLong("managerEstablishmentId"));
                est.setEstablishmentEventId(rs.getLong("eventId"));
                est.setCategoyEstablishment(est.getCategoyEstablisment(rs.getString("categoryEstablishment")));
                return est;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("An error has occurred: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Establishment> getAll() {
        Operations.setConnection(BDConnection.MySQLConnection());
        // Create a query and send corresponding information in each field by replacing the character "?" with the information
        String stmInsert = "SELECT * FROM tbl_establishments;";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
            ResultSet rs = Operations.query_db(ps);
            List<Establishment> listEstablishment = new ArrayList<>();
            while (rs.next()) {
                Establishment est = new Establishment();
                est.setEstablishmentId(rs.getLong("establishmentId"));
                est.setNameEstablishment(rs.getString("nameEstablishment"));
                est.setManagerEstablishmentId(rs.getLong("managerEstablishmentId"));
                est.setEstablishmentEventId(rs.getLong("eventId"));
                est.setCategoyEstablishment(est.getCategoyEstablisment(rs.getString("categoryEstablishment")));
                listEstablishment.add(est);
            }
            return listEstablishment;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("An error has occurred: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void save(Establishment t) {
        Operations.setConnection(BDConnection.MySQLConnection());
        // Create a query and send corresponding information in each field by replacing the character "?" with the information
        String stmInsert = "INSERT INTO tbl_establishments (categoryEstablishment, nameEstablishment, eventId, managerEstablishmentId) VALUES(?, ?, ?, ?);";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
            ps.setString(1, t.getCategoyEstablishment().getCategory());
            ps.setString(2, t.getNameEstablishment());
            ps.setLong(3, t.getEstablishmentEventId());
            ps.setLong(4, t.getManagerEstablishmentId());
            // use Operation class with insert_update_delete and verify if the rows in database are affected
            int rows = Operations.insert_update_delete_db(ps);

            if (rows <= 0) {
                System.out.println("Error insert establishment to database");
            } else {
                System.out.println("Successful  insert establishment");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("An error has occurred: " + e.getMessage());
        }
    }

    @Override
    public void delete(long establishmentId) {
        Operations.setConnection(BDConnection.MySQLConnection());
        // Create a query and send corresponding information in each field by replacing the character "?" with the information
        String stmInsert = "DELETE FROM tbl_establishments WHERE establishmentId = ?;";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
            ps.setLong(1, establishmentId);
            // use Operation class with insert_update_delete and verify if the rows in database are affected
            int rows = Operations.insert_update_delete_db(ps);
            if (rows <= 0) {
                System.out.println("Error delete ingredient  from database");
            } else {
                System.out.println("Successful  delete ingredient");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("An error has occurred: " + e.getMessage());
        }
    }

}
