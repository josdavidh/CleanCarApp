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

}
