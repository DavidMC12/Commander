/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commander.Model;


/**
 *
 * @author dm200
 */
public class Order {
    
    private int id;
    private String status;
    private int nTable;

    public Order(int id, String status, int table) {
        this.id = id;
        this.status = status;
        this.nTable = table;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTable() {
        return nTable;
    }

    public void setTable(int table) {
        this.nTable = table;
    }
}
