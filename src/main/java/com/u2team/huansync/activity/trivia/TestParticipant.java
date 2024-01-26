package com.u2team.huansync.activity.trivia;

public class TestParticipant {
    private long participantId;
    private String name;

    public TestParticipant(long participantId, String name) {
        this.participantId = participantId;
        this.name = name;
    }

    public long getParticipantId() {
        return participantId;
    }

    public void setParticipantId(long id) {
        this.participantId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
