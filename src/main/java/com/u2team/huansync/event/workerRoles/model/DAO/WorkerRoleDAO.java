package com.u2team.huansync.event.workerRoles.model.DAO;

import com.u2team.huansync.event.DAO.*;
import com.u2team.huansync.event.workerRoles.model.classes.WorkerRole;
import com.u2team.huansync.persistence.BDConnection;
import com.u2team.huansync.persistence.Operations;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Edgar Pinzon
 */
public class WorkerRoleDAO implements IGetByIdDao<WorkerRole>, IGetAllDao<WorkerRole>, ISaveDao<WorkerRole>, IUpdateDao<WorkerRole>, IDeleteDao<WorkerRole> {

    /**
     * Retrieves a workerRole from the database based on its unique identifier (ID).
     * This method queries the database to retrieve an event with the specified ID. It establishes
     * a connection with the database, prepares a SELECT query, and executes the query with the provided
     * ID. If the query returns a result, it constructs a workerRole object  and  returns
     * the populated object. If no result is found, an error message is printed to the console, and the
     * method returns null.
     *
     * @param workerRoleid The unique identifier of the workerRole to be retrieved.
     * @return A WorkerRole object representing the retrieved workerRole , or null if the ID is not found in the database.
     */

    @Override
    public WorkerRole getById(long workerRoleid) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "select * from tbl_workerRoles where workerRoleId = ? ;";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, workerRoleid);
            ResultSet rs = Operations.query_db(ps);
            if (rs.next()) {
                WorkerRole workerRole = new WorkerRole();
                workerRole.setWorkerRoleId(rs.getLong("workerRoleId"));

                workerRole.setWorkerRoleName(rs.getString("nameWorkerRole"));
                List<String> listActivities = Arrays.asList(rs.getString("activitiesWorkerRole").split("\\|"));
                workerRole.setWorkerRoleActivities(listActivities);
                return workerRole;
            } else {
                System.out.println("ERROR: The id has not been found");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Retrieves a list of all workerRoles from the database.
     * This method establishes a connection to the MySQL database, executes a SELECT query
     * to fetch all workerRoles from the 'tbl_workerRoles' table, and constructs a list of WorkerRole objects
     * based on the retrieved data.
     *
     * @return A list of WorkerRole objects representing all events in the database.
    */

    @Override
    public List<WorkerRole> getAll() {
        List<WorkerRole> workerRolesList = new ArrayList<>();
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "select * from tbl_workerRoles ;";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {

            ResultSet rs = Operations.query_db(ps);

            while (rs.next()) {
                WorkerRole workerRole = new WorkerRole();
                workerRole.setWorkerRoleId(rs.getLong("workerRoleId"));
                workerRole.setWorkerRoleName(rs.getString("nameWorkerRole"));
                List<String> listActivities = Arrays.asList(rs.getString("activitiesWorkerRole").split("\\|"));
                workerRole.setWorkerRoleActivities(listActivities);
                workerRolesList.add(workerRole);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return workerRolesList;
    }

    /**
     * Saves a workerRole to the database.
     * It checks for repeated 'nameWorkerRole' in the 'tbl_workerRoles' table, and if 'nameWorkerRole' is not
     * repeated inserts the workerRole information into the database.
     *
     * @param workerRole The workerRole object to be saved to the database.
    */

    @Override
    public void save(WorkerRole workerRole) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stmInsert = "INSERT INTO tbl_workerRoles (nameWorkerRole,activitiesWorkerRole) VALUES (?,?);";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
            ps.setString(1, workerRole.getWorkerRoleName());
            String activitiesWorkerRole = String.join("|", workerRole.getWorkerRoleActivities());
            ps.setString(2, activitiesWorkerRole);

            int rows = Operations.insert_update_delete_db(ps);
            if (rows <= 0) {
                System.out.println("Cannot insert worker role");
            } else {
                System.out.println("Successful insert of worker role");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Updates an existing workerRole in the database.
     * It checks for repeated 'nameWorkerRole' in the 'tbl_workerRoles' table, and if 'nameWorkerRole' is not
     * repeated retrieves the existing workerRole based on the id provided.
     * then updates the values of the existing worlerRole with the values provided in the  WorkerRole object parameter, 
     * and updates the database record.

     * @param workerRole The workerRole object containing updated information to be applied to the database.
    */

    @Override
    public void update(WorkerRole workerRole) {

        WorkerRole sqlWorkerRole = getById(workerRole.getWorkerRoleId());

        if (sqlWorkerRole != null) {
            sqlWorkerRole.setWorkerRoleName(workerRole.getWorkerRoleName());
            sqlWorkerRole.setWorkerRoleActivities(workerRole.getWorkerRoleActivities());
            String stmUpdate = """
            UPDATE tbl_workerRoles
            SET nameWorkerRole = ?,
                activitiesWorkerRole = ?
            WHERE workerRoleId = ?;
                               """;

            try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmUpdate)) {

                ps.setString(1, sqlWorkerRole.getWorkerRoleName());
                String activitiesWorkerRole = String.join("|", sqlWorkerRole.getWorkerRoleActivities());
                ps.setString(2, activitiesWorkerRole);
                ps.setLong(3, sqlWorkerRole.getWorkerRoleId());
                System.out.println(ps.toString());
                int rows = Operations.insert_update_delete_db(ps);
                if (rows <= 0) {
                    System.out.println("Cannot update worker role");
                } else {
                    System.out.println("Successful update of worker role");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * Deletes a workerRole from the database using its ID.
     * This method deletes a workerRole from the database identified by the provided workerRole id.
     * It establishes a connection with the database, prepares a DELETE query, and executes
     * the query to remove the specified workerRole. The success or failure of the operation is
     * indicated by printing appropriate messages to the console.
     *
     * @param workerRoleId The unique identifier of the workerRole to be deleted.
    */

    @Override
    public void delete(long workerRoleId) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "DELETE FROM tbl_workerRoles WHERE workerRoleId = ?;";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, workerRoleId);
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

}
 
