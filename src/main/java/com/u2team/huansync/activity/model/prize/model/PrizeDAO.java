package com.u2team.huansync.activity.model.prize.model;

import com.u2team.huansync.persistence.BDConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * The PrizeDAO class provides Data Access Object (DAO) methods to interact with the database
 * and perform CRUD operations on Prize entities.
 */
public class PrizeDAO {

    /**
     * Retrieves all available prizes from the database.
     *
     * @return A list of Prize objects representing available prizes.
     */
    public List<Prize> getAllPrizes() {
        List<Prize> prizes = new ArrayList<>();
        try (Connection connection = BDConnection.MySQLConnection()) {
            String sql = "SELECT * FROM tbl_prizes WHERE statusPrize = 'available'";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Prize prize = new Prize();
                    prize.setPrizeId(resultSet.getLong("prizeId"));
                    prize.setTypePrize(TypePrize.valueOf(resultSet.getString("typePrize").toUpperCase()));
                    prize.setDescription(resultSet.getString("description"));
                    prize.setPrice(resultSet.getDouble("price"));
                    prize.setStatusPrize(StatusPrize.valueOf(resultSet.getString("statusPrize").toUpperCase()));
                    prize.setActivityId(resultSet.getLong("activityId") == 0 ? null : resultSet.getLong("activityId"));
                    prize.setWinnerId(resultSet.getLong("winnerId") == 0 ? null : resultSet.getLong("winnerId"));
                    prizes.add(prize);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prizes;
    }


    /**
     * Retrieves a Prize from the database based on its unique identifier.
     *
     * @param prizeId The unique identifier of the Prize.
     * @return The Prize object representing the retrieved prize.
     */
    public Prize getPrizeById(Long prizeId) {
        Prize prize = new Prize();
        try (Connection connection = BDConnection.MySQLConnection()) {
            String sql = "SELECT * FROM tbl_prizes WHERE prizeId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, prizeId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        prize.setPrizeId(resultSet.getLong("prizeId"));
                        prize.setTypePrize(TypePrize.valueOf(resultSet.getString("typePrize").toUpperCase()));
                        prize.setDescription(resultSet.getString("description"));
                        prize.setPrice(resultSet.getDouble("price"));
                        prize.setStatusPrize(StatusPrize.valueOf(resultSet.getString("statusPrize").toUpperCase()));
                        prize.setActivityId(resultSet.getLong("activityId") == 0 ? null : resultSet.getLong("activityId"));
                        prize.setWinnerId(resultSet.getLong("winnerId") == 0 ? null : resultSet.getLong("winnerId"));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prize;
    }


    /**
     * Inserts a new Prize into the database.
     *
     * @param prize The Prize object to be inserted.
     */
    public void insertPrize(Prize prize) {
        try (Connection connection = BDConnection.MySQLConnection()) {
            String sql = "INSERT INTO tbl_prizes (typePrize, description, price, statusPrize) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, prize.getTypePrize().getName());
                statement.setString(2, prize.getDescription());
                statement.setDouble(3, prize.getPrice());
                statement.setString(4, "available");
                statement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Updates an existing Prize in the database.
     *
     * @param prize The Prize object with updated values.
     */
    public void updatePrize(Prize prize) {
        try (Connection connection = BDConnection.MySQLConnection()) {
            String sql = "UPDATE tbl_prizes SET typePrize = ?, description = ?, price = ?, statusPrize = ?, activityId = ?, winnerId = ? WHERE prizeId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, prize.getTypePrize().getName());
                statement.setString(2, prize.getDescription());
                statement.setDouble(3, prize.getPrice());
                statement.setString(4, prize.getStatusPrize().getName());
                statement.setObject(5, prize.getActivityId());
                statement.setObject(6, prize.getWinnerId());
                statement.setLong(7, prize.getPrizeId());
                statement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes a Prize from the database based on its unique identifier.
     *
     * @param prizeId The unique identifier of the Prize to be deleted.
     */
    public void deletePrize(Long prizeId) {
        try (Connection connection = BDConnection.MySQLConnection()) {
            String sql = "DELETE FROM tbl_prizes WHERE prizeId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, prizeId);
                statement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
