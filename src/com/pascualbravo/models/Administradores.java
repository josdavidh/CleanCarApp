package com.pascualbravo.models;

public class Administradores {
    
    private int cedulaAdmin;
    
    private String nombres;
    
    private String apellidos; 
    
    private String password;

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

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
