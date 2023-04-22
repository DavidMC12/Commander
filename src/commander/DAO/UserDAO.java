/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commander.DAO;

import commander.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import commander.Model.User;
import javax.swing.JComboBox;

/**
 *
 * @author dm200
 */
public class UserDAO {
    private int validation;

    public int getValidation() {
        return validation;
    }

    public void setValidation(int validation) {
        this.validation = validation;
    }

    //|Hace el login con datos de la base de datos|
    public void Login(JTextField paramUser, JPasswordField paramPassword){
        
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

                statement = myConnection.Connection().createStatement();
                ResultSet result = statement.executeQuery(query);

                if(result.next()){
                    
                    setValidation(1);
                    JOptionPane.showMessageDialog(null, "Bienvenido!");
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                }
                
                result.close();
                statement.close();
                myConnection.Connection().close();

            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos, Error: " + ex.toString());
            }
        }
    }
    //|Muestra los registros conectado a una base de datos| 
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
            
            statement = myConnection.Connection().createStatement();
            
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
    
    public void addUser(JTextField paramNames, JTextField paramDocument, JComboBox paramRole){
        
        User myUser = new User();
        
        myUser.setName(paramNames.getText());
        myUser.setDocument(paramDocument.getText());
        myUser.setPassword(paramDocument.getText());
        myUser.setRole((String) paramRole.getSelectedItem());
        
        Connection myConnection = new Connection();
        
        String query = ("INSERT INTO user (names, document, password, role) values (?,?,?,?);");
        
        try {
            
            CallableStatement cs = myConnection.Connection().prepareCall(query);
            
            
            cs.setString(1, myUser.getName());
            cs.setString(2,myUser.getDocument());
            cs.setString(3, myUser.getDocument());
            cs.setString(4,myUser.getRole());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se agregó correctamente el registro");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al realizar la acción" + e.toString());
        }
    
    }
    
    public void selectRecord(JTable paramTabla, JTextField paramId, JTextField paramNames, JTextField paramDocument, JComboBox paramRole){
        
        try {
            
            int fila = paramTabla.getSelectedRow();
            
            if (fila >= 0) {
                
                paramId.setText((String) paramTabla.getValueAt(fila, 0));
                paramNames.setText((String) paramTabla.getValueAt(fila, 1));
                paramDocument.setText((String) paramTabla.getValueAt(fila,2));
                paramRole.setSelectedItem((String) paramTabla.getValueAt(fila,3));
                
            } else {
                JOptionPane.showMessageDialog(null, "Fila, no seleccionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de selección: " + e.toString());
        }
    }
    
    public void modifyUser(JTextField paramId, JTextField paramNames, JTextField paramDocument, JComboBox paramRole){
    
        Connection myConnection = new Connection();
        
        User myUser = new User();
        
        myUser.setId(Integer.parseInt(paramId.getText()));
        myUser.setName(paramNames.getText());
        myUser.setDocument(paramDocument.getText());
        myUser.setRole((String) paramRole.getSelectedItem());
        
        String query = "UPDATE user SET user.names = ?, user.document = ?, user.role = ? WHERE user.id = ?;";
        
        try {
            
            CallableStatement cs = myConnection.Connection().prepareCall(query);
            
            cs.setString(1, myUser.getName());
            cs.setString(2,myUser.getDocument());
            cs.setString(3,myUser.getRole());
            cs.setInt(4, myUser.getId());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Modificación hecha");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la modificación: " + e.toString());
        }
    }
    
    public void deleteUser(JTextField paramID){
        
        Connection myConnection = new Connection();
        
        User myUser = new User();
        
        myUser.setId(Integer.parseInt(paramID.getText()));
        
        String query = "DELETE FROM user WHERE user.id = ?;";
        
        try {
            
            CallableStatement cs = myConnection.Connection().prepareCall(query);
            
            cs.setInt(1, myUser.getId());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Eliminación Exitosa");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la eliminación del registro: " + e.toString());
        }
    }
}
