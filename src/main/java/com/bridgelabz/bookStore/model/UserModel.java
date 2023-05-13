package com.bridgelabz.bookStore.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class UserModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL)
	private CartModel cartmodel;
	
	private boolean isLogin = false;
	
	private String role;
	
	
	public int getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public boolean isLogin() {
		return isLogin;
	}
	public String getRole() {
		return role;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public CartModel getCartmodel() {
		return cartmodel;
	}
	public void setCartmodel(CartModel cartmodel) {
		this.cartmodel = cartmodel;
	}
	
	
	
	

}
