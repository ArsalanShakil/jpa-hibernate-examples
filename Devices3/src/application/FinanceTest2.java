package application;

import dao.*;
import java.util.*;  


public class FinanceTest2 {

    public static void main(String[] args) {
    	
    	Dao dao = new Dao();
    	Scanner input= new Scanner(System.in);    //System.in is a standard input stream  

    	int transactionId= input.nextInt();  
    	dao.getTransaction(transactionId);

    	input.close();
        
    }
}

