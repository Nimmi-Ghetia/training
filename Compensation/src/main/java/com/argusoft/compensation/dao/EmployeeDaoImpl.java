/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.compensation.dao;

import com.argusoft.compensation.model.Employee;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author helisha
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public void addEmployee(Employee e) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(e);
        tx.commit();

    }

    @Override
    public void updateEmployee(Employee e) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(e);
        tx.commit();
    }

    @Override
    public void deleteEmployee(int id) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Criteria cr = session.createCriteria(Employee.class);
        cr.add(Restrictions.eq("id",id));
        session.delete(cr.list().get(0));
        tx.commit();
    }

    @Override
    public Employee getEmployee(int id) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Criteria cr = session.createCriteria(Employee.class);
        cr.add(Restrictions.eq("id",id));
        Employee e = (Employee) cr.list().get(0);
        tx.commit();
        return e;
    }

    @Override
    public List<Employee> getAllEmployees() {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Criteria cr = session.createCriteria(Employee.class);
        List<Employee> e = cr.list();
        tx.commit();
        return e;
    }

}
