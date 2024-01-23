package com.u2team.huansync.activity.trivia.question.model;

public interface QuestionBuilder {
    QuestionBuilder questionId(long questionId);
    QuestionBuilder question(String question);
    QuestionBuilder answer(String answer);
    QuestionBuilder categoryQuestion(CategoryQuestion categoryQuestion);
    QuestionBuilder difficultyQuestion(DifficultyQuestion difficultyQuestion);
    Question build();
}
