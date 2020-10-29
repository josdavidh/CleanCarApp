package com.pascualbravo.app;

import Vistas.FrmLogin;
import Vistas.FrmServicios;
import com.pascualbravo.controller.ControllerLogin;
import com.pascualbravo.controller.ControllerServicios;
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


public class CleanCarApplication {
    
    public static void main (String [] args){
        
     /*   Clientes clnts = new Clientes();
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
        
        
        ControllerServicios controllerClnts = new ControllerServicios(clnts,vehicl,emp,recb, serv,
                crudClnts,crudEmp,crudVehicl,crudRecb,crudServ,frmServ);
        
        controllerClnts.iniciar();
        frmServ.setVisible(true);*/
     
        Administradores admin= new Administradores();
        CrudAdministradores crud=new CrudAdministradores();
        FrmLogin frm= new FrmLogin();
        ControllerLogin cont=new ControllerLogin(admin,crud,frm);
        
        cont.iniciar();
        frm.setVisible(true);
    }
}
