package com.pascualbravo.controller;

import Vistas.ActualizarAdmins;
import Vistas.FrmServicios;
import Vistas.Prueba;
import com.pascualbravo.models.Administradores;
import com.pascualbravo.models.Clientes;
import com.pascualbravo.models.CrudAdministradores;
import com.pascualbravo.models.CrudClientes;
import com.pascualbravo.models.CrudEmpleados;
import com.pascualbravo.models.CrudRecibo;
import com.pascualbravo.models.CrudServicios;
import com.pascualbravo.models.CrudVehiculos;
import com.pascualbravo.models.Empleados;
import com.pascualbravo.models.Recibo;
import com.pascualbravo.models.Servicios;
import com.pascualbravo.models.Vehiculos;

public class ControllerVistasRun {

    public void runFrmServicios() {
        Clientes clnts = new Clientes();
        Vehiculos vehicl = new Vehiculos();
        Empleados emp = new Empleados();
        Recibo recb = new Recibo();
        Servicios serv = new Servicios();
        CrudVehiculos crudVehicl = new CrudVehiculos();
        CrudEmpleados crudEmp = new CrudEmpleados();
        CrudClientes crudClnts = new CrudClientes();
        CrudRecibo crudRecb = new CrudRecibo();
        CrudServicios crudServ = new CrudServicios();
        FrmServicios frmServ = new FrmServicios();

        ControllerServicios controllerClnts = new ControllerServicios(clnts, vehicl, emp, recb, serv,
                crudClnts, crudEmp, crudVehicl, crudRecb, crudServ, frmServ);

        controllerClnts.iniciar();
        frmServ.setVisible(true);
    }

    public void runFrmActualizarAdmin() {
        Administradores admin = new Administradores();
        CrudAdministradores crud = new CrudAdministradores();
        ActualizarAdmins adminf = new ActualizarAdmins();
        Prueba prueba = new Prueba();
        ControllerAdministrador controllerAdmin = new ControllerAdministrador(admin, crud, adminf,prueba);

        controllerAdmin.iniciar();
        prueba.setVisible(true);
    }
}
