package commander.DAO;


import commander.Connection;
import commander.Model.Dish;
import commander.Model.Order;
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dm200
 */
public class OrderDAO {
    public void showRecords(JTable paramTable){
        
        Connection myConnection = new Connection();
        
        DefaultTableModel model = new DefaultTableModel();
        
        TableRowSorter<TableModel> orderTable = new TableRowSorter<TableModel>(model);
        paramTable.setRowSorter(orderTable);
        
        Statement statement;
        String query = "SELECT * FROM commander.order WHERE status='Pendiente';";
        
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
    
    public void addOrder(JTextField paramTable){
        
        Order myOrder = new Order();              
        
        myOrder.setTable(Integer.parseInt(paramTable.getText()));
        //myOrder.setStatus("Pendiente");
        
        Connection myConnection = new Connection();
        
        String query = ("INSERT INTO commander.`order` (status,nTable) VALUES ('Pendiente',?);");
        
        try {
            
            CallableStatement cs = myConnection.Connection().prepareCall(query);
            
            
            cs.setInt(1, myOrder.getTable());
            //cs.setString(2,myOrder.getStatus());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se agregó correctamente el producto");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al realizar la acción" + e.toString());
        }
    }
    
    public void showDishesRelationated(JTable paramTable, JTextField paramID){
        
        Connection myConnection = new Connection();
        
        Order myOrder = new Order();
        
        DefaultTableModel model = new DefaultTableModel();
        
        TableRowSorter<TableModel> orderTable = new TableRowSorter<TableModel>(model);
        paramTable.setRowSorter(orderTable);
        
        myOrder.setId(Integer.parseInt(paramID.getText()));
        
        String query = "SELECT od.id, d.name, d.description "
                + "FROM commander.`order` o "
                + "INNER JOIN commander.`order-dish` od ON o.id = od.fk_id_order "
                + "INNER JOIN commander.dish d ON od.fk_id_dish = d.id "
                + "WHERE o.id = ?;";
        
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Descripción");
        
        paramTable.setModel(model);
        
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
            
            paramTable.setModel(model);
                    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo mostrar los registros, Error: " + e.toString());
        }
    }
    
    public void addOrderDish(JTable paramTabla, String paramId){
        
        Order myOrder = new Order();
        
        myOrder.setId(Integer.parseInt(paramId));
        
        int id = 0;
            
        int fila = paramTabla.getSelectedRow();
            
            if (fila >= 0) {
                
                id = Integer.parseInt(paramTabla.getValueAt(fila, 0).toString());
                System.out.println(id);
            } else {
                JOptionPane.showMessageDialog(null, "Fila, no seleccionada");
            }
        
        Connection myConnection = new Connection();
        
        String query = ("INSERT INTO commander.`order-dish` (fk_id_order, fk_id_dish) values (?,?);");
        
        try {
            
            CallableStatement cs = myConnection.Connection().prepareCall(query);
            
            
            cs.setInt(1, myOrder.getId());
            cs.setInt(2,id);
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se agregó correctamente el producto");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al realizar la acción" + e.toString());
        }
    }
    
    public void deleteDishFromOrder(JTable paramTabla){
        
        Connection myConnection = new Connection();
        
        int id = 0;
            
        int fila = paramTabla.getSelectedRow();
            
            if (fila >= 0) {
                
                id = Integer.parseInt(paramTabla.getValueAt(fila, 0).toString());
                
                String query = "DELETE FROM commander.`order-dish` WHERE `order-dish`.id = ?;";
                
                try {

                    CallableStatement cs = myConnection.Connection().prepareCall(query);

                    cs.setInt(1, id);

                    cs.execute();

                    JOptionPane.showMessageDialog(null, "Eliminación Exitosa");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error en la eliminación del registro: " + e.toString());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Fila, no seleccionada");
            }
        
        
    }
    
    public void FinishOrder(JTable paramTable){
    
        Connection myConnection = new Connection();
        
        Order myOrder = new Order();
        
        int id = 0;
            
        int fila = paramTable.getSelectedRow();
            
            if (fila >= 0) {
                id = Integer.parseInt(paramTable.getValueAt(fila, 0).toString());
                myOrder.setId(id);
            } else {
                JOptionPane.showMessageDialog(null, "Fila, no seleccionada");
            }
        
        myOrder.setId(id);
        
        String query = "UPDATE commander.`order` SET commander.`order`.status = 'Finalizado' WHERE commander.`order`.id = ?;";
        
        try {
            
            CallableStatement cs = myConnection.Connection().prepareCall(query);
            
            
            cs.setInt(1, id);
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "La orden ha finalizado");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la modificación: " + e.toString());
        }
    }
    
    public void SendOrder(JTable paramTable){
    
        Connection myConnection = new Connection();
        
        Order myOrder = new Order();
        
        int id = 0;
            
        int fila = paramTable.getSelectedRow();
            
            if (fila >= 0) {
                id = Integer.parseInt(paramTable.getValueAt(fila, 0).toString());
                myOrder.setId(id);
            } else {
                JOptionPane.showMessageDialog(null, "Fila, no seleccionada");
            }
        
        myOrder.setId(id);
        
        String query = "UPDATE commander.`order` SET commander.`order`.status = 'Enviado' WHERE commander.`order`.id = ?;";
        
        try {
            
            CallableStatement cs = myConnection.Connection().prepareCall(query);
            
            cs.setInt(1, id);
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "La orden se ha enviado a la cocina");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la modificación: " + e.toString());
        }
    }
    
}
