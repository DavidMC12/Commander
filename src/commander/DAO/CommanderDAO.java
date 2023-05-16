/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commander.DAO;

import commander.Connection;
import commander.Model.Order;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
public class CommanderDAO {
    public void showOrders(JTable paramTable){
        
        Connection myConnection = new Connection();
        
        DefaultTableModel model = new DefaultTableModel();
        
        TableRowSorter<TableModel> orderTable = new TableRowSorter<TableModel>(model);
        paramTable.setRowSorter(orderTable);
        
        Statement statement;
        String query = "SELECT * FROM commander.order o WHERE status='Enviado';";
        
        model.addColumn("ID");
        model.addColumn("Estado");
        model.addColumn("Mesa");
        
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
    
    public void selectRecord(JTable paramTabla, JTextField paramId, JTextField paramTeble){
        
        try {
            
            int fila = paramTabla.getSelectedRow();
            
            if (fila >= 0) {
                
                paramId.setText((String) paramTabla.getValueAt(fila, 0));
                paramTeble.setText((String) paramTabla.getValueAt(fila, 2));
            } else {
                JOptionPane.showMessageDialog(null, "Fila, no seleccionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de selección: " + e.toString());
        }
    }
    
    public void showDishesRelationated(JTable paramTableOrders, JTable paramTableDishes){
        
        Connection myConnection = new Connection();
        
        Order myOrder = new Order();
        
        int id = 0;
            
        int fila = paramTableOrders.getSelectedRow();
        System.out.println(fila);
            
            if (fila >= 0) {
                id = Integer.parseInt(paramTableOrders.getValueAt(fila, 0).toString());
                myOrder.setId(id);
            } else {
                JOptionPane.showMessageDialog(null, "Fila, no seleccionada");
            }
        
        DefaultTableModel model = new DefaultTableModel();
        
        TableRowSorter<TableModel> orderTable = new TableRowSorter<TableModel>(model);
        paramTableDishes.setRowSorter(orderTable);
        
        String query = "SELECT od.id, d.name, d.description "
                + "FROM commander.`order` o "
                + "INNER JOIN commander.`order-dish` od ON o.id = od.fk_id_order "
                + "INNER JOIN commander.dish d ON od.fk_id_dish = d.id "
                + "WHERE o.id = ?;";
        
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Descripción");
        
        paramTableDishes.setModel(model);
        
        String[] records = new String[3];
        
        try {
            
            CallableStatement  ps = myConnection.Connection().prepareCall(query);
            ps.setInt(1, myOrder.getId());
            ResultSet result = ps.executeQuery();
            
            while (result.next()) {
                
                records[0] = result.getString(1);
                records[1] = result.getString(2);
                records[2] = result.getString(3);
                
                model.addRow(records);
            }
            
            paramTableDishes.setModel(model);
                    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo mostrar los registros, Error: " + e.toString());
        }
    }
}
