
package com.pascualbravo.models;

import java.sql.Connection;
import java.sql.*;
import javax.swing.JOptionPane;


public class Conexion {
    
    private final String base = "cleancardb"; 
    private final String username = "root"; 
    private final String password = "rrj69c"; 
    private final String URL = "jdbc:mysql://localhost:3306/"+ base; 
    
    private Connection con = null; 
    
    public Connection getConexion(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            con = (Connection) DriverManager.getConnection(URL, username, password);
            
            JOptionPane.showMessageDialog(null, "conexion a la base de datos exitosa");
                    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return con; 
        
    }
    
    
}
