
package entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="ContractCustomer")
public class ContractCustomer extends Customer{
 
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="contractId", nullable=true)
	public int contractId;
	
	@Column(name="startDate")
	public Date startDate;
	
	@Column(name="endDate")
    public Date endDate;

    public ContractCustomer(int contractId, Date startDate, Date endDate) {
        this.contractId = contractId;
        this.startDate = startDate;
        this.endDate = endDate;

    }

    public ContractCustomer() {
    }   
    
	@Override
	public String toString() {
		return "ContractCustomer [contractId=" + contractId + ", startDate=" + startDate +", endDate=" + endDate + "]";
	} 
}




