/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commander.Model;

import commander.Class.Product;
import java.util.ArrayList;

/**
 *
 * @author dm200
 */
public class ProductModel {
    public ArrayList<Product> productsList;
    
    public ProductModel() {
        this.productsList = new ArrayList<>();
        fillList();
    }
    
    public void fillList(){
        productsList.add(new Product(1, "Arroz", "Blanco", 3, "Arroba", "2023-06-01"));
        productsList.add(new Product(2, "Papa", "Pastusa", 2, "Arroba", "2023-06-01"));
        productsList.add(new Product(3, "Pechuga", "Pollo blanco", 21, "Kilos", "2023-06-01"));
        productsList.add(new Product(4, "Perniles de pollo", "Pollo amarillo", 2, "Arroba", "2023-06-01"));
        productsList.add(new Product(5, "Centro de cadera", "Carne de res", 2, "Arroba", "2023-06-01"));
        productsList.add(new Product(6, "Frijol", "bola Roja", 10, "Kilos", "2023-06-01"));
        productsList.add(new Product(7, "Lenteja", "Comun", 7, "Kilos", "2023-06-01"));
        productsList.add(new Product(8, "Papa", "Criolla", 8, "kilos", "2023-06-01"));
        productsList.add(new Product(9, "Chorizo", "Ranchero", 10, "Docenas", "2023-05-01"));
        productsList.add(new Product(10, "Arveja", "Verde", 3, "Arroba", "2023-06-01"));
        productsList.add(new Product(11, "Huevos", "Blanco", 9, "decenas", "2023-06-01"));
        productsList.add(new Product(12, "Tomates", "Chonto", 15, "kilos", "2023-05-01"));
        productsList.add(new Product(13, "Arveja", "Seca", 3, "Arroba", "2023-06-01"));
        productsList.add(new Product(14, "Frijol", "Verde", 10, "Kilos", "2023-06-01"));
        productsList.add(new Product(15, "Leche", "Entera", 12, "pacas", "2023-09-01"));
        productsList.add(new Product(16, "Frijol", "pepa negra", 10, "Kilos", "2023-06-01"));
        productsList.add(new Product(17, "Chontaduro", "Afrodisiaco", 5, "Kilos", "2023-05-09"));
        productsList.add(new Product(18, "Lulo", "Del monte xd", 10, "Kilos", "2023-04-30"));
    }   
    
    
    public ArrayList<Product> getProductsList(){
        return productsList;
    }
    
    
}
