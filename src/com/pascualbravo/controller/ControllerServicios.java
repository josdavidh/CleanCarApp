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

    public ControllerServicios(Clientes clnts, Vehiculos vehicl, Empleados emp, Recibo recb, Servicios serv, CrudClientes crudClnts,
            CrudEmpleados crudEmp, CrudVehiculos crudVehicl, CrudRecibo crudRecb, CrudServicios crudServ, FrmServicios frmServ) {

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
        frmServicios.cbxEncargadoServicios.setSelectedIndex(0);
        frmServicios.cbxTipoLavadoServicios.setSelectedIndex(0);

    }

    public void iniciar() {

        frmServicios.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmServicios.btnConfirmarServicio) {

            try {
                clientes.setCedulaCliente(Integer.parseInt(frmServicios.txtCedulaCliente.getText()));
                vehiculos.setCedulaClnt(Integer.parseInt(frmServicios.txtCedulaCliente.getText()));
            } catch (NumberFormatException excp) {
                JOptionPane.showMessageDialog(null, "Escriba una cedula");
            }

            clientes.setNombre(frmServicios.txtNombreCliente.getText());
            clientes.setTelefono(frmServicios.txtTelefonoCliente.getText());

            vehiculos.setPlaca(frmServicios.txtPlacaVehiculo.getText());
            vehiculos.setMarca(frmServicios.txtMarcaVehiculo.getText());
            vehiculos.setNombre(frmServicios.txtNombreVehiculo.getText());
            vehiculos.setModelo(frmServicios.txtModeloVehiculo.getText());
            vehiculos.setColor(frmServicios.txtColorVehiculo.getText());

            if ("".equals(clientes.getNombre())
                    || "".equals(clientes.getTelefono())
                    || "".equals(vehiculos.getPlaca())
                    || "".equals(vehiculos.getNombre())
                    || "".equals(vehiculos.getCedulaClnt())
                    || "".equals(vehiculos.getModelo())
                    || "".equals(vehiculos.getMarca())
                    || "".equals(vehiculos.getColor())
                    || "Selecciona".equals(frmServicios.cbxEncargadoServicios.getSelectedItem().toString())
                    || "Selecciona".equals(frmServicios.cbxTipoLavadoServicios.getSelectedItem().toString())
                    || Double.valueOf(frmServicios.txtPrecioServicio.getText()) < 0) {

                JOptionPane.showMessageDialog(null, "No deje ningun campo vacio");

                if ("Selecciona".equals(frmServicios.cbxEncargadoServicios.getSelectedItem().toString())) {

                    JOptionPane.showMessageDialog(null, "Seleccione un encargado (empleado)");

                }
                if ("Selecciona".equals(frmServicios.cbxTipoLavadoServicios.getSelectedItem().toString())) {

                    JOptionPane.showMessageDialog(null, "Seleccione un tipo de lavado");

                }

                if (Double.valueOf(frmServicios.txtPrecioServicio.getText()) < 0) {
                    JOptionPane.showMessageDialog(null, "Escriba un valor mayor a 0");
                }

            } else {

                empleados = crudEmpleados.buscarEmpleado(frmServicios.cbxEncargadoServicios.getSelectedItem().toString());
                recibo.setCedulaEmp(empleados.getCedulaEmp());

                servicios = crudServicios.buscarServicio(frmServicios.cbxTipoLavadoServicios.getSelectedItem().toString());
                recibo.setIdServicio(servicios.getIdServicio());

                recibo.setTotal(Double.valueOf(frmServicios.txtPrecioServicio.getText()));

                if (crudClientes.registrar(clientes)) {
                    crudRecibo.registrar(recibo);

                    if (crudVehiculos.registrar(vehiculos)) {

                        JOptionPane.showMessageDialog(null, "Recibo generado");

                        limpiar();

                    } else {
                        JOptionPane.showMessageDialog(null, "Error al registrar");

                        limpiar();
                    }
                }

            }

        }
        if (e.getSource() == frmServicios.btnCancelarServicio) {
            limpiar();
        }
    }

}
