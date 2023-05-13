package com.bridgelabz.bookStore.model;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class BookModel {
	@Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private int bookId;
    private String bookName;
    private String authorName;
    private int bookQuantity;
    private double price;
    private String bookImage;
    
    
	public int getBookId() {
		return bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public String getAuthorName() {
		return authorName;
	}

	public double getPrice() {
		return price;
	}
	public String getBookImage() {
		return bookImage;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}
	public int getBookQuantity() {
		return bookQuantity;
	}
	public void setBookQuantity(int bookQuantity) {
		this.bookQuantity = bookQuantity;
	}
	
	
    
    
    
    

}
