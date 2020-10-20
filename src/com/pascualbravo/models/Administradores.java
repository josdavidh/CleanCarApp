package com.pascualbravo.models;

public class Administradores {
    
    private int cedulaAdmin;
    
    private String nombres;
    
    private String apellidos; 

    /**
     * @return the cedulaAdmin
     */
    public int getCedulaAdmin() {
        return cedulaAdmin;
    }

    /**
     * @param cedulaAdmin the cedulaAdmin to set
     */
    public void setCedulaAdmin(int cedulaAdmin) {
        this.cedulaAdmin = cedulaAdmin;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}
