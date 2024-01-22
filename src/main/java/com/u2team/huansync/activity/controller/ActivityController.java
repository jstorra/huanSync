package com.u2team.huansync.activity.controller;

import com.u2team.huansync.activity.model.Activity;
import com.u2team.huansync.activity.model.ActivityDAO;
import java.util.List;

public class ActivityController {
    private ActivityDAO activityDAO = new ActivityDAO();

    public List<Activity> getAllActivities() {
        return activityDAO.getAllActivities();
    }

    public Activity getActivityById(long activityId) {
        return activityDAO.getActivityById(activityId);
    }

    public void insertActivity(Activity activity) {
        activityDAO.insertActivity(activity);
    }

    public void updateActivity(Activity activity) {
        activityDAO.updateActivity(activity);
    }

    public void deleteActivity(long activityId) {
        activityDAO.deleteActivity(activityId);
    }

    public boolean searchActivity(int idActivity, String typeAct){return activityDAO.searchActivity(idActivity,typeAct);}
}
