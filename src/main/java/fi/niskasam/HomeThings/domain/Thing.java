package fi.niskasam.HomeThings.domain;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.xml.crypto.Data;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;



@Entity
public class Thing {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "categoryid")
	private Category category;
	
	// @Size määrittää kuinka pitkä min/max käyttäjän syöte saa olla
	@Size(min=3, max=20, message="You need to insert a title between 3 and 20 characters")
	private String title;
	@Size(min=3, max=2000, message="You need to insert a description between 3 and 2000 characters")
	private String description;
	
	// @DateTimeFormatilla pystyy määrittämään päivämäärän muodon
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Future(message="Insert future date")
	private LocalDate due_date;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate reg_date;
	
	public Thing() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Thing(String title, String description, Category category, LocalDate due_date, LocalDate reg_date) {
		super();
		this.title = title;
		this.description = description;
		this.category = category;
		this.due_date = due_date;
		this.reg_date = reg_date;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}


	public LocalDate getDue_date() {
		return due_date;
	}

	public void setDue_date(LocalDate due_date) {
		this.due_date = due_date;
	}

	public LocalDate getReg_date() {
		return reg_date;
	}

	public void setReg_date(LocalDate reg_date) {
		this.reg_date = reg_date;
	}
	
	

	
	

	


	
	
	

}
