package com.u2team.huansync.activity.trivia.question.controller;

import com.u2team.huansync.activity.trivia.question.model.CategoryQuestion;
import com.u2team.huansync.activity.trivia.question.model.DifficultyQuestion;
import com.u2team.huansync.activity.trivia.question.model.Question;
import com.u2team.huansync.persistence.BDConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionDAO {
    public static List<Question> getAllQuestions() {
        List<Question> questions = new ArrayList<>();
        try (Connection connection = BDConnection.MySQLConnection()) {
            String sql = "SELECT * FROM tbl_questions";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Question question = new Question();
                    question.setQuestionId(resultSet.getLong("questionId"));
                    question.setQuestion(resultSet.getString("question"));
                    question.setAnswer(resultSet.getString("answer"));
                    question.setCategoryQuestion(CategoryQuestion.valueOf(resultSet.getString("category").toUpperCase()));
                    question.setDifficultyQuestion(DifficultyQuestion.valueOf(resultSet.getString("difficulty").toUpperCase()));
                    questions.add(question);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return questions;
    }

    public static void insertQuestion(Question question){
    }

    public static void updateQuestion(Question question){
    }

    public static void deleteQuestion(long questionId){
    }
}
