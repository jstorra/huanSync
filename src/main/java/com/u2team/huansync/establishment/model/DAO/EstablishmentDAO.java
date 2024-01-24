package com.u2team.huansync.establishment.model.DAO;

import com.u2team.huansync.establishment.DAO.*;
import com.u2team.huansync.establishment.model.classes.Establishment;
import com.u2team.huansync.persistence.BDConnection;
import com.u2team.huansync.persistence.Operations;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author user
 */
public class EstablishmentDAO implements IGetByIdDao<Establishment>,IGetAll<Establishment>,ISaveDao<Establishment>, IUpdateDao<Establishment>{

    @Override
    public Establishment getById(long id) {
        
        return null;
        
    }

    @Override
    public List<Establishment> getAll() {
        
        return null;
        
    }
//    private long establishmentId;
//    private String nameEstablishment;
//    private long managerEstablishmentId;
//    private CategoryEstablishment categoyEstablisment;
//    private long establishmentEventId;
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
    public void update(Establishment t) {
        
    }

    
}
