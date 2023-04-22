/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commander.Model;

import commander.Model.Product;
import java.util.List;

/**
 *
 * @author dm200
 */
public class Order {
    
    private int id;
    private String status;
    private int table;
    private List<Dish> dishes;

    public Order(int id, String status, int table, List<Dish> dishes) {
        this.id = id;
        this.status = status;
        this.table = table;
        this.dishes = dishes;
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
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
    
    
    
}
