/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commander.DAO;

import commander.Connection;
import commander.Model.Dish;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author dm200
 */
public class DishDAO {
    public void showRecords(JTable paramTable){
        
        Connection myConnection = new Connection();
        
        DefaultTableModel model = new DefaultTableModel();
        
        TableRowSorter<TableModel> orderTable = new TableRowSorter<TableModel>(model);
        paramTable.setRowSorter(orderTable);
        
        Statement statement;
        String query = "SELECT * FROM commander.dish;";
        
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
    
    public void addDish(JTextField paramNames, JTextArea paramDesc){
        
        Dish myDish = new Dish();
        
        
        myDish.setName(paramNames.getText());
        myDish.setDesc(paramDesc.getText());
        
        Connection myConnection = new Connection();
        
        String query = ("INSERT INTO dish (name, description) values (?,?);");
        
        try {
            
            CallableStatement cs = myConnection.Connection().prepareCall(query);
            
            
            cs.setString(1, myDish.getName());
            cs.setString(2,myDish.getDesc());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se agregó correctamente el producto");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al realizar la acción" + e.toString());
        }
    }
    
    public void selectRecord(JTable paramTabla, JTextField paramId, JTextField paramName, JTextArea paramDesc){
        
        try {
            
            int fila = paramTabla.getSelectedRow();
            
            if (fila >= 0) {
                
                paramId.setText((String) paramTabla.getValueAt(fila, 0));
                paramName.setText((String) paramTabla.getValueAt(fila, 1));
                paramDesc.setText((String) paramTabla.getValueAt(fila,2));
            } else {
                JOptionPane.showMessageDialog(null, "Fila, no seleccionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de selección: " + e.toString());
        }
    }
    
    public void modifyDish(JTextField paramId, JTextField paramName, JTextArea paramDesc){
    
        Connection myConnection = new Connection();
        
        Dish myDish = new Dish();
        
        myDish.setId(Integer.parseInt(paramId.getText()));
        myDish.setName(paramName.getText());
        myDish.setDesc(paramDesc.getText());
        
        String query = "UPDATE dish SET dish.name = ?, dish.description = ? WHERE dish.id = ?;";
        
        try {
            
            CallableStatement cs = myConnection.Connection().prepareCall(query);
            
            
            cs.setString(1, myDish.getName());
            cs.setString(2,myDish.getDesc());
            cs.setInt(3, myDish.getId());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Modificación hecha");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la modificación: " + e.toString());
        }
    }
    
    public void deleteDish(JTextField paramID){
        
        Connection myConnection = new Connection();
        
        Dish myDish = new Dish();
        
        myDish.setId(Integer.parseInt(paramID.getText()));
        
        String query = "DELETE FROM dish WHERE dish.id = ?;";
        
        try {
            
            CallableStatement cs = myConnection.Connection().prepareCall(query);
            
            cs.setInt(1, myDish.getId());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Eliminación Exitosa");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la eliminación del registro: " + e.toString());
        }
    }
    
    public void showProductsRelationated(JTable paramTable, JTextField paramID){
        
        Connection myConnection = new Connection();
        
        Dish myDish = new Dish();
        
        DefaultTableModel model = new DefaultTableModel();
        
        TableRowSorter<TableModel> orderTable = new TableRowSorter<TableModel>(model);
        paramTable.setRowSorter(orderTable);
        
        myDish.setId(Integer.parseInt(paramID.getText()));
        
        String query = "SELECT p.name, p.description "
                + "FROM commander.product p "
                + "INNER JOIN commander.`dish-product` dp ON p.id = dp.fk_id_product "
                + "INNER JOIN commander.dish d ON dp.fk_id_dish = d.id "
                + "WHERE d.id = ?;";
        
        model.addColumn("Nombre");
        model.addColumn("Descripción");
        
        paramTable.setModel(model);
        
        String[] records = new String[2];
        
        try {
            
            CallableStatement  ps = myConnection.Connection().prepareCall(query);
            ps.setInt(1, myDish.getId());
            ResultSet result = ps.executeQuery();
            
            while (result.next()) {
                
                records[0] = result.getString(1);
                records[1] = result.getString(2);
                
                model.addRow(records);
            }
            
            paramTable.setModel(model);
                    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo mostrar los registros, Error: " + e.toString());
        }
    }
}
