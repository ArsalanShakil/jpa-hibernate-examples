package application;

import entity.*;
import dao.*;

public class KassaApp {


	
    public static void main(String[] args) {
    	
    	Dao dao = new Dao();
    	
    	Account l1 = new Account(0,29.10);
    	dao.saveAccount(l1);
    	
    	Account l2 = new Account(0,30.10);
    	dao.saveAccount(l2);
    	
    	dao.loadAccount(1);
    	dao.loadAccount(2);

    	dao.transfer(l1.getId(), l2.getId(), 10.10);
    	
    	dao.loadAccount(1);
    	dao.loadAccount(2);

    	
    }
}

