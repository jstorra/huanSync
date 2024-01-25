package com.u2team.huansync.activity.trivia.informs;

public class Informs {
    private static InformsDAO informsDAO = new InformsDAO();

    public static void getParticipantDetails(){informsDAO.getParticipantDetails();};
    public static void getWinnersAndStaff(){informsDAO.getWinnersAndStaff();};
    public static void getTriviasPerParticipant(){informsDAO.getTriviasPerParticipant();};
    public static void getTriviasWithoutWinner(){informsDAO.getTriviasWithoutWinner();};
    public static void getParticipantDetailsByActivityId(){informsDAO.getParticipantDetailsByActivityId();}
}
