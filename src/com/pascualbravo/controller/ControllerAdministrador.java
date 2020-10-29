package com.pascualbravo.controller;

import Vistas.ActualizarAdmins;
import Vistas.Prueba;
import static com.pascualbravo.controller.ControllerLogin.cc;
import static com.pascualbravo.controller.ControllerLogin.password;
import com.pascualbravo.models.Administradores;
import com.pascualbravo.models.CrudAdministradores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ControllerAdministrador implements ActionListener {

    private Administradores administradores;
    private CrudAdministradores crudAdministradores;
    private ActualizarAdmins admins;
    private Prueba prueba;

    public ControllerAdministrador(Administradores administrador,
            CrudAdministradores crudAdministradores, ActualizarAdmins admin, Prueba prueba) {

        this.administradores = administrador;
        this.crudAdministradores = crudAdministradores;
        this.admins = admin;
        this.prueba = prueba;

        this.prueba.btnPrueba.addActionListener(this);
        this.admins.btnActualizar.addActionListener(this);

        admins.setVisible(true);
        administradores = crudAdministradores.BuscarPerfil(cc, password);
        admins.Cedula.setText(String.valueOf(administradores.getCedulaAdmin()));
        admins.Nombre.setText(administradores.getNombres());
        admins.Apellidos.setText(administradores.getApellidos());
        admins.password.setText(administradores.getPassword());
    }

    public void iniciar() {
        admins.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton option = (JButton) e.getSource();
        //if (prueba.btnPrueba == option) {

        if (admins.btnActualizar == option) {
            try {

                if (!admins.Cedula.getText().isEmpty() && !admins.Nombre.equals("")
                        && !admins.Apellidos.equals("") && !admins.password.equals("")) {

                    actualizar();

                } else {
                    JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
                }
            } catch (Exception es) {
                JOptionPane.showMessageDialog(null, "Error! " + es);
            }
        }
        // }
    }

    public void actualizar() {
        try {
            String pass = new String(admins.password.getPassword());
            administradores.setCedulaAdmin(Integer.parseInt(admins.Cedula.getText()));
            administradores.setNombres(admins.Nombre.getText());
            administradores.setApellidos(admins.Apellidos.getText());
            administradores.setPassword(pass);

            if (crudAdministradores.actualizarAdmin(cc, administradores)) {
                JOptionPane.showMessageDialog(null, "Administrador actualizado");

            }
        } catch (Exception ed) {
            JOptionPane.showMessageDialog(null, "Error! " + ed);
        }
    }

}
