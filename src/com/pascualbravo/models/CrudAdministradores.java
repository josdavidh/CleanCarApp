package com.pascualbravo.models;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.*;
import javax.swing.JOptionPane;

public class CrudAdministradores extends Conexion {

    PreparedStatement ps;
    Connection con;
    ResultSet rs;

    public boolean BuscarPerfil(int cc, String password) {
        ps = null;
        con = (Connection) getConexion();

        String sql = "select Cedula_Admin, password from administradores where Cedula_Admin = ? and password = ?";

        try {

            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, cc);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        } finally {
            try {
                con.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
}
