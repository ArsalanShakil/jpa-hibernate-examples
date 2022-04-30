package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.*;

public class Dao {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("DevPU");

	public void saveDevice(Device device) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
        em.persist(device);
        em.getTransaction().commit();
        em.close();
	}	
	
	public void loadDevice(int deviceId) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Device device = em.find(Device.class, deviceId); 
        em.getTransaction().commit();
        em.close();
        System.out.println(device);

	}
	public boolean updateDeviceDescription(int id, String newDescription) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Device device = new Device(id, newDescription);
		em.merge(device);
        em.getTransaction().commit();
        em.close();
        return true;
	}
	
	public void deleteDevice(int id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Device device = em.find(Device.class, id); 
		em.remove(device);
        em.getTransaction().commit();
        em.close();
	}
	
}
