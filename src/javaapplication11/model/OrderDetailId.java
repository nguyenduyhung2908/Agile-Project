/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication11.model;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Nguyen Duy Hung
 */
@Embeddable
public class OrderDetailId implements Serializable{
    @ManyToOne(targetEntity = Order.class)
    @JoinColumn(name = "id_order")
    private Order order;
    
    @ManyToOne(targetEntity = Products.class)
    @JoinColumn(name = "id_product")
    private Products products ;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }
    
}
