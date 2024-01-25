package com.u2team.huansync.establishment.controller;

import com.u2team.huansync.establishment.model.DAO.EstablishmentDAO;
import com.u2team.huansync.establishment.model.classes.Establishment;
import java.util.List;

public class EstablishmentController {

    private final static EstablishmentDAO establishmentDAO = new EstablishmentDAO();

    public static void insertEstablishment(Establishment establishment) {
        establishmentDAO.save(establishment);
    }

    public static Establishment getByIdEstablishment(long id) {
        return establishmentDAO.getById(id);
    }

    public static List<Establishment> getAllEstablishment() {
        return establishmentDAO.getAll();
    }

    public static void deleteEstablishment(long establishmentId) {
        establishmentDAO.delete(establishmentId);
    }

}
