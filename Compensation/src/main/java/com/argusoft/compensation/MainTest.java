package com.argusoft.compensation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainTest {

    public static void main(String[] args) {
        Address address;
        address = new Address();
        address.setCity("rajkot");
        address.setState("Gujrat");
        address.setCountry("india");
        User user = new User();
        user.setId(10);
        user.setActive("true");
        user.setUsername("Helisha");
        user.setLastname("Sangani");
        user.setPassword("123");
        user.setDob(new Date());
        user.setX(50);
        user.setAddress(address);
//        List<Role> roles=user.getRoles();

        Role role = new Role();
        role.setId(1);
        role.setRole("user");

//        roles.add(role);
        Role role2 = new Role();
        role2.setId(2);
        role2.setRole("admin");
//        roles.add(role2);
        Role_User role_User = new Role_User();

//        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
//  
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
//        Session session = sf.openSession();
        Configuration con = new Configuration().configure();
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(user);
        session.save(role);
        session.save(role2);
//        session.save(role_User)
        tx.commit();
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        User u = (User) session.get(User.class, 1);
        System.out.println("\n\n" + u + "  \n");
        tx.commit();
    }

}
