package com.u2team.huansync.activity.model.prize.model;

import com.u2team.huansync.persistence.BDConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object (DAO) for Prize entities, responsible for database operations.
 */
public class PrizeDAO {

    /**
     * Retrieves a list of all available prizes from the database.
     *
     * @return List of available prizes.
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
     * Retrieves a prize by its ID from the database.
     *
     * @param prizeId The ID of the prize to retrieve.
     * @return The prize with the specified ID.
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
     * Inserts a new prize into the database.
     *
     * @param prize The prize to be inserted.
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
     * Updates an existing prize in the database.
     *
     * @param prize The updated prize object.
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
     * Deletes a prize from the database by its ID.
     *
     * @param prizeId The ID of the prize to be deleted.
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
