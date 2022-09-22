/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication11.repository;

import java.util.ArrayList;
import java.util.List;
import javaapplication11.model.Categories;
import javaapplication11.util.HBFactorySession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 *
 * @author Nguyen Duy Hung
 */
public class CategoryRepository {
    public List<Categories> getAllCategories(){
        SessionFactory sessionFactory = HBFactorySession.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Categories> listCategories = null;
        try{
            Query query = session.createNativeQuery("select * from categories").addEntity(Categories.class);
            listCategories = query.list();
            session.beginTransaction().commit();
        } catch(Exception ex){
            session.getTransaction().rollback();
        } finally{
            if(session!=null){
                session.close();
            }
        }
        return listCategories;
    }
}
