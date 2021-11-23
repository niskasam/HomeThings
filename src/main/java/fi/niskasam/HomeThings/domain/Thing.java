package fi.niskasam.HomeThings.domain;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Thing {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "Field is mandatory")
	private String title, description;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate due_date;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate reg_date;
	
	public Thing() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Thing(String title, String description, LocalDate due_date, LocalDate reg_date) {
		super();
		this.title = title;
		this.description = description;
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
