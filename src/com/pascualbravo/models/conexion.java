package com.pascualbravo.models;

import java.sql.Connection;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Conexion {

    private final String base = "cleancardb";
    private final String username = "root";

    private final String password = "rrj69c";
    private final String URL = "jdbc:mysql://localhost:3306/" + base;

    private Connection con = null;
    private PreparedStatement ps;
    private ResultSet rs;

    public Connection getConexion() {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            con = (Connection) DriverManager.getConnection(URL, username, password);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return con;

    }

    public JComboBox llenarCbx(JComboBox cbx, String campo, String tabla) {
        
        con = getConexion();
        try {
            String sql = "select " + campo + " from " + tabla;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                cbx.addItem(rs.getString(campo));
            }
            
            rs.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return cbx;
    }

}
