/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commander;

import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author dm200
 */
public class Connection {
    java.sql.Connection con;
    
    String user = "root";
    String pass = "2002";
    String cadena = "jdbc:mysql://localhost:3306/commander";
    
    public java.sql.Connection Connection(){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(cadena, user, pass);
            //JOptionPane.showMessageDialog(null, "Se conectó correctamente a la BD", "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al coectar con la BD" + e.toString(), "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
        }
        return con;
    }
}
