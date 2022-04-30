package entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Clinic")
public class Clinic {
 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="clinicId", nullable=false)
    public int clinicId;
	
	@Column(name="location")
    public String location;
	
	@ManyToMany(fetch=FetchType.LAZY)
	private List<Customer> customers = new ArrayList<Customer>();

    public Clinic(int clinicId, String location) {
        this.clinicId = clinicId;
        this.location = location;

    }

    public Clinic() {
    }   
    
	@Override
	public String toString() {
		return "Clinic [clinicId=" + clinicId + ", location=" + location +"]";
	} 
}




