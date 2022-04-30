
package entity;

import javax.persistence.*;

@Entity
@Table(name="Account")
public class Account {
 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="AccountId", nullable=false)
	public int accountId;
	
	@Column(name="AccountName")
	public String accountName;
	
	@Column(name="Balance")
    public float balance;

    public Account(int accountId, String accountName, float balance) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.balance = balance;

    }

    public Account() {
    }   
    
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountName=" + accountName +", balance=" + balance + "]";
	} 
}




