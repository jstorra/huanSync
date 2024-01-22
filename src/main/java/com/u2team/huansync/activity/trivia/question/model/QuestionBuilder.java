package com.u2team.huansync.activity.trivia.question.model;

public interface QuestionBuilder {
    QuestionBuilder question(String question);
    QuestionBuilder answer(String answer);
    QuestionBuilder category(CategoryQuestion categoryQuestion);
    QuestionBuilder difficulty(DifficultyQuestion difficultyQuestion);
    Question build();
}
