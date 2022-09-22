/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication11.repository;

import java.util.List;
import javaapplication11.model.OrderDetail;
import javaapplication11.util.HBFactorySession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 *
 * @author Nguyen Duy Hung
 */
public class OrderDetailRepository {
    public OrderDetail saveOrderDetail(OrderDetail orderDetail){
        SessionFactory sessionFactory = HBFactorySession.getSessionFactory();
        try(Session session = sessionFactory.openSession()){
            session.save("order_products", orderDetail);
            session.beginTransaction().commit();
        }catch(Exception ex){
            return null;
        }
        return orderDetail;
    }
    public List<OrderDetail> getOrderDetail(int id){
        SessionFactory sessionFactory = HBFactorySession.getSessionFactory();
        try(Session session = sessionFactory.openSession()){
            Query<OrderDetail> query = session.createNativeQuery("select * from order_products where id_order = ?").addEntity(OrderDetail.class);
            query.setParameter(1, id);
            List<OrderDetail> listOrderDetail = query.list();
            session.beginTransaction().commit();
            return listOrderDetail;
        }catch(Exception ex){
            return null;
        }
    }
    public List<OrderDetail> getOrderDetailByProduct(int id){
        SessionFactory sessionFactory = HBFactorySession.getSessionFactory();
        try(Session session = sessionFactory.openSession()){
            Query<OrderDetail> query = session.createNativeQuery("select o.id_product,sum(quantity) from order_products o join o.orderDetailId.order"
                    + "where and year(createdAt) = year(now()) and month(createdAT) = month(now()) and o.id_product = ? "
                    + "group by o.id_product ").addEntity(OrderDetail.class);
            query.setParameter(1, id);
            List<OrderDetail> listOrderDetail = query.list();
            session.beginTransaction().commit();
            return listOrderDetail;
        }catch(Exception ex){
            return null;
        }
    }
    public List<OrderDetail> getOrderDetailInMonth(){
        SessionFactory sessionFactory = HBFactorySession.getSessionFactory();
        try(Session session = sessionFactory.openSession()){
            Query<OrderDetail> query = session.createNativeQuery("select od.id_product,od.id_order,sum(od.quantity) as quantity from order_products as od join orders as o on od.id_order = o.id "
                    + "where year(o.createdAt) = year(now()) and month(o.createdAT) = month(now()) group by od.id_product",OrderDetail.class);
            List<OrderDetail> listOrderDetail = query.list();
            session.beginTransaction().commit();
            return listOrderDetail;
        }catch(Exception ex){
            return null;
        }
    }
    public List<OrderDetail> getOrderDetailInYear(){
        SessionFactory sessionFactory = HBFactorySession.getSessionFactory();
        try(Session session = sessionFactory.openSession()){
            Query<OrderDetail> query = session.createNativeQuery("select od.id_product,od.id_order,sum(od.quantity) as quantity from order_products as od join orders as o on od.id_order = o.id "
                    + "where year(o.createdAt) = year(now()) group by od.id_product",OrderDetail.class);
            List<OrderDetail> listOrderDetail = query.list();
            session.beginTransaction().commit();
            return listOrderDetail;
        }catch(Exception ex){
            return null;
        }
    }
}
