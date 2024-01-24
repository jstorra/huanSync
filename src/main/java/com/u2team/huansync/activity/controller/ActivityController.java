package com.u2team.huansync.activity.controller;

import com.u2team.huansync.activity.model.Activity;
import com.u2team.huansync.activity.model.ActivityDAO;
import java.util.List;

/**
 * The {@code ActivityController} class serves as a controller for managing activities.
 * It interacts with the underlying data access object (DAO) to perform CRUD operations on activities.
 */
public class ActivityController {

    private static ActivityDAO activityDAO = new ActivityDAO();

    /**
     * Retrieves a list of all activities.
     *
     * @return A {@code List} of {@code Activity} objects representing all activities.
     */
    public static List<Activity> getAllActivities() {
        return activityDAO.getAllActivities();
    }

    /**
     * Retrieves an activity based on the specified activity ID.
     *
     * @param activityId The unique identifier of the activity.
     * @return An {@code Activity} object representing the activity with the given ID, or {@code null} if not found.
     */
    public static Activity getActivityById(Long activityId) {
        return activityDAO.getActivityById(activityId);
    }

    /**
     * Inserts a new activity into the system.
     *
     * @param activity The {@code Activity} object to be inserted.
     */
    public static void insertActivity(Activity activity) {
        activityDAO.insertActivity(activity);
    }

    /**
     * Updates an existing activity in the system.
     *
     * @param activity The {@code Activity} object to be updated.
     */
    public static void updateActivity(Activity activity) {
        activityDAO.updateActivity(activity);
    }

    /**
     * Deletes an activity based on the specified activity ID.
     *
     * @param activityId The unique identifier of the activity to be deleted.
     */
    public static void deleteActivity(Long activityId) {
        activityDAO.deleteActivity(activityId);
    }
}
