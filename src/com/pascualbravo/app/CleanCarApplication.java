package com.pascualbravo.app;

import Vistas.FrmLogin;
import Vistas.FrmServicios;
import com.pascualbravo.controller.ControllerLogin;
import com.pascualbravo.models.Administradores;
import com.pascualbravo.models.CrudAdministradores;

public class CleanCarApplication {

    public static void main(String[] args) {

        Administradores admin = new Administradores();
        CrudAdministradores crud = new CrudAdministradores();
        FrmLogin frm = new FrmLogin();
        FrmServicios frmServicios = new FrmServicios();

        ControllerLogin cont = new ControllerLogin(admin, crud, frm, frmServicios);

        cont.iniciar();
        frm.setVisible(true);

    }
}
