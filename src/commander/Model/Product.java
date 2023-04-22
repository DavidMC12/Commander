/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commander.Model;

/**
 *
 * @author dm200
 */
public class Product {
    
    private int id;
    private String name;
    private String description;
    private int quantityInStock;
    private String measurementUnity;
    private String dateExpiration;

    public Product(int id, String name, String description, int quantityInStock, String measurementUnity, String dateExpiration) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantityInStock = quantityInStock;
        this.measurementUnity = measurementUnity;
        this.dateExpiration = dateExpiration;
    }

    public Product() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public String getMeasurementUnity() {
        return measurementUnity;
    }

    public void setMeasurementUnity(String measurementUnity) {
        this.measurementUnity = measurementUnity;
    }

    public String getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(String dateExpiration) {
        this.dateExpiration = dateExpiration;
    }
}
