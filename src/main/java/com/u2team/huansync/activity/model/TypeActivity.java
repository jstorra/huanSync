package com.u2team.huansync.activity.model;

/**
 * Enum representing different types of activities.
 */
public enum TypeActivity {
    COSPLAY("cosplay"), TRIVIA("trivia");

    private final String name;

    /**
     * Constructor for TypeActivity enum.
     *
     * @param name The name of the activity type.
     */
    private TypeActivity(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the activity type.
     *
     * @return The name of the activity type.
     */
    public String getName() {
        return name;
    }
}
