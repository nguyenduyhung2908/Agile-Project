/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication11.repository;

import java.util.List;
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
public class ProductRepository {
    public List<Products> getAllProducts(){
        SessionFactory sessionFactory = HBFactorySession.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Products> listProducts = null;
        try{
            Query query = session.createNativeQuery("select * from products order by id desc").addEntity(Products.class);
            listProducts = query.list();
            session.beginTransaction().commit();
        } catch(Exception ex){
            session.getTransaction().rollback();
        } finally{
            if(session!=null){
                session.close();
            }
        }
        return listProducts;
    }
    public boolean updateProducts(Products products){
        SessionFactory sessionFactory = HBFactorySession.getSessionFactory();
        Session session = sessionFactory.openSession();
        try{
            session.update("products", products);
            session.beginTransaction().commit();
        } catch(Exception ex){
            session.getTransaction().rollback();
            return false;
        } finally{
            if(session!=null){
                session.close();
            }
        }
        return true;
    }
    public int deleteProdcutsById(int id){
        SessionFactory sessionFactory = HBFactorySession.getSessionFactory();
        Session session = sessionFactory.openSession();
        int aff = -1;
        try{
            session.beginTransaction();
            NativeQuery query = session.createNativeQuery("delete from order_products where id_product = ?",OrderDetail.class);
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
    public boolean deleteProducts(Products products){
        SessionFactory sessionFactory = HBFactorySession.getSessionFactory();
        Session session = sessionFactory.openSession();
        try{
            session.delete(products);
            session.beginTransaction().commit();
        } catch(Exception ex){
            session.getTransaction().rollback();
            return false;
        } finally{
            if(session!=null){
                session.close();
            }
        }
        return true;
    }
    public Products saveProducts(Products products){
        SessionFactory sessionFactory = HBFactorySession.getSessionFactory();
        Session session = sessionFactory.openSession();
        try{
            session.save(products);
            session.beginTransaction().commit();
        } catch(Exception ex){
            session.getTransaction().rollback();
        } finally{
            if(session!=null){
                session.close();
            }
        }
        return products;
    }
    public List<Products> searchProductsByName(String name){
        SessionFactory sessionFactory = HBFactorySession.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Products> listProducts = null;
        try{
            Query query = session.createNativeQuery("select * from products where name like :name").addEntity(Products.class);
            query.setParameter("name", name);
            listProducts = query.list();
            session.beginTransaction().commit();
        } catch(Exception ex){
            session.getTransaction().rollback();
        } finally{
            if(session!=null){
                session.close();
            }
        }
        return listProducts;
    }
    public List<Products> getAllOrderInMonth(){
        SessionFactory sessionFactory = HBFactorySession.getSessionFactory();
        Session session = sessionFactory.openSession();
        try{
            Query<Products> query = session.createNativeQuery("SELECT * FROM products where year(createdAt) = year(now()) and month(createdAT) = month(now())").addEntity(Products.class);
            List<Products> listProducts = query.list();
            session.beginTransaction().commit();
            return listProducts;
        } catch(Exception ex){
            session.getTransaction().rollback();
        } finally{
            if(session!=null){
                session.close();
            }
        }
        return null;
    }
    public List<Products> getAllOrderInYear(){
        SessionFactory sessionFactory = HBFactorySession.getSessionFactory();
        Session session = sessionFactory.openSession();
        try{
            Query<Products> query = session.createNativeQuery("SELECT * FROM products where year(createdAt) = year(now())").addEntity(Products.class);
            List<Products> listProducts = query.list();
            session.beginTransaction().commit();
            return listProducts;
        } catch(Exception ex){
            session.getTransaction().rollback();
        } finally{
            if(session!=null){
                session.close();
            }
        }
        return null;
    }
}
