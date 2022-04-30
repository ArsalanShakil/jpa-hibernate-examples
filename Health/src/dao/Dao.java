package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.*;

public class Dao {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Dev");
	
	public void createClinic(Clinic clinic) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
        em.persist(clinic);
        em.getTransaction().commit();
        em.close();
	}	
	public void createCustomer(Customer customer, BasicProfile basicProfile) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
        em.persist(customer);
        em.persist(basicProfile);
        em.getTransaction().commit();
        em.close();
	}	
	
}
