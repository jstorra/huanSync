package com.u2team.huansync.ticketOffice.tickets.model.DAO;

import com.u2team.huansync.persistence.BDConnection;
import com.u2team.huansync.persistence.Operations;
import com.u2team.huansync.ticketOffice.tickets.model.classes.TicketType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TicketTypeDAO implements IDao<TicketType>{

    @Override
    public TicketType getById(long id) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "SELECT * FROM tbl_ticketType where ticketTypeId = ?;";
        
        try(PreparedStatement ps = Operations.getConnection().prepareStatement(stm)){
            ps.setLong(1, id);
            ResultSet rs = Operations.query_db(ps);
            if (rs.next()) {
                TicketType ticketType = new TicketType;
                ticketType.
                
                
                
                
            }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<TicketType> getAll() {
       
    }

    @Override
    public void save(TicketType t) {
        
    }

    @Override
    public void update(TicketType t) {
        
    }

    @Override
    public void delete(long id) {
        
    }
    
    
}
