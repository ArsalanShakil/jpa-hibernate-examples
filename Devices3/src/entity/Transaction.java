
package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="Transaction")
public class Transaction implements Serializable {
 
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TransactionId", nullable=false)
    public int transactionId;
	
	@Column(name="Amount")
    public float amount;
	
	@Column(name="Description")
	public String description;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="Timestamp")
	public Date timestamp;
	
	
	
	
	//FK

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CatergoryId")
    public Category categoryId;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = true,name = "SourceAccountId")
    public Account sourceAccountId;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = true,name = "DestinationAccountId")
    public Account destinationAccountId;
	

    public Transaction(int transactionId, float amount, String description,Date timestamp,Category categoryId,Account sourceAccountId,Account destinationAccountId  ) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.description = description;
        this.timestamp = timestamp;
        this.categoryId = categoryId;
        this.sourceAccountId = sourceAccountId;
        this.destinationAccountId = destinationAccountId;

    }

    public Transaction() {
    }   
    
	@Override
	public String toString() {
		return " Transaction (" + transactionId + amount + description + timestamp + categoryId + sourceAccountId + destinationAccountId + ")";
	} 
}