/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication11.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


/**
 *
 * @author Nguyen Duy Hung
 */
public class HBFactorySession implements AutoCloseable{
    private static SessionFactory sessionFactory;
    private static StandardServiceRegistry registry;
    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            try{
            registry = new StandardServiceRegistryBuilder().configure().build();
            MetadataSources sources = new MetadataSources(registry);
            Metadata metadata = sources.buildMetadata();
            sessionFactory = metadata.buildSessionFactory();
            }catch(Exception e){
                e.printStackTrace();
                if(registry != null){
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }

    @Override
    public void close() throws Exception {
        if(sessionFactory != null)
            sessionFactory.close();
        if(null != registry)
            StandardServiceRegistryBuilder.destroy(registry);
    }
}
