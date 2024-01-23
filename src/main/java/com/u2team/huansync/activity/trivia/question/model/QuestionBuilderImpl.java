package com.u2team.huansync.activity.trivia.question.model;

public class QuestionBuilderImpl implements QuestionBuilder {
    Question question = new Question();

    @Override
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
    public QuestionBuilder categoryQuestion(CategoryQuestion categoryQuestion) {
        question.setCategoryQuestion(categoryQuestion);
        return this;
    }

    @Override
    public QuestionBuilder difficultyQuestion(DifficultyQuestion difficultyQuestion) {
        question.setDifficultyQuestion(difficultyQuestion);
        return this;
    }

    @Override
    public Question build() {
        return question;
    }
}
