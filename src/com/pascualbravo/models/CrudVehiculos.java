package com.pascualbravo.models;

import java.sql.Connection;
import java.sql.*;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class CrudVehiculos extends Conexion {
    
    PreparedStatement ps;
    Connection con;
    ResultSet rs;
    
    public boolean registrar(Vehiculos vehiculos) {

        ps = null; //Variable de preparacion 

        con = getConexion(); //variable de conexion 

        String SQL = "insert into Vehiculos (Placa,nombre,modelo,Marca,Color,Dueño) values (?,?,?,?,?,?);";

        try {
            ps = con.prepareStatement(SQL);

            ps.setString(1, vehiculos.getPlaca());
            ps.setString(2, vehiculos.getNombre());
            ps.setString(3, vehiculos.getModelo());
            ps.setString(4, vehiculos.getMarca());
            ps.setString(5, vehiculos.getColor());
            ps.setInt(6, vehiculos.getCedulaClnt());

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
