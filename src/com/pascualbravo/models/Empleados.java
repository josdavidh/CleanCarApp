
package com.pascualbravo.models;


public class Empleados {
    
    private int cedulaEmp;
    
    private String nombre;
    
    private double salario;
    
    private int cedulaJefe;

    /**
     * @return the cedulaEmp
     */
    public int getCedulaEmp() {
        return cedulaEmp;
    }

    /**
     * @param cedulaEmp the cedulaEmp to set
     */
    public void setCedulaEmp(int cedulaEmp) {
        this.cedulaEmp = cedulaEmp;
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
     * @return the salario
     */
    public double getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }

    /**
     * @return the cedulaJefe
     */
    public int getCedulaJefe() {
        return cedulaJefe;
    }

    /**
     * @param cedulaJefe the cedulaJefe to set
     */
    public void setCedulaJefe(int cedulaJefe) {
        this.cedulaJefe = cedulaJefe;
    }
    
}
