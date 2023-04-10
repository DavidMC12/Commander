/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commander.Class;

/**
 *
 * @author dm200
 */
public class User {
    
    private int id;
    private String name;
    private String document;
    private String password;
    private String role;
    
    /*Los posibles roles pueden ser los siguientes
    private String adminRol = "admin";
    private String chefRol = "chef";
    private String waiterRol = "waiter";*/

    public User(int id, String name, String document, String password, String role) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.password = password;
        this.role = role;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
}
