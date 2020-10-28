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
     
    public boolean Actualizar(Clientes clientes, int cedula) {
        ps = null; //Variable de preparacion 

        con = getConexion(); //variable de conexion 

        String SQL = "UPDATE clientes set Cedula_Clnt=?,Nombre=?,Telefono=? where Cedula_Clnt=? ;";

        try {

            ps = con.prepareStatement(SQL);

            ps.setInt(1, clientes.getCedulaCliente());
            ps.setString(2, clientes.getNombre());
            ps.setString(3, clientes.getTelefono());
            ps.setInt(4, cedula);

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
    
    public boolean Eliminar(int cedula) {
        ps = null; //Variable de preparacion 

        con = getConexion(); //variable de conexion 

        String SQL = "delete from clientes where Cedula_Clnt=? ;";

        try {

            ps = con.prepareStatement(SQL);

            ps.setInt(1, cedula);

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
    
    public void cargarDatosCliente() {
        ps = null; //Variable de preparacion 

        con = getConexion(); //variable de conexion
        try {

            String sql = "select * from clientes";
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();

        } catch (Exception e) {
            System.err.println(e.toString());
        }

    }
    
    public ResultSet getRs() {
        return rs;
    }
}
