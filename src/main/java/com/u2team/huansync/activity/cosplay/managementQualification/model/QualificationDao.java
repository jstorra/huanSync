package com.u2team.huansync.activity.cosplay.managementQualification.model;
import java.util.*;

public interface QualificationDao {
   List<Qualification> listJuryQualifications(int idCosplay);
   List<Qualification> assignQualification(int idCosplay, List<Integer> qualificationList);
   void send(int cosplayId, List<Integer> qualifications);
   void createQualification(List<Qualification> qualificationList);
   double calculateAverage(List<Qualification> qualificationList) ;
   public void updateCosplayScore(int cosplayId, double average) ;
}
