package com.pascualbravo.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import javax.swing.JOptionPane;

public class CrudClientes extends Conexion {
    
    PreparedStatement ps;
    Connection con;
    ResultSet rs;

    public boolean registrar(Clientes clientes) {
        ps = null; //Variable de preparacion 

        con = getConexion(); //variable de conexion 

        String SQL = "insert into Clientes (Cedula_Clnt,Nombre,Telefono) values (?,?,?);";

        try {

            ps = con.prepareStatement(SQL);

            ps.setInt(1, clientes.getCedulaCliente());
            ps.setString(2, clientes.getNombre());
            ps.setString(3, clientes.getTelefono());

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
