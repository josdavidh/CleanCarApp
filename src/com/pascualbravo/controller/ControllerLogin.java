package com.pascualbravo.controller;

import Vistas.FrmLogin;
import Vistas.FrmServicios;
import com.pascualbravo.models.Administradores;
import com.pascualbravo.models.CrudAdministradores;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.util.Objects.hash;
import javax.swing.JOptionPane;

public class ControllerLogin implements ActionListener {

    private Administradores administradores;
    private CrudAdministradores crudAdministradores;
    private FrmLogin frmLogin;

    public ControllerLogin(Administradores administradores,
            CrudAdministradores crudAdministradores, FrmLogin frmLogin) {
        this.administradores = administradores;
        this.crudAdministradores = crudAdministradores;
        this.frmLogin = frmLogin;

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
        try {
            String password;
            int cc;
            if (!frmLogin.txtUsuario.getText().isEmpty() && !frmLogin.Jpassword.equals("")) {

                password = new String(frmLogin.Jpassword.getPassword());
                cc = Integer.parseInt(frmLogin.txtUsuario.getText());

                if (crudAdministradores.BuscarPerfil(cc, password)) {
                    frmLogin.dispose();

                    FrmServicios frm = new FrmServicios();
                    frm.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Datos Incorrectos");
                    limpiar();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
            }
        }catch (NumberFormatException es) {
            JOptionPane.showMessageDialog(null, "El usuario debe ser numerico "+es, "Error!", JOptionPane.ERROR_MESSAGE);
        }

    }

}
