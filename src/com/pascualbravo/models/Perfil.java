
package com.pascualbravo.models;

public class Perfil {
    
    private int idPerfil;
    
    private String usuario;
    
    private String password; 
    
    private int cedulaAdmin; 

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
     * @return the idPerfil
     */
    public int getIdPerfil() {
        return idPerfil;
    }

    /**
     * @param idPerfil the idPerfil to set
     */
    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }
    
    
}
