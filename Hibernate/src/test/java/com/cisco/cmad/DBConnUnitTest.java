package com.cisco.cmad;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.BeforeClass;
import org.junit.Test;
import junit.framework.Assert;

public class DBConnUnitTest {
	
	private static SessionFactory sf;
	
	@BeforeClass
	public static void initHibernate(){
		//initHibernate Code
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sf = configuration.buildSessionFactory(serviceRegistry);
		
	}
	
/*	@Test
	public void testCount(){
		int x=3+4;
		Assert.assertEquals(7, x);
	}
*/

	public void testUserLoading(){
		
		Session session = sf.openSession();
		List<Users> userList = session.createQuery("select u from Users u").list();
		for(Users user : userList)
			System.out.println(user);
		
		session.close();
	}
	
/*	public void testUserDel(){
		
		Session session = sf.openSession();
		
		List<Users> userList = session.createQuery("select u from Users u").list();
		for (Users user : userList){
			if (user.getId()>200) {
				session.delete(user);
				Transaction tx=session.beginTransaction();
				session.save(user);
				tx.commit();
			}
		}

		session.close();
		
	} */
	
	public void testUserDelId(int id){
		
		Session session = sf.openSession();
		
		Users user = new Users();
		user.setId(id);

		
		Transaction tx=session.beginTransaction();
		session.delete(user);
		tx.commit();

		session.close();
		
	}


/*	public void testLastUserId(){
		
		Session session = sf.openSession();
		
		List<Users> userList = session.createQuery("select u from Users u").list();
		Users user = new Users();
		user.setId(id);

		session.close();
		
	}*/
	
	public void testUserAdd(){
		
		Users user = new Users();
		user.setName("Srini");
		user.setEmailId("srinkri2@cisco.com");
		user.setJoinDate(new Date());
		user.setAge(35);
		user.setState("KA");
		user.setPassword("Cisco123");
		
		Session session = sf.openSession();
		
		Transaction tx=session.beginTransaction();
		session.save(user);
		tx.commit();
		
		List<Users> userList = session.createQuery("select u from Users u").list();
		System.out.println(userList);
		
		session.close();
		
	}
	
	@Test
	public void test(){
		testUserLoading();
//		testUserDel();
		for (i=1;i< )
		testUserDelId(201);
		testUserDelId(202);
		testUserDelId(203);
		testUserDelId(204);
		testUserDelId(205);
		testUserDelId(206);
		testUserAdd();
		testUserLoading();
		
	}

}
