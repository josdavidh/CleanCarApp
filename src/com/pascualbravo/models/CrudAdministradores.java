package com.pascualbravo.models;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.*;
import javax.swing.JOptionPane;

public class CrudAdministradores extends Conexion {

    PreparedStatement ps;
    Connection con;
    ResultSet rs;

    public Administradores BuscarPerfil(int cc, String password) {
        Administradores admin =new Administradores();
        ps = null;
        con = (Connection) getConexion();

        String sql = "select * from administradores where Cedula_Admin = ? and password = ?";

        try {

            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, cc);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                admin.setCedulaAdmin(rs.getInt("Cedula_Admin"));
                admin.setNombres(rs.getString("Nombres"));
                admin.setApellidos(rs.getString("Apellidos"));
                admin.setPassword(rs.getString("password"));
            }
           
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                con.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        
        return admin;
    }
    
    public boolean actualizarAdmin(int cc, Administradores admin){
        ps = null;
        con = (Connection) getConexion();
        
        String sql = "update administradores set Cedula_Admin = ?, Nombres = ?, Apellidos = ?, password = ? where Cedula_Admin=?";
        
        try{
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, admin.getCedulaAdmin());
            ps.setString(2, admin.getNombres());
            ps.setString(3, admin.getApellidos());
            ps.setString(4, admin.getPassword());
            ps.setInt(5, cc);
            
            ps.execute();

            return true;

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
