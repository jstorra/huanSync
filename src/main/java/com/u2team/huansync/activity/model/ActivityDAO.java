package com.u2team.huansync.activity.model;

import com.u2team.huansync.persistence.BDConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ActivityDAO {

    public List<Activity> getAllActivities() {
        List<Activity> activities = new ArrayList<>();

        try (Connection connection = BDConnection.MySQLConnection()) {
            String sql = "SELECT * FROM tbl_activities";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    Activity activity = new Activity();
                    activity.setActivityId(resultSet.getLong("activityId"));
                    activity.setName(resultSet.getString("name"));
                    String typeActivityName = resultSet.getString("typeActivity");
                    typeActivityName = typeActivityName.toUpperCase();  // Convierte a mayúsculas
                    activity.setTypeActivity(TypeActivity.valueOf(typeActivityName));
                    activity.setCategoryCosplayId(resultSet.getLong("categoryCosplayId"));
                    activity.setNumParticipants(resultSet.getInt("numParticipants"));
                    activity.setEventId(resultSet.getLong("eventId"));
                    activity.setPrice(resultSet.getLong("price"));
                    activity.setStartTime(LocalTime.parse(resultSet.getString("startTime")));
                    // The use of the staff list will be analyzed here.
                    activities.add(activity);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return activities;
    }


    public Activity getActivityById(long activityId) {
        Activity activity = null;

        try (Connection connection = BDConnection.MySQLConnection()) {
            String sql = "SELECT * FROM tbl_activities WHERE activityId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, activityId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        activity = new Activity();
                        activity.setActivityId(resultSet.getLong("activityId"));
                        activity.setName(resultSet.getString("name"));
                        String typeActivityName = resultSet.getString("typeActivity");
                        typeActivityName = typeActivityName.toUpperCase();  // Convierte a mayúsculas
                        activity.setTypeActivity(TypeActivity.valueOf(typeActivityName));
                        activity.setCategoryCosplayId(resultSet.getLong("categoryCosplayId"));
                        activity.setNumParticipants(resultSet.getInt("numParticipants"));
                        activity.setEventId(resultSet.getLong("eventId"));
                        activity.setPrice(resultSet.getLong("price"));
                        activity.setStartTime(LocalTime.parse(resultSet.getString("startTime")));
                        // The use of the staff list will be analyzed here.
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
            String sql = "INSERT INTO tbl_activities (name, typeActivity, categoryCosplayId, numParticipants, eventId, startTime, price) VALUES (?, ?, ?, ?, ?, ?,?)";
            try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, activity.getName());
                statement.setString(2, activity.getTypeActivity().name());
                statement.setLong(3, activity.getCategoryCosplayId());
                statement.setInt(4, activity.getNumParticipants());
                statement.setLong(5, activity.getEventId());
                statement.setString(6, activity.getStartTime().toString());
                statement.setLong(7,activity.getPrice());
                // The use of the staff list will be analyzed here.
                statement.executeUpdate();

                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        activity.setActivityId(generatedKeys.getLong(1));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateActivity(Activity activity) {
        try (Connection connection = BDConnection.MySQLConnection()) {
            String sql = "UPDATE tbl_activities SET name = ?, typeActivity = ?, categoryCosplayId = ?, numParticipants = ?, eventId = ?, startTime = ?, price = ? WHERE activityId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, activity.getName());
                statement.setString(2, activity.getTypeActivity().name());
                statement.setLong(3, activity.getCategoryCosplayId());
                statement.setInt(4, activity.getNumParticipants());
                statement.setLong(5, activity.getEventId());
                statement.setString(6, activity.getStartTime().toString());
                statement.setLong(7,activity.getPrice());
                statement.setLong(8, activity.getActivityId());
                // The use of the staff list will be analyzed here.
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteActivity(long activityId) {
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
