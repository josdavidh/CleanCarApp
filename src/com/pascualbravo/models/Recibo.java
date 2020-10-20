package com.pascualbravo.models;

public class Recibo {
    
    private int codRecibo; 
    
    private double total;
    
    private int cedulaEmp;
    
    private int idServicio;

    /**
     * @return the codRecibo
     */
    public int getCodRecibo() {
        return codRecibo;
    }

    /**
     * @param codRecibo the codRecibo to set
     */
    public void setCodRecibo(int codRecibo) {
        this.codRecibo = codRecibo;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

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
     * @return the idServicio
     */
    public int getIdServicio() {
        return idServicio;
    }

    /**
     * @param idServicio the idServicio to set
     */
    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }
}
