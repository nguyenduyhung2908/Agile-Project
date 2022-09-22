/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication11.service;

import java.util.List;
import javaapplication11.model.OrderDetail;
import javaapplication11.repository.OrderDetailRepository;

/**
 *
 * @author Nguyen Duy Hung
 */
public class OrderDetailService {
    private OrderDetailRepository orderDetailRepository;
    public OrderDetailService() {
        orderDetailRepository = new OrderDetailRepository();
    }
    public OrderDetail saveOrderDetail(OrderDetail orderDetail){
        return this.orderDetailRepository.saveOrderDetail(orderDetail);
    }
    public List<OrderDetail> getOrderDetail(int id){
        return this.orderDetailRepository.getOrderDetail(id);
    }
    public List<OrderDetail> getOrderDetailInMonth(){
        return this.orderDetailRepository.getOrderDetailInMonth();
    }
    public List<OrderDetail> getOrderDetailInYear(){
        return this.orderDetailRepository.getOrderDetailInYear();
    }
}
