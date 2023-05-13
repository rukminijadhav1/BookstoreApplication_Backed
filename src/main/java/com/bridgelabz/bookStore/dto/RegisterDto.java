package com.bridgelabz.bookStore.dto;

import org.springframework.stereotype.Component;
import com.bridgelabz.bookStore.model.CartModel;

@Component
public class RegisterDto {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private CartModel cartmodel;
	
	private boolean isLogin = false;
	private String role;
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
	public CartModel getCartmodel() {
		return cartmodel;
	}
	public boolean isLogin() {
		return isLogin;
	}
	public String getRole() {
		return role;
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
	public void setCartmodel(CartModel cartmodel) {
		this.cartmodel = cartmodel;
	}
	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public RegisterDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RegisterDto(String firstName, String lastName, String email, String password, CartModel cartmodel,
			boolean isLogin, String role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.cartmodel = cartmodel;
		this.isLogin = isLogin;
		this.role = role;
	}
	
	
	
	

}
