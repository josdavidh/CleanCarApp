package com.pascualbravo.controller;

import Vistas.ActualizarAdmins;
import Vistas.FrmLogin;
import Vistas.FrmServicios;
import com.pascualbravo.models.Administradores;
import com.pascualbravo.models.CrudAdministradores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControllerLogin implements ActionListener {

    private Administradores administradores;
    private CrudAdministradores crudAdministradores;
    private FrmLogin frmLogin;
    private FrmServicios frmServicios;
    private ActualizarAdmins admins;

    public static String password;
    public static int cc;

    ControllerVistasRun controllerServicios = new ControllerVistasRun();

    public ControllerLogin(Administradores administradores,
            CrudAdministradores crudAdministradores, FrmLogin frmLogin, FrmServicios frmServicios) {
        this.administradores = administradores;
        this.crudAdministradores = crudAdministradores;
        this.frmLogin = frmLogin;
        this.frmServicios = frmServicios;

        this.frmLogin.btnIgresar.addActionListener(this);

    }

    public void limpiar() {
        frmLogin.txtUsuario.setText(null);
        frmLogin.Jpassword.setText(null);
    }

    public void iniciar() {
        frmLogin.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmLogin.btnIgresar) {
            try {
                if (!frmLogin.txtUsuario.getText().isEmpty() && !frmLogin.Jpassword.equals("")) {

                    password = new String(frmLogin.Jpassword.getPassword());
                    cc = Integer.parseInt(frmLogin.txtUsuario.getText());

                    administradores = crudAdministradores.BuscarPerfil(ControllerLogin.cc, ControllerLogin.password);
                    if (administradores.getNombres() != null) {
                        frmLogin.dispose();

                        //controllerServicios.runFrmServicios();
                        
                        controllerServicios.runFrmServicios();
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Datos Incorrectos");
                        limpiar();
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
                }
            } catch (NumberFormatException es) {
                JOptionPane.showMessageDialog(null, "El usuario debe ser numerico " + es, "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
