package com.bridgelabz.bookStore.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class CartModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int cartId;
	
	
	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}


	

}
