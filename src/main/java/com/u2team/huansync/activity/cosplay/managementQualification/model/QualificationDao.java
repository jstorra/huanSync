package com.u2team.huansync.activity.cosplay.managementQualification.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.u2team.huansync.activity.cosplay.managementCosplay.model.CosplayBuilderImpl;
import com.u2team.huansync.persistence.BDConnection;

/**
 * DAO class for handling Qualification entities related to cosplays.
 */
public class QualificationDao {

    /**
     * SQL query to retrieve all jurors available for qualification.
     */
    private final static String QUERY_GETALL_jurys = 
    """
        select sff.staffId as juryId from tbl_staff sff JOIN tbl_workerRoles wr on sff.workerRoleId =wr.workerRoleId where lower(wr.nameWorkerRole) = "judge" and lower(sff.statusStaff) = "on hold" ORDER BY sff.staffId asc    
    """; 

    /**
     * Retrieves a list of jurors available for the qualification of a cosplay.
     *
     * @param idCosplay The ID of the cosplay.
     * @return A list of Qualification objects representing jurors for the cosplay.
     */
    public List<Qualification> listJugesCalification (int idCosplay) {
        List<Qualification> jurysList = new ArrayList<>();
        try (Connection con = BDConnection.MySQLConnection();
             PreparedStatement preparedStatement = con.prepareStatement(QUERY_GETALL_jurys)) {
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    Qualification q =new Qualification();
                    q.setCosplayId(idCosplay);
                    q.setJuryId(rs.getInt("juryId"));
                    jurysList.add(q);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jurysList;
        
    }

    /*metodo front - end */

    /**
     * Retrieves the number of available jurors for the qualification of a cosplay.
     *
     * @param idCosplay The ID of the cosplay.
     * @return The number of available jurors.
     */
    public int numCajasOrventanas (int idCosplay){
        int numVentanas = listJugesCalification(idCosplay).size();
        return numVentanas;
    }


    /**
     * Assigns qualifications to jurors for a cosplay.
     *
     * @param idCosplay           The ID of the cosplay.
     * @param listaCalificaciones A list of integers representing the qualifications to be assigned.
     * @return A list of Qualification objects representing the assigned qualifications.
     * @throws IllegalArgumentException If the number of qualifications does not match the number of available jurors.
     */
    public List<Qualification> asignCalificacion(int idCosplay, List<Integer> listaCalificaciones) {
        List<Qualification> califications_cosplay = listJugesCalification(idCosplay);
        List<Qualification> assignedQualifications = new ArrayList<>();

        // Verificar si hay suficientes calificaciones para asignar
        if (califications_cosplay.size() != listaCalificaciones.size()) {
            // Manejar el caso de que no haya suficientes calificaciones
            throw new IllegalArgumentException("La cantidad de calificaciones no coincide con la cantidad de jueces.");
        }

        for (int i = 0; i < califications_cosplay.size(); i++) {
            Qualification qua = califications_cosplay.get(i);
            int calificacion = listaCalificaciones.get(i);

            // Crear un nuevo objeto Qualification y asignar la calificación
            Qualification assignedQualification = new Qualification();
            assignedQualification.setQualification(calificacion);
            
            // Agregar el objeto asignado a la lista
            assignedQualifications.add(assignedQualification);
        }

        return assignedQualifications;
}


}
