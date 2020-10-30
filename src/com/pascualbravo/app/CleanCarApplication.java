package com.pascualbravo.app;

import Vistas.FrmLogin;
import Vistas.FrmServicios;
import Vistas.listaEmpleados;
import com.pascualbravo.controller.ControllerLogin;
import com.pascualbravo.controller.ListaEmp_Clnt;
import com.pascualbravo.models.Administradores;
import com.pascualbravo.models.CrudAdministradores;

public class CleanCarApplication {

    public static void main(String[] args) {

        Administradores admin = new Administradores();
        CrudAdministradores crud = new CrudAdministradores();
        FrmLogin frm = new FrmLogin();
        FrmServicios frmServicios = new FrmServicios();
        listaEmpleados lista = new listaEmpleados();
        ListaEmp_Clnt intit = new ListaEmp_Clnt(lista);
        /*ControllerLogin cont = new ControllerLogin(admin, crud, frm, frmServicios);

        cont.iniciar();
        frm.setVisible(true);*/

    }
}
