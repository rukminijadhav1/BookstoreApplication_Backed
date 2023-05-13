package com.bridgelabz.bookStore.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class OrderModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	private double price;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private long contact;
	private String pincode;
	private String type;
	private int quantity;
	@OneToOne
	private CartModel cart;
	

	public String getCity() {
		return city;
	}

	
	public void setCity(String city) {
		this.city = city;
	}


	public CartModel getcart() {
		return cart;
	}

	public void setCart(CartModel cart) {
		this.cart = cart;
	}

	public int getOrderId() {
		return orderId;
	}

	public double getPrice() {
		return price;
	}

	public String getAddress() {
		return address;
	}

	public long getContact() {
		return contact;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPincode() {
		return pincode;
	}

	public String getType() {
		return type;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
