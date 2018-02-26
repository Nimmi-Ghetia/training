/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.compensation.service;

import com.argusoft.compensation.model.Employee;
import java.util.List;

public interface EmployeeService {
    
    public void addEmployee(Employee e);
    public void updateEmployee(Employee e);
    public void deleteEmployee(int id);
    public Employee getEmployee(int id);
    public List<Employee> getAllEmployees();
    
   
}
