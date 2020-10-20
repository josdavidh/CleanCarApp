package com.pascualbravo.app;

import Vistas.FrmServicios;
import com.pascualbravo.controller.ControllerClientes;
import com.pascualbravo.models.Clientes;
import com.pascualbravo.models.CrudClientes;


public class CleanCarApplication {
    
    public static void main (String [] args){
        
        Clientes clnts = new Clientes();
        CrudClientes crudClnts = new CrudClientes();
        FrmServicios frmServ = new FrmServicios();
        
        ControllerClientes controllerClnts = new ControllerClientes(clnts,crudClnts,frmServ);
        controllerClnts.iniciar();
        frmServ.setVisible(true);
    }
}
