package entity;
import javax.persistence.*;

@Entity
@Table(name="BasicProfile")
public class BasicProfile {


	@Id
	@Column(name="profileId", nullable=false)
    public int profileId;
	
	@Column(name="birthyear")
    public int birthyear;
	
	@Column(name="weight")
	public float weight;
	
	@Column(name="height")
	public float height;
	
	
	//FK
    @JoinColumn(name = "custId")
    @OneToOne(optional=false)
    @MapsId
    public Customer custId;
	



    public BasicProfile(int birthyear, float weight,float height, Customer custId) {
         this.birthyear = birthyear;
         this.weight = weight;
         this.height = height;
         this.custId = custId;
    }   
    
	@Override
	public String toString() {
		return " BasicProfile (" + profileId + birthyear + weight + height + custId + ")";
	} 
}