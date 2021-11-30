package fi.niskasam.HomeThings.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Register {

	@NotEmpty(message = "Field username can not be empty")
	@Size(min = 4, max = 64, message = "Insert a username that is at least 4 characters long!")
	private String username = "";

	@NotEmpty(message = "Field password can not be empty")
	@Size(min = 6, max = 32, message = "Insert a password that is at least 6 characters long!")
	private String password = "";

	@NotEmpty(message = "Passwords need to match!")
	private String passwordCheck = "";

	@NotEmpty
	private String role = "USER";

	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Register(String username, String password, String passwordCheck, String role) {
		super();
		this.username = username;
		this.password = password;
		this.passwordCheck = passwordCheck;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordCheck() {
		return passwordCheck;
	}

	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
