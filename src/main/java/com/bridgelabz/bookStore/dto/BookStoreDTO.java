package com.bridgelabz.bookStore.dto;



public class BookStoreDTO {
    
	
	private String bookName;
	private String authorName;
	private int  bookQuantity;
	private int price;
	private String bookImage;
	public String getBookName() {
		return bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public int getBookQuantity() {
		return bookQuantity;
	}
	public int getPrice() {
		return price;
	}
	public String getBookImage() {
		return bookImage;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public void setBookQuantity(int bookQuantity) {
		this.bookQuantity = bookQuantity;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}
	
	

}