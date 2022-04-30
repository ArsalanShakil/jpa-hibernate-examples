package application;

import dao.Dao;
import entity.*;

public class HealthTest {

    public static void main(String[] args) {
    	
    	Dao dao = new Dao();

    	Clinic l1 = new Clinic(0, "Heslinki");
    	dao.createClinic(l1);

    	Customer l2 = new Customer(0, "Arsalan","Shakil");

    	BasicProfile l3 = new BasicProfile(2000, 65.0f,179.0f,l2);
    	dao.createCustomer(l2,l3);
        
    }
}

