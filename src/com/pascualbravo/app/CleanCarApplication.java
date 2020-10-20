package com.pascualbravo.app;

import Vistas.FrmServicios;
import com.pascualbravo.controller.ControllerServicios;
import com.pascualbravo.models.Clientes;
import com.pascualbravo.models.CrudClientes;
import com.pascualbravo.models.CrudVehiculos;
import com.pascualbravo.models.Vehiculos;


public class CleanCarApplication {
    
    public static void main (String [] args){
        
        Clientes clnts = new Clientes();
        Vehiculos vehicl = new Vehiculos();
        CrudVehiculos crudVehicl = new CrudVehiculos();
        CrudClientes crudClnts = new CrudClientes();
        FrmServicios frmServ = new FrmServicios();
        
        ControllerServicios controllerClnts = new ControllerServicios(clnts,vehicl,crudClnts,crudVehicl,frmServ);
        controllerClnts.iniciar();
        frmServ.setVisible(true);
    }
}
