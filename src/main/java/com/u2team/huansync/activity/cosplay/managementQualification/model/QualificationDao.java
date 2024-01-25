package com.u2team.huansync.activity.cosplay.managementQualification.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.u2team.huansync.activity.cosplay.managementCosplay.model.Cosplay;
import com.u2team.huansync.persistence.BDConnection;

/**
 * DAO class for handling Qualification entities related to cosplays.
 */
public class QualificationDao {

    /**
     * Retrieves a list of jurors available for the qualification of a cosplay.
     *
     * @param idCosplay The ID of the cosplay.
     * @return A list of Qualification objects representing jurors for the cosplay.
     */

    public List<Qualification> listJugesCalification(int idCosplay) {
        List<Qualification> jurysList = new ArrayList<>();
        String query = """
                select sff.staffId as juryId from tbl_staff sff JOIN tbl_workerRoles wr on
                 sff.workerRoleId =wr.workerRoleId where lower(wr.nameWorkerRole) = "judge" and lower(sff.statusStaff) = "on hold" ORDER BY sff.staffId asc limit 5
                """;
        // limitar la cantidad de jurados
        try (Connection con = BDConnection.MySQLConnection();
                PreparedStatement preparedStatement = con.prepareStatement(query)) {
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    Qualification qualification = new Qualification();
                    qualification.setCosplayId(idCosplay);
                    qualification.setJuryId(rs.getInt("juryId"));
                    // add list
                    jurysList.add(qualification);

                }
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
        return jurysList;
    }

    /**
     * Assigns qualifications to jurors for a cosplay.
     *
     * @param idCosplay           The ID of the cosplay.
     * @param listaCalificaciones A list of integers representing the qualifications
     *                            to be assigned.
     * @return A list of Qualification objects representing the assigned
     *         qualifications.
     * @throws IllegalArgumentException If the number of qualifications does not
     *                                  match the number of available jurors.
     */

    public List<Qualification> asignCalificacion(int idCosplay, List<Integer> listaCalificaciones) {
        List<Qualification> califications_cosplay = listJugesCalification(idCosplay);
        List<Qualification> assignedQualifications = new ArrayList<>();

        // Check if there are enough grades to assign
        if (califications_cosplay.size() != listaCalificaciones.size()) {
            // Handle the case that there are not enough grades
            throw new IllegalArgumentException("La cantidad de calificaciones no coincide con la cantidad de jueces");
        }

        for (int i = 0; i < califications_cosplay.size(); i++) {
            Qualification qualification = califications_cosplay.get(i);
            int calificacion = listaCalificaciones.get(i);

            // Create a new Qualification object and assign the properties
            Qualification assignedQualification = new Qualification();
            assignedQualification.setCosplayId(idCosplay);
            assignedQualification.setJuryId(qualification.getJuryId()); // Set the juryId from the fetched qualification
            assignedQualification.setQualification(calificacion);

            // Add the assigned object to the list
            assignedQualifications.add(assignedQualification);
        }

        return assignedQualifications;
    }

    public void send(int cosplayId) {

        List<Integer> calificaciones = new ArrayList<>(Arrays.asList(1, 10, 8));
        List<Qualification> calification = asignCalificacion(cosplayId, calificaciones);

        // enviar a jury califications

        for (int i = 0; i < calification.size(); i++) {
            String query = "INSERT INTO tbl_juryQualification (cosplayId, juryId, qualification) VALUES ('"
                    + calification.get(i).getCosplayId() + "','"
                    + calification.get(i).getJuryId() + "','"
                    + calification.get(i).getQualification() + "' )";

            try (Connection con = BDConnection.MySQLConnection()) {
                try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                    preparedStatement.executeUpdate();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        // promediar

        int suma = 0;
        for (Qualification i : calification) {
            suma += i.getQualification();

        }

        double prom = suma / calification.size();

        // enviar

        // insercion hacia cosplay score

        String query = "UPDATE  tbl_cosplay SET score = ? where  cosplayId = ? ";
        try (Connection con = BDConnection.MySQLConnection()) {
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setDouble(1, prom);
                preparedStatement.setInt(2, cosplayId);
                preparedStatement.executeUpdate();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

   


}
