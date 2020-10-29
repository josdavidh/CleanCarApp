package com.pascualbravo.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Vistas.NuevoEmpleado;
import Vistas.listaEmpleados;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;
import com.pascualbravo.models.Clientes;
import com.pascualbravo.models.Conexion;
import com.pascualbravo.models.CrudClientes;
import com.pascualbravo.models.CrudEmpleados;
import com.pascualbravo.models.Empleados;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.ButtonGroup;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;


/**
 *
 * @author Johan Arboleda
 */
public class ListaEmp_Clnt implements ChangeListener, MouseListener, ActionListener, KeyListener {

    private listaEmpleados lista = new listaEmpleados();
    private ButtonGroup bg;
    private CrudClientes crudClnt = new CrudClientes();
    private CrudEmpleados crudEmp = new CrudEmpleados();
    private NuevoEmpleado frmNEm = new NuevoEmpleado();
    private Clientes cliente;
    private Empleados empleado;
    

    public ListaEmp_Clnt(listaEmpleados lista) {
        bg = new ButtonGroup();
        this.lista = lista;
        lista.jrbClientes.addChangeListener(this);
        bg.add(lista.jrbClientes);
        lista.jrbEmpleados.addChangeListener(this);
        bg.add(lista.jrbEmpleados);
        this.lista.jtListaEmp.addMouseListener(this);
        this.lista.btnActualizar.addActionListener(this);
        this.lista.btnBorrar.addActionListener(this);
        this.lista.btnNuevoEmp.addActionListener(this);
        this.frmNEm.btnNuevoEmp.addActionListener(this);
        this.frmNEm.btnCancelar.addActionListener(this);
        this.lista.TxtCedula.addKeyListener(this);
        this.lista.txtNombre.addKeyListener(this);
        this.lista.txtSalario.addKeyListener(this);
        this.lista.txtJefe.addKeyListener(this);
        this.lista.txtBuscarCedula.addKeyListener(this);
        
    }

    @Override
    public void stateChanged(ChangeEvent arg0) {
        if (lista.jrbClientes.isSelected()) {
            cargarDatosClientes();
            txtClientes();
            limpiar();
        }
        if (lista.jrbEmpleados.isSelected()) {
            cargarDatosEmpleados();
            txtEmpleado();
            limpiar();
        }

    }

    // este metodo habilita las cajas de texto para editar 
    public void txtClientes() {
        lista.txtJefe.setVisible(false);
        lista.jlblJefe.setVisible(false);
        lista.JlblSalario.setText("Telefono");
        lista.jSeparator2.setVisible(false);
    }

    public void txtEmpleado() {
        lista.txtJefe.setVisible(true);
        lista.jlblJefe.setVisible(true);
        lista.jSeparator2.setVisible(true);
        lista.JlblSalario.setText("Salario");
    }

    public void limpiar() {
        lista.TxtCedula.setText("");
        lista.txtNombre.setText("");
        lista.txtJefe.setText("");
        lista.txtSalario.setText("");

    }
    
    public void limpiar1(){
    frmNEm.txtCC.setText("");
    frmNEm.txtJef.setText("");
    frmNEm.txtNom.setText("");
    frmNEm.txtSalar.setText("");
    
    }

