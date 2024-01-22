package com.u2team.huansync.activity.trivia.question.model;

public enum CategoryQuestion {
    NARUTO("Naruto"),
    SPYXFAMILY("SPYxFamily"),
    JUJUTSU_KAIZEN("Jujutsu Kaizen"),
    HARRY_POTTER("Harry Potter"),
    COMICS("Comics");

    private String name;

    private CategoryQuestion(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
