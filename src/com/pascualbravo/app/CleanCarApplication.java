package com.pascualbravo.app;

import Vistas.Servicios;
import com.pascualbravo.controller.ControllerClientes;
import com.pascualbravo.models.Clientes;
import com.pascualbravo.models.CrudClientes;


public class CleanCarApplication {
    
    public static void main (String [] args){
        
        Clientes clnts = new Clientes();
        CrudClientes crudClnts = new CrudClientes();
        Servicios frmServ = new Servicios();
        
        ControllerClientes controllerClnts = new ControllerClientes(clnts,crudClnts,frmServ);
        controllerClnts.iniciar();
        frmServ.setVisible(true);
    }
}
