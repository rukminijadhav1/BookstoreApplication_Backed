package com.bridgelabz.bookStore.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CartBookModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartbookId;
	
	private int quantity;
	
	private double price;

	@ManyToOne
	private BookModel books;

	@ManyToOne
	private CartModel cart;

	public int getCartbookId() {
		return cartbookId;
	}

	public void setCartbookId(int cartbookId) {
		this.cartbookId = cartbookId;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public CartModel getCart() {
		return cart;
	}

	public void setCart(CartModel cart) {
		this.cart = cart;
	}

	public BookModel getBooks() {
		return books;
	}

	public void setBooks(BookModel books) {
		this.books = books;
	}

}
