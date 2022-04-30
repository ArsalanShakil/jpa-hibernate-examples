

package entity;

import javax.persistence.*;

@Entity
@Table(name="Category")
public class Category {
 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CategoryId", nullable=false)
    public int categoryId;
	
	@Column(name="CategoryDescription")
    public String categoryDescription;
	


    public Category(int categoryId, String categoryDescription) {
        this.categoryId = categoryId;
        this.categoryDescription = categoryDescription;

    }

    public Category() {
    }   
    
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryDescription=" + categoryDescription +"]";
	} 
}




