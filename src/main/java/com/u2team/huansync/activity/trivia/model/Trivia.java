package com.u2team.huansync.activity.trivia.model;

import com.u2team.huansync.activity.model.Activity;

public class Trivia extends Activity {
    private long triviaId;
    private long activityId;
    private long participantOneId;
    private long participantTwoId;
    private long winnerId;
    private long inchargedId;

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

    public long getInchargedId() {
        return inchargedId;
    }

    public void setInchargedId(long inchargedId) {
        this.inchargedId = inchargedId;
    }

    @Override
    public String toString() {
        return "Trivia{" +
                "triviaId=" + triviaId +
                ", activityId=" + activityId +
                ", participantOneId=" + participantOneId +
                ", participantTwoId=" + participantTwoId +
                ", winnerId=" + winnerId +
                ", inchargedId=" + inchargedId +
                '}';
    }
}
