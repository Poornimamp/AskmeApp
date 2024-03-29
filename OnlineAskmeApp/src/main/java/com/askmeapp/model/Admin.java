package com.askmeapp.model;

import java.util.Objects;

public class Admin {
	private String name;
	private String emailId;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(String name, String emailId, String password) {
		super();
		this.name = name;
		this.emailId = emailId;
		this.password = password;
	}
	@Override
	public int hashCode() {
		return Objects.hash(emailId, name, password);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		return Objects.equals(emailId, other.emailId) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password);
	}
	
  	
	
}
