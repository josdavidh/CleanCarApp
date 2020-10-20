package com.pascualbravo.controller;

import Vistas.FrmServicios;
import com.pascualbravo.models.Clientes;
import com.pascualbravo.models.CrudClientes;
import com.pascualbravo.models.CrudVehiculos;
import com.pascualbravo.models.Vehiculos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControllerServicios implements ActionListener {

    private Clientes clientes;
    private Vehiculos vehiculos;
    private CrudClientes crudClientes;
    private CrudVehiculos crudVehiculos;
    private FrmServicios servicios;

    public ControllerServicios(Clientes clnts, Vehiculos vehicl, CrudClientes crudClnts,
            CrudVehiculos crudVehicl, FrmServicios frmServ) {

        this.clientes = clnts;
        this.vehiculos = vehicl;
        this.crudClientes = crudClnts;
        this.crudVehiculos = crudVehicl;
        this.servicios = frmServ;

        this.servicios.btnConfirmarServicio.addActionListener(this);

    }

    public void limpiar() {
        servicios.txtCedulaCliente.setText(null);
        servicios.txtNombreCliente.setText(null);
        servicios.txtTelefonoCliente.setText(null);
        servicios.txtPlacaVehiculo.setText(null);
        servicios.txtMarcaVehiculo.setText(null);
        servicios.txtNombreVehiculo.setText(null);
        servicios.txtModeloVehiculo.setText(null);
        servicios.txtColorVehiculo.setText(null);
        
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
                JOptionPane.showMessageDialog(null, "Cliente creado");

                vehiculos.setCedulaClnt(Integer.parseInt(servicios.txtCedulaCliente.getText()));
                vehiculos.setPlaca(servicios.txtPlacaVehiculo.getText());
                vehiculos.setMarca(servicios.txtMarcaVehiculo.getText());
                vehiculos.setNombre(servicios.txtNombreVehiculo.getText());
                vehiculos.setModelo(servicios.txtModeloVehiculo.getText());
                vehiculos.setColor(servicios.txtColorVehiculo.getText());

                if (crudVehiculos.registrar(vehiculos)) {
                    JOptionPane.showMessageDialog(null, "vehiculo Creado");
                    
                    limpiar();

                } else {
                    JOptionPane.showMessageDialog(null, "Error al crear vehiculo");
                    
                    limpiar();

                }
                
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar cliente");
                limpiar();
            }

        }
    }

}
