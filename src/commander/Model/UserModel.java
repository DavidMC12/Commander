/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commander.Model;

import java.util.ArrayList;
import commander.Class.User;
import commander.Controller.userController;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dm200
 */
public class UserModel {
    
    public ArrayList<User> usersList;
    
    public UserModel() {
        this.usersList = new ArrayList<>();
        fillList();
    }
    
    public void fillList(){
        usersList.add(new User(1,"Admin admin", "12345", "clave123","SuperUser"));
        usersList.add(new User(2,"Daniella Leon", "99999", "99999","SuperUser"));
        usersList.add(new User(3,"Angie Ochoa", "88888", "qwerty","SuperUser"));
        usersList.add(new User(4,"David Madrid", "11111", "abcde","SuperUser"));
        usersList.add(new User(5,"Uribe Paraco HP", "66666", "66666","Ratero xd"));
    }
    
    public ArrayList<User> getUsersList(){
        return usersList;
    }
   
    public void addUser(int id , String name, String document, String password, String role,JTable paramTable){
        
        
        DefaultTableModel model = new DefaultTableModel();

        /*String id = paramID.getText();
        int ID = Integer.parseInt(id);
        
        String name = paramName.getText();
        
        String document = paramDocument.getText();
        
        String password = paramPassword.getText();
        
        String role = paramRole.getText();*/
        
        usersList.add(new User(id, name, document, password, role));
        
        model.addRow(new Object[]{id, name, document, password, role});
        
        for (int i = 0; i < usersList.size(); i++){
            
            usersList.get(i).ImprimirDatos();
        
        }
       

        
        /*JOptionPane.showMessageDialog(null, "Usuario agregado: " + name);*/
        
        userController myUserController = new userController();
        myUserController.showRecords(paramTable);
    }
    
    
    
}
