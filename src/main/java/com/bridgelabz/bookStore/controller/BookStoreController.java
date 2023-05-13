package com.bridgelabz.bookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bridgelabz.bookStore.Response;
import com.bridgelabz.bookStore.dto.BookStoreDTO;
import com.bridgelabz.bookStore.model.BookModel;
import com.bridgelabz.bookStore.service.IBookService;

@CrossOrigin("*")	
@RestController
@RequestMapping("/BookStore")
public class BookStoreController {

	@Autowired
	IBookService bookService;

	@GetMapping("/Hello")
	public String bookStore() {
		return "Welcome to our BookStore";

}

	@PostMapping("/Add_Book")
	public ResponseEntity<Response> addBook(@RequestParam String token,@RequestBody BookStoreDTO bookStoredto) {
		BookModel bookModel = bookService.addBook(token,bookStoredto);
		Response response = new Response("Added Book Successfull", bookStoredto);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@PutMapping("/Update_book")
	public ResponseEntity<Response> updateBook(@RequestParam int bookid, @RequestBody BookStoreDTO bookStoredto) {
		BookModel update = bookService.updateBook(bookid, bookStoredto);
		Response response = new Response("Book Updated Successfully", update);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping("/Delete_Book")
	public ResponseEntity<Response> deleteBook(@RequestParam int bookid) {
		BookModel update = bookService.deleteBook(bookid);
		Response response = new Response("Deleted Successfully", update);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/fetchBooks")
	public ResponseEntity<Response> getAllBook() {
		List<BookModel> books = bookService.getAllBook();
		Response response = new Response("user fetch successfully ", books);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/Search_Book")
	public ResponseEntity<Response> getBook(@RequestParam int id) {
		BookModel bookModel = bookService.getBook(id);
		Response response = new Response("Emplyoee Data", bookModel);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	@GetMapping("/sortPrice_by_HighToLow")
    public ResponseEntity<Response> sortPriceHighToLow() {
        List<BookModel> bookmodel = bookService.sortPriceHighToLow();
        Response response = new Response( "Sort Books By Price High To Low",bookmodel);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
	 @GetMapping("/Sort_Price_LowToHigh")
	    public ResponseEntity<Response> sortPriceLowToHigh() {
	        List<BookModel> bookmodel = bookService.sortPriceLowToHigh();
	        Response response = new Response( "Sort Books By Price Low To High",bookmodel);
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    }

}