    // este metodo carga los datos en la tabla
    public void cargarDatosEmpleados() {
        crudEmp.cargarDatosEmpleados();
        ResultSet re = crudEmp.getRs();
        try {
            
            DefaultTableModel modelo = new DefaultTableModel();
            lista.jtListaEmp.setModel(modelo);
            ResultSetMetaData reMD = (ResultSetMetaData) re.getMetaData();
            int cantidadColumnas = reMD.getColumnCount();

            modelo.addColumn("Cedula");
            modelo.addColumn("Nombre");
            modelo.addColumn("Salario");
            modelo.addColumn("Jefe");

            while (re.next()) {

                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i += 1) {
                    filas[i] = re.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }

    }

    public void cargarDatosClientes() {
        crudClnt.cargarDatosCliente();
        ResultSet re = crudClnt.getRs();;

        try {
            DefaultTableModel modelo = new DefaultTableModel();
            lista.jtListaEmp.setModel(modelo);
            ResultSetMetaData reMD = (ResultSetMetaData) re.getMetaData();
            int cantidadColumnas = reMD.getColumnCount();

            modelo.addColumn("Cedula_Clnt");
            modelo.addColumn("Nombre");
            modelo.addColumn("Telefono");

            while (re.next()) {

                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i += 1) {
                    filas[i] = re.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }

    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        int columna = lista.jtListaEmp.getSelectedRow();
        int nCol = lista.jtListaEmp.getColumnCount();
        if (nCol == 4) {
            lista.txtNombre.setText(lista.jtListaEmp.getModel().getValueAt(columna, 1).toString());
            lista.TxtCedula.setText(lista.jtListaEmp.getModel().getValueAt(columna, 0).toString());
            lista.txtSalario.setText(lista.jtListaEmp.getModel().getValueAt(columna, 2).toString());
            lista.txtJefe.setText(lista.jtListaEmp.getModel().getValueAt(columna, 3).toString());
        }
        if (nCol == 3) {
            lista.txtNombre.setText(lista.jtListaEmp.getModel().getValueAt(columna, 1).toString());
            lista.TxtCedula.setText(lista.jtListaEmp.getModel().getValueAt(columna, 0).toString());
            lista.txtSalario.setText(lista.jtListaEmp.getModel().getValueAt(columna, 2).toString());

        }

    }

    @Override
    public void mousePressed(MouseEvent arg0) {

    }

    @Override
    public void mouseReleased(MouseEvent arg0) {

    }

    @Override
    public void mouseEntered(MouseEvent arg0) {

    }

    @Override
    public void mouseExited(MouseEvent arg0) {

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        
        if (arg0.getSource() == lista.btnNuevoEmp) {
            frmNEm.setVisible(true);
        }
        
         if (arg0.getSource() == frmNEm.btnCancelar) {
            frmNEm.setVisible(false);
            limpiar1();
        }
       if (arg0.getSource() == frmNEm.btnNuevoEmp){
       
           empleado = new Empleados();
            
            empleado.setCedulaEmp(Integer.parseInt(frmNEm.txtCC.getText()));
            empleado.setNombre(frmNEm.txtNom.getText());
            empleado.setSalario(Double.parseDouble(frmNEm.txtSalar.getText()));
            empleado.setCedulaJefe(Integer.parseInt(frmNEm.txtJef.getText()));
            if(crudEmp.registrar(empleado)){
            JOptionPane.showMessageDialog(null, "Empleado Registrado");
            limpiar1();
            frmNEm.setVisible(false);
            }else{
            JOptionPane.showMessageDialog(null, "Error al crear empleado ");
              limpiar1();
            }
            
       }

        int cedula = 0;

        if (arg0.getSource() == lista.btnActualizar && lista.jrbClientes.isSelected()) {
            cedula = Integer.parseInt(lista.TxtCedula.getText());
            cliente = new Clientes();
            cliente.setCedulaCliente(Integer.parseInt(lista.TxtCedula.getText()));
            cliente.setNombre(lista.txtNombre.getText());
            cliente.setTelefono(lista.txtSalario.getText());
            if (crudClnt.Actualizar(cliente, cedula)) {
                JOptionPane.showMessageDialog(null, "Cliente Actualizado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Actualizar Cliente ");
                limpiar();
            }

        }

        if (arg0.getSource() == lista.btnActualizar && lista.jrbEmpleados.isSelected()) {
            cedula = Integer.parseInt(lista.TxtCedula.getText());
            empleado = new Empleados();

            empleado.setNombre(lista.txtNombre.getText());
            empleado.setSalario(Double.parseDouble(lista.txtSalario.getText()));
            empleado.setCedulaJefe(Integer.parseInt(lista.txtJefe.getText()));
            if (crudEmp.Actualizar(empleado, cedula)) {
                JOptionPane.showMessageDialog(null, "Empleado Actualizado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Actualizar Empleado");
                limpiar();
            }
        }

        // botone borrar 
        if (arg0.getSource() == lista.btnBorrar && lista.jrbClientes.isSelected()) {
            cedula = Integer.parseInt(lista.TxtCedula.getText());
            crudClnt.Eliminar(cedula);
            JOptionPane.showMessageDialog(null, "Cliente borrado");
        }
        if (arg0.getSource() == lista.btnBorrar && lista.jrbEmpleados.isSelected()) {
            cedula = Integer.parseInt(lista.TxtCedula.getText());
            crudEmp.eliminar(cedula);
            JOptionPane.showMessageDialog(null, "Empleado borrado");
        }

        
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        char validar = arg0.getKeyChar();
        if (arg0.getSource() == lista.txtSalario) {
          
            if (Character.isLetter(validar)) {

                arg0.consume();

                JOptionPane.showMessageDialog(null, "Escriba solo numeros");
            }
        }
        if (arg0.getSource() == lista.txtJefe) {
           
            if (Character.isLetter(validar)) {

                arg0.consume();

                JOptionPane.showMessageDialog(null, "Escriba solo numeros");
            }
        }

        if (arg0.getSource() == lista.txtNombre) {

            if (Character.isDigit(validar)) {

                arg0.consume();

                JOptionPane.showMessageDialog(null, "Escriba solo letras");
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        if (arg0.getSource() == lista.txtBuscarCedula){
            if (lista.jrbEmpleados.isSelected()){
            BuscarEmpleado(Integer.parseInt(lista.txtBuscarCedula.getText()));
            }
         if (lista.jrbClientes.isSelected()){
          BuscarCliente(Integer.parseInt(lista.txtBuscarCedula.getText()));
         }
        
        }
    }
    
    
    public void BuscarEmpleado(int Buscar) {
        PreparedStatement ps = null;
        ResultSet re = null;
        Conexion con = new Conexion();
        Connection conn = con.getConexion();
        
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            lista.jtListaEmp.setModel(modelo);

            String sql = "select * from empleados where Cedula_Emp LIKE'%"+Buscar+"%';";
            ps = (PreparedStatement) conn.prepareStatement(sql);
            re = ps.executeQuery();
            ResultSetMetaData reMD = (ResultSetMetaData) re.getMetaData();
            int cantidadColumnas = reMD.getColumnCount();

            modelo.addColumn("Cedula");
            modelo.addColumn("Nombre");
            modelo.addColumn("Salario");
            modelo.addColumn("Jefe");

            while (re.next()) {

                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i += 1) {
                    filas[i] = re.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }

    }
    
    public void BuscarCliente(int Buscar) {
        PreparedStatement ps = null;
        ResultSet re = null;
        Conexion con = new Conexion();
        Connection conn = con.getConexion();
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            lista.jtListaEmp.setModel(modelo);
            String sql = "select * from clientes where Cedula_Clnt LIKE '%"+Buscar+"%';";
            ps = (PreparedStatement) conn.prepareStatement(sql);
            re = ps.executeQuery();
            ResultSetMetaData reMD = (ResultSetMetaData) re.getMetaData();
            int cantidadColumnas = reMD.getColumnCount();

            modelo.addColumn("Cedula_Clnt");
            modelo.addColumn("Nombre");
            modelo.addColumn("Telefono");

            while (re.next()) {

                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i += 1) {
                    filas[i] = re.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }

    }

}
