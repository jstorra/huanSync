package com.u2team.huansync.event.equipment.model.DAO;

import com.u2team.huansync.event.DAO.IDeleteDao;
import com.u2team.huansync.event.DAO.IGetByIdDao;
import com.u2team.huansync.event.DAO.ISaveDao;
import com.u2team.huansync.event.equipment.model.classes.Equipment;
import com.u2team.huansync.persistence.BDConnection;
import com.u2team.huansync.persistence.Operations;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author criis
 */
/**
 * DAO class for Equipment entity. Implements ISaveDao, IDeleteDao, and
 * IGetByIdDao interfaces for Equipment. Handles database operations for saving,
 * deleting, and retrieving Equipment objects.
 */
public class EquipmentDAO implements ISaveDao<Equipment>, IDeleteDao<Equipment>, IGetByIdDao<Equipment> {

    /**
     * Saves an Equipment object to the database. Inserts a new equipment record
     * or updates an existing one based on the provided Equipment object.
     *
     * @param equipment Equipment object to be saved in the database.
     */
    @Override
    public void save(Equipment equipment) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stmInsert = "INSERT INTO tbl_equipment(nameEquipment, quantity, statusStaff) VALUES (?,?,?);";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
            ps.setString(1, equipment.getNameEquipment());
            ps.setLong(2, equipment.getQuantity());
            ps.setString(3, equipment.getStatusEquipmentEnum().name());

            int rows = Operations.insert_update_delete_db(ps);
            if (rows <= 0) {
                System.out.println("Cannot insert Equipment");
            } else {
                System.out.println("Successful insert of Equipment");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes an Equipment object from the database using its ID.
     *
     * @param idEquipment The ID of the Equipment to be deleted.
     */
    @Override
    public void delete(long idEquipment) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "DELETE FROM tbl_equipment WHERE equipmentId = ?;";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, idEquipment);
            int rows = Operations.insert_update_delete_db(ps);
            if (rows > 0) {
                System.out.println("succesful delete workerRole");
                return;
            } else {
                System.out.println("not exists workerRole");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("something was wrong on delete workerRole");
        return;

    }

    /**
     * Retrieves an Equipment object by its ID from the database.
     *
     * @param id The ID of the Equipment to retrieve.
     * @return Equipment object if found, or null if not found.
     */
    @Override
    public Equipment getById(long id) {

        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "SELECT * FROM tbl_equipment where equipmentId = ?;";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, id);
            ResultSet rs = Operations.query_db(ps);
            if (rs.next()) {
                Equipment equipment = new Equipment();
                equipment.setEquipmentId(rs.getLong("equipmentId"));
                equipment.setNameEquipment(rs.getString("nameEquipment"));
                equipment.setQuantity(rs.getLong("quantity"));
                equipment.setStatusEquipmentEnum(equipment.getStatusEquipmentEnum(rs.getString("statusStaff")));
                return equipment;
            } else {
                System.out.println("ERROR: The id has not been found");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
