package com.rentalrides.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "Register")
public class Register {

	@Column(name = "Username")
	String Username;
	@Id
	@Column(name = "Email")
	String Email;
	@Column(name = "password")
	String Password;

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

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
		return "Register [Username=" + Username + ", Email=" + Email + ", Password=" + Password + "]";
	}

	public Register(String username, String email, String password) {
		super();
		Username = username;
		Email = email;
		Password = password;
	}

	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

}
