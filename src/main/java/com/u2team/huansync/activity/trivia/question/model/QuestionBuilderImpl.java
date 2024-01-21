package com.u2team.huansync.activity.trivia.question.model;

public class QuestionBuilderImpl implements QuestionBuilder {
    Question question = new Question();

    public QuestionBuilder questionId(long questionId) {
        question.setQuestionId(questionId);
        return this;
    }

    @Override
    public QuestionBuilder question(String question) {
        this.question.setQuestion(question);
        return this;
    }

    @Override
    public QuestionBuilder answer(String answer) {
        question.setAnswer(answer);
        return this;
    }

    @Override
    public QuestionBuilder category(CategoryQuestion categoryQuestion) {
        question.setCategory(categoryQuestion);
        return this;
    }

    @Override
    public QuestionBuilder difficulty(DifficultyQuestion difficultyQuestion) {
        question.setDifficulty(difficultyQuestion);
        return this;
    }

    @Override
    public Question build() {
        return question;
    }
}
