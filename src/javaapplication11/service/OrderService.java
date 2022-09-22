/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication11.service;

import java.util.List;
import javaapplication11.model.Order;
import javaapplication11.repository.OrderRepository;

/**
 *
 * @author Nguyen Duy Hung
 */
public class OrderService {
    private OrderRepository orderRepository;

    public OrderService() {
        orderRepository = new OrderRepository();
    }
    public int countOrders(){
        return this.orderRepository.countOrders();
    }
    public Order saveOrder(Order order){
        return this.orderRepository.saveOrder(order);
    }
    public List<Order> getAllOrder(){
        return this.orderRepository.getAllOrder();
    }
    public Order findOrderById(int id){
        return this.orderRepository.findOrderById(id);
    }
    public List<Order> getAllOrderInMonth(){
        return this.orderRepository.getAllOrderInMonth();
    }
    public List<Order> getAllOrderInYear(){
        return this.orderRepository.getAllOrderInYear();
    }
    public boolean deleteOrder(Order order){
        this.orderRepository.deleteOrderById(order.getId());
        return this.orderRepository.deleteOrder(order);
    }
}
