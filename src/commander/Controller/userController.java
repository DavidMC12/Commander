/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commander.Controller;

import commander.Connection;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
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
    
    public void showRecords(JTable paramTable){
        
        Connection myConnection = new Connection();
        
        DefaultTableModel model = new DefaultTableModel();
        
        TableRowSorter<TableModel> orderTable = new TableRowSorter<TableModel>(model);
        paramTable.setRowSorter(orderTable);
        
        Statement statement;
        String query = "SELECT * FROM commander.user;";
        
        model.addColumn("ID");
        model.addColumn("Nombres");
        model.addColumn("N° Documento");
        model.addColumn("Cargo");
        
        paramTable.setModel(model);
        
        String[] records = new String[4];
        
        try {
            
            statement = myConnection.Conexion().createStatement();
            
            ResultSet result = statement.executeQuery(query);
            
            while (result.next()) {
                
                records[0] = result.getString(1);
                records[1] = result.getString(2);
                records[2] = result.getString(3);
                records[3] = result.getString(5);
                
                model.addRow(records);
            }
            
            paramTable.setModel(model);
                    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo mostrar los registros, Error: " + e.toString());
        }
    }
}

