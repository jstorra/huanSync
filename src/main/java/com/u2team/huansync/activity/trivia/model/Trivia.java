package com.u2team.huansync.activity.trivia.model;

public class Trivia {
    private long triviaId;
    private long activityId;
    private long participantOneId;
    private long participantTwoId;
    private long winnerId;
    private int round;

    public long getTriviaId() {
        return triviaId;
    }

    public void setTriviaId(long triviaId) {
        this.triviaId = triviaId;
    }

    public long getActivityId() {
        return activityId;
    }

    public void setActivityId(long activityId) {
        this.activityId = activityId;
    }

    public long getParticipantOneId() {
        return participantOneId;
    }

    public void setParticipantOneId(long participantOneId) {
        this.participantOneId = participantOneId;
    }

    public long getParticipantTwoId() {
        return participantTwoId;
    }

    public void setParticipantTwoId(long participantTwoId) {
        this.participantTwoId = participantTwoId;
    }

    public long getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(long winnerId) {
        this.winnerId = winnerId;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }
}
