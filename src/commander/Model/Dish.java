/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commander.Model;

import java.util.List;

/**
 *
 * @author dm200
 */
public class Dish {
    
    private int id;
    private String name;
    private List<Product> product;

    public Dish(int id, String name, List<Product> product) {
        this.id = id;
        this.name = name;
        this.product = product;
    }

    public Dish() {
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

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }
    
}
