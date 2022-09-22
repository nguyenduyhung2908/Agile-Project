/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication11.service;

import java.util.List;
import javaapplication11.model.Products;
import javaapplication11.repository.ProductRepository;

/**
 *
 * @author Nguyen Duy Hung
 */
public class ProductService {
    private ProductRepository productRepository;

    public ProductService() {
        productRepository = new ProductRepository();
    }
    public List<Products> getAllProducts(){
        return this.productRepository.getAllProducts();
    }
    
    public Products saveProducts(Products products){
        return this.productRepository.saveProducts(products);
    }
    public boolean updateProducts(Products products){
        return this.productRepository.updateProducts(products);
    }
    public boolean deleteProducts(Products products){
        this.productRepository.deleteProdcutsById(products.getId());
        return this.productRepository.deleteProducts(products);
    }
    public List<Products> searchProductsByName(String name){
        return this.productRepository.searchProductsByName("%"+name+"%");
    }
    public List<Products> getAllProductsInMonth(){
        return this.productRepository.getAllOrderInMonth();
    }
    public List<Products> getAllProductsInYear(){
        return this.productRepository.getAllOrderInYear();
    }
}
