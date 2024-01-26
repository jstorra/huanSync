package com.u2team.huansync.activity.cosplay.managementQualification.model;

import java.sql.*;
import java.util.*;
import com.u2team.huansync.persistence.BDConnection;

public class QualificationDaoImp implements QualificationDao{

    @Override
    public List<Qualification> listJuryQualifications(int idCosplay) {
        List<Qualification> jurysList = new ArrayList<>();
        String query = """
            SELECT sff.staffId AS juryId FROM tbl_staff sff 
            JOIN tbl_workerRoles wr ON sff.roleWorkId = wr.workerRoleId 
            WHERE LOWER(wr.nameWorkerRole) = 'jury' AND LOWER(sff.statusStaff) = 'NO_TASK_ASSIGNED' 
            ORDER BY sff.staffId ASC LIMIT 3;
            """;;

        try (Connection con = BDConnection.MySQLConnection();
             PreparedStatement preparedStatement = con.prepareStatement(query);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                Qualification qualification = new Qualification();
                qualification.setCosplayId(idCosplay);
                qualification.setJuryId(rs.getInt("juryId"));
                jurysList.add(qualification);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return jurysList;
    }

    @Override
    public List<Qualification> assignQualification(int idCosplay, List<Integer> qualificationList) {
        List<Qualification> cosplayQualifications = listJuryQualifications(idCosplay);
        List<Qualification> assignedQualifications = new ArrayList<>();

        if (cosplayQualifications.size() != qualificationList.size()) {
            throw new IllegalArgumentException("The number of qualifications does not match the number of judges");
        }

        for (int i = 0; i < cosplayQualifications.size(); i++) {
            Qualification qualification = cosplayQualifications.get(i);
            int calification = qualificationList.get(i);

            Qualification assignedQualification = new Qualification();
            assignedQualification.setCosplayId(idCosplay);
            assignedQualification.setJuryId(qualification.getJuryId());
            assignedQualification.setQualification(calification);

            assignedQualifications.add(assignedQualification);
        }

        return assignedQualifications;
    }

    @Override
    public void send(int cosplayId, List<Integer> qualifications) {
        List<Qualification> qualificationList = assignQualification(cosplayId, qualifications);
        createQualification(qualificationList);
        double average = calculateAverage(qualificationList);
        updateCosplayScore(cosplayId, average);
    }

    @Override
    public void createQualification(List<Qualification> qualificationList) {
        String query = "INSERT INTO tbl_juryQualification (cosplayId, juryId, qualification) VALUES (?, ?, ?)";

        try (Connection con = BDConnection.MySQLConnection();
             PreparedStatement preparedStatement = con.prepareStatement(query)) {

            for (Qualification qualification : qualificationList) {
                preparedStatement.setInt(1, qualification.getCosplayId());
                preparedStatement.setInt(2, qualification.getJuryId());
                preparedStatement.setInt(3, qualification.getQualification());
                preparedStatement.executeUpdate();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public double calculateAverage(List<Qualification> qualificationList) {
        int sum = qualificationList.stream().mapToInt(Qualification::getQualification).sum();
        return (double) sum / qualificationList.size();
    }

    @Override
    public void updateCosplayScore(int cosplayId, double average) {
        String query = "UPDATE  tbl_cosplay SET score = ? WHERE cosplayId = ?";

        try (Connection con = BDConnection.MySQLConnection();
             PreparedStatement preparedStatement = con.prepareStatement(query)) {

            preparedStatement.setDouble(1, average);
            preparedStatement.setInt(2, cosplayId);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
