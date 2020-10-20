package com.pascualbravo.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class CrudClientes extends Conexion {

    public boolean registrar(Clientes clientes) {
        PreparedStatement ps = null; //Variable de preparacion 

        Connection con = getConexion(); //variable de conexion 

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
