package com.u2team.huansync.activity.trivia.model;

import com.u2team.huansync.activity.model.Activity;

public class Trivia extends Activity {
    private Long triviaId;
    private Long activityId;
    private Long participantOneId;
    private Long participantTwoId;
    private Long winnerId;
    private Long inchargedId;

    public Long getTriviaId() {
        return triviaId;
    }

    public void setTriviaId(Long triviaId) {
        this.triviaId = triviaId;
    }

    @Override
    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Long getParticipantOneId() {
        return participantOneId;
    }

    public void setParticipantOneId(Long participantOneId) {
        this.participantOneId = participantOneId;
    }

    public Long getParticipantTwoId() {
        return participantTwoId;
    }

    public void setParticipantTwoId(Long participantTwoId) {
        this.participantTwoId = participantTwoId;
    }

    public Long getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(Long winnerId) {
        this.winnerId = winnerId;
    }

    public Long getInchargedId() {
        return inchargedId;
    }

    public void setInchargedId(Long inchargedId) {
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
