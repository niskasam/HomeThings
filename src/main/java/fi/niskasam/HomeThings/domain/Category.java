package fi.niskasam.HomeThings.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.List;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long categoryid;
	private String name;
	
	// Yhden suhde moneen Thing entiteetin kanssa
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Thing> things;
	
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Category(long id, String name) {
		super();
		this.categoryid = id;
		this.name = name;
	}

	public long getId() {
		return categoryid;
	}
	public void setId(long id) {
		this.categoryid = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Category(long categoryid, String name, List<Thing> things) {
		super();
		this.categoryid = categoryid;
		this.name = name;
		this.things = things;
	}
	
	
	
	
}
