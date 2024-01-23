package com.u2team.huansync.activity.trivia.question.model;

public enum DifficultyQuestion {
    EASY("easy"), MEDIUM("medium"), HARD("hard");

    private String name;

    private DifficultyQuestion(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
