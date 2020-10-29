package com.pascualbravo.controller;


import Vistas.FrmServicios;
import com.pascualbravo.models.Clientes;
import com.pascualbravo.models.CrudClientes;
import com.pascualbravo.models.CrudEmpleados;
import com.pascualbravo.models.CrudRecibo;
import com.pascualbravo.models.CrudServicios;
import com.pascualbravo.models.CrudVehiculos;
import com.pascualbravo.models.Empleados;
import com.pascualbravo.models.Recibo;
import com.pascualbravo.models.Servicios;
import com.pascualbravo.models.Vehiculos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControllerServicios implements ActionListener {

    private Clientes clientes;
    private Vehiculos vehiculos;
    private Empleados empleados;
    private Recibo recibo;
    private Servicios servicios;
    private CrudEmpleados crudEmpleados;
    private CrudClientes crudClientes;
    private CrudVehiculos crudVehiculos;
    private CrudRecibo crudRecibo;
    private CrudServicios crudServicios;
    private FrmServicios frmServicios;
    private ControllerAdministrador controllerAdmin;

    public ControllerServicios(Clientes clnts, Vehiculos vehicl, Empleados emp, Recibo recb,Servicios serv, CrudClientes crudClnts, 
            CrudEmpleados crudEmp, CrudVehiculos crudVehicl,CrudRecibo crudRecb,CrudServicios crudServ,FrmServicios frmServ) {

        this.clientes = clnts;
        this.vehiculos = vehicl;
        this.empleados = emp;
        this.recibo = recb;
        this.servicios = serv;
        this.crudClientes = crudClnts;
        this.crudEmpleados = crudEmp;
        this.crudVehiculos = crudVehicl;
        this.crudRecibo = crudRecb;
        this.crudServicios = crudServ;
        this.frmServicios = frmServ;
        this.controllerAdmin = controllerAdmin;
        
        this.frmServicios.btnConfirmarServicio.addActionListener(this);
    }

    public void limpiar() {
        frmServicios.txtCedulaCliente.setText(null);
        frmServicios.txtNombreCliente.setText(null);
        frmServicios.txtTelefonoCliente.setText(null);
        frmServicios.txtPlacaVehiculo.setText(null);
        frmServicios.txtMarcaVehiculo.setText(null);
        frmServicios.txtNombreVehiculo.setText(null);
        frmServicios.txtModeloVehiculo.setText(null);
        frmServicios.txtColorVehiculo.setText(null);

    }

    public void iniciar() {

        frmServicios.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmServicios.btnConfirmarServicio) {

            clientes.setCedulaCliente(Integer.parseInt(frmServicios.txtCedulaCliente.getText()));
            clientes.setNombre(frmServicios.txtNombreCliente.getText());
            clientes.setTelefono(frmServicios.txtTelefonoCliente.getText());
            
            empleados = crudEmpleados.buscarEmpleado(frmServicios.cbxEncargadoServicios.getSelectedItem().toString());
            recibo.setCedulaEmp(empleados.getCedulaEmp());
            
            servicios = crudServicios.buscarServicio(frmServicios.cbxTipoLavadoServicios.getSelectedItem().toString());
            recibo.setIdServicio(servicios.getIdServicio());
            
            recibo.setTotal(Double.valueOf(frmServicios.txtPrecioServicio.getText()));
            
            
            

            if (crudClientes.registrar(clientes) && crudRecibo.registrar(recibo)) {
                JOptionPane.showMessageDialog(null, "Cliente creado y recibo creado");

                vehiculos.setCedulaClnt(Integer.parseInt(frmServicios.txtCedulaCliente.getText()));
                vehiculos.setPlaca(frmServicios.txtPlacaVehiculo.getText());
                vehiculos.setMarca(frmServicios.txtMarcaVehiculo.getText());
                vehiculos.setNombre(frmServicios.txtNombreVehiculo.getText());
                vehiculos.setModelo(frmServicios.txtModeloVehiculo.getText());
                vehiculos.setColor(frmServicios.txtColorVehiculo.getText());

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
