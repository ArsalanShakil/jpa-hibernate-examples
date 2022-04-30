package dao;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;

import entity.*;
import java.util.*;

public class Dao {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Harj1PU");

	
	public void addRegister(Register reg) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
        em.persist(reg);
        
        em.getTransaction().commit();
        em.close();
	}
	
	public void addEvent(int eventNumber, int regNumber, double amount) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
        Register reg = em.find(Register.class, regNumber);
        SalesEvent evt = new SalesEvent(eventNumber, reg, amount);
        
        em.persist(evt);
        
        em.getTransaction().commit();
        em.close();	
	}
	
	public List<SalesEvent> retrieveSmallSales(double limit) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<SalesEvent> result = null;
		// logic goes here
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<SalesEvent> cq = cb.createQuery(SalesEvent.class);
		Root<SalesEvent> seroot = cq.from(SalesEvent.class);
		cq.select(seroot);
		cq.where(cb.gt(seroot.get(SalesEvent_.amount), limit));
		
		TypedQuery<SalesEvent> q = em.createQuery(cq);
		result = q.getResultList();
		
		em.getTransaction().commit();
		em.close();
		return result;
	}
	
	public void addServiceFees(double serviceFees) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
		
		CriteriaBuilder cb = em.getCriteriaBuilder();;
		
        CriteriaUpdate<SalesEvent> update = cb.createCriteriaUpdate(SalesEvent.class);
        Root<SalesEvent>seroot = update.from(SalesEvent.class);
        update.set(seroot.get(SalesEvent_.amount),cb.sum(seroot.get(SalesEvent_.amount), serviceFees));
        em.createQuery(update).executeUpdate();
 
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteAllSalesEvent() {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaDelete<SalesEvent> delete = cb.createCriteriaDelete(SalesEvent.class);
        delete.from(SalesEvent.class);

        em.createQuery(delete).executeUpdate();
        em.getTransaction().commit();
		em.close();
	}
	

}
