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
    private String adminRol = "admin";
    private String chefRol = "chef";
    private String waiterRol = "waiter";

    public User(int id, String name, String document) {
        this.id = id;
        this.name = name;
        this.document = document;
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

    public String getAdminRol() {
        return adminRol;
    }

    public void setAdminRol(String adminRol) {
        this.adminRol = adminRol;
    }

    public String getChefRol() {
        return chefRol;
    }

    public void setChefRol(String chefRol) {
        this.chefRol = chefRol;
    }

    public String getWaiterRol() {
        return waiterRol;
    }

    public void setWaiterRol(String waiterRol) {
        this.waiterRol = waiterRol;
    }
    
    
}
