package com.u2team.huansync.establishment.store.promotion.model.DAO;


import com.u2team.huansync.establishment.DAO.IDeleteDao;
import com.u2team.huansync.establishment.DAO.IGetAllDao;
import com.u2team.huansync.establishment.DAO.IGetByIdDao;
import com.u2team.huansync.establishment.DAO.ISaveDao;
import com.u2team.huansync.establishment.DAO.IUpdateDao;
import com.u2team.huansync.establishment.store.promotion.model.classes.Promotion;
import com.u2team.huansync.persistence.Operations;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;




public class PromotionDAO implements ISaveDao<Promotion>, IDeleteDao<Promotion>, IGetAllDao<Promotion>,IGetByIdDao<Promotion>,IUpdateDao<Promotion>{

    @Override
    public void save(Promotion promotion) {
            String stmInsert = "INSERT INTO tbl_promotion(promotionId,namePromotion,description,statusPromotion,percent) VALUES(?,?,?,?,?);";
             try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
            ps.setLong(1, promotion.getPromotionId());
            ps.setString(2, promotion.getNamePromotion());
            ps.setString(3, promotion.getDescription());
            ps.setBoolean(4, promotion.isStatusPromotion());
            ps.setInt(5, promotion.getPercent());


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

    // CRUD 
    
    @Override
    public void delete(long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Promotion> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Promotion getById(long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Promotion t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    }

   
    
    
    

