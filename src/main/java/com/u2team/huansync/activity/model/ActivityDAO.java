package com.u2team.huansync.activity.model;

import com.u2team.huansync.persistence.BDConnection;

import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ActivityDAO {

    public List<Activity> getAllActivities() {
        List<Activity> activities = new ArrayList<>();
        try (Connection connection = BDConnection.MySQLConnection()) {
            String sql = "SELECT * FROM tbl_activities WHERE completed = FALSE";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    Activity activity = new Activity();
                    activity.setActivityId(resultSet.getLong("activityId"));
                    activity.setName(resultSet.getString("name"));
                    activity.setTypeActivity(TypeActivity.valueOf(resultSet.getString("typeActivity").toUpperCase()));
                    activity.setCategoryCosplayId((resultSet.getLong("categoryCosplayId") == 0) ? null : resultSet.getLong("categoryCosplayId"));
                    activity.setNumParticipants(resultSet.getInt("numParticipants"));
                    activity.setEventId(resultSet.getLong("eventId") == 0  ? null : resultSet.getLong("eventId"));
                    activity.setPrice(resultSet.getLong("price"));
                    activity.setStartTime(LocalTime.parse(resultSet.getString("startTime")));
                    activity.setCompleted(resultSet.getBoolean("completed"));
                    activities.add(activity);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return activities;
    }

    public Activity getActivityById(Long activityId) {
        Activity activity = new Activity();
        try (Connection connection = BDConnection.MySQLConnection()) {
            String sql = "SELECT * FROM tbl_activities WHERE activityId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, activityId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        activity.setActivityId(resultSet.getLong("activityId"));
                        activity.setName(resultSet.getString("name"));
                        activity.setTypeActivity(TypeActivity.valueOf(resultSet.getString("typeActivity").toUpperCase()));
                        activity.setCategoryCosplayId(resultSet.getLong("categoryCosplayId") == 0 ? null : resultSet.getLong("categoryCosplayId"));
                        activity.setNumParticipants(resultSet.getInt("numParticipants"));
                        activity.setEventId(resultSet.getLong("eventId") == 0  ? null : resultSet.getLong("eventId"));
                        activity.setPrice(resultSet.getLong("price"));
                        activity.setStartTime(LocalTime.parse(resultSet.getString("startTime")));
                        activity.setCompleted(resultSet.getBoolean("completed"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return activity;
    }

    public void insertActivity(Activity activity) {
        try (Connection connection = BDConnection.MySQLConnection()) {
            String sql = "INSERT INTO tbl_activities (name, typeActivity, categoryCosplayId, numParticipants, startTime, price, completed) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, activity.getName());
                statement.setString(2, activity.getTypeActivity().name());
                statement.setObject(3, activity.getCategoryCosplayId());
                statement.setInt(4, activity.getNumParticipants());
                statement.setString(5, activity.getStartTime().toString());
                statement.setDouble(6,activity.getPrice());
                statement.setBoolean(7, false);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateActivity(Activity activity) {
        try (Connection connection = BDConnection.MySQLConnection()) {
            String sql = "UPDATE tbl_activities SET name = ?, typeActivity = ?, categoryCosplayId = ?, numParticipants = ?, eventId = ?, startTime = ?, price = ?, completed = ? WHERE activityId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, activity.getName());
                statement.setString(2, activity.getTypeActivity().name());
                statement.setObject(3, activity.getCategoryCosplayId());
                statement.setInt(4, activity.getNumParticipants());
                statement.setObject(5, activity.getEventId());
                statement.setString(6, activity.getStartTime().toString());
                statement.setDouble(7,activity.getPrice());
                statement.setBoolean(8, activity.isCompleted());
                statement.setLong(9, activity.getActivityId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteActivity(Long activityId) {
        try (Connection connection = BDConnection.MySQLConnection()) {
            String sql = "DELETE FROM tbl_activities WHERE activityId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, activityId);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
