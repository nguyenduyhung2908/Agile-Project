/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication11.repository;

import java.util.ArrayList;
import java.util.List;
import javaapplication11.model.Employees;
import javaapplication11.util.HBFactorySession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 *
 * @author Nguyen Duy Hung
 */
public class EmployeeRepository {

    public Employees getEmployeeById(int id) {
        Session session = null;
        SessionFactory sessionFactory = HBFactorySession.getSessionFactory();
        Employees employees = null;
        try {
            session = sessionFactory.openSession();
            employees = session.get(Employees.class, id);
            session.beginTransaction().commit();
        } catch (Exception ex) {
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return employees;
    }

    public boolean addEmployee(Employees e) {
        Session session = null;
        SessionFactory sessionFactory = HBFactorySession.getSessionFactory();
        try {
            session = sessionFactory.openSession();
            session.persist(e);
            session.beginTransaction().commit();
        } catch (Exception ex) {
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return true;
    }

    public List<Employees> getAllEmployees() {
        List<Employees> list = new ArrayList<>();
        Session session = null;
        SessionFactory sessionFactory = HBFactorySession.getSessionFactory();
        try {
            session = sessionFactory.openSession();
            Query<Employees> query = session.createNativeQuery("select * from employees", Employees.class);
            list = query.list();
            session.beginTransaction().commit();
        } catch (Exception ex) {

        } finally {
            if (session != null) {
                session.close();
            }
        }
        return list;
    }

    public boolean updateEmployees(Employees e) {
        SessionFactory sessionFactory = HBFactorySession.getSessionFactory();
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.update("employees", e);
            session.beginTransaction().commit();
            return true;
        } catch (Exception ex) {
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public boolean deleteEmployees(int id) {
        SessionFactory sessionFactory = HBFactorySession.getSessionFactory();
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query<Employees> query = session.createNativeQuery("delete from employees where id = :id", Employees.class);
            query.setParameter("id", id);
            int deleted = query.executeUpdate();
            session.beginTransaction().commit();
            return true;
        } catch (Exception ex) {
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Employees getEmployeeForLogin(String email, String pass) {
        SessionFactory sessionFactory = HBFactorySession.getSessionFactory();
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query<Employees> query = session.createNativeQuery("select * from employees where email =? limit 1", Employees.class);
            List<Employees> employees = new ArrayList<>();
            employees = query.setParameter(1, email).list();
            if (employees.size() >= 1) {
                Employees e = employees.get(0);
                return e;
            }
            session.beginTransaction().commit();
        } catch (Exception ex) {
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }
    
}
