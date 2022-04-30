package application;

import entity.*;

import java.util.Date;

import dao.*;

public class FinanceTest {

    public static void main(String[] args) {
    	
    	Dao dao = new Dao();
    	
    	// Generate a few categories (food, leisure, school, gifts, internal transfer etc.).
        Category l1 = new Category(0, "food");
        dao.createCategory(l1);
        Category l2 = new Category(0, "leisure");
        dao.createCategory(l2);
        Category l3 = new Category(0, "school");
        dao.createCategory(l3);
        Category l4 = new Category(0, "gifts");
        dao.createCategory(l4);
        Category l5 = new Category(0, "internal transfer ");
        dao.createCategory(l5);
        
        
        // Generate a savings account with a € 400.00 balance.
        Account account1 = new Account(0, "savings account", 400.00f);
        dao.createAccount(account1);
        
        
        //  Generate a wallet with a € 14.50 balance.
        Account account2 = new Account(0, "wallet", 14.50f);
        dao.createAccount(account2);
        
        
        
        //  Receive a gift of € 100.00 from Aunt Mary to the savings account.
        
        Account nullAccount = new Account(); //created a null account 
        dao.createAccount(nullAccount);

        
        Transaction transaction1 = new Transaction(0, 100.00f, "gift of € 100.00 from Aunt Mary",new Date(),l4,nullAccount,account1 );
        dao.createTransaction(transaction1);
        
        
        // Transfer € 40.00 from the savings account to the wallet
        Transaction transaction2 = new Transaction(0, 40.00f, "Transfer € 40.00 from the savings account to the wallet",new Date(),l5,account1,account2 );
        dao.createTransaction(transaction2);
        
        // Spend € 8.40 from the wallet in the pub
        Transaction transaction3 = new Transaction(0, 8.40f, "Spend € 8.40 from the wallet in the pub",new Date(),l1,account2,nullAccount);
        dao.createTransaction(transaction3);
        
        System.out.println("Device saved.");
        
    }
}

