/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commander.DAO;

import commander.Connection;
import commander.Model.Product;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author dm200
 */
public class ProductDAO {
    
    public void showRecords(JTable paramTable){
        
        Connection myConnection = new Connection();
        
        DefaultTableModel model = new DefaultTableModel();
        
        TableRowSorter<TableModel> orderTable = new TableRowSorter<TableModel>(model);
        paramTable.setRowSorter(orderTable);
        
        Statement statement;
        String query = "SELECT * FROM commander.product;";
        
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Descripción");
        model.addColumn("Cantiadad en Stock");
        model.addColumn("Unidad de Medida");
        model.addColumn("Fecha Caducidad");
        
        paramTable.setModel(model);
        
        String[] records = new String[6];
        
        try {
            
            statement = myConnection.Connection().createStatement();
            
            ResultSet result = statement.executeQuery(query);
            
            while (result.next()) {
                
                records[0] = result.getString(1);
                records[1] = result.getString(2);
                records[2] = result.getString(3);
                records[3] = result.getString(4);
                records[4] = result.getString(5);
                 records[5] = result.getString(6);
                
                model.addRow(records);
            }
            
            paramTable.setModel(model);
                    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo mostrar los registros, Error: " + e.toString());
        }
    }
    
    public void addProduct(JTextField paramNames, JTextField paramDesc, JTextField paramStock, JComboBox paramUnity, JTextField paramDateExpiration){
        
        Product mytProduct = new Product();
        
        mytProduct.setName(paramNames.getText());
        mytProduct.setDescription(paramDesc.getText());
        mytProduct.setQuantityInStock(Integer.parseInt(paramStock.getText()));
        mytProduct.setMeasurementUnity((String) paramUnity.getSelectedItem());
        mytProduct.setDateExpiration(paramDateExpiration.getText());
        
        Connection myConnection = new Connection();
        
        String query = ("INSERT INTO product (name, description, stock, unity, expiration_date) values (?,?,?,?,?);");
        
        try {
            
            CallableStatement cs = myConnection.Connection().prepareCall(query);
            
            
            cs.setString(1, mytProduct.getName());
            cs.setString(2,mytProduct.getDescription());
            cs.setString(3, String.valueOf(mytProduct.getQuantityInStock()));
            cs.setString(4,mytProduct.getMeasurementUnity());
            cs.setString(5,mytProduct.getDateExpiration());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se agregó correctamente el producto");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al realizar la acción" + e.toString());
        }
    
    }
    
    public void selectRecord(JTable paramTabla, JTextField paramId, JTextField paramName, JTextField paramDesc, JTextField paramQuanity, JComboBox paramUnity, JTextField paramDateExpiration){
        
        try {
            
            int fila = paramTabla.getSelectedRow();
            
            if (fila >= 0) {
                
                paramId.setText((String) paramTabla.getValueAt(fila, 0));
                paramName.setText((String) paramTabla.getValueAt(fila, 1));
                paramDesc.setText((String) paramTabla.getValueAt(fila,2));
                paramQuanity.setText((String) paramTabla.getValueAt(fila,3));
                paramUnity.setSelectedItem((String) paramTabla.getValueAt(fila,4));
                paramDateExpiration.setText((String) paramTabla.getValueAt(fila,5));
                
            } else {
                JOptionPane.showMessageDialog(null, "Fila, no seleccionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de selección: " + e.toString());
        }
    }
    
    public void modifyProduct(JTextField paramId, JTextField paramName, JTextField paramDesc, JTextField paramQuanity, JComboBox paramUnity, JTextField paramDateExpiration){
    
        Connection myConnection = new Connection();
        
        Product myProduct = new Product();
        
        myProduct.setId(Integer.parseInt(paramId.getText()));
        myProduct.setName(paramName.getText());
        myProduct.setDescription(paramDesc.getText());
        myProduct.setQuantityInStock(Integer.parseInt(paramQuanity.getText()));
        myProduct.setMeasurementUnity((String) paramUnity.getSelectedItem());
        myProduct.setDateExpiration(paramDateExpiration.getText());
        
        String query = "UPDATE product SET product.name = ?, product.description = ?, product.stock = ?,  product.unity = ?,  product.expiration_date = ? WHERE product.id = ?;";
        
        try {
            
            CallableStatement cs = myConnection.Connection().prepareCall(query);
            
            
            cs.setString(1, myProduct.getName());
            cs.setString(2,myProduct.getDescription());
            cs.setInt(3,myProduct.getQuantityInStock());
            cs.setString(4,myProduct.getMeasurementUnity());
            cs.setString(5,myProduct.getDateExpiration());
            cs.setInt(6, myProduct.getId());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Modificación hecha");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la modificación: " + e.toString());
        }
    }
    
    public void deleteProduct(JTextField paramID){
        
        Connection myConnection = new Connection();
        
        Product myProduct = new Product();
        
        myProduct.setId(Integer.parseInt(paramID.getText()));
        
        String query = "DELETE FROM product WHERE product.id = ?;";
        
        try {
            
            CallableStatement cs = myConnection.Connection().prepareCall(query);
            
            cs.setInt(1, myProduct.getId());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Eliminación Exitosa");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la eliminación del registro: " + e.toString());
        }
    }
    
    public void showRecordsProduct(JTable paramTable){
        
        Connection myConnection = new Connection();
        
        DefaultTableModel model = new DefaultTableModel();
        
        TableRowSorter<TableModel> orderTable = new TableRowSorter<TableModel>(model);
        paramTable.setRowSorter(orderTable);
        
        Statement statement;
        String query = "SELECT * FROM commander.product;";
        
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Descripción");
        
        paramTable.setModel(model);
        
        String[] records = new String[3];
        
        try {
            
            statement = myConnection.Connection().createStatement();
            
            ResultSet result = statement.executeQuery(query);
            
            while (result.next()) {
                
                records[0] = result.getString(1);
                records[1] = result.getString(2);
                records[2] = result.getString(3);
                
                model.addRow(records);
            }
            
            paramTable.setModel(model);
                    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo mostrar los registros, Error: " + e.toString());
        }
    }
    

    
}
