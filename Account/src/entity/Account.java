package entity;
import javax.persistence.*;

@Entity
@Table(name="Account")
public class Account {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="number")
	private int number;
	
	
	@Column(name="balance")
    @Convert(converter = DoubleConverter.class)
	private double balance;
	
	@Version
	private long version;
	
	
	public Account() {
		super();
	}

	public Account(int number, double balance) {
		super();
		this.number = number;
		this.balance = balance;
	}
	
	public int getId() {
		return number;
	}
	public void setId(int number) {
		this.number = number;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [number=" + number + ", balance=" + balance + "]";
	}
	

}
