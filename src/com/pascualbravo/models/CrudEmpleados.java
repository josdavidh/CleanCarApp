package com.pascualbravo.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class CrudEmpleados extends Conexion {

    PreparedStatement ps = null;
    Connection con = null;
    ResultSet rs = null;
   
    public Empleados buscarEmpleado(String nombre) {
        Empleados empleado = new Empleados();

        con = getConexion();

        String sql = "select * from Empleados where Nombre = ?";
        try {

            ps = con.prepareStatement(sql);

            ps.setString(1, nombre);

            rs = ps.executeQuery();

            if (rs.next()) {

                empleado.setCedulaEmp(rs.getInt("Cedula_Emp"));
                empleado.setNombre(rs.getString("Nombre"));
                empleado.setSalario(rs.getDouble("Slario"));
                empleado.setCedulaJefe(rs.getInt("Jefe"));
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

        return empleado;

    }
    
    public boolean Actualizar(Empleados empleado, int cedula) {
        ps = null; //Variable de preparacion 

        con = getConexion(); //variable de conexion 

        String SQL = "UPDATE empleados set Nombre=?,Slario=?, Jefe=? where Cedula_Emp=? ;";

        try {

            ps = con.prepareStatement(SQL);

            ps.setString(1, empleado.getNombre());
            ps.setDouble(2, empleado.getSalario());
            ps.setInt(3, empleado.getCedulaJefe());
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
    
    public boolean eliminar(int cedula) {
        ps = null; //Variable de preparacion 

        con = getConexion(); //variable de conexion 

        String SQL = "delete from empleados where Cedula_Emp=? ;";

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
     
    public boolean registrar(Empleados empleado) {
        ps = null; //Variable de preparacion 

        con = getConexion(); //variable de conexion 

        String SQL = "insert into empleados(Cedula_Emp,Nombre,Slario,Jefe) values (?,?,?,?);";

        try {

            ps = con.prepareStatement(SQL);

            ps.setInt(1, empleado.getCedulaEmp());
            ps.setString(2, empleado.getNombre());
            ps.setDouble(3, empleado.getSalario());
            ps.setInt(4, empleado.getCedulaJefe());

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
    
    public void cargarDatosEmpleados() {
        ps = null; //Variable de preparacion 

        con = getConexion(); //variable de conexion
        try {

            String sql = "select * from empleados";
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
