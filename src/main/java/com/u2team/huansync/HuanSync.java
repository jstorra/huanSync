package com.u2team.huansync;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.u2team.huansync.persistence.BDConnection;
import com.u2team.huansync.persistence.Operations;

public class HuanSync {

    public static void main(String[] args) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String sentencia = "SELECT * FROM cargo;";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(sentencia)) {
            ResultSet rs = Operations.query_db(ps);
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                System.out.println(nombre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
