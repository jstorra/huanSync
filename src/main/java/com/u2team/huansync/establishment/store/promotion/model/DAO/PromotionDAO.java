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

/**
 * The {@code PromotionDAO} class implements various data access operations
 * (CRUD) for the {@code Promotion} entity using SQL queries.
 */
public class PromotionDAO implements ISaveDao<Promotion>, IDeleteDao<Promotion>, IGetAllDao<Promotion>, IGetByIdDao<Promotion>,IUpdateDao<Promotion> {

    /**
     * Saves a new promotion to the database.
     *
     * @param promotion The promotion to be saved.
     */
    @Override
    public void save(Promotion promotion) {
        String stmInsert = "INSERT INTO promotion(promotionId, namePromotion, description, statusPromotion, percent) VALUES(?,?,?,?,?);";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
            ps.setLong(1, promotion.getPromotionId());
            ps.setString(2, promotion.getNamePromotion());
            ps.setString(3, promotion.getDescription());
            ps.setBoolean(4, promotion.isStatusPromotion());
            ps.setInt(5, promotion.getPercent());

            int rows = Operations.insert_update_delete_db(ps);
            if (rows <= 0) {
                System.out.println("Cannot push promotion");
            } else {
                System.out.println("Successful push promotion");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes a promotion from the database based on the provided promotion ID.
     *
     * @param promotionId The ID of the promotion to be deleted.
     */
    @Override
    public void delete(long promotionId) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "DELETE FROM promotion WHERE promotionId = ?;";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, promotionId);
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
    }

    /**
     * Retrieves a list of all promotions from the database.
     *
     * @return A list containing all promotions.
     */
    @Override
    public List<Promotion> getAll() {
        List<Promotion> promotionList = new ArrayList<>();
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "SELECT * FROM promotion";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ResultSet rs = Operations.query_db(ps);

            while (rs.next()) {
                PromotionBuilder eventBuilder = new PromotionConcreteBuilder();

                Promotion sqlProduct = eventBuilder
                        .promotionId(rs.getLong("promotionId"))
                        .namePromotion(rs.getString("namePromotion"))
                        .description(rs.getString("description"))
                        .statusPromotion(rs.getBoolean("statusPromotion"))
                        .percent(rs.getInt("percent"))
                        .build();

                promotionList.add(sqlProduct);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return promotionList;
    }

    /**
     * Retrieves a promotion from the database based on the provided promotion ID.
     *
     * @param id The ID of the promotion to be retrieved.
     * @return The promotion with the specified ID.
     */
    @Override
    public Promotion getById(long id) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "SELECT * FROM promotion where promotionId = ?;";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, id);
            ResultSet rs = Operations.query_db(ps);

            if (rs.next()) {
                PromotionBuilder productBuilder = new PromotionConcreteBuilder();

                Promotion sqlProduct = productBuilder
                        .promotionId(rs.getLong("promotionId"))
                        .namePromotion(rs.getString("namePromotion"))
                        .description(rs.getString("description"))
                        .statusPromotion(rs.getBoolean("statusPromotion"))
                        .percent(rs.getInt("percent"))
                        .build();

                return sqlProduct;
            } else {
                System.out.println("ERROR: The id has not been found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Promotion promotion) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    
        Promotion sqlPromotion = getById(promotion.getPromotionId());

        if (sqlPromotion != null) {
            
            //Without promotionId
            sqlPromotion.setNamePromotion(promotion.getNamePromotion());
            sqlPromotion.setDescription(promotion.getDescription());
            sqlPromotion.setStatusPromotion(promotion.isStatusPromotion());
            sqlPromotion.setPercent(promotion.getPercent());

            String stmInsert = """
            UPDATE promotion
            SET namePromotion  = ?,
                description  = ?,
                statusPromotion = ?,
                percent  = ?
            WHERE promotionId  = ?;
            """;
            
//            private long promotionId;
//            private String namePromotion; 
//            private String description ; 
//            private boolean statusPromotion; 
//            private int percent; 

            try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
                ps.setString(1, promotion.getNamePromotion());
                ps.setString(2, promotion.getDescription());
                ps.setBoolean(3, promotion.isStatusPromotion());
                ps.setInt(4, promotion.getPercent());
                ps.setLong(5, promotion.getPromotionId());

                System.out.println(ps.toString());

                int rows = Operations.insert_update_delete_db(ps);
                if (rows <= 0) {
                    System.out.println("Cannot update products");
                } else {
                    System.out.println("Successful update products");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("not found results products");
        }
    
    }
}
