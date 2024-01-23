package com.u2team.huansync.activity.trivia.controller;

import com.u2team.huansync.activity.trivia.model.Trivia;
import com.u2team.huansync.activity.trivia.model.TriviaDAO;

import java.util.List;

public class TriviaController {
    private static TriviaDAO triviaDAO = new TriviaDAO();

    public static List<Trivia> getAllTrivia() {
        return triviaDAO.getAllTrivia();
    }

    public static Trivia getTriviaById(Long triviaId) {
        return triviaDAO.getTriviaById(triviaId);
    }

    public static void insertTrivia(Trivia trivia) {
        triviaDAO.insertTrivia(trivia);
    }

    public static void updateTrivia(Trivia trivia) {
        triviaDAO.updateTrivia(trivia);
    }

    public static void deleteTrivia(Long triviaId) {
        triviaDAO.deleteTrivia(triviaId);
    }
}
