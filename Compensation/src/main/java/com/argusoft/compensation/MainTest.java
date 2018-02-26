package com.argusoft.compensation;

import com.argusoft.compensation.model.Roles;
import com.argusoft.compensation.model.Address;
import com.argusoft.compensation.model.User;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import static org.hibernate.cfg.AttributeConverterDefinition.from;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

public class MainTest {

    @PersistenceContext
    static EntityManager em;
final static Logger logger= Logger.getLogger("MyLogger");
    public static void main(String[] args) {
   
        logger.info("This is my first log4j's statement");
        Address address;
        address = new Address();
        
        address.setCity("rajkot");
        address.setState("Gujrat");
//        address.setCountry("india");
        User user = new User();
        user.setId(3);
        user.setActive("true");
        user.setUsername("Helisha");
        user.setLastname("Sangani");
        user.setPassword("123");
        user.setDob(new Date());
        user.setX(50);
        user.setAddress(address);
//        List<Role> roles=user.getRoles();

        Roles role = new Roles();
        role.setId(1);
        role.setRole("user");

//        roles.add(role);
        Roles role2 = new Roles();
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
//        session.save(user);
//        session.save(role);
//        session.save(role2);
//        session.save(role_User)
        tx.commit();
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        User u = (User) session.get(User.class, 4);

//        System.out.println("\n\n" + u + "\n");
        tx.commit();

        session = sessionFactory.openSession();
        tx = session.beginTransaction();
//        CriteriaQuery<User> cq = em.getCriteriaBuilder().createQuery(User.class);
//        Root<User> from= cq.from(User.class);
//        cq.select(from);
//        cq.where(em.getCriteriaBuilder().equal(from.get("user1_username"),"Honey")); // <- this will add the restriction. 
//
////        cq.groupBy();
//        List<User> results = em.createQuery(cq).getResultList();
//        System.out.println("\n\n Answer : \n" + results + "\n");
        try {
            Criteria cr = session.createCriteria(User.class);
            LogicalExpression or = Restrictions.or(Restrictions.eq("username", "Helisha"), Restrictions.eq("username", "Honey"));//,Restrictions.eq("salary", new BigDecimal(30000))
            cr.add(or);
            cr.addOrder(Order.desc("salary"));
            cr.setProjection(Projections.rowCount());

//        cr.setFirstResult(3);
//        cr.setMaxResults(5);
            List results = cr.list();
            for (Object i : results) {
                System.out.println("\n " + i);
            }
//        System.out.println("\n\n"+cr.list()); 

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        logger.info("\nThis is my first log4j's statement2");

    }
}
