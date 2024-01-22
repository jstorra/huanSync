package com.u2team.huansync.activity.model.prize.controller;

import com.u2team.huansync.activity.model.prize.model.Prize;
import com.u2team.huansync.activity.model.prize.model.StatusPrize;
import com.u2team.huansync.activity.model.prize.model.TypePrize;
import com.u2team.huansync.persistence.BDConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrizeDAO {

    public List<Prize> getAllPrizes() {
        List<Prize> prizes = new ArrayList<>();
        try (Connection connection = BDConnection.MySQLConnection()) {
            String sql = "SELECT * FROM tbl_prizes WHERE statusPrize = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, "available");
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Prize prize = new Prize();
                        prize.setPrizeId(resultSet.getLong("prizeId"));
                        prize.setTypePrize(TypePrize.valueOf(resultSet.getString("typePrize").toUpperCase()));
                        prize.setDescription(resultSet.getString("description"));
                        prize.setPrice(resultSet.getDouble("price"));
                        prize.setStatusPrize(StatusPrize.valueOf(resultSet.getString("statusPrize").toUpperCase()));
                        prizes.add(prize);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prizes;
    }

    public Prize getPrizeById(long id) {
        Prize prize = null;
        try (Connection connection = BDConnection.MySQLConnection()) {
            String sql = "SELECT * FROM tbl_prizes WHERE prizeId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        prize = new Prize();
                        prize.setPrizeId(resultSet.getLong("prizeId"));
                        prize.setTypePrize(TypePrize.valueOf(resultSet.getString("typePrize").toUpperCase()));
                        prize.setDescription(resultSet.getString("description"));
                        prize.setPrice(resultSet.getDouble("price"));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prize;
    }

    public void insertPrize(Prize prize) {
        try (Connection connection = BDConnection.MySQLConnection()) {
            String sql = "INSERT INTO tbl_prizes (typePrize, description, price, statusPrize) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, prize.getTypePrize().getName());
                statement.setString(2, prize.getDescription());
                statement.setDouble(3, prize.getPrice());
                statement.setString(4, prize.getStatusPrize().getName());
                statement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updatePrize(Prize prize) {
        try (Connection connection = BDConnection.MySQLConnection()) {
            String sql = "UPDATE tbl_prizes SET typePrize = ?, description = ?, price = ? WHERE prizeId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, prize.getTypePrize().getName());
                statement.setString(2, prize.getDescription());
                statement.setDouble(3, prize.getPrice());
                statement.setLong(4, prize.getPrizeId());
                statement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletePrize(long id) {
        try (Connection connection = BDConnection.MySQLConnection()) {
            String sql = "DELETE FROM tbl_prizes WHERE prizeId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, id);
                statement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
