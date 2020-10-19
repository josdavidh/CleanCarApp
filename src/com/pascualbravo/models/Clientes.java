
package com.pascualbravo.models;


public class Clientes {
    
    
    private int cedulaCliente;
    
    private String nombre;
    
    private String telefono;

    
    /**
     * @return the cedulaCliente
     */
    public int getCedulaCliente() {
        return cedulaCliente;
    }

    /**
     * @param cedulaCliente the cedulaCliente to set
     */
    public void setCedulaCliente(int cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
