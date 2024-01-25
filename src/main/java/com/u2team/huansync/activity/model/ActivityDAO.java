package com.u2team.huansync.activity.model;

import com.u2team.huansync.persistence.BDConnection;

import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object (DAO) for managing activities in the database.
 */
public class ActivityDAO {

    /**
     * Retrieves a list of all activities that are not completed.
     *
     * @return List of activities.
     */
    public List<Activity> getAllActivities() {
        List<Activity> activities = new ArrayList<>();
        try (Connection connection = BDConnection.MySQLConnection()) {
            String sql = "SELECT * FROM tbl_activities WHERE completed = FALSE";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    Activity activity = new Activity();
                    activity.setActivityId(resultSet.getLong("activityId"));
                    activity.setNameActivity(resultSet.getString("name"));
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

    /**
     * Retrieves a single activity by its ID.
     *
     * @param activityId The ID of the activity to retrieve.
     * @return The activity with the specified ID.
     */
    public Activity getActivityById(Long activityId) {
        Activity activity = new Activity();
        try (Connection connection = BDConnection.MySQLConnection()) {
            String sql = "SELECT * FROM tbl_activities WHERE activityId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, activityId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        activity.setActivityId(resultSet.getLong("activityId"));
                        activity.setNameActivity(resultSet.getString("name"));
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

    /**
     * Inserts a new activity into the database.
     *
     * @param activity The activity to be inserted.
     */
    public void insertActivity(Activity activity) {
        try (Connection connection = BDConnection.MySQLConnection()) {
            String sql = "INSERT INTO tbl_activities (name, typeActivity, categoryCosplayId, numParticipants, startTime, price, completed) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, activity.getNameActivity());
                statement.setString(2, activity.getTypeActivity().name());
                statement.setObject(3, activity.getCategoryCosplayId());
                statement.setInt(4, activity.getNumParticipants());
                statement.setString(5, activity.getStartTime().toString());
                statement.setDouble(6, activity.getPrice());
                statement.setBoolean(7, false);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates an existing activity in the database.
     *
     * @param activity The updated activity object.
     */
    public void updateActivity(Activity activity) {
        try (Connection connection = BDConnection.MySQLConnection()) {
            String sql = "UPDATE tbl_activities SET name = ?, typeActivity = ?, categoryCosplayId = ?, numParticipants = ?, eventId = ?, startTime = ?, price = ?, completed = ? WHERE activityId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, activity.getNameActivity());
                statement.setString(2, activity.getTypeActivity().name());
                statement.setObject(3, activity.getCategoryCosplayId());
                statement.setInt(4, activity.getNumParticipants());
                statement.setObject(5, activity.getEventId());
                statement.setString(6, activity.getStartTime().toString());
                statement.setDouble(7, activity.getPrice());
                statement.setBoolean(8, activity.isCompleted());
                statement.setLong(9, activity.getActivityId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes an activity from the database by its ID.
     *
     * @param activityId The ID of the activity to be deleted.
     */
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
