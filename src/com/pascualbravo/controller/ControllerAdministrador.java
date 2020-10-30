package com.pascualbravo.controller;

import Vistas.ActualizarAdmins;
import static com.pascualbravo.controller.ControllerLogin.cc;
import static com.pascualbravo.controller.ControllerLogin.password;
import com.pascualbravo.models.Administradores;
import com.pascualbravo.models.CrudAdministradores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControllerAdministrador implements ActionListener {

    private Administradores administradores;
    private CrudAdministradores crudAdministradores;
    public ActualizarAdmins frmAdmins;

    public ControllerAdministrador(ActualizarAdmins frmAdmin) {

        this.frmAdmins = frmAdmin;

        this.frmAdmins.btnActualizar.addActionListener(this);

        administradores = crudAdministradores.BuscarPerfil(cc, password);
        frmAdmins.Cedula.setText(String.valueOf(administradores.getCedulaAdmin()));
        frmAdmins.Nombre.setText(administradores.getNombres());
        frmAdmins.Apellidos.setText(administradores.getApellidos());
        frmAdmins.password.setText(administradores.getPassword());
    }

    public void iniciar() {
        frmAdmins.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == frmAdmins.btnActualizar) {
            try {

                if (!frmAdmins.Cedula.getText().isEmpty() && !frmAdmins.Nombre.equals("")
                        && !frmAdmins.Apellidos.equals("") && !frmAdmins.password.equals("")) {

                    actualizar();

                } else {
                    JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
                }
            } catch (Exception es) {
                JOptionPane.showMessageDialog(null, "Error! " + es);
            }
        }
    }

    public void actualizar() {
        try {
            String pass = new String(frmAdmins.password.getPassword());
            administradores.setCedulaAdmin(Integer.parseInt(frmAdmins.Cedula.getText()));
            administradores.setNombres(frmAdmins.Nombre.getText());
            administradores.setApellidos(frmAdmins.Apellidos.getText());
            administradores.setPassword(pass);

            if (crudAdministradores.actualizarAdmin(cc, administradores)) {
                JOptionPane.showMessageDialog(null, "Administrador actualizado");

            }
        } catch (Exception ed) {
            JOptionPane.showMessageDialog(null, "Error! " + ed);
        }
    }

}