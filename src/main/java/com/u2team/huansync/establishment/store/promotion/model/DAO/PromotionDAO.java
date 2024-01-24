package com.u2team.huansync.establishment.store.promotion.model.DAO;


import com.u2team.huansync.establishment.DAO.IDeleteDao;
import com.u2team.huansync.establishment.DAO.IGetAllDao;
import com.u2team.huansync.establishment.DAO.IGetByIdDao;
import com.u2team.huansync.establishment.DAO.ISaveDao;
import com.u2team.huansync.establishment.DAO.IUpdateDao;
import com.u2team.huansync.establishment.store.promotion.model.classes.Promotion;
import com.u2team.huansync.establishment.store.promotion.model.classes.builder.PromotionBuilder;
import com.u2team.huansync.establishment.store.promotion.model.classes.builder.PromotionConcreteBuilder;
import com.u2team.huansync.persistence.BDConnection;
import com.u2team.huansync.persistence.Operations;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    public void delete(long promotionId) {
           Operations.setConnection(BDConnection.MySQLConnection());
      String stm = "DELETE FROM tbl_promotion WHERE promotionId = ?;";
      try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1,promotionId);
            int rows = Operations.insert_update_delete_db(ps);
            if (rows > 0) {
                System.out.println("successful delete promotion");
                return;
            } else {
                System.out.println("not exists promotion");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("something was wrong on delete the promotion");
        return;
    }

    @Override
    public List<Promotion> getAll() {
     List<Promotion> promotionList = new ArrayList<>();
          Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "SELECT * FROM tbl_promotion";
           try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ResultSet rs = Operations.query_db(ps);

            // As long as there is a row of data in the query, it will execute:
            while (rs.next()) {

                // Create builder with concrete Builder -> (Concrete builder creates the object step by step)
                PromotionBuilder eventBuilder = new PromotionConcreteBuilder();

                // Creates an event object and constructs it using the information from the query(rs) (field by field)
                Promotion sqlProduct = eventBuilder
                        .promotionId(rs.getLong("promotionId"))
                        .namePromotion(rs.getString("namePromotion"))
                        .description(rs.getString("description"))
                        .statusPromotion(rs.getBoolean("statusPromotion"))
                        .percent(rs.getInt("percent"))
                        // Build object
                        .build();            
                promotionList.add(sqlProduct);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Returns the list with objects inside
        return promotionList;
            
    
    }

    @Override
    public Promotion getById(long id) {
         //Class Operations are used to configure the connection with database and send a Query saved in variable stm
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "SELECT * FROM tbl_promotion where promotionId = ?;";

        //ps (prepareStatement) receives stm and replaces "?" for the variable with the index: "1" with "id"
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, id);

            // The result of the query is saved in the "rs" variable to apply logic.
            ResultSet rs = Operations.query_db(ps);

            // rs.next() -> Means if there is an answer, execute logic
            if (rs.next()) {

                // Create builder with concrete Builder -> (Concrete builder creates the object step by step)
                PromotionBuilder productBuilder = new PromotionConcreteBuilder();

                // Creates an event object and use eventBuilder for constructs it using the information from the query(rs) (field by field)
                Promotion sqlProduct = productBuilder
                        .promotionId(rs.getLong("promotionId"))
                        .namePromotion(rs.getString("namePromotion"))
                        .description(rs.getString("description"))
                        .statusPromotion(rs.getBoolean("statusPromotion"))
                        .percent(rs.getInt("percent"))                      
                        .build();

                //return contructed object sqlEvent
                return sqlProduct;
            } else {
                System.out.println("ERROR: The id has not been found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Return null always because this method should return something
        return null;

    }

    @Override
    public void update(Promotion t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    }

   
    
    
    

