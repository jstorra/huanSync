package com.u2team.huansync.activity.trivia.model;


public class TriviaBuilderImpl implements TriviaBuilder {
    private Trivia trivia = new Trivia();

    @Override
    public TriviaBuilder triviaId(Long triviaId) {
        trivia.setTriviaId(triviaId);
        return this;
    }

    @Override
    public TriviaBuilder activityId(Long activityId) {
        trivia.setActivityId(activityId);
        return this;
    }
    @Override
    public TriviaBuilder participantOneId(Long participantOneId) {
        trivia.setParticipantOneId(participantOneId);
        return this;
    }
    
    @Override
    public TriviaBuilder participantTwoId(Long participantTwoId) {
        trivia.setParticipantTwoId(participantTwoId);
        return this;
    }
    
    @Override
    public TriviaBuilder winnerId(Long winnerId) {
        trivia.setWinnerId(winnerId);
        return this;
    }

    @Override
    public TriviaBuilder inchargedId(Long inchargedId) {
        trivia.setInchargedId(inchargedId);
        return this;
    }

    @Override
    public Trivia build() {
        return trivia;
    }
}