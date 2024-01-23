package com.u2team.huansync.activity.trivia.model;


public interface TriviaBuilder {
    TriviaBuilder triviaId(Long triviaId);
    TriviaBuilder activityId(Long activityId);
    TriviaBuilder participantOneId(Long participantOneId);
    TriviaBuilder participantTwoId(Long participantTwoId);
    TriviaBuilder winnerId(Long winnerId);
    TriviaBuilder inchargedId(Long inchargedId);
    Trivia build();
}
