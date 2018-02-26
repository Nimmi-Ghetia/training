/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.compensation.controller;

import com.argusoft.compensation.model.Employee;
import com.argusoft.compensation.service.EmployeeService;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class EmployeeController {

    final static Logger logger = Logger.getLogger("MyLogger1");

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(@RequestBody Employee e) {
        employeeService.addEmployee(e);
        logger.info("\nEmployee added");
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void update(@RequestBody Employee e) {
        employeeService.updateEmployee(e);
        logger.info("\nEmployee updated");
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(@RequestBody int id) {
        employeeService.deleteEmployee(id);
        logger.info("\nEmployee deleted");
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public Employee get(@RequestBody int id) {
        return employeeService.getEmployee(id);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Employee> getall() {
        logger.info("\nEmployee got");
        return employeeService.getAllEmployees();
    }
}
