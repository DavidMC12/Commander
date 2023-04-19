/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commander.Controller;

import commander.Class.Product;
import commander.Model.ProductModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dm200
 */
public class ProductController {
    
    private ProductModel productModel;
   
    
    public ProductController(){
        productModel = new ProductModel();
    }
    
    //Mostrar Registros  
    public void showRecords(JTable paramTable){
        
        DefaultTableModel model = new DefaultTableModel();
        
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Descripción");
        model.addColumn("Stock");
        model.addColumn("Unidad de Medida");
        model.addColumn("Fecha de Vencimiento (YYY-MM-DD)");
        
        for (Product product : productModel.getProductsList()) {
        Object[] row = {product.getId(), product.getName(), product.getDescription(), product.getQuantityInStock(), product.getMeasurementUnity(), product.getDateExpiration()};
        model.addRow(row);
        }
        
        paramTable.setModel(model);
        
    }
}
