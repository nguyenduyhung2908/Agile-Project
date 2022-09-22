/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication11.repository;

import java.util.List;
import javaapplication11.model.Order;
import javaapplication11.model.OrderDetail;
import javaapplication11.model.Products;
import javaapplication11.util.HBFactorySession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

/**
 *
 * @author Nguyen Duy Hung
 */
public class OrderRepository {
    public int countOrders(){
        SessionFactory sessionFactory = HBFactorySession.getSessionFactory();
        Session session = sessionFactory.openSession();
        int quantityOrder = 0;
        try{
            Query query = session.createNativeQuery("select count(*) from orders").addEntity(Products.class);
            quantityOrder = Integer.parseInt(query.uniqueResult().toString());
            session.beginTransaction().commit();
        } catch(Exception ex){
            session.getTransaction().rollback();
        } finally{
            if(session!=null){
                session.close();
            }
        }
        return quantityOrder;
    }
    
    public Order saveOrder(Order order){
        SessionFactory sessionFactory = HBFactorySession.getSessionFactory();
        Session session = sessionFactory.openSession();
        int quantityOrder = 0;
        try{
            session.save("orders", order);
            session.beginTransaction().commit();
        } catch(Exception ex){
            session.getTransaction().rollback();
        } finally{
            if(session!=null){
                session.close();
            }
        }
        return order;
    }
    public List<Order> getAllOrder(){
        SessionFactory sessionFactory = HBFactorySession.getSessionFactory();
        Session session = sessionFactory.openSession();
        try{
            Query<Order> query = session.createNativeQuery("SELECT * FROM orders").addEntity(Order.class);
            List<Order> listOrders = query.list();
            session.beginTransaction().commit();
            return listOrders;
        } catch(Exception ex){
            session.getTransaction().rollback();
        } finally{
            if(session!=null){
                session.close();
            }
        }
        return null;
    }
    public Order findOrderById(int id){
        SessionFactory sessionFactory = HBFactorySession.getSessionFactory();
        Session session = sessionFactory.openSession();
        try{
            Order order = session.get(Order.class, id);
            session.beginTransaction().commit();
            return order;
        } catch(Exception ex){
            session.getTransaction().rollback();
        } finally{
            if(session!=null){
                session.close();
            }
        }
        return null;
    }
    public List<Order> getAllOrderInMonth(){
        SessionFactory sessionFactory = HBFactorySession.getSessionFactory();
        Session session = sessionFactory.openSession();
        try{
            Query<Order> query = session.createNativeQuery("SELECT * FROM orders where year(createdAt) = year(now()) and month(createdAt) = month(now())").addEntity(Order.class);
            List<Order> listOrders = query.list();
            session.beginTransaction().commit();
            return listOrders;
        } catch(Exception ex){
            session.getTransaction().rollback();
        } finally{
            if(session!=null){
                session.close();
            }
        }
        return null;
    }
    public List<Order> getAllOrderInYear(){
        SessionFactory sessionFactory = HBFactorySession.getSessionFactory();
        Session session = sessionFactory.openSession();
        try{
            Query<Order> query = session.createNativeQuery("SELECT * FROM orders where year(createdAt) = year(now())").addEntity(Order.class);
            List<Order> listOrders = query.list();
            session.beginTransaction().commit();
            return listOrders;
        } catch(Exception ex){
            session.getTransaction().rollback();
        } finally{
            if(session!=null){
                session.close();
            }
        }
        return null;
    }
    public boolean deleteOrder(Order oder){
        SessionFactory sessionFactory = HBFactorySession.getSessionFactory();
        Session session = sessionFactory.openSession();
        try{
            session.delete("orders",oder);
            session.beginTransaction().commit();
            return true;
        } catch(Exception ex){
            session.getTransaction().rollback();
        } finally{
            if(session!=null){
                session.close();
            }
        }
        return false;
    }
    public int deleteOrderById(int id){
        SessionFactory sessionFactory = HBFactorySession.getSessionFactory();
        Session session = sessionFactory.openSession();
        int aff = -1;
        try{
            session.beginTransaction();
            NativeQuery query = session.createNativeQuery("delete from order_products where id_order = ?",OrderDetail.class);
            query.setParameter(1, id);
            aff = query.executeUpdate();
            session.getTransaction().commit();
        } catch(Exception ex){
            session.getTransaction().rollback();
        } finally{
            if(session!=null){
                session.close();
            }
        }
        return aff;
    }
}
