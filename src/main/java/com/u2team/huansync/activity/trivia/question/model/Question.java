package com.u2team.huansync.activity.trivia.question.model;

public class Question {
    private long questionId;
    private String question;
    private String answer;
    private CategoryQuestion categoryQuestion;
    private DifficultyQuestion difficultyQuestion;

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public CategoryQuestion getCategory() {
        return categoryQuestion;
    }

    public void setCategory(CategoryQuestion categoryQuestion) {
        this.categoryQuestion = categoryQuestion;
    }

    public DifficultyQuestion getDifficulty() {
        return difficultyQuestion;
    }

    public void setDifficulty(DifficultyQuestion difficultyQuestion) {
        this.difficultyQuestion = difficultyQuestion;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", category=" + categoryQuestion +
                ", difficulty=" + difficultyQuestion +
                '}';
    }
}
