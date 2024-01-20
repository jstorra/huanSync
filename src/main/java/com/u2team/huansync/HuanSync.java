package com.u2team.huansync;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.u2team.huansync.persistencia.ConexionBD;
import com.u2team.huansync.persistencia.Operaciones;

public class HuanSync {

    public static void main(String[] args) {
        Operaciones.setConnection(ConexionBD.MySQLConnection());
        String sentencia = "SELECT * FROM cargo;";
        try (PreparedStatement ps = Operaciones.getConnection().prepareStatement(sentencia)) {
            ResultSet rs = Operaciones.consultar_BD(ps);
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                System.out.println(nombre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
