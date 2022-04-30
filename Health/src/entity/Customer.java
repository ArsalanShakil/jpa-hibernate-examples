package entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name="Customer")
public class Customer{
 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="custId", nullable=false)
	public int custId;
	
	@Column(name="firstName")
	public String firstName;
	
	@Column(name="lastName")
    public String lastName;
	
	@ManyToMany(mappedBy="customers")
	private List<Clinic> clinics = new ArrayList<Clinic>();

    public Customer(int custId, String firstName, String lastName) {
        this.custId = custId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer() {
    }   
    
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", firstName=" + firstName +", lastName=" + lastName + "]";
	} 
}
