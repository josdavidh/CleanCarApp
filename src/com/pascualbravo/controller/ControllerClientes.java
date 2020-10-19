package com.pascualbravo.controller;

import Vistas.Servicios;
import com.pascualbravo.models.Clientes;
import com.pascualbravo.models.CrudClientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControllerClientes implements ActionListener {

    private Clientes clientes;
    private CrudClientes crudClientes;
    private Servicios servicios;

    public ControllerClientes(Clientes clnts, CrudClientes crudClnts, Servicios frmServ) {

        this.clientes = clnts;
        this.crudClientes = crudClnts;
        this.servicios = frmServ;

        this.servicios.btnConfirmarServicio.addActionListener(this);

    }

    public void limpiar() {
        servicios.txtCedulaCliente.setText(null);
        servicios.txtNombreCliente.setText(null);
        servicios.txtTelefonoCliente.setText(null);
    }

    public void iniciar() {

        servicios.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == servicios.btnConfirmarServicio) {
            clientes.setCedulaCliente(Integer.parseInt(servicios.txtCedulaCliente.getText()));
            clientes.setNombre(servicios.txtNombreCliente.getText());
            clientes.setTelefono(servicios.txtTelefonoCliente.getText());

            if (crudClientes.registrar(clientes)) {
                JOptionPane.showMessageDialog(null, "Registro guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
                limpiar();
            }

        }
    }

}
