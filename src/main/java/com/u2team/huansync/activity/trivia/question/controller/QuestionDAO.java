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
        try (Connection connection = BDConnection.MySQLConnection()) {
            String sql = "INSERT INTO tbl_questions (question, answer, category, difficulty) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1,question.getQuestion());
                statement.setString(2,question.getAnswer());
                statement.setString(3,question.getCategory().getName());
                statement.setString(4,question.getDifficulty().getName());
                statement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateQuestion(Question question){
        try (Connection connection = BDConnection.MySQLConnection()) {
            String sql = "UPDATE tbl_questions SET question = ?, answer = ?, category = ?, difficulty = ? WHERE questionId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, question.getQuestion());
                statement.setString(2, question.getAnswer());
                statement.setString(3, question.getCategory().getName());
                statement.setString(4, question.getDifficulty().getName());
                statement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteQuestion(long questionId){
        try (Connection connection = BDConnection.MySQLConnection()) {
            String sql = "DELETE FROM tbl_questions WHERE questionId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, questionId);
                statement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
