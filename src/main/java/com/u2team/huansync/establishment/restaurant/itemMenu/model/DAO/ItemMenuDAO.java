package com.u2team.huansync.establishment.restaurant.itemMenu.model.DAO;

import com.u2team.huansync.establishment.restaurant.itemMenu.model.classes.ItemMenu;
import com.u2team.huansync.event.DAO.ISaveDao;
import com.u2team.huansync.event.model.util.Validations;
import com.u2team.huansync.persistence.Operations;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author misae
 */
public class ItemMenuDAO implements ISaveDao<ItemMenu> {

    @Override
    public void save(ItemMenu itemMenu) {
        

        // Create a query and send corresponding information in each field by replacing the character "?" with the information
        String stmInsert = "INSERT INTO tbl_events(nameEvent, countryEvent, cityEvent, addressEvent, peopleCapacity, storeCapacity, restaurantCapacity, dateEvent, timeEvent, organizerId, ageClassification, statusEvent)  VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {


            // use Operation class with insert_update_delete and verify if the rows in database are affected
            int rows = Operations.insert_update_delete_db(ps);
            if (rows <= 0) {
                System.out.println("Cannot push event");
            } else {
                System.out.println("Successful push event");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("An error has occurred: "  + e.getMessage());
        }
        
        
    }
    
    
    
}
