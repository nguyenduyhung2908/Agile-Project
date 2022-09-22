/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication11.service;

import java.util.List;
import javaapplication11.model.Employees;
import javaapplication11.repository.EmployeeRepository;

/**
 *
 * @author Nguyen Duy Hung
 */
public class EmployeeService {
    private EmployeeRepository repository;

    public EmployeeService() {
        repository = new EmployeeRepository();
    }
    
    public boolean addEmployee(Employees e) {
        return this.repository.addEmployee(e);
    }
    public List<Employees> getAllEmployees(){
        return this.repository.getAllEmployees();
    }
    public Employees getEmployeeByID(int id){
        return this.repository.getEmployeeById(id);
    }
    public boolean deleteEmployees(int id){
        return this.repository.deleteEmployees(id);
    }
    public boolean updateEmployees(Employees e){
        return this.repository.updateEmployees(e);
    }
    public Employees getEmployeeForLogin(String email, String pass){
        return this.repository.getEmployeeForLogin(email, pass);
    }
}
