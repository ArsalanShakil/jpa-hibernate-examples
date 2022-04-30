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

	
	public void saveAccount(Account account) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
        em.persist(account);
        em.getTransaction().commit();
        em.close();
	}	
	
	public void loadAccount(int number) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Account device = em.find(Account.class, number); 
        em.getTransaction().commit();
        em.close();
        System.out.println(device.getBalance());

	}
	
	public void transfer(int sourceAccountNumber, int destinationAccountNumber, double amount) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		

		Account accountStart = em.find(Account.class, sourceAccountNumber);  
		Account accountEnd = em.find(Account.class, destinationAccountNumber);  
		
		double startBalance = accountStart.getBalance() - amount;
		double endBalance = accountEnd.getBalance() + amount;
				
		Account setAccEnd = new Account(accountStart.getId(),startBalance); 
		Account setAccStart = new Account(accountEnd.getId(),endBalance); 

		em.merge(setAccEnd);
		em.merge(setAccStart);

        em.getTransaction().commit();
        em.close();

	}
	

}
