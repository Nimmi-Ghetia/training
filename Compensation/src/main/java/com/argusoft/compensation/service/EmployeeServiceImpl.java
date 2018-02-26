/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.compensation.service;

import com.argusoft.compensation.dao.EmployeeDao;
import com.argusoft.compensation.model.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeDao employeeDao;
    
    @Override
    public void addEmployee(Employee e) {
        employeeDao.addEmployee(e);
        employeeDao.addEmployee(e);
    }

    @Override
    public void updateEmployee(Employee e) {
            employeeDao.updateEmployee(e);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeDao.deleteEmployee(id);
    }

    @Override
    public Employee getEmployee(int id) {
        return employeeDao.getEmployee(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }
    
}
