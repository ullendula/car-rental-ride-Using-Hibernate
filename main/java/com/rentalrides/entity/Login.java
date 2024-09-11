package com.rentalrides.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Login")
public class Login {

	@Id
	@Column(name = "Email")
	String Email;
	@Column(name = "password")
	String Password;

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	@Override
	public String toString() {
		return "Login [Email=" + Email + ", Password=" + Password + "]";
	}

	public Login(String email, String password) {
		super();
		Email = email;
		Password = password;
	}

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean loginUser(Login loginUser) {
		// TODO Auto-generated method stub
		return false;
	}

}
