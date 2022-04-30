package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.*;

public class Dao {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Dev");
	
	public void createCategory(Category category) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
        em.persist(category);
        em.getTransaction().commit();
        em.close();
	}	
	
	public void createAccount(Account account) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
        em.persist(account);
        em.getTransaction().commit();
        em.close();
	}
	

	
	public void createTransaction(Transaction transaction) {	
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		int idStart = transaction.sourceAccountId.accountId;
		int idEnd = transaction.destinationAccountId.accountId;

		Account accountStart = em.find(Account.class, idStart);  
		Account accountEnd = em.find(Account.class, idEnd);  
		
		float startBalance = accountStart.balance - transaction.amount;
		float endBalance = accountEnd.balance + transaction.amount;
		
		System.out.println(startBalance);
		System.out.println(endBalance);
		
		Account setAccEnd = new Account(accountStart.accountId,accountStart.accountName,startBalance); 
		Account setAccStart = new Account(accountEnd.accountId,accountEnd.accountName,endBalance); 

		em.merge(setAccEnd);
		em.merge(setAccStart);
		
        em.persist(transaction);
        em.getTransaction().commit();
        em.close();
	}

	
	
	public void getTransaction(int id) {
		
        EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Transaction transaction = em.find(Transaction.class, id); 
		Account accountSrc = em.find(Account.class, transaction.sourceAccountId.accountId); 
		Account accountDes = em.find(Account.class, transaction.destinationAccountId.accountId); 
		Category category = em.find(Category.class, transaction.categoryId.categoryId);
		
        em.getTransaction().commit();
        em.close();
        
        System.out.println("transaction description: "+transaction.description);
        
        if(accountSrc == null) {
            System.out.println("No source account");
        } else {
            System.out.println("source account: "+ accountSrc.accountName);
        }
        
        if(accountDes == null) {
            System.out.println("No destination account");
        } else {
            System.out.println("destination account: "+accountDes.accountName);
        }
        
        
        System.out.println("category name: "+category.categoryDescription);


	}
	
}
