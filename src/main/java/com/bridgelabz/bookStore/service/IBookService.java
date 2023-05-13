package com.bridgelabz.bookStore.service;

import java.util.List;

import com.bridgelabz.bookStore.dto.BookStoreDTO;
import com.bridgelabz.bookStore.model.BookModel;

public interface IBookService {

	BookModel addBook(String token,BookStoreDTO bookStoredto);

	BookModel updateBook(int bookid, BookStoreDTO bookStoredto);

	BookModel deleteBook(int bookid);

	List<BookModel> getAllBook();

	BookModel getBook(int id);

	List<BookModel> sortPriceHighToLow();

	List<BookModel> sortPriceLowToHigh();

	

	

	

	

	

}
