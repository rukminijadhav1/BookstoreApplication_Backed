package com.bridgelabz.bookStore.dto;

import org.springframework.stereotype.Component;

@Component
public class OrderDto {
	
	private String firstName;
	private String lastName;
	private String address;
	private String pincode;
	private String type;
	
	private long contact;
	private int quantity;
	private String city;

	public String getAddress() {
		return address;
	}

	public long getContact() {
		return contact;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
	
	

}
