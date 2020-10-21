package com.pascualbravo.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class CrudServicios extends Conexion {

    PreparedStatement ps = null;
    Connection con = null;
    ResultSet rs = null;

    public Servicios buscarServicio(String tipoServicio) {
        Servicios servicios = new Servicios();

        con = getConexion();

        String sql = "select * from Servicios where TIpo_Servicio = ?";
        try {

            ps = con.prepareStatement(sql);
            ps.setString(1, tipoServicio);
            rs = ps.executeQuery();

            if (rs.next()) {

                servicios.setIdServicio(rs.getInt("Id_Servicio"));
                servicios.setTipoServicio(rs.getString("TIpo_Servicio"));
                servicios.setValor(rs.getDouble("Valor"));
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);

        } finally {

            try {
                con.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);

            }
        }

        return servicios;
    }

}
