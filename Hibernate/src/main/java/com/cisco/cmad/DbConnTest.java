package com.cisco.cmad;

import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import java.util.*;


public class DbConnTest {
	
	public static void main (String args[]) {
	
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		Session session1 = sessionFactory.openSession();
		List<Users> userList = session1.createQuery("select u from Users u").list();
		System.out.println(userList);
		
		Users user = new Users();
		user.setName("Srini");
		user.setEmailId("srinkri2@cisco.com");
		user.setJoinDate(new Date());
		user.setAge(35);
		user.setState("KA");
		user.setPassword("Cisco123");
		
		Transaction tx=session1.beginTransaction();
		session1.save(user);
		tx.commit();
		
		session1.close();
		
		Session session2 = sessionFactory.openSession();
		List<Users> userListNew = session2.createQuery("select u from Users u").list();
		System.out.println(userListNew);
		session2.close();
	
	}
}

