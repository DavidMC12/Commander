/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commander.Controller;

import commander.Class.User;
import commander.Connection;
import commander.View.Login;
import commander.View.usersView;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
 *
 * @author dm200
 */
public class userController {
    
    int validation;

    public int getValidation() {
        return validation;
    }

    public void setValidation(int validation) {
        this.validation = validation;
    }
     
    public void login(JTextField paramUser, JPasswordField paramPassword){
        
        String user = paramUser.getText();
        String password = String.valueOf(paramPassword.getPassword());
        
        Connection myConnection = new Connection();
    
        Statement statement;
        String query = ("SELECT * FROM user WHERE document='"+ user +"' AND password='"+ password +"' ");
        
        if (user.isEmpty() || password.isEmpty()) {
        // Mostrar mensaje de error si algún campo está vacío
         JOptionPane.showMessageDialog(null, "Por favor, ingrese su usuario y contraseña");
        
        } else {
        
            try{

                statement = myConnection.Conexion().createStatement();
                ResultSet result = statement.executeQuery(query);

                if(result.next()){
                    
                    setValidation(1);
                    JOptionPane.showMessageDialog(null, "Bienvenido!");
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                }
                
                result.close();
                statement.close();
                myConnection.Conexion().close();

            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos, Error: " + ex.toString());
            }
        }
    }
}

