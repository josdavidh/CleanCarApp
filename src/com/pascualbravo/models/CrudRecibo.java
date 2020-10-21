package com.pascualbravo.models;

import com.mysql.jdbc.Connection;
import java.sql.*;
import com.mysql.jdbc.PreparedStatement;
import javax.swing.JOptionPane;

public class CrudRecibo extends Conexion {

    PreparedStatement ps;
    Connection con;
    ResultSet rs;

    public boolean registrar(Recibo recibo) {

        ps = null;

        con = (Connection) getConexion();

        String sql = "insert into Recibo (Total,Cedula_Emp,Id_Servicio) values (?,?,?);";

        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            
            ps.setDouble(1, recibo.getTotal());
            ps.setInt(2, recibo.getCedulaEmp());
            ps.setInt(3, recibo.getIdServicio());
            
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
